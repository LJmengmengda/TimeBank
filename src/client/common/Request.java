package client.common;

public class Request {
	
	private int store_id;//数据库里面存储的ID号 
	private int user_id; ///发布这条需求的ID
	private String place;//
	private String content;
	private String time;
	private int cost;
	
	
	
	public Request(int store_id, int user_id, String place,
			String content, String time, int cost) {
		super();
		this.store_id = store_id;
		this.user_id = user_id;
		this.place = place;
		this.content = content;
		this.time = time;
		this.cost = cost;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	



}
