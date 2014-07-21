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
	/**
	 * @param userName  发布用户名
	 * @param requestID	需求ID
	 * @param time		时间
	 * @param content	内容
	 */
	public Request(String userName, int requestID, String time, String content) {
		this.userName = userName;
		this.requestID = requestID;
		this.time = time;
		this.content = content;
	}
	
	
}
