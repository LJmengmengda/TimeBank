package server.common.packages;



/**
 * @author Administrator
 *
 */
public class ClientDealRecordPackage extends ServerPackage{
	
	private byte state;//��Ԥ�����Ǳ�Ԥ����
	private String name;///�Ѿ���ɵĽ��׶���~~
	private String TimeA;//Ԥ��ʱ��Ľ���ʱ��
	private String TimeB;//�Ѵ�ɵĽ���ʱ��
	private String content;//���׵�����
	private int timedeal;//����״̬д�Լ��õ����ǽ������˽��׵�ʱ����
	
	
	/**用户完成的记录构造方法
	 * @param state 
	 * @param name 
	 * @param timeA
	 * @param timeB
	 * @param content
	 * @param timedeal
	 * @param zan_or_JuBao
	 */
	public ClientDealRecordPackage(byte state, String name, String timeA,
			String timeB, String content, int timedeal, int zan_or_JuBao) {
		super();
		this.state = state;
		this.name = name;
		TimeA = timeA;
		TimeB = timeB;
		this.content = content;
		this.timedeal = timedeal;
		this.zan_or_JuBao = zan_or_JuBao;
	}


	public byte getState() {
		return state;
	}


	public void setState(byte state) {
		this.state = state;
	}


	public byte[] getName() {
		return name.getBytes();
	}


	public void setName(String name) {
		this.name = name;
	}


	public byte[] getTimeA() {
		return TimeA.getBytes();
	}


	public void setTimeA(String timeA) {
		TimeA = timeA;
	}


	public byte[] getTimeB() {
		return TimeB.getBytes();
	}


	public void setTimeB(String timeB) {
		TimeB = timeB;
	}


	public byte[] getContent() {
		return content.getBytes();
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getTimedeal() {
		return timedeal;
	}


	public void setTimedeal(int timedeal) {
		this.timedeal = timedeal;
	}


	public int getZan_or_JuBao() {
		return zan_or_JuBao;
	}


	public void setZan_or_JuBao(int zan_or_JuBao) {
		this.zan_or_JuBao = zan_or_JuBao;
	}


	//0��ʾ��    1��ʾ�ٱ�
	private int zan_or_JuBao;///����״̬д�Լ����Ǳ����޻��Ǿٱ�

}
