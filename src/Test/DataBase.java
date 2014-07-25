package  Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	/**
	 * @throws Exception 
	 * @�͵¶�  
	 * ��ݿ�������~~
	 */
	public static void main(String[] args) throws Exception {
		//������ݿ�ĵ�ַ���û�������
		String url="jdbc:mysql://localhost:3308/timebank";
		String username="root";
		String userpassword="123456";
		//������Ӷ���
		Connection con=DataBase.Createcon(url, username, userpassword);
		
//		///�����ݵ�ѭ�����Կ��Ƿ�ɹ�
//		for(int i=0;i<10;i++){
//			Adduser(con,i,"username"+(i+65),"201~~3070201"+i);
//		}
//		
		//�޸����
//		updateuser(con,8,"Xue","222222222");
		
		//ɾ�����
//		for(int i=0;i<10;i++){
//			if(i==5){
//				continue;
//			}
//			deleteuser(con,i,"","");
//		}
//		//���ò��ҷ���
//		Quryuser(con);
		
		
		DataBase d=new DataBase();
		
//		d.Adduser("aa","qq");
		
//		System.out.print("~~~All_Booking的总数是：~~~~~`"+d.getCount());
//		for(int i=10;i<=20;i++){
////			deletelist(con,10+i);
//			d.AddDDuser(i,i+1);
////			d.Addrequest(i,"A","B",i+1,"C");
//		}
//		System.out.print("~~~All_Booking的总数是：~~~~~`"+d.getCount());
//		String perform="select id from UserMessage  where username=\'?\',userpassword=\'?\'";
//		System.out.print(perform);
//		
//		
		String per="insert into UserMessage(id,username,userpassword) values(?,\'?\',\'?\')";
//		
		
		System.out.print(per);
//		
		int a=Quryuser("qq","qq");
		System.out.print("~~~~~~用户名的ID是~~~~~~~`"+a);
		
	}
	
	
	///向用户信息数据库里面添加一个新的用户信息~~
	public   int Adduser(String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="insert into UserMessage(id,username,userpassword) values(?,?,?)";
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAa"+ this.getCount());
		PreparedStatement psta=con.prepareStatement(perform);
		System.out.println("每写入前已存在用户信息的总数长度是："+ this.getCount());
//ֵ
		psta.setInt(1, this.getCount()+1);
		psta.setString(2, name);
		psta.setString(3, password);
		
		int count=psta.executeUpdate();
		
		if(count>0){
			System.out.println("注册写入数据库成功~~");
			
			System.out.print("插入书记哭后的存在用户信息的总数长度是："+this.getCount()+1);
		}
		else{
			System.out.println("注册写入数据库不成功");
			
		}
		
		//返回用户的建立的用户的ID号
		return this.getCount()+1;
	}
	
	
	
	///添加用户的信息
		public   int Addrequest(int ID, String title, String content, int cost,
				String time) throws Exception{
			
			//����Ҫִ�е�SQl���
			String perform="insert into UserRequestMessage(id,userid,place,content,time,cost) " +
					" values(?,?,?,?,?,?)";
			
			///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
			PreparedStatement psta=con.prepareStatement(perform);
			
			//��ÿһ��ռλ��ָ��һ��ֵ
			psta.setInt(1,this.getCount()+1);
			psta.setInt(2, ID);
			psta.setString(3, title);
			psta.setString(4, content);
			psta.setString(5, time);
			psta.setInt(6, cost);
			//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
			int count=psta.executeUpdate();
			//���count����0��ʾ������ݳɹ�
			if(count>0){
				System.out.println(" 插入数据库成功");
			}
			else{
				System.out.println(" 插入数据库不成功");
			}
			return count;
		}
	
	
	///返回该表格的信息总数
	public int getCount() throws SQLException{
//	方法1：	
		Statement sta=con.createStatement();
		
		String s="select count(*) from usermessage as countNumber";
		ResultSet res=sta.executeQuery(s);
		int count=0;
		while(res.next()){
			count=res.getInt(1);
		}
		return count;
		
		
	//方法2：	
//		Statement sta=con.createStatement();
//		
//		String perform="select * from UserRequestMessage";
//		
//		ResultSet res=sta.executeQuery(perform);
//		
//		int count=0;
//		while(res.next()){
//			count++;
//		}
//		return count;
		
	}
	
	
	///向用户信息数据库里面添加一个新的用户信息~~
	public    int AddDDuser(int userID,int Request_UserID) throws Exception{
		
		
		
		//����Ҫִ�е�SQl���
		String perform="insert into AllBooking(id,userid,requestid) values(?,?,?)";
		
		
		PreparedStatement psta=con.prepareStatement(perform);
		System.out.print("每写入前已存在用户信息的总数长度是："+this.getCount());
//ֵ
		psta.setInt(1, this.getCount()+1);
		psta.setInt(2, userID);
		psta.setInt(3, Request_UserID);
		
		int count=psta.executeUpdate();
		
		if(count>0){
			System.out.println("注册写入数据库成功~~");
			
			System.out.print("插入书记哭后的存在用户信息的总数长度是："+this.getCount());
		}
		else{
			System.out.println("注册写入数据库不成功");
			
		}
		return count;
	}
	
	
	//按照用戶名和密码来查询~~~用来对付登陆的操作~~
	public static   int Quryuser(String username,String password) throws Exception{
		
		
		
		
		Statement sta=con.createStatement();
		System.out.println("~~~~~~~BBBBBBBBBBBBBBbB~~~~");
		String perform="select * from UserMessage  where username=\'"+username+"\'and userpassword=\'"+password+"\'";
		System.out.println(perform);
		ResultSet res=sta.executeQuery(perform);
		System.out.println("~~~~~~~AAAAAAAAAAAAA~~~~");
		//��ʼ��������������
		
		int ID=0;
		while(res.next()){
			ID=res.getInt(1);
			System.out.println(res.getString(1)+"����������������"+res.getString(2)+
					"����������������"+res.getString(3));
		}
		System.out.println("ID是："+ID+"~~~~~~~~~~~");
		return ID;
	}
	
	
	
	///��ѯ��ݿ�������~~~~
	public static  void Quryuser(Connection con) throws Exception{
		///ͨ�����Ӷ�����SQL����
		Statement sta=con.createStatement();
		//����Ҫִ�е�SQl���
		String perform="select * from usermessage";
		///��ʼִ��SQL���,���ҷ���һ�����
		ResultSet res=sta.executeQuery(perform);
		System.out.println("���"+"����������������"+"�˺�"+"����������������"+"����");
		//��ʼ��������������
		while(res.next()){
			System.out.println(res.getString(1)+"����������������"+res.getString(2)+
					"����������������"+res.getString(3));
		}
	}
	
	
	///��ӵķ���
	public static  void Adduser(Connection con,int id,String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="insert into UserMessage(id,username,userpassword) values(?,?,?)";
		
		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
		PreparedStatement psta=con.prepareStatement(perform);
		
		//��ÿһ��ռλ��ָ��һ��ֵ
		psta.setInt(1, id);
		psta.setString(2, name);
		psta.setString(3, password);
		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
		int count=psta.executeUpdate();
		System.out.println(count);
		//���count����0��ʾ������ݳɹ�
		if(count>0){
			System.out.println(" ~~~~~~~~~~~~~~~~`");
		}
		else{
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			
		}
	}
	
	//�޸���ݿ�~~~
	public static  void updateuser(Connection con,int id,String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="update user set username=?,userpassword=? where userid=?";
		
		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
		PreparedStatement psta=con.prepareStatement(perform);
		
		//��ÿһ��ռλ��ָ��һ��ֵ
		psta.setString(1, name);
		psta.setString(2, password);
		psta.setInt(3, id);
		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
		int count=psta.executeUpdate();
		//���count����0��ʾ������ݳɹ�
		if(count>0){
			System.out.println(" ��ݸ�����ݿ�ɹ�");
		}
		else{
			System.out.println(" ��ݸ�����ݿ�ʧ��");
			
		}
	}
	
	//ɾ�����~~~
	public static  void deleteuser(Connection con,int id,String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="delete from usermessage where id=?";
		
		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
		PreparedStatement psta=con.prepareStatement(perform);
		
		//��ÿһ��ռλ��ָ��һ��ֵ
		
		psta.setInt(1, id);
		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
		int count=psta.executeUpdate();
		//���count����0��ʾ������ݳɹ�
		if(count>0){
			System.out.println(" ���ɾ����ݿ�ɹ�");
		}
		else{
			System.out.println(" ���ɾ����ݿ�ʧ��");
		}
	}
	
	public static  void deletelist(Connection con,int id) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="delete from userrequestmessage where id=?";
		
		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
		PreparedStatement psta=con.prepareStatement(perform);
		
		//��ÿһ��ռλ��ָ��һ��ֵ
		
		psta.setInt(1, id);
		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
		int count=psta.executeUpdate();
		//���count����0��ʾ������ݳɹ�
		if(count>0){
			System.out.println(" ���ɾ����ݿ�ɹ�");
		}
		else{
			System.out.println(" ���ɾ����ݿ�ʧ��");
		}
	}
	
	//����һ��Connection�����Ӷ��󣬸���ֵΪnull
	private static Connection con=null;
	/**
	 * ��������ʵ��һ�����Ӷ���
	 * @param url������ݿ�ĵ�ַ
	 * @param username��ݿ�ĵ�¼��
	 * @param userpassword��ݿ�ĵ�½����
	 * @return����һ���Ѿ�ʵ���Connection����
	 */
	private static Connection Createcon(String url,String username,String userpassword){
		if(con==null){
			//����mySQL����,����ʵ��һ�������
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				///ʵ����Ķ���,ָ��Ҫ���ӵ���ݿ��ַ���û�������
				con=DriverManager.getConnection(url, username, userpassword);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return con;
	}

}
