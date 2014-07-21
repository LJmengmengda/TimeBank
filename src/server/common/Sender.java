package server.common;

import java.io.DataOutputStream;
import java.io.IOException;

import client.common.packages.TypeConfig;

import server.common.packages.LoginRequestPackage;
import server.common.packages.ServerConfig;
import server.common.packages.ServerPackage;
import server.common.packages.SignRequestPackage;

public class Sender {
	
	DataOutputStream dos;
	ServerPackage sp;
	
	public Sender(ServerPackage sp,DataOutputStream dos){
		this.dos=dos;
		this.sp=sp;
	}
	
	public void run(){
//		
//			try {
//				send();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		
	}
	
	public  void send() throws IOException{
		byte b=sp.getType();
		System.out.println("这个消息类型字节是"+b);
		if(b==ServerConfig.SIGN_REQUEST){
			
			SignRequestPackage lo=(SignRequestPackage)sp;
			dos.writeByte(b);
//			dos.writeInt(lo.getSrc());
//			dos.writeInt(lo.getDest());
			dos.writeByte(lo.getState());
			System.out.println("这个state字节是"+lo.getType());

			System.out.print("~~~~~注册回复信息已经发送~~~~~~~`");
		}
		
		else if(b==ServerConfig.LOGIN_REQUEST){
			
			LoginRequestPackage lo=(LoginRequestPackage)sp;
			dos.writeByte(b);
//			dos.writeInt(lo.getSrc());
//			dos.writeInt(lo.getDest());
			dos.writeByte(lo.getState());
			System.out.println("这个state字节是"+lo.getType());
			dos.writeInt(lo.getSrcnum());
			System.out.print("~~~~~登陆回复已经发送~~~~~~~");
		}

	}

}
