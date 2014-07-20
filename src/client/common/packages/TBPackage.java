package client.common.packages;


/**
 * 数据包父类，其他所有数据包都是其子类
 * @author SSheng
 *
 */
public class TBPackage {
	private byte type;//数据包类型

	
	//type的set和get方法
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}

	
}
