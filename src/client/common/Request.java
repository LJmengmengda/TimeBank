package client.common;

/**
 * 需求类
 * @author 唐梓毅
 *
 */
public class Request {
	private String userName;
	private int requestID;
	private String time;
	private String content;
	private String place;
	private int cost;
	/**
	 * @param userName  发布用户名
	 * @param requestID	需求ID
	 * @param time		时间
	 * @param content	内容
	 * @param place		地点
	 */
	public Request(String userName, int requestID, String time, String content,int cost,String place) {
		this.userName = userName;
		this.requestID = requestID;
		this.time = time;
		this.content = content;
		this.cost = cost;
		this.place = place;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void change(Request r){
		this.userName = r.userName;
		this.requestID = r.requestID;
		this.time = r.time;
		this.content = r.content;
		this.cost = r.cost;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
