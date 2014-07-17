package client.common;

import java.io.IOException;
import java.util.ArrayList;

import client.backup.login.LoginProcessor;
import client.backup.main.Launcher;
import client.common.packages.IPackage;
import client.common.packages.LoginPackage;


/**
 * 通用的接受数据类的接口
 * @author pc
 *
 */
public class Receiver extends Thread{
	//保存所有信息处理类的队列
	private ArrayList<IProcessor> processors;
	
	//run
	public void run(){
		while(true){
			//循环等待接收数据包
			try {
				int type = Launcher.dins.readInt();
				if(type == 1){
					//TODO 得到接收的登录信息数据包
					IPackage p = new LoginPackage();
					//创建登陆数据包处理泪，并处理
					int n = this.processors.size();
					for (int i = 0; i < n; i++) {
						IProcessor current = this.processors.get(i);
						if(current instanceof LoginProcessor){
							((LoginProcessor)current).process(p);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//添加消息处理类的方法
	public void addProcessor(IProcessor p){
		this.processors.add(p);
	}
	//删除消息处理类的方法
	public void delProcessor(IProcessor p){
		this.processors.remove(p);
	}
	
}
