package server.main;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import server.SQL.Client_Message;
import sever.common.packages.LoginResquestPackage;
import sever.common.packages.ServerPackage;
import server.backup.login.LoginProcessor;
import client.common.packages.LoginPackage;

/**
 * @author Administrator
 *
 */
public class Receiver extends Thread{


	int src=0;///每个客户的ID号码~不是0，，因为0是服务器的ID号码~~
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	}
	

	private void readAllMessage() throws Exception {
		
		byte b=dis.readByte();//读取消息头的标记位
		
		if(b==0x01){
		
			System.out.println("aaaaaaa");
			int UserNameLength=dis.readInt();
			String UserName=this.Readbytes(dis,UserNameLength);
			int PassWordLength=dis.readInt();
			String PassWord=this.Readbytes(dis,PassWordLength);
			System.out.println("bbbbbb");
		
			
			LoginPackage lp=new LoginPackage(UserName,PassWord);
			System.out.print("~~~~~~~~XXXX~~~~~~~~~~~~");
		
			///生成一个LoginProcessor对象~~调用实现的方法~
			LoginProcessor loginprocessor = new LoginProcessor();
			
			loginprocessor.process(lp,dos);

			
		}else if(b==0x02){
			
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
