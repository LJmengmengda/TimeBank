package client.common.packages;

/**
 * 刷新数据包
 * @author SSheng
 *
 */
public class RequestPackage extends ClientPackage{
	
	private byte requestType;//请求类型
	
	public RequestPackage(byte type){
		this.requestType = type;
		
		this.setType(TypeConfig.TYPE_REQUEST);
	}

	public byte getRequestType() {
		return requestType;
	}

}
