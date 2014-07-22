package server.common.packages;

public class ClientResultPackage extends ServerPackage{

	private	byte resultbyte;//0是发送回答，1是接收回复
	private	byte state;///是否成功
	


	public ClientResultPackage(byte resultbyte, byte state) {
		super();
		this.resultbyte = resultbyte;
		this.state = state;
		this.setType(ServerConfig.CLIENT_RESULT_PACKAGE);
	}
	public byte getResultbyte() {
		return resultbyte;
	}
	public void setResultbyte(byte resultbyte) {
		this.resultbyte = resultbyte;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	
}
