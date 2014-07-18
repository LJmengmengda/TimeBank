package client.common.packages;


/**
 * 数据包接口
 * @author pc
 *
 */
public class TBPackage {
	private byte type;//消息类型    1

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}
	
}
