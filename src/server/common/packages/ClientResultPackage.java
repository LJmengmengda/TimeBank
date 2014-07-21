package server.common.packages;

public class ClientResultPackage extends ServerPackage{

	public ClientResultPackage(byte state) {
		super();
		this.state = state;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	private	byte resultbyte;//0是登陆回答，1是注册回复
	private	byte state;///是否成功
	
	
}
