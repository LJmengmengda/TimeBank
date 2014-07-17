package client.backup.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import client.common.Receiver;
import client.common.Sender;
import client.ui.LoginUI;

/**
 * 启动客户机的类
 * @author pc
 *
 */
public class Launcher {
	private OutputStream ous;
	private InputStream ins;
	public static DataInputStream dins;
	public static DataOutputStream dous;
	public static Socket socket;
	public static Sender sender = new Sender();
	
	//所有界面
	public LoginUI loginui;
	//TODO 接收到包的操作
	public void onReceivePackage(){
		
	}
	public static boolean iflogin;
	//连接到服务器的方法
	public int connect2server(String ip, int port){
		try {
			socket = new Socket(ip,port);
			System.out.println("创建了客户端，连接上了服务器");
			ous = socket.getOutputStream();
			ins = socket.getInputStream();
			dous = new DataOutputStream(ous);
			dins = new DataInputStream(ins);
			//启动接收线程
			
			return 1;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	//TODO 循环等待接收的方法
	public void receive() throws IOException{
		int type = dins.readInt();
		
		
	}
	
	//主函数入口
	public static void main(String[] args){
		Launcher l = new Launcher();
		if(l.connect2server("localhost", 8080) > 0){
			l.loginui = new LoginUI();
		}
		
	}
	
}
