package server.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client_Message {


	
	
	
	public Client_Message(){
		//连接数据库的地址
		String url="jdbc:mysql://localhost:3306/BankOfTimeSQL";
		String username="root";
		String userpassword="123456";
		//获得连接对象
		con=Client_Message.Createcon(url, username, userpassword);
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
	
	
	//按照用戶名和密码来查询~~~用来对付登陆的操作~~
	public  int Quryuser(String username,String password) throws Exception{
		
		Statement sta=con.createStatement();
		
		String perform="select * from UserMessage  where username=?,userpassword=?";
		
		ResultSet res=sta.executeQuery(perform);
		System.out.println("在执行执行了登陆的验证操作~~~~");
		
		int ID=0;
		
		while(res.next()){
			ID=res.getInt(0);
		}
		return ID;
	}
	
	
	
	///��ѯ��ݿ�������~~~~
	public   void Quryuser() throws Exception{
		///ͨ�����Ӷ�����SQL����
		Statement sta=con.createStatement();
		//����Ҫִ�е�SQl���
		String perform="select * from user";
		///��ʼִ��SQL���,���ҷ���һ�����
		ResultSet res=sta.executeQuery(perform);
		System.out.println("���"+"����������������"+"�˺�"+"����������������"+"����");
		//��ʼ��������������
		while(res.next()){
			
			System.out.println(res.getString(1)+"����������������"+res.getString(2)+
					"����������������"+res.getString(3));
		}
	}
	
	
	
	public   String QuryuserName(int id) throws Exception{
		///ͨ�����Ӷ�����SQL����
		Statement sta=con.createStatement();
		//����Ҫִ�е�SQl���
		String perform="select * from user where id="+id;
		///��ʼִ��SQL���,���ҷ���һ�����
		ResultSet res=sta.executeQuery(perform);
		System.out.println("���"+"����������������"+"�˺�"+"����������������"+"����");
		//��ʼ��������������
		String name="";
		while(res.next()){
			name=res.getNString(2);
			System.out.println(res.getString(1)+"����������������"+res.getString(2)+
					"����������������"+res.getString(3));
		}
		return name;
	}
	
	
	///返回该表格的信息总数
	public int getCount() throws SQLException{
//	方法1：	
//		Statement sta=con.createStatement();
//		
//		String s="select count(*) from UserMessage as countNumber";
//		ResultSet res=sta.executeQuery(s);
//		int count=0;
//		while(res.next()){
//			count=res.getInt(0);
//		}
//		return 0;
		
		
	//方法2：	
		Statement sta=con.createStatement();
		
		String perform="select * from UserMessage";
		
		ResultSet res=sta.executeQuery(perform);
		
		int count=0;
		while(res.next()){
			count++;
		}
		return count;
		
	}
	
	
	///向用户信息数据库里面添加一个新的用户信息~~
	public   int Adduser(String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="insert into UserMessage(id,username,userpassword) values(?,?,?)";
		
		
		PreparedStatement psta=con.prepareStatement(perform);
		System.out.print("每写入前已存在用户信息的总数长度是："+ this.getCount());
//ֵ
		psta.setInt(1, this.getCount()+1);
		psta.setString(2, name);
		psta.setString(3, password);
		
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
	
	//�޸���ݿ�~~~
	public static  void updateuser(int id,String name,String password) throws Exception{
		
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
	public static  void deleteuser(int id,String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="delete from user where userid=?";
		
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
			}
		}
		
		return con;
	}
	
}
