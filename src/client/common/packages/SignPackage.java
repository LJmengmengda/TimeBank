package client.common.packages;

/** 注册数据包类
 * @author SSheng
 *
 */
public class SignPackage extends TBPackage{

	private String userName;//用户名
	private String pwd;//用户密码   
	private String nickName;//用户昵称 
	private String field;//领域
	
	/**
	 * 注册数据包的构造方法
	 * @param userName 用户名
	 * @param pwd 密码
	 * @param nickName 昵称
	 * @param field 领域
	 */
	public SignPackage(String userName,String pwd,String nickName,String field){
		this.userName = userName;
		this.pwd = pwd;
		this.nickName = nickName;
		this.field = field;
		
		this.setType(TypeConfig.TYPE_SIGNUP);
	}

	public String getUserName() {
		return userName;
	}
	public String getPwd() {
		return pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public String getField() {
		return field;
	}
	
}
