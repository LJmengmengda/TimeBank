package server.common.packages;

public class ClientResultPackage extends ServerPackage{
	private	byte resultbyte;//0是登陆回答，1是注册回复
	private	byte state;///是否成功

	public ClientResultPackage(byte state, byte resultbyte) {
		
		this.state = state;
		this.resultbyte = resultbyte;
	}
	
	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	
	
}
