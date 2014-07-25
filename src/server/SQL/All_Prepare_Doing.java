package server.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class All_Prepare_Doing {
	
	

	public All_Prepare_Doing(){
		//������ݿ�ĵ�ַ���û�������
		String url="jdbc:mysql://localhost:3306/sqltest";
		String username="root";
		String userpassword="123456";
		//������Ӷ���
		con=All_Prepare_Doing.Createcon(url, username, userpassword);
		
		
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
	public   void Quryuser(Connection con) throws Exception{
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
	public   void Adduser(Connection con,int id,String name,String password) throws Exception{
		
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
	public   void updateuser(Connection con,int id,String name,String password) throws Exception{
		
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
	public   void deleteuser(Connection con,int id,String name,String password) throws Exception{
		
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
			//加载驱动
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				///实例化连接对象的方法
				con=DriverManager.getConnection(url, username, userpassword);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return con;
	}


}
