package client.common;

import java.io.DataInputStream;
import java.io.IOException;

import client.backup.login.LoginProcessor;
import client.backup.signup.SignupProcessor;
import server.common.packages.ServerConfig;
import server.common.packages.LoginRequestPackage;
import server.common.packages.SignRequestPackage;

/**
 * 通用的接受数据类的接口
 * @author pc
 *
 */
public class Receiver extends Thread{
	private DataInputStream dins;
	private LoginProcessor loginprocessor;
	private SignupProcessor signupprocessor;
	
	public Receiver(DataInputStream dins) {
		this.dins = dins;
		loginprocessor = new LoginProcessor();
		signupprocessor = new SignupProcessor();
	}
	//启动线程方法
	public void run(){
		while(true){
			//循环等待接收数据包
			try {
				int type = dins.readByte();
				if(type == ServerConfig.LOGIN_REQUEST){
					System.out.println("接收到服务器发来的type"+type);
//					//TODO 得到接收的登录信息数据包
//					int src = dins.readInt();
//					int dest = dins.readInt();
					byte state = dins.readByte();
					System.out.println("接收到服务器发来的state"+state);
					int userID = dins.readInt();
					System.out.println("接收到服务器发来的ID"+userID);
//					int srcnum = dins.readInt();
					LoginRequestPackage loginRequest = new LoginRequestPackage(userID,state);
					
					loginprocessor.process(loginRequest);
				}else if(type == ServerConfig.SIGN_REQUEST){
					//得到
					System.out.println("接收到服务器发来的type"+type);
//					int src = dins.readInt();
//					int dest = dins.readInt();
					byte state = dins.readByte();
					System.out.println("接收到服务器发来的state"+state);
					SignRequestPackage signuppack = new SignRequestPackage(state);
					
					signupprocessor.process(signuppack);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}


}
