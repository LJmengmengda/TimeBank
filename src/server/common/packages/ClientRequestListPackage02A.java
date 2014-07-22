package server.common.packages;



public class ClientRequestListPackage02A extends ServerPackage{
	
	public ClientRequestListPackage02A(String name, int eachClient_Number,
			String time, String title, String content, int zan, int juBao) {
		super();
		this.name = name;
		EachClient_Number = eachClient_Number;
		Time = time;
		Title = title;
		Content = content;
		Zan = zan;
		JuBao = juBao;
	}
	
	
	private String name;///����������������û���
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEachClient_Number() {
		return EachClient_Number;
	}
	public void setEachClient_Number(int eachClient_Number) {
		EachClient_Number = eachClient_Number;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getZan() {
		return Zan;
	}
	public void setZan(int zan) {
		Zan = zan;
	}
	public int getJuBao() {
		return JuBao;
	}
	public void setJuBao(int juBao) {
		JuBao = juBao;
	}


	private int EachClient_Number;///��������û����ĵڼ�������
	private String Time;//�����ʱ��
	private String Title;//����ı���
	private String Content;///�����������
	private int Zan;//������
	private int JuBao;///�ٱ���

}
