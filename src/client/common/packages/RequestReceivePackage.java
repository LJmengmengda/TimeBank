
package client.common.packages;

/**需求被接受的数据包
 * @author SSheng
 * 
 */
public class RequestReceivePackage extends TBPackage{
	
	private int requestID;//所接受需求的序列号
	private String time;//接受的时间
	private int receiverID;//接受者ID
	
	/**
	 * 需求接受数据包的构造方法
	 * @param requestID 需求的ID
	 * @param time 需求被接受的时间
	 * @param receiverID 接受者的ID
	 */
	public RequestReceivePackage(int requestID,String time,int receiverID){
		this.requestID = requestID;
		this.receiverID = receiverID;
		this.time = time;
		
		this.setType(TypeConfig.TYPE_REQUEST_RECEIVE);
	}
	
	
	public int getRequestID() {
		return requestID;
	}
	public String getTime() {
		return time;
	}
	public int getReceiverID() {
		return receiverID;
	}
	
}
