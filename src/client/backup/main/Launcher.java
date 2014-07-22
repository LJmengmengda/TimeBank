package client.backup.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import client.common.PackageList;
import client.common.Receiver;
import client.common.Sender;
import client.common.packages.RequestPackage;
import client.common.packages.TypeConfig;
import client.ui.LoginUI;
import client.ui.MainUI;
import client.ui.SignupUI;

/**
 * 启动客户机的类
 * 
 * @author 唐梓毅
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

	// TODO 添加所有界面
	static public LoginUI loginui;
	static public SignupUI signupui;
	static public MainUI mainui;

	// TODO　添加更多状态变量
	public static boolean iflogin;// 是否登陆

	// 连接到服务器的方法
	public int connect2server(String ip, int port) {
		try {
			// 创建socket，得到IO流
			socket = new Socket(ip, port);
			System.out.println("创建了客户端，连接上了服务器");
			ous = socket.getOutputStream();

			ins = socket.getInputStream();
			dous = new DataOutputStream(ous);
			dins = new DataInputStream(ins);

			return 1;
		} catch (UnknownHostException e) {
			System.out.println("未连接到服务器");
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 初始化sender和receiver的方法
	public void initSenderAndReceiver() {
		sender = new Sender(dous);
		receiver = new Receiver(dins);
		sender.start();
		receiver.start();
	}

	// 主函数入口
	public static void main(String[] args) {
		Launcher l = new Launcher();
		// 连接到服务器
		//if (l.connect2server("192.168.0.117", 9090) > 0) {
			// 初始化sender与receiver
			l.initSenderAndReceiver();
			// 弹出登录界面
			// INIT 登陆界面第一次实例化
			loginui = new LoginUI();
//			mainui = new MainUI();
			sender.packagelist.add(new RequestPackage(TypeConfig.REQUEST_GET_QEQUESTS, 0));
			System.out.println("发送了数据包");
		//}

	}

}
