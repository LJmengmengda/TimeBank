package server.backup.login;

import java.io.DataOutputStream;

import server.SQL.Client_Message;
import server.common.IProcessor;
import server.common.Sender;
import sever.common.packages.LoginResquestPackage;
import sever.common.packages.ServerPackage;
import client.common.packages.LoginPackage;
import client.common.packages.TBPackage;

public class LoginProcessor implements IProcessor{

	@Override
	public void process(TBPackage p, DataOutputStream dos) {
		// TODO Auto-generated method stub
		//
		LoginPackage lp = (LoginPackage)p;
		String username = lp.getUserName();
		String pwd = lp.getPwd();
		try {
//		int src = Client_Message.client_message.Quryuser(username, pwd);
		int src=1;
		if(src!=0){
			
			System.out.println("登陆成功~~该用户存在~~ID是："+src);
			ServerPackage lo=new LoginResquestPackage(src,(byte) 0);
			lo.setType((byte) 0);
			lo.setDest(src);
			lo.setSrc(0);
			lo.setType((byte) 0);
			//添加到要发送的队列中
//			Hong.F_K_packagelist.add(lo);
			Sender send=new Sender(lo,dos);
			send.send();
		}
		else{
			System.out.println("登陆不成功~该用户存在~~");
			ServerPackage lo=new LoginResquestPackage(src,(byte) 1);
			lo.setType((byte) 1);
			//添加到要发送的队列中
//			Hong.F_K_packagelist.add(lo);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
