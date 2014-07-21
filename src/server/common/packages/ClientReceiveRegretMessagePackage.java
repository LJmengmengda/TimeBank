package server.common.packages;



public class ClientReceiveRegretMessagePackage extends ServerPackage{
	
	public ClientReceiveRegretMessagePackage(String regret_name,
			String regret_time, String regret_content, String content) {
		super();
		Regret_name = regret_name;
		Regret_time = regret_time;
		Regret_content = regret_content;
		this.content = content;
	}
	public String getRegret_name() {
		return Regret_name;
	}
	public void setRegret_name(String regret_name) {
		Regret_name = regret_name;
	}
	public String getRegret_time() {
		return Regret_time;
	}
	public void setRegret_time(String regret_time) {
		Regret_time = regret_time;
	}
	public String getRegret_content() {
		return Regret_content;
	}
	public void setRegret_content(String regret_content) {
		Regret_content = regret_content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String Regret_name;///��ѡ�û�������
	private String Regret_time;///��ѡ��ʱ��
	private String Regret_content;///��ѡ��ԭ��
	private String content;//��ѡ����������

}
