package sever.common.packages;



public class ClientRequestClientListPackage extends ServerPackage{
	
	public ClientRequestClientListPackage(String nameA, String nameB,
			String content, String time, int eachClient_Number) {
		super();
		this.nameA = nameA;
		this.nameB = nameB;
		Content = content;
		Time = time;
		EachClient_Number = eachClient_Number;
	}
	
	
	public String getNameA() {
		return nameA;
	}
	public void setNameA(String nameA) {
		this.nameA = nameA;
	}
	public String getNameB() {
		return nameB;
	}
	public void setNameB(String nameB) {
		this.nameB = nameB;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getEachClient_Number() {
		return EachClient_Number;
	}
	public void setEachClient_Number(int eachClient_Number) {
		EachClient_Number = eachClient_Number;
	}


	private String nameA;///�ظ����û�a
	private String nameB;//���ظ����û�b
	private String Content;//�ظ��û�b������
	private String Time;//�ظ��û�b��ʱ��
	private int EachClient_Number;//�ظ��û�b����һ������˵˵

}
