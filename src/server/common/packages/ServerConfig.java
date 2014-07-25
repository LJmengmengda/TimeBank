package server.common.packages;

public class ServerConfig {
	
	public static byte SIGN_REQUEST=0;
		public static byte SIGN_REQUEST_STATE_SUCCESS=0;
		public static byte SIGN_REQUEST_STATE_FAILURE=1;
		public static byte SIGN_REQUEST_STATE_OTHER=2;

	
	
	public static byte LOGIN_REQUEST=1;
		public static byte LOGIN_REQUEST_STATE_SUCCESS=0;
		public static byte LOGIN_REQUEST_STATE_FAILURE=1;
		public static byte LOGIN_REQUEST_STATE_OTHER=2;
	
	public static byte PERSONAL_MESSAGE_REQUEST=2;
	public static byte CLIENT_ONLINE_REQUEST=3;
	public static byte CLIENT_REQUEST_LIST_REQUEST=4;
	public static byte CLIENT_REQUEST_CLIENT_REQUEST=5;
	public static byte SEND_FILE_REQUEST=6;
	public static byte SEND_MESSAGE_REQUEST=7;
	
	public static byte QUIRYABC_REQUEST=8;
		public static byte QUIRYABC_REQUEST_STATE_BOOK=0;//预定
		public static byte QUIRYABC_REQUEST_STATE_DAIBAN=1;//待办
		public static byte QUIRYABC_REQUEST_STATE_REGRET=2;//退选
	
	public static byte regretREQUEST_REQUEST=9;
	public static byte CLIENT_RECEIVE_REGRET_REQUEST=10;
	public static byte CLIENT_DEAL_RECORD_REQUEST=11;
	
	public static byte CLIENT_LIUYAN_REQUEST=12;
	
	
	public static byte CLIENT_RESULT_PACKAGE=13;
	//回复用户是发送需求还是接受需求
	public static byte CLIENT_RESULT_PACKAGE_PUBLISH_MESSAGE=0;
	public static byte CLIENT_RESULT_PACKAGE_RECEIVE_MESSAGE=1;
	///回复用户的结果的三个状态~
	
	public static byte CLIENT_RESULT_PACKAGE_STATE_SUCCESS=0;
	public static byte CLIENT_RESULT_PACKAGE_STATE_FAILURE=1;
	public static byte CLIENT_RESULT_PACKAGE_STATE_OTHER=2;


}
