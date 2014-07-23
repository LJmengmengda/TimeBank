package server.main;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import server.backup.Resquestlist.requestListProcessor;
import server.backup.login.LoginProcessor;
import server.backup.requestBook.requestBookProcessor;
import server.backup.requestPublis.RequestPublishProcessor;
import server.backup.signup.SignProcessors;
import server.common.packages.ClientRequestListPackage02A;
import client.common.packages.LoginPackage;
import client.common.packages.RequestPackage;
import client.common.packages.RequestPublishPackage;
import client.common.packages.RequestReceivePackage;
import client.common.packages.SignupPackage;
import client.common.packages.TypeConfig;

/**
 * @author Administrator
 *
 */
public class Receiver extends Thread{



	private int ID ;
	private Socket s;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public OutputStream getOutput() {
		return output;
	}

	public void setOutput(OutputStream output) {
		this.output = output;
	}


	private DataOutputStream dos;
	private DataInputStream dis;
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
				sleep(20);
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
		if(b==TypeConfig.TYPE_SIGNUP){
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

			
		}else if(b==TypeConfig.TYPE_LOGIN){    ///这个是登陆的请求信息
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
			
		}else if(b==TypeConfig.TYPE_REQUEST_PUBLISH){
			System.out.println("这是用户发布需求的的信息");
//			int userID=dis.readInt();
			int placelen=dis.readInt();
			String place=this.Readbytes(dis, placelen);
			int contentlen=dis.readInt();
			String content=this.Readbytes(dis, contentlen);
			int timelen=dis.readInt();
			String time=this.Readbytes(dis, timelen);
			int cost=dis.readInt();
			System.out.println("发布的信息的信息读取完毕~");
			System.out.println("信息分别是"+ID+"~"+place+"~"+content+"~"
					+time+"~"+cost+"~");
			
			RequestPublishPackage pk=new RequestPublishPackage(ID,place,content,cost,time);
			
			RequestPublishProcessor rp=new RequestPublishProcessor();
			rp.process(pk, dos);
			
			
		}else if(b==TypeConfig.TYPE_REQUEST_RECEIVE){
			System.out.println("这是用户接受需求的的信息");
			int requestID=dis.readInt();
			int timelen=dis.readInt();
			String time=this.Readbytes(dis, timelen);
			
//			int userID=dis.readInt();
			System.out.println("接受的信息的信息读取完毕~");
			RequestReceivePackage rp=new RequestReceivePackage(requestID,time,ID);
			
			requestBookProcessor bp=new requestBookProcessor();
			
			bp.process(rp, dos);
			
		}
		////这是客户机请求列表的信息
		else if(b==TypeConfig.TYPE_REQUEST){
			
			byte bb=dis.readByte();

			RequestPackage r=new RequestPackage(bb,ID);
			r.setID(ID);
			
			requestListProcessor rp=new requestListProcessor();
			rp.process(r, dos);
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
