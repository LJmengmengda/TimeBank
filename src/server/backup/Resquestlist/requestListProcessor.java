package server.backup.Resquestlist;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import server.SQL.SQL_Common;
import server.common.IProcessor;
import server.common.Sender;
import server.common.packages.ClientRequestListPackage;
import server.common.packages.ServerPackage;
import client.common.Request;
import client.common.packages.ClientPackage;
import client.common.packages.RequestPackage;

/**
 * @author Administrator
 *
 */
public class requestListProcessor implements IProcessor{

	@Override
	public int process(ClientPackage p, DataOutputStream dos) {
		
		RequestPackage rp=(RequestPackage)p;
		try {
			//得到~~需求列表的总数~~~
			int count=SQL_Common.clintrequestneed.getCount();
			
			//
			System.out.print("总的需求表格的总数信息~~"+count);
			
			
			int a=0;
			
			///这个判断语句是为了确定给发送的需求总数的整数值
			///目前做测试的试用版本的做法
			if(25<=count){
				a=25;
			}
			else{
				a=count;
			}
			
//			ClientRequestListPackage
			ArrayList<Request> list=new ArrayList<Request>();
			
			int i=0;
			while(i<a){
				
				 try {
					 
					 ///分别获得存储id，用户id，地点，内容，发表需求时间，预备金额
					int store_id=SQL_Common.clintrequestneed.QuryUserIntMessages(i, 1);
					 int user_id=SQL_Common.clintrequestneed.QuryUserIntMessages(i, 2); ///发布这条需求的ID
					String username=SQL_Common.client_message.QuryuserName(user_id);
					 String place=SQL_Common.clintrequestneed.QuryUserStringMessages(i, 3);
					 String content=SQL_Common.clintrequestneed.QuryUserStringMessages(i, 4);
					 String time=SQL_Common.clintrequestneed.QuryUserStringMessages(i, 5);
					 int cost=SQL_Common.clintrequestneed.QuryUserIntMessages(i, 6);
					 
					 Request r=new Request(username,store_id,content,time,cost,place);
					 list.add(r);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}//数据库里面存储的ID号 

				i++;
			}
			
			
			ServerPackage sp=new ClientRequestListPackage(a,list);
			
			Sender s=new Sender(sp,dos);
			
			try {
				
				s.send();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}

}
