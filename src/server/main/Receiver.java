package server.main;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import server.backup.login.LoginProcessor;
import server.backup.signup.SignProcessors;
import client.common.packages.LoginPackage;
import client.common.packages.SignupPackage;

/**
 * @author Administrator
 *
 */
public class Receiver extends Thread{



	int ID ;
	Socket s;
	public DataOutputStream dos;
	public DataInputStream dis;
	private InputStream input;
	private OutputStream output;
	/**
	 * @param s：socket
	 * @throws IOException 
	 */
	public  Receiver(Socket s) throws IOException{
		
		this.s=s;
		input=s.getInputStream();
		output=s.getOutputStream();
		dis=new DataInputStream(input);
		dos=new DataOutputStream(output);
	}
	
	public void run(){
		while(true){
			try {
				this.readAllMessage();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		
	}
	

	private void readAllMessage() throws Exception {
		
		byte b=dis.readByte();//读取消息头的标记位
		int ID=dis.readInt();//读取用户的ID号码
		//TODO 该变量为宏定义文件的常量
		
		///这是注册的信息
		if(b==0x00){
			System.out.println("这是注册的信息");
			int UserNameLength=dis.readInt();
			String UserName=this.Readbytes(dis,UserNameLength);
			System.out.println("用户名是："+UserName);
			int PassWordLength=dis.readInt();
			String PassWord=this.Readbytes(dis,PassWordLength);
			System.out.println("密码是："+PassWord);
			System.out.println("注册信息读取完毕~");
			
			//生成一个客户机的注册类来保存数据~~
			SignupPackage spk=new SignupPackage(UserName,PassWord);
			//生成一个SignProcessors的对象来处理这类
			SignProcessors signprocessors = new SignProcessors();
			signprocessors.process(spk, dos);
			System.out.print("~~~~萌萌哒~~~~~XXXX~~~~萌萌哒~~~~~~");

			
		}else if(b==0x01){    ///这个是登陆的请求信息
			System.out.println("这个是登陆的请求信息");
			int UserNameLength=dis.readInt();
			String UserName=this.Readbytes(dis,UserNameLength);
			System.out.println("用户名是："+UserName);
			int PassWordLength=dis.readInt();
			String PassWord=this.Readbytes(dis,PassWordLength);
			System.out.println("密码是："+PassWord);
			System.out.println("登陆信息读取完毕~");
		
			LoginPackage lp=new LoginPackage(UserName,PassWord);
//			lp.setID(ID);//此句代码可要可不要
			
		
			///生成一个LoginProcessor对象~~调用实现的方法~
			LoginProcessor loginprocessor = new LoginProcessor();

			int result =loginprocessor.process(lp,dos);//返回对象的ID
			if(result!=0){
				this.ID=result;///每一个Receiver类都保存的有自己的一个ID属性~~以后可以查找队列来得到ID
				Hong.clientOnlientList.add(result);//把这个ID添加到在线用户的队列里面去
				Hong.Receiverlist.add(this);//把这个线程添加到队列里面去
			}
			
		}else if(b==0x03){
			
		}else if(b==0x04){
			
		}else if(b==0x05){
			
		}
		
		
	}

	
	//定义的一个读取一个字节数组的方法
	private String Readbytes(DataInputStream dis,int n) throws IOException{
		byte[] bytes=new byte[n];
		dis.read(bytes);
		String string=new String(bytes,"GBk");
		return string;
	}
	
	
	///读取一行字符的方法
	private String LineString(InputStream input) throws IOException{
		//这是一个字节数组输出流~~
		ByteArrayOutputStream  baos=new ByteArrayOutputStream ();
		while(true){
			///读取每一个字节
			int a=input.read();
			///不是换行的话就继续读取
			if(a=='\n'){
				break;
			}
			///写入到这个数组队列中去
			baos.write(a);
		}
		//转化为字节 数组
		byte []bytes=baos.toByteArray();
		
		//转化为字符串
		String str=new String(bytes,"GBK");
		return str;
		
	}
	
	
	//发送一个字节的方法
	public void sendbyte(byte b) throws IOException{
		
		dos.writeByte(b);
	}
	
	
	//发送一个证书的方法
	public void sendInt(int v) throws IOException{
		
		dos.writeInt(v);
	}
	
	
	//发送一个字符串的放法
	public void sendString(String mess) throws IOException{
		
			System.out.println("XXXXXXXXXXXXXXXXXXXXX");
			dos.writeBytes(mess);
	
	}
}
