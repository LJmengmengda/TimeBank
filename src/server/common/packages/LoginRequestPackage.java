package server.common.packages;

import org.omg.CORBA.TypeCode;

public class LoginRequestPackage extends ServerPackage {

	private int ID;
	private byte state;

	public LoginRequestPackage(int id, byte state) {

		this.ID = id;
		this.state = state;
		this.setType(ServerConfig.LOGIN_REQUEST);
	}

	public int getID() {
		return ID;
	}

	public void setSrc(int src) {
		this.ID = src;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
