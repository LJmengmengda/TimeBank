package server.common.packages;


////��Ϣͷ
public class ServerPackage{
	////�ܳ���  4
	private byte type;//��Ϣ����    1

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
	private int src=0;//�����û���JK��   4
	
}
