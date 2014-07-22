package server.common.packages;


////��Ϣͷ
public class ServerPackage{
	////�ܳ���  4
	private byte type;//消息头类型~~

	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}

	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	private int dest;//Ŀ���û�JK��     4����������������ͳһ��000000
	private int src=0;//目前暂且定义服务器的ID是0，用户的是从1开始的
	
}
