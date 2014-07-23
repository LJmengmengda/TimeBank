package server.common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import client.common.Request;

import server.common.packages.ClientRequestListPackage;
import server.common.packages.ClientResultPackage;
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
		//
		else if(b==ServerConfig.CLIENT_RESULT_PACKAGE){
			
			ClientResultPackage cp=(ClientResultPackage)sp;
			if(cp.getResultbyte()==ServerConfig.CLIENT_RESULT_PACKAGE_PUBLISH_MESSAGE){
				dos.writeByte(b);
				dos.writeByte(cp.getResultbyte());
				dos.writeByte(cp.getState());
	//			dos.writeInt(lo.getSrc());
	//			dos.writeInt(lo.getDest());
				System.out.print("~~~~~已经回复了用户是否成功的已经发送需求~~~~~~~");
			}
			else if(cp.getResultbyte()==ServerConfig.CLIENT_RESULT_PACKAGE_RECEIVE_MESSAGE){
				
				dos.writeByte(b);
				dos.writeByte(cp.getResultbyte());
				dos.writeByte(cp.getState());
	//			dos.writeInt(lo.getSrc());
	//			dos.writeInt(lo.getDest());
				System.out.print("~~~~~已经回复了用户是否成功的已经发送的接受呀~~~~~~~");
			}
		}
		
		else if(b==ServerConfig.CLIENT_REQUEST_LIST_REQUEST){
			
			ClientRequestListPackage cp=(ClientRequestListPackage)sp;
			dos.writeByte(b);
			dos.writeInt(cp.getTotal());
			ArrayList<Request> list=cp.getList();
			for(int i=0;i<list.size();i++){
				Request r=list.get(i);
				dos.writeInt(r.getRequestID());
				dos.write(r.getUserName().getBytes());
				dos.write(r.getPlace().getBytes());
				dos.write(r.getContent().getBytes());
				dos.write(r.getTime().getBytes());
				dos.writeInt(r.getCost());
				
			}
			System.out.print("~~~~~已经回复了用户需求列表的信息已经发送的接受呀~~~~~~~");
			
		}
		

	}

}
