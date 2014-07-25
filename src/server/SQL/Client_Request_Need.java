package server.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 用户发布的需求列表
 * @author 纪德东
 *
 */
public class Client_Request_Need {
	


	public Client_Request_Need(){
		//连接数据库的地址
		String url="jdbc:mysql://localhost:3308/timebank";
		String username="root";
		String userpassword="123456";
		//实例化连接对象
		con=Client_Request_Need.Createcon(url, username, userpassword);
	}
	
//	public static void main(String[] args) throws Exception {

		
//		///�����ݵ�ѭ�����Կ��Ƿ�ɹ�
//		for(int i=0;i<10;i++){
//			Adduser(con,i,"username"+(i+65),"2013070201"+i);
//		}
//		
		//�޸����
//		updateuser(con,8,"Xue","222222222");
		
		//ɾ�����
//		deleteuser(con,5,"","");
//		//���ò��ҷ���
//		Quryuser(con);
//		
//		
//	}
	
	
	///返回该表格的信息总数
	public int getCount() throws SQLException{
//	方法1：	
//		Statement sta=con.createStatement();
//		
//		String s="select count(*) from UserRequestMessage as countNumber";
//		ResultSet res=sta.executeQuery(s);
//		int count=0;
//		while(res.next()){
//			count=res.getInt(0);
//		return 0;
		
		
	//方法2：	
		Statement sta=con.createStatement();
		
		String perform="select * from UserRequestMessage";
		
		ResultSet res=sta.executeQuery(perform);
		
		int count=0;
		while(res.next()){
			count++;
		}
		return count;
		
	}
	
	
	
	///添加用户的信息
	public   int Addrequest(int ID, String title, String content, int cost,
			String time) throws Exception{
		
		//插入数据库的语句
		String perform="insert into UserRequestMessage(id,userid,place,content,time,cost) " +
				" values(?,?,?,?,?,?)";
		
		///ͨ获得预编译执行对象
		PreparedStatement psta=con.prepareStatement(perform);
		
		//设置问号的值ֵ
		psta.setInt(1,this.getCount()+1);
		psta.setInt(2, ID);
		psta.setString(3, title);
		psta.setString(4, content);
		psta.setString(5, time);
		psta.setInt(6, cost);
		//SQL的执行语句，每次执行完后，返回改变数据的条数
		int count=psta.executeUpdate();
		//当有条数改变时，就输出插入数据库
		if(count>0){
			System.out.println(" 插入数据库成功");
		}
		else{
			System.out.println(" 插入数据库不成功");
		}
		return count;
	}
	
	
	///按照存储序列号来找用户的ID
	public   int QuryUserID(int ID) throws Exception{
		
		Statement sta=con.createStatement();
		
		String perform="select * from UserRequestMessage where id="+ID;
		
		ResultSet res=sta.executeQuery(perform);
	
		int id=0;
		while(res.next()){
			id=res.getInt(2);
		}
		return id;
	}
	
	
	///查询所有的信息~~
	public   int QuryUserIntMessages(int ID,int num) throws Exception{
		
		Statement sta=con.createStatement();
		
		String perform="select * from UserRequestMessage where id="+ID;
		
		ResultSet res=sta.executeQuery(perform);
	
		int result=0;
		
		while(res.next()){
			
			if(num==1||num==2||num==6){
				result=res.getInt(num);
			}
			
		}
		return result;
	}
	
	
	
	///查询所有的信息~~
	public   String QuryUserStringMessages(int ID,int num) throws Exception{
		
		Statement sta=con.createStatement();
		
		String perform="select * from UserRequestMessage where id="+ID;
		
		ResultSet res=sta.executeQuery(perform);
	
		String result="";
		
		while(res.next()){
			
			if(num==3||num==4||num==5){
				result=res.getString(num);
			}
			
		}
		return result;
	}
	
	
	
	
	///按照存储序列号来找第几个用户的消息的ID
	public   int QuryUserRequestID(int ID) throws Exception{
		
		Statement sta=con.createStatement();
		
		String perform="select * from UserRequestMessage where id="+ID;
		
		ResultSet res=sta.executeQuery(perform);
	
		int requestId=0;
		while(res.next()){
			requestId=res.getInt(10);
		}
		return requestId;
	}
//	///��ѯ��ݿ�������~~~~
//	public   void Quryuser(Connection con) throws Exception{
//		///ͨ�����Ӷ�����SQL����
//		Statement sta=con.createStatement();
//		//����Ҫִ�е�SQl���
//		String perform="select * from UserRequestMessage";
//		///��ʼִ��SQL���,���ҷ���һ�����
//		ResultSet res=sta.executeQuery(perform);
//		System.out.println("���"+"����������������"+"�˺�"+"����������������"+"����");
//		//��ʼ��������������
//		while(res.next()){
//			System.out.println(res.getString(1)+"����������������"+res.getString(2)+
//					"����������������"+res.getString(3));
//		}
//	}
	
//	
//	///��ӵķ���
//	public   void Adduser(Connection con,int id,String name,String password) throws Exception{
//		
//		//����Ҫִ�е�SQl���
//		String perform="insert into UserRequestMessage(userid,username,userpassword) values(?,?,?)";
//		
//		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
//		PreparedStatement psta=con.prepareStatement(perform);
//		
//		//��ÿһ��ռλ��ָ��һ��ֵ
//		psta.setInt(1, id);
//		psta.setString(2, name);
//		psta.setString(3, password);
//		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
//		int count=psta.executeUpdate();
//		//���count����0��ʾ������ݳɹ�
//		if(count>0){
//			System.out.println(" ��ݲ�����ݿ�ɹ�");
//		}
//		else{
//			System.out.println(" ��ݲ�����ݿ�ʧ��");
//			
//		}
//	}
//	
//	//�޸���ݿ�~~~
//	public   void updateuser(Connection con,int id,String name,String password) throws Exception{
//		
//		//����Ҫִ�е�SQl���
//		String perform="update UserRequestMessage set username=?,userpassword=? where userid=?";
//		
//		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
//		PreparedStatement psta=con.prepareStatement(perform);
//		
//		//��ÿһ��ռλ��ָ��һ��ֵ
//		psta.setString(1, name);
//		psta.setString(2, password);
//		psta.setInt(3, id);
//		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
//		int count=psta.executeUpdate();
//		//���count����0��ʾ������ݳɹ�
//		if(count>0){
//			System.out.println(" ��ݸ�����ݿ�ɹ�");
//		}
//		else{
//			System.out.println(" ��ݸ�����ݿ�ʧ��");
//			
//		}
//	}
//	
//	//ɾ�����~~~
//	public   void deleteuser(Connection con,int id,String name,String password) throws Exception{
//		
//		//����Ҫִ�е�SQl���
//		String perform="delete from UserRequestMessage where userid=?";
//		
//		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
//		PreparedStatement psta=con.prepareStatement(perform);
//		
//		//��ÿһ��ռλ��ָ��һ��ֵ
//		
//		psta.setInt(1, id);
//		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
//		int count=psta.executeUpdate();
//		//���count����0��ʾ������ݳɹ�
//		if(count>0){
//			System.out.println(" ���ɾ����ݿ�ɹ�");
//		}
//		else{
//			System.out.println(" ���ɾ����ݿ�ʧ��");
//		}
//	}
//	
	
	
	//实例化一个连接对象
	private static Connection con=null;
	/**
	 * 实例化连接对象的方法
	 * @param url  连接数据库的地址ַ
	 * @param username
	 * @param userpassword
	 * @return 已经实例化的连接对象
	 */
	private static Connection Createcon(String url,String username,String userpassword){
		if(con==null){
			//����mySQL����,����ʵ��һ�������
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				///ʵ����Ķ���,ָ��Ҫ���ӵ���ݿ��ַ���û�������
				con=DriverManager.getConnection(url, username, userpassword);
				
			} catch (Exception e) {
			}
		}
		
		return con;
	}
	
}
