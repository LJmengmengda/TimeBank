package client.common;

import java.io.DataOutputStream;
import java.io.IOException;

import client.backup.main.Launcher;
import client.common.packages.LoginPackage;
import client.common.packages.TBPackage;
import client.common.packages.TypeConfig;

/**
 * 用来发送信息的线程
 * @author pc
 *
 */

public class Sender extends Thread{
	//消息队列
	public static PackageList packagelist;
	private DataOutputStream dios;//输出流
	
	//构造方法，传入输出流
	public Sender(DataOutputStream dios){
		this.dios = dios;
	}
	
	//线程启动方法
	public void run(){
		while(true){
			//TODO gitHead()改为节点数量？？？
			if(packagelist.getHead() != null){
				TBPackage p = packagelist.getHead().p;
				this.send(p);
			}
		}
	}
	
	//发送数据包的方法
	public int send(TBPackage p){
		//根据协议发送数据包
		switch(p.getType()){
		case TypeConfig.TYPE_LOGIN:
			//TODO 按照协议发送登陆数据包
			try {
				dios.writeByte(TypeConfig.TYPE_LOGIN);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
		return 1;
	}
}
