package server.common.packages;


public class RegretRequestRequestPackage extends ServerPackage{
	
	
	
	public RegretRequestRequestPackage(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	//�ظ�~�û��ĸ��˵���Ϣ
	private String Message;//������ѡ�ĺ��~��һЩʲôʲô�Է��ĵ绰��Ϣ~�Լ�ȥ˵
	

}
