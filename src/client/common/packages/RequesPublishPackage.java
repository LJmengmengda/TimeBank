package client.common.packages;

/**
 * 发布需求数据包
 * 
 * @author SSheng
 * 
 */
public class RequesPublishPackage extends TBPackage {

	private int publisherID;// 发布客户ID
	private String title;// 客户发表需求的标题
	private String content;// 客户发表需求的内容
	private int cost;// 需求额度
	// private String keyWord;//客户发表的需求的关键字 //暂时考虑可能比较复杂，没弄
	private String time;// 客户发表需求的时间

	/**
	 * 需求发布数据的构造函数
	 * 
	 * @param ID
	 *            发布客户ID
	 * @param title
	 *            客户发表的需求的标题
	 * @param content
	 *            客户发表需求的内容
	 * @param cost
	 *            需求额度
	 * @param time
	 *            客户发表需求的时间
	 */
	public RequesPublishPackage(int ID, String title, String content, int cost,
			String time) {
		this.publisherID = ID;
		this.title = title;
		this.content = content;
		this.cost = cost;
		this.time = time;
	}

	public int getPublisherID() {
		return publisherID;
	}

	public String getTitle() {
		return title;

	}

	public String getContent() {
		return content;
	}

	public int getCost() {
		return cost;
	}

	public String getTime() {
		return time;
	}

}
