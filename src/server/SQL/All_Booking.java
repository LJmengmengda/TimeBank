package server.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 用户接受需求的列表
 * @author 纪德东
 *
 */
public class All_Booking {


	/**
	 * 构造方法，作用生成连接数据库的连接对象
	 * 目前只有一个连接对象，保存在SQL_Common
	 */
	public All_Booking(){
		//连接数据库的地址
		String url="jdbc:mysql://localhost:3308/timebank";
		String username="root";
		String userpassword="123456";
		//实力化连接数据库的连接对象
		con=All_Booking.Createcon(url, username, userpassword);
		
		
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
		
	///��ѯ��ݿ�������~~~~
	/**
	 * @param con 连接对象
	 * @throws Exception 
	 */
//	public   void Quryuser(Connection con) throws Exception{
//		///ͨ�����Ӷ�����SQL����
//		Statement sta=con.createStatement();
//		//����Ҫִ�е�SQl���
//		String perform="select * from AllBooking";
//		///��ʼִ��SQL���,���ҷ���һ�����
//		ResultSet res=sta.executeQuery(perform);
//		System.out.println("���"+"����������������"+"�˺�"+"����������������"+"����");
//		//��ʼ��������������
//		while(res.next()){
//			System.out.println(res.getString(1)+"����������������"+res.getString(2)+
//					"����������������"+res.getString(3));
//		}
//	}
	
	
	
	
	///返回该表格的信息总数
	public  int getCount() throws SQLException{
//	方法1：	
//		Statement sta=con.createStatement();
//		
//		String s="select count(*) from AllBooking as countNumber";
//		ResultSet res=sta.executeQuery(s);
//		int count=0;
//		while(res.next()){
//			count=res.getInt(0);
//		}
//		return 0;
		
		
	//方法2：	
		Statement sta=con.createStatement();
		
		String perform="select * from AllBooking";
		
		ResultSet res=sta.executeQuery(perform);
		
		int count=0;
		while(res.next()){
			count++;
		}
		return count;
		
	}
	
	
	
	///向用户信息数据库里面添加一个新的用户信息~~
	public   int Adduser(int userID,int Request_UserID) throws Exception{
		
		
		
		//执行添加的语句
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
	
	
	
//	///��ӵķ���
//	public   void Adduser(Connection con,int id,String name,String password) throws Exception{
//		
//		//����Ҫִ�е�SQl���
//		String perform="insert into AllBooking(userid,username,userpassword) values(?,?,?)";
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
//		String perform="update AllBooking set username=?,userpassword=? where id=?";
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
//		String perform="delete from AllBooking where userid=?";
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
	
	
	//连接数据库的连接对象作为全局变量
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
			//加载连接数据库的驱动
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				con=DriverManager.getConnection(url, username, userpassword);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return con;
	}

}
