package client.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import client.backup.main.Launcher;

/**
 * 用来发送信息的接口
 * @author pc
 *
 */
public class Sender {
	public DataInputStream dins = Launcher.dins;
	public DataOutputStream dous = Launcher.dous;
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
		
		return 1;
	}
}
