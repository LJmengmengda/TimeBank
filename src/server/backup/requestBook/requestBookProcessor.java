package server.backup.requestBook;

import java.io.DataOutputStream;

import server.SQL.SQL_Common;
import server.common.IProcessor;
import server.common.Sender;
import server.common.packages.ClientResultPackage;
import server.common.packages.ServerConfig;
import server.common.packages.ServerPackage;
import client.common.packages.ClientPackage;
import client.common.packages.RequestReceivePackage;

public class requestBookProcessor implements IProcessor{

	@Override
	public int process(ClientPackage p, DataOutputStream dos) {
		
		RequestReceivePackage rp=(RequestReceivePackage)p;
		
		int requestID=rp.getRequestID();//第几个需求的的ID
		String time=rp.getTime();
		int userID=rp.getReceiverID();//这个用户的ID
		
		try {
			
			///得到被接受的那个用户的ID
//			int Request_UserID=SQL_Common.clintrequestneed.QuryUserID(requestID);
			//得到某用户的第某个需求的ID
//			int Request_User_Which_ID=SQL_Common.clintrequestneed.QuryUserRequestID(requestID);
			//插入到预定消息的的那个表中去啊
			int result=SQL_Common.all_booking.Adduser(userID,requestID);
			if(result>0){
				System.out.println("数据库记录客户的接收成功了~~");
				ServerPackage sp=new ClientResultPackage (ServerConfig.CLIENT_RESULT_PACKAGE_RECEIVE_MESSAGE,
						ServerConfig.CLIENT_RESULT_PACKAGE_STATE_SUCCESS);
				
				Sender s=new Sender(sp,dos);
				s.send();
				
			}else{
				System.out.println("数据库记录客户的接收失败了~~");
				
				ServerPackage sp=new ClientResultPackage (ServerConfig.CLIENT_RESULT_PACKAGE_RECEIVE_MESSAGE,
						ServerConfig.CLIENT_RESULT_PACKAGE_STATE_FAILURE);
				
				Sender s=new Sender(sp,dos);
				s.send();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
