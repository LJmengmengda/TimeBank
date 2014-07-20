package sever.common.packages;


public class PersonalMessagePackage extends ServerPackage{

	
	public PersonalMessagePackage(String nikeName, String schoolNumber,
			String school, String qQ_number, String tel, String nianJi,
			int timeCount, int honstycount) {
		super();
		this.nikeName = nikeName;
		SchoolNumber = schoolNumber;
		School = school;
		QQ_number = qQ_number;
		Tel = tel;
		NianJi = nianJi;
		TimeCount = timeCount;
		this.honstycount = honstycount;
	}
	
	
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	public String getSchoolNumber() {
		return SchoolNumber;
	}
	public void setSchoolNumber(String schoolNumber) {
		SchoolNumber = schoolNumber;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getQQ_number() {
		return QQ_number;
	}
	public void setQQ_number(String qQ_number) {
		QQ_number = qQ_number;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getNianJi() {
		return NianJi;
	}
	public void setNianJi(String nianJi) {
		NianJi = nianJi;
	}
	public int getTimeCount() {
		return TimeCount;
	}
	public void setTimeCount(int timeCount) {
		TimeCount = timeCount;
	}
	public int getHonstycount() {
		return honstycount;
	}
	public void setHonstycount(int honstycount) {
		this.honstycount = honstycount;
	}


	private String nikeName;//�û��ǳ�     10
	private String SchoolNumber;///ѧ�š� 
	private String School;///ѧУ�� 
	private String QQ_number;///QQ���롣 
	private String Tel;///�绰���롣 
	private String NianJi;///���꼶�ġ� 
	private int TimeCount;///ʱ�����
	private int honstycount;///���Ż��
}
