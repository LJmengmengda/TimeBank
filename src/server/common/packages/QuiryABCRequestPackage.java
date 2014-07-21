package server.common.packages;



public class QuiryABCRequestPackage extends ServerPackage{

	public QuiryABCRequestPackage(byte state, String time, String name,
			int regret_YuDing_or_DaiBan_number, String content) {
		super();
		this.state = state;
		Time = time;
		this.name = name;
		Regret_YuDing_or_DaiBan_number = regret_YuDing_or_DaiBan_number;
		Content = content;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegret_YuDing_or_DaiBan_number() {
		return Regret_YuDing_or_DaiBan_number;
	}
	public void setRegret_YuDing_or_DaiBan_number(int regret_YuDing_or_DaiBan_number) {
		Regret_YuDing_or_DaiBan_number = regret_YuDing_or_DaiBan_number;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	private byte state;///回复的是退选，待办，预定
	private String Time;///表格存储的信息时间
	private String name;///对象名字
	
	private int Regret_YuDing_or_DaiBan_number;///退选项目，待办项目还是预定项目的序列号~~
	private String Content;//内容
	
}
