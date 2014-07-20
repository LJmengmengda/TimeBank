package sever.common.packages;



public class ClientOnlinePackage extends ServerPackage{

	
	public ClientOnlinePackage(String name, String school, String nianJi) {
		super();
		this.name = name;
		School = school;
		NianJi = nianJi;
	}
	private String name;//�û���

	private String School;///ѧУ��
	private String NianJi;///���꼶�ġ� 
	public byte[] getName() {
		return name.getBytes();
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getSchool() {
		return School.getBytes();
	}
	public void setSchool(String school) {
		School = school;
	}
	public byte[] getNianJi() {
		return NianJi.getBytes();
	}
	public void setNianJi(String nianJi) {
		NianJi = nianJi;
	}
	
}
