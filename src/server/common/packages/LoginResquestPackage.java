package server.common.packages;

public class LoginResquestPackage extends ServerPackage{
	
	public LoginResquestPackage(int src, byte state) {
		super();
		this.srcnum = src;
		this.state = state;
	}
	private int srcnum; 
	private byte state;
	public int getSrcnum() {
		return srcnum;
	}
	public void setSrc(int src) {
		this.srcnum = src;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	


}
