package client.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import client.backup.main.Launcher;
import client.common.packages.Package;
import client.common.packages.LoginPackage;

/**
 * 用来发送信息的接口
 * @author pc
 *
 */

public class Sender {
	public DataInputStream dins;
	public DataOutputStream dous;
	public void init(){
		try {
			dins = new DataInputStream(Launcher.socket.getInputStream());
			dous = new DataOutputStream(Launcher.socket.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//发送数据包的方法
	public int send(Package p){
		if(dous != null){
			this.init();
		}
		if(p instanceof LoginPackage){
			System.out.println("接收到了LoginPackage");
			LoginPackage lp = (LoginPackage)p;
//			try {
//				dous.writeInt(lp.getUserNameLength());
//				dous.writeInt(lp.getUserNameLength());
//				dous.write(lp.getUserName());
//				dous.write(lp.getPassWord());
				//测试
//				dous.writeInt(1);
//				dous.writeInt(lp.getPassWordLength());
//				dous.write(lp.getPassWord());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return 1;
	}
}
