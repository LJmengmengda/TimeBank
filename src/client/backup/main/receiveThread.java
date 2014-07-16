package client.backup.main;

import java.io.IOException;
import java.net.Socket;

public class receiveThread extends Thread{
	private Launcher l;
	public receiveThread(Launcher l){
		this.l = l;
	}
	//用来循环等待接收到服务器数据包的线程
	public void run(){
		while(true){
			try {
				l.receive();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
