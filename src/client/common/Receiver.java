package client.common;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import client.backup.login.LoginProcessor;
import client.backup.main.Launcher;
import client.common.packages.TBPackage;
import client.common.packages.LoginPackage;
import client.common.packages.TypeConfig;


/**
 * 通用的接受数据类的接口
 * @author pc
 *
 */
public class Receiver extends Thread{
	private DataInputStream dins;
	//保存所有信息处理类的队列
	private ArrayList<IProcessor> processors;
	
	public Receiver(DataInputStream dins) {
		this.dins = dins;
	}
	//启动线程方法
	public void run(){
		while(true){
			//循环等待接收数据包
			try {
				int type = Launcher.dins.readByte();
				if(type == TypeConfig.TYPE_LOGIN){
//					//TODO 得到接收的登录信息数据包
//					TBPackage p = new LoginPackage();
//					
//					
//					//创建登陆数据包处理类，并处理
//					int n = this.processors.size();
//					for (int i = 0; i < n; i++) {
//						IProcessor current = this.processors.get(i);
//						if(current instanceof LoginProcessor){
//							((LoginProcessor)current).process(p);
//						}
//					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//添加所有的消息处理类的方法
	public void addAllProcessors(){
		this.addProcessor(new LoginProcessor());
		//TODO 添加所有其他的Processor
		
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
