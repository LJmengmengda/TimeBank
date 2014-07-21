package server.common.packages;

public class SignRequestPackage extends ServerPackage{

	private byte state;

	public byte getState() {
		return state;
	}

	public SignRequestPackage(byte state) {
		super();
		this.state = state;
	}

	public void setState(byte state) {
		this.state = state;
	}
}
