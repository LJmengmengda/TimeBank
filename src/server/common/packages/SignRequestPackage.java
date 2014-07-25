package server.common.packages;

public class SignRequestPackage extends ServerPackage{

	private byte state;



	

	public SignRequestPackage( byte state) {
		this.state = state;
		
		this.setType(ServerConfig.SIGN_REQUEST);
		this.setSrc(0);
	}

	public void setState(byte state) {
		this.state = state;
	}
	public byte getState() {
		return state;
	}
}
