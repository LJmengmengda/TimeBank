package client.common.packages;

/**
 * 刷新数据包
 * @author SSheng
 *
 */
public class RequestPackage extends ClientPackage{
	
	private byte requestType;//请求类型
	
	public RequestPackage(byte type,int id){
		this.requestType = type;
		
		this.setType(TypeConfig.TYPE_REQUEST);
		this.setID(id);
	}

	public byte getRequestType() {
		return requestType;
	}

}
