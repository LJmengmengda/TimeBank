package server.common.packages;



public class SendFilePackage extends ServerPackage{
	
	private String Filename;//�ļ���
	public SendFilePackage(byte type, int dest, int src, String filename,
			String content, String time) {
		super();
		Filename = filename;
		this.content = content;
		this.time = time;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
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
	private String content;//�ļ�������
	private String time;//��������ļ���ʱ��

}
