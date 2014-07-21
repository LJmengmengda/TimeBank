package server.backup.signup;

import java.io.DataOutputStream;

import server.SQL.Client_Message;
import server.common.IProcessor;
import server.common.Sender;
import server.common.packages.ServerPackage;
import server.common.packages.SignRequestPackage;
import client.common.packages.ClientPackage;
import client.common.packages.SignupPackage;

public class SignProcessors implements IProcessor{

	
	public int process(ClientPackage p, DataOutputStream dos) {
		
		SignupPackage sp = (SignupPackage)p;
		String username = sp.getUserName();
		String password = sp.getPwd();
		
			try {
				//写入数据库的函数调用
				//返回的count也是写入时候的对数据库的对所有数据能过有影响的总数
				//count在数值上也是ID
				
//				int count=Client_Message.client_message.Adduser(username, password);
				int count=1;
				if(count>0){
					System.out.println("注册成功~~");
					ServerPackage lo=new SignRequestPackage((byte) 1);
					lo.setDest(0);///注册和登陆的时候这个值暂时用0代替~
					lo.setSrc(0);//服务器端的ID同一是0
					lo.setType((byte) 0);
					
					Sender send=new Sender(lo,dos);
					send.send();
					
				}
				else{
					System.out.println("注册不成功");
					ServerPackage lo=new SignRequestPackage((byte) 0);
					lo.setDest(0);///注册和登陆的时候这个值暂时用0代替~
					lo.setSrc(0);//服务器端的ID同一是0
					lo.setType((byte) 0);
					
					Sender send=new Sender(lo,dos);
					send.send();
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		return 0;
		
		
	}

}
