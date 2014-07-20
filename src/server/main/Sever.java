package server.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {

	public static void main(String[] args) throws Exception {
		Sever s=new Sever(); 

			s.procession(9090);
		
	}

	private void procession(int port) throws Exception {
		
		ServerSocket  ss=new ServerSocket (port);
		System.out.println("~~~~~~~~~~~!!!~~~~~~~~~!!!!!!!~~~");
		while(true){
		
			Socket s=ss.accept();
			Receiver st=new Receiver(s);
			System.out.println("~有人登陆了~~");
			st.start();
		}
		
	}

}
