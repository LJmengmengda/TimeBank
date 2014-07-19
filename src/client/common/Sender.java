package client.common;

import java.io.DataOutputStream;
import java.io.IOException;

import client.backup.main.Launcher;
import client.common.packages.LoginPackage;
import client.common.packages.RequesPublishPackage;
import client.common.packages.SignPackage;
import client.common.packages.TBPackage;
import client.common.packages.TypeConfig;
import client.ui.SignupUI;

/**
 * 用来发送信息的线程
 * 
 * @author 唐梓毅
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
		case TypeConfig.TYPE_LOGIN:// 登陆
			LoginPackage lp = (LoginPackage) p;
			try {
				dous.writeByte(TypeConfig.TYPE_LOGIN);
				dous.write(lp.getUserName().getBytes().length);
				dous.write(lp.getUserName().getBytes());
				dous.write(lp.getPwd().getBytes().length);
				dous.write(lp.getPwd().getBytes());
				dous.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case TypeConfig.TYPE_SIGN_UP:// 注册
			SignPackage sp = (SignPackage) p;
			try {
				dous.writeByte(TypeConfig.TYPE_SIGN_UP);
				dous.writeInt(sp.getUserName().getBytes().length);
				dous.write(sp.getUserName().getBytes());
				dous.writeInt(sp.getPwd().getBytes().length);
				dous.write(sp.getPwd().getBytes());
				dous.writeInt(sp.getNickName().getBytes().length);
				dous.write(sp.getNickName().getBytes());
				dous.writeInt(sp.getField().getBytes().length);
				dous.write(sp.getField().getBytes());
				dous.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case TypeConfig.TYPE_REQUEST_PUBLISH:// 发布请求
			RequesPublishPackage rpp = (RequesPublishPackage) p;
			try {
				dous.writeByte(TypeConfig.TYPE_REQUEST_PUBLISH);
				dous.writeInt(rpp.getPublisherID());
				dous.writeInt(rpp.getTitle().getBytes().length);
				dous.write(rpp.getTitle().getBytes());
				dous.writeInt(rpp.getContent().getBytes().length);
				dous.write(rpp.getContent().getBytes());
				dous.writeInt(rpp.getCost());
				dous.writeInt(rpp.getTime().getBytes().length);
				dous.write(rpp.getTime().getBytes());
				dous.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		return 1;
	}
}
