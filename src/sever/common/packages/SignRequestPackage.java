package sever.common.packages;

public class SignRequestPackage extends ServerPackage{

	private byte state;

	public byte getState() {
		return state;
	}

	public SignRequestPackage(byte type, int dest, int src, byte state) {
		super();
		this.state = state;
	}

	public void setState(byte state) {
		this.state = state;
	}
}
