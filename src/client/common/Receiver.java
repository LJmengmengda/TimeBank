package client.common;

import java.io.DataInputStream;
import java.io.IOException;

import client.backup.login.LoginProcessor;
import server.common.packages.ServerConfig;
import server.common.packages.LoginRequestPackage;

/**
 * 通用的接受数据类的接口
 * @author pc
 *
 */
public class Receiver extends Thread{
	private DataInputStream dins;
	private LoginProcessor loginprocessor;
	
	public Receiver(DataInputStream dins) {
		this.dins = dins;
		loginprocessor = new LoginProcessor();
	}
	//启动线程方法
	public void run(){
		while(true){
			//循环等待接收数据包
			try {
				int type = dins.readByte();
				if(type == ServerConfig.LOGIN_REQUEST){
//					//TODO 得到接收的登录信息数据包
					int userID = dins.readInt();
					byte loginstate = dins.readByte();
					LoginRequestPackage loginRequest = new LoginRequestPackage(userID,loginstate);
					loginprocessor.process(loginRequest);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
