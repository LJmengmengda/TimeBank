package server.common.packages;
import org.omg.CORBA.TypeCode;

public class LoginRequestPackage extends ServerPackage{
	
	
	private int srcnum; 
	private byte state;
	
	public LoginRequestPackage(int src, byte state) {
		this.srcnum = src;
		this.state = state;
		
		this.setType(ServerConfig.LOGIN_REQUEST);
	}
	
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
