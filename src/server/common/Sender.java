package server.common;

import java.io.DataOutputStream;
import java.io.IOException;

import server.common.packages.LoginRequestPackage;
import server.common.packages.ServerPackage;

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
			
			LoginRequestPackage lo=(LoginRequestPackage)sp;
			dos.writeByte(b);
			dos.writeInt(lo.getSrc());
			dos.writeInt(lo.getDest());
			dos.writeByte(lo.getType());
			dos.writeInt(lo.getSrcnum());
			System.out.print("~~~~~已经发送~~~~~~~`");
			
		}
		
		else if(b==1){
			
		}

	}

}
