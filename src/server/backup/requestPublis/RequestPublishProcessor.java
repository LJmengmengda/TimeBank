package server.backup.requestPublis;

import java.io.DataOutputStream;

import server.SQL.SQL_Common;
import server.common.IProcessor;
import server.common.Sender;
import server.common.packages.ClientResultPackage;
import server.common.packages.ServerConfig;
import server.common.packages.ServerPackage;
import client.common.packages.ClientPackage;
import client.common.packages.RequestPublishPackage;

public class RequestPublishProcessor implements IProcessor{

	public int process(ClientPackage p, DataOutputStream dos){
		
		RequestPublishPackage rp=(RequestPublishPackage)p;
		
		int userID=rp.getID();
		String place=rp.getTitle();
		String content=rp.getContent();
		String time=rp.getTime();
		int cost=rp.getCost();
		
		try {
			int result=SQL_Common.clintrequestneed.Addrequest(userID, place, content, cost, time);
			if(result>0){
				System.out.println("插入用户的需求列表数据库成功~");
				
				ServerPackage sp=new ClientResultPackage (ServerConfig.CLIENT_RESULT_PACKAGE_PUBLISH_MESSAGE,
						ServerConfig.CLIENT_RESULT_PACKAGE_STATE_SUCCESS);
				
				Sender s=new Sender(sp,dos);
				s.send();
				
			}else{
				System.out.println("插入用户的需求列表数据库失败~");
				
				ServerPackage sp=new ClientResultPackage (ServerConfig.CLIENT_RESULT_PACKAGE_PUBLISH_MESSAGE,
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
