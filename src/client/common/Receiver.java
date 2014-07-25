package client.common;

import java.io.DataInputStream;
import java.io.IOException;

import client.backup.login.LoginProcessor;
import client.backup.main.Launcher;
import client.backup.signup.SignupProcessor;
import client.ui.MainUI;
import server.common.packages.ClientRequestListPackage;
import server.common.packages.ClientResultPackage;
import server.common.packages.ServerConfig;
import server.common.packages.LoginRequestPackage;
import server.common.packages.SignRequestPackage;

/**
 * 通用的接受数据类的接口
 * 
 * @author pc
 * 
 */
public class Receiver extends Thread {
	private DataInputStream dins;
	private LoginProcessor loginprocessor;
	private SignupProcessor signupprocessor;

	public Receiver(DataInputStream dins) {
		this.dins = dins;
		loginprocessor = new LoginProcessor();
		signupprocessor = new SignupProcessor();
	}

	// 启动线程方法
	public void run() {
		while (true) {
			// 循环等待接收数据包
			try {
				int type = dins.readByte();
				// 登陆
				if (type == ServerConfig.LOGIN_REQUEST) {
					System.out.println("接收到服务器发来的type" + type);
					// //TODO 得到接收的登录信息数据包
					// int src = dins.readInt();
					// int dest = dins.readInt();
					byte state = dins.readByte();
					System.out.println("接收到服务器发来的state" + state);
					int userID = dins.readInt();
					System.out.println("接收到服务器发来的ID" + userID);
					// int srcnum = dins.readInt();
					LoginRequestPackage loginRequest = new LoginRequestPackage(
							userID, state);

					loginprocessor.process(loginRequest);
					// 注册
				} else if (type == ServerConfig.SIGN_REQUEST) {
					System.out.println("接收到服务器发来的type" + type);
					// int src = dins.readInt();
					// int dest = dins.readInt();
					byte state = dins.readByte();
					System.out.println("接收到服务器发来的state" + state);
					SignRequestPackage signuppack = new SignRequestPackage(
							state);

					signupprocessor.process(signuppack);
					// 获得需求列表请求
				} else if (type == ServerConfig.CLIENT_REQUEST_LIST_REQUEST) {
					// TODO 为了简化操作，我暂时避开processor，直接丢request对象到mainUI就好，日后可能还要改
					System.out.println("接收到服务器发来的type" + type);
					int total = dins.readInt();
					for (int i = 0; i < total; i++) {
						
						System.out.println(i);
						
						int usernamelength = dins.readInt();
						byte[] username = new byte[usernamelength];
						dins.read(username);

						int requestID = dins.readInt();

						int timelength = dins.readInt();
						byte[] time = new byte[timelength];
						dins.read(time);

						int contentlength = dins.readInt();
						byte[] content = new byte[contentlength];
						dins.read(content);

						int cost = dins.readInt();

						int placelength = dins.readInt();
						byte[] place = new byte[placelength];
						dins.read(place);
						
						Request r = new Request(new String(username),
								requestID, new String(time),
								new String(content), cost,new String(place));

						Launcher.mainui.requestList.get(i).change(r);
						Launcher.mainui.requestPanelList.get(i).change(r);
								
						
						System.out.println("创建了request");
						System.out.println("接收到服务器的request"+r.getUserName()+	r.getRequestID()+ r.getTime());
						
					}
				

					// 发布需求
				} else if (type == ServerConfig.CLIENT_RESULT_PACKAGE_PUBLISH_MESSAGE) {
					System.out.println("接收到服务器发来的type" + type);
					byte resultType = dins.readByte();
					byte state = dins.readByte();
					ClientResultPackage result = new ClientResultPackage(state, resultType);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
