package client.backup.login;

import client.common.Package;
/**
 * 登陆数据包类
 * @author pc
 *
 */
public class LoginPackage extends Package {
	private int UserNameLength;
	private int PassWordLength;
	private byte[] UserName;
	private byte[] PassWord;
	public int getUserNameLength() {
		return UserNameLength;
	}
	public void setUserNameLength(int userNameLength) {
		UserNameLength = userNameLength;
	}
	public int getPassWordLength() {
		return PassWordLength;
	}
	public void setPassWordLength(int passWordLength) {
		PassWordLength = passWordLength;
	}
	public byte[] getUserName() {
		return UserName;
	}
	public void setUserName(byte[] userName) {
		UserName = userName;
	}
	public byte[] getPassWord() {
		return PassWord;
	}
	public void setPassWord(byte[] passWord) {
		PassWord = passWord;
	}
	

	
	
}
