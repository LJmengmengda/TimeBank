package sever.common.packages;



public class SendMessagePackage extends ServerPackage{
	
	public SendMessagePackage(String content, String time) {
		super();
		this.content = content;
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String content;//��Ϣ����
	private String time;//���������Ϣ��ʱ��

}
