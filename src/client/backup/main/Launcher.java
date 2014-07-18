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
import client.ui.SignupUI;

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
	public static Sender sender;
	public static Receiver receiver;
	
	//TODO 添加所有界面
	public LoginUI loginui;
	public SignupUI signupui;
	
	//TODO　添加更多状态变量
	public static boolean iflogin;//是否登陆
	
	//连接到服务器的方法
	public int connect2server(String ip, int port){
		try {
			//创建socket，得到IO流
			socket = new Socket(ip,port);
			System.out.println("创建了客户端，连接上了服务器");
			ous = socket.getOutputStream();
			ins = socket.getInputStream();
			dous = new DataOutputStream(ous);
			dins = new DataInputStream(ins);
			
			return 1;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	//初始化sender和receiver的方法
	public void initSenderAndReceiver(){
		this.sender = new Sender(this.dous);
		this.receiver = new Receiver(this.dins);
		sender.start();
		receiver.start();
	}
	
	//主函数入口
	public static void main(String[] args){
		Launcher l = new Launcher();
		
		if(l.connect2server("localhost", 8080) > 0){
			l.initSenderAndReceiver();
			l.loginui = new LoginUI();
		}
		
	}
	
}
