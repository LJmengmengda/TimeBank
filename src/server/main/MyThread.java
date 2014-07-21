package server.main;

import java.net.Socket;

import server.common.Sender;

public class MyThread {
	
	Socket s;
	
	Receiver receiver;
	Sender sender;
	
	public MyThread(Socket s){
		this.s = s;
	}
}
