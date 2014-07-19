package client.common;

import java.io.DataOutputStream;
import java.io.IOException;

import client.backup.main.Launcher;
import client.common.packages.LoginPackage;
import client.common.packages.SignPackage;
import client.common.packages.TBPackage;
import client.common.packages.TypeConfig;
import client.ui.SignupUI;

/**
 * 用来发送信息的线程
 * 
 * @author pc
 * 
 */

public class Sender extends Thread {
	// 消息队列
	public static PackageList packagelist;
	private DataOutputStream dous;// 输出流

	// 构造方法，传入输出流
	public Sender(DataOutputStream dous) {
		this.dous = dous;
	}

	// 线程启动方法
	public void run() {
		while (true) {
			synchronized (packagelist) {

				// TODO gitHead()改为节点数量？？？
				if (packagelist.getHead() != null) {
					TBPackage p = packagelist.getHead().p;
					this.send(p);
				}
			}
		}
	}

	// 发送数据包的方法
	public int send(TBPackage p) {
		// 根据协议发送数据包
		switch (p.getType()) {
		case TypeConfig.TYPE_LOGIN://登陆
			LoginPackage lp = (LoginPackage) p;
			try {
				dous.writeByte(TypeConfig.TYPE_LOGIN);
				dous.write(lp.getUserName().length());
				dous.write(lp.getUserName().getBytes());
				dous.write(lp.getPwd().length());
				dous.write(lp.getPwd().getBytes());
				dous.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case TypeConfig.TYPE_SIGNUP://注册
			SignPackage sp = (SignPackage)p;
			try {
				dous.write(TypeConfig.TYPE_SIGNUP);
				dous.write(sp.getUserName().length());
				dous.write(sp.getUserName().getBytes());
				dous.write(sp.getPwd().length());
				dous.write(sp.getPwd().getBytes());
				dous.write(sp.getNickName().length());
				dous.write(sp.getNickName().getBytes());
				dous.write(sp.getField().length());
				dous.write(sp.getField().getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
	}
}
