package server.common;

import java.io.DataOutputStream;
import java.io.IOException;

import server.common.packages.LoginRequestPackage;
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
		if(b==0){
			
			SignRequestPackage lo=(SignRequestPackage)sp;
			dos.writeByte(b);
			dos.writeInt(lo.getSrc());
			dos.writeInt(lo.getDest());
			dos.writeByte(lo.getType());

			System.out.print("~~~~~注册回复信息已经发送~~~~~~~`");
		}
		
		else if(b==1){
			
			LoginRequestPackage lo=(LoginRequestPackage)sp;
			dos.writeByte(b);
			dos.writeInt(lo.getSrc());
			dos.writeInt(lo.getDest());
			dos.writeByte(lo.getType());
			dos.writeInt(lo.getSrcnum());
			System.out.print("~~~~~登陆回复已经发送~~~~~~~`");
		}

	}

}
