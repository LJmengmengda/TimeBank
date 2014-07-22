package server.backup.login;

import java.io.DataOutputStream;

import server.SQL.SQL_Common;
import server.common.IProcessor;
import server.common.Sender;
import server.common.packages.LoginRequestPackage;
import server.common.packages.ServerConfig;
import server.common.packages.ServerPackage;
import client.common.packages.ClientPackage;
import client.common.packages.LoginPackage;

public class LoginProcessor implements IProcessor{

	@Override
	public int process(ClientPackage p, DataOutputStream dos) {
		//
		LoginPackage lp = (LoginPackage)p;
		String username = lp.getUserName();
		String pwd = lp.getPwd();
		try {
			int ID=0;
			//通过查询 服务器数据库的这两个值来返回用户的ID是否存在~存在的话ID不为 0。不存在继续为0
			ID = SQL_Common.client_message.Quryuser(username, pwd);
//			ID = 得到用户的ID号码的函数
			
			if(ID>0){
				
				System.out.println("登陆成功~~该用户存在~~ID是："+ID);
				ServerPackage lo=new LoginRequestPackage(ID,ServerConfig.LOGIN_REQUEST_STATE_SUCCESS);
				
				lo.setDest(ID);//目的用户的ID
				lo.setSrc(0);//服务器的ID号码
	
				//放在Sender的对象中去处理
				Sender send=new Sender(lo,dos);
				send.send();
				return ID;///便是登录成功、、函数返回ID号并保存到队列中去
		}
		else{
				System.out.println("登陆不成功~~该用户不存在~~ID是："+ID);
				ServerPackage lo=new LoginRequestPackage(ID,ServerConfig.SIGN_REQUEST_STATE_FAILURE);
				
				lo.setDest(ID);//目的用户的ID
				lo.setSrc(0);//服务器的ID号码			
	
				//放在Sender的对象中去处理
				Sender send=new Sender(lo,dos);
				send.send();
				return 0;///便是登录成功、、函数返回ID号并保存到队列中去
		}
		
		} catch (Exception e) {
	}
		
		return 10000;//写到这这里没什么用的~只是为了不报错而已~~
		

	}

}
