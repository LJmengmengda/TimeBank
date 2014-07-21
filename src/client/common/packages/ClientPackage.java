package client.common.packages;


/**
 * 数据包父类，其他所有数据包都是其子类
 * @author SSheng
 *
 */
public abstract class ClientPackage {
	private byte type;//数据包类型

	private  int ID;//客户机的ID
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	//type的set和get方法
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}

	
}
