package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.backup.main.MainUIListener;
import client.common.Request;

/**
 * 主界面
 * 
 * @author 徐意
 * 
 */
public class MainUI extends JFrame {

	private JButton jbPageUp;// 上一页
	private JButton jbPageDown;// 下一页
	private JButton jbRequest;//租赁
	private JButton jbWanted;//出租
	private JButton jbNews;//消息
	private JButton jbMe;//我
	private JButton jbSetting;//设置
	
	private JLabel Larrow;
	private JLabel Rarrow;
	
	private RequestPanel p1;
	private RequestPanel p2;
	private RequestPanel p3;
	private RequestPanel p4;
	private RequestPanel p5;
	
	MainUIListener mainuilistener;

	public static ArrayList<Request> requestList;
	
	public static void main(String[] args) {
		MainUI ui = new MainUI();
		requestList = new ArrayList<Request>();
	}

	public MainUI() {

		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo2.png").getImage());// 设置窗体的图标
		this.setUndecorated(false);

		this.setIconImage(new ImageIcon("images/logo.png").getImage());// 设置窗体的图标
		
		mainuilistener = new MainUIListener(this);
		
		
		// 北边面板
		JPanel northPane = this.createnorthPanel();
		this.add(northPane, BorderLayout.NORTH);
	
		//西边面板
		JPanel westPanel = createwestPanel();
		this.add(westPanel, BorderLayout.WEST);
		
		//东边面板
		JPanel eastPanel = createeastPanel();
		this.add(eastPanel, BorderLayout.EAST);
		
		// 中间面板
		JPanel centerPane = createcenterPanel();
		this.add(centerPane, BorderLayout.CENTER);
		
		// 南边面板
		JPanel southPanel = createsouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		
		
		
		this.setVisible(true);

	}

	/**
	 * 下方面板的构造方法
	 * 
	 * @return 下方的面板
	 */
	
	private JPanel createsouthPanel() {
		JPanel southPanel = new JPanel();
		// 设置下方面板的尺寸
		southPanel.setPreferredSize(new Dimension(350, 60));
		// 添加按钮
		 jbRequest = new JButton("租凭");
		southPanel.add(jbRequest);
		 jbWanted = new JButton("出租");
		southPanel.add(jbWanted);
		 jbNews = new JButton("消息");
		southPanel.add(jbNews);
		 jbMe = new JButton("我");
		southPanel.add(jbMe);
	
		southPanel.setOpaque(false);
		return southPanel;
	}

	/**
	 * 中间面板的构造方法
	 * 
	 * @return 中间的面板
	 */
	private JPanel createcenterPanel() {
		JPanel centerPanel = new JPanel();
		// 设置z中间面板的尺寸
		centerPanel.setPreferredSize(new Dimension(300, 500));
		// 设置背景色
		centerPanel.setBackground(Color.white);
		FlowLayout f = new FlowLayout();
		f.setVgap(2);
		centerPanel.setLayout(f);
		
		Request r = new Request("逗比", 1, "2014.7.21", "需求一逗比共商逗比大业",5);
		
		p1 = new RequestPanel(r);
		centerPanel.add(p1);
		p1.getDetail().addMouseListener(mainuilistener);
		
		p2 = new RequestPanel(r);
		centerPanel.add(p2);
		p2.getDetail().addMouseListener(mainuilistener);
		
		p3 = new RequestPanel(r);
		centerPanel.add(p3);
		p3.getDetail().addMouseListener(mainuilistener);
		
		p4 = new RequestPanel(r);
		centerPanel.add(p4);
		p4.getDetail().addMouseListener(mainuilistener);
		
		p5 = new RequestPanel(r);
		centerPanel.add(p5);
		p5.getDetail().addMouseListener(mainuilistener);
		return centerPanel;
	}

	/**
	 * 上方面板的构造方法
	 * 
	 * @return 上方的面板
	 */
	private JPanel createnorthPanel() {
		JPanel northPanel = new JPanel();
		// 设置上方面板的尺寸
		northPanel.setPreferredSize(new Dimension(350, 40));
		// 添加图片，标签，按钮图片
		
		
		
		ImageIcon logo = new ImageIcon("images/logo3.png");// 时间银行logo
		JLabel jlogo = new JLabel(logo);
		northPanel.add(jlogo);

		JLabel jText = new JLabel("TimeBank");
		northPanel.add(jText);

		 jbSetting = new JButton("设置");
		northPanel.add(jbSetting);
		
		return northPanel;
	}
	
	private JPanel createwestPanel() {
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(25, 300));
		westPanel.setLayout(null);
		ImageIcon l = new ImageIcon("images/Larrows.png");
		Larrow = new JLabel(l);
		Larrow.setBounds(0, 220, 25, 25);
		Larrow.addMouseListener(mainuilistener);
		westPanel.add(Larrow);
		westPanel.setOpaque(false);
		return westPanel;
	}

	private JPanel createeastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(25,300));
		eastPanel.setLayout(null);
		ImageIcon r = new ImageIcon("images/Rarrows.png");
		Rarrow = new JLabel(r);
		Rarrow.setBounds(0, 220, 25, 25);
		Rarrow.setBackground(Color.black);
		Rarrow.addMouseListener(mainuilistener);
		eastPanel.add(Rarrow);
		eastPanel.setOpaque(false);
		return eastPanel;
	}
	
	
	
	public JButton getJbPageUp() {
		return jbPageUp;
	}

	public void setJbPageUp(JButton jbPageUp) {
		this.jbPageUp = jbPageUp;
	}

	public JButton getJbPageDown() {
		return jbPageDown;
	}

	public void setJbPageDown(JButton jbPageDown) {
		this.jbPageDown = jbPageDown;
	}

	public JButton getJbRequest() {
		return jbRequest;
	}

	public void setJbRequest(JButton jbRequest) {
		this.jbRequest = jbRequest;
	}

	public JButton getJbWanted() {
		return jbWanted;
	}

	public void setJbWanted(JButton jbWanted) {
		this.jbWanted = jbWanted;
	}

	public JButton getJbNews() {
		return jbNews;
	}

	public void setJbNews(JButton jbNews) {
		this.jbNews = jbNews;
	}

	public JButton getJbMe() {
		return jbMe;
	}

	public void setJbMe(JButton jbMe) {
		this.jbMe = jbMe;
	}

	public JButton getJbSetting() {
		return jbSetting;
	}

	public void setJbSetting(JButton jbSetting) {
		this.jbSetting = jbSetting;
	}

	public JLabel getLarrow() {
		return Larrow;
	}

	public void setLarrow(JLabel larrow) {
		Larrow = larrow;
	}

	public JLabel getRarrow() {
		return Rarrow;
	}

	public void setRarrow(JLabel rarrow) {
		Rarrow = rarrow;
	}

	public RequestPanel getP1() {
		return p1;
	}

	public void setP1(RequestPanel p1) {
		this.p1 = p1;
	}

	public RequestPanel getP2() {
		return p2;
	}

	public void setP2(RequestPanel p2) {
		this.p2 = p2;
	}

	public RequestPanel getP3() {
		return p3;
	}

	public void setP3(RequestPanel p3) {
		this.p3 = p3;
	}

	public RequestPanel getP4() {
		return p4;
	}

	public void setP4(RequestPanel p4) {
		this.p4 = p4;
	}

	public RequestPanel getP5() {
		return p5;
	}

	public void setP5(RequestPanel p5) {
		this.p5 = p5;
	}

	public static ArrayList<Request> getRequestList() {
		return requestList;
	}

	public static void setRequestList(ArrayList<Request> requestList) {
		MainUI.requestList = requestList;
	}
}
