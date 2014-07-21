package client.common;

import java.util.ArrayList;
import client.common.Request;

/**
 * 用户类
 * 
 * @author pc
 * 
 */
public class User {

	private int ID; // 用户ID
	private String userName; // 用户名
	private String passWord; // 用户密码
	
	
	
	private int Time; // 用户时间额度
	private String nickName; // 昵称
	private String field; // 领域
	private ArrayList<Request> publishRequests;// 发布过的需求
	private ArrayList<Request> doneRequests;// 做过的需求

	/**
	 * 构造函数你懂的
	 * 
	 * @param iD
	 * @param userName
	 * @param passWord
	 * @param time
	 * @param nickName
	 * @param field
	 */
	public User(int iD, String userName, String passWord, int time,
			String nickName, String field) {
		ID = iD;
		this.userName = userName;
		this.passWord = passWord;
		Time = time;
		this.nickName = nickName;
		this.field = field;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public ArrayList<Request> getPublishRequests() {
		return publishRequests;
	}

	public void setPublishRequests(ArrayList<Request> publishRequests) {
		this.publishRequests = publishRequests;
	}

	public ArrayList<Request> getDoneRequests() {
		return doneRequests;
	}

	public void setDoneRequests(ArrayList<Request> doneRequests) {
		this.doneRequests = doneRequests;
	}

}
