package server.SQL;
/**
 * 保存每一个表类的一个静态对象
 * 目前一个表只生成一个连接对象
 * @author 纪德东
 *
 */
public class SQL_Common {
//下面是每一个表类的对应对象
	public static All_Booking all_booking=new All_Booking();
	public static All_Change_Doing all_change_doing=new All_Change_Doing();
	public static All_Prepare_Doing all_prepare_doing=new All_Prepare_Doing();
	public static All_Recorder_Message all_recorder_message=new All_Recorder_Message();
	public static Client_Message client_message=new Client_Message();
	public static Client_Request_Client clint_request_client=new Client_Request_Client();
	public static Client_Request_Need clintrequestneed=new Client_Request_Need();
}
