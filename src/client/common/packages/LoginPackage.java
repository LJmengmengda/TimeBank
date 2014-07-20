package client.common.packages;

/**
 * 登陆数据包类
 * @author pc
 *
 */
public class LoginPackage extends TBPackage {

	private String userName;	//用户名
	private String pwd;  		//密码
	
	/**
	 * 构造函数
	 * @param userName 用户名
	 * @param pwd 密码
	 */
	public LoginPackage(String userName,String pwd){
		
		this.userName = userName;
		this.pwd = pwd;
		this.setType(TypeConfig.TYPE_LOGIN);
	}

	
	//get方法，没有设置set方法因为考虑用不到
	public String getUserName() {
		return userName;
	}
	public String getPwd() {
		return pwd;
	}
	
}
