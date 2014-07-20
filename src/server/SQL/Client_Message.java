package server.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client_Message {


	
	public static  Client_Message client_message=new Client_Message();
	
	public Client_Message(){
		//������ݿ�ĵ�ַ���û�������
		String url="jdbc:mysql://localhost:3306/sqltest";
		String username="root";
		String userpassword="123456";
		//������Ӷ���
		Connection con=Client_Message.Createcon(url, username, userpassword);
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
	
	
	//按照用戶名和密码来查询
	public   int Quryuser(String username,String password) throws Exception{
		
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
	
	
	///��ӵķ���
	public   void Adduser(int id,String name,String password) throws Exception{
		
		//����Ҫִ�е�SQl���
		String perform="insert into user(userid,username,userpassword) values(?,?,?)";
		
		///ͨ�����Ӷ�����Ԥ����ִ�е�SQL����
		PreparedStatement psta=con.prepareStatement(perform);
		
		//��ÿһ��ռλ��ָ��һ��ֵ
		psta.setInt(1, id);
		psta.setString(2, name);
		psta.setString(3, password);
		//ִ��SQl,���ҷ���Ӱ���˼�����ݵ�ͳ����Ŀ
		int count=psta.executeUpdate();
		//���count����0��ʾ������ݳɹ�
		if(count>0){
			System.out.println(" ��ݲ�����ݿ�ɹ�");
		}
		else{
			System.out.println(" ��ݲ�����ݿ�ʧ��");
			
		}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return con;
	}
	
}
