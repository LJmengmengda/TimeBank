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

import client.backup.main.Launcher;
import client.backup.main.MainUIListener;
import client.backup.main.jbMeListener;
import client.backup.main.jbChatListener;
import client.backup.main.jbRequestListener;
import client.backup.main.jbFootPrintListener;
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
	private JButton jbRequest;//需求
	private JButton jbFootPrint;//足迹
	private JButton jbAddRequest;//增加
	private JButton jbChat;//对话
	private JButton jbMe;//我
	private JButton jbSetting;//设置
	
	private JLabel Larrow;
	private JLabel Rarrow;
	
	MainUIListener mainuilistener;

	public static ArrayList<Request> requestList;
	public static ArrayList<RequestPanel> requestPanelList;
	
//	public static void main(String[] args) {
//		MainUI ui = new MainUI();
//	}

	public MainUI() {
		

		requestPanelList = new ArrayList<RequestPanel>();
		requestList = new ArrayList<Request>();
		Request r = new Request("0",0,"0","0",0,"0");
		requestList.add(r);
		requestList.add(r);
		requestList.add(r);
		requestList.add(r);
		requestList.add(r);

		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo2.png").getImage());// 设置窗体的图标
		this.setUndecorated(false);

		this.setIconImage(new ImageIcon("images/logo3.png").getImage());// 设置窗体的图标
		
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
		jbRequest = new JButton("需求");
		southPanel.add(jbRequest);
		jbFootPrint = new JButton("足迹");
		southPanel.add(jbFootPrint);
		jbAddRequest = new JButton("+");
		southPanel.add(jbAddRequest);
		jbChat = new JButton("对话");
		southPanel.add(jbChat);
		jbMe = new JButton("我");
		southPanel.add(jbMe);
		
	
		//给各个按钮加上监听器
		jbRequest.addActionListener(new jbRequestListener());
		jbFootPrint.addActionListener(new jbFootPrintListener());
		jbChat.addActionListener(new jbChatListener());
		jbMe.addActionListener(new jbMeListener());
		
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
		

		
		RequestPanel requestPanel1 = new RequestPanel(requestList.get(0));
		requestPanelList.add(requestPanel1);
		centerPanel.add(requestPanel1);
		requestPanel1.getDetail().addMouseListener(mainuilistener);
		
		RequestPanel requestPanel2 = new RequestPanel(requestList.get(1));
		requestPanelList.add(requestPanel2);
		centerPanel.add(requestPanel2);
		requestPanel2.getDetail().addMouseListener(mainuilistener);
		
		
		RequestPanel requestPanel3 = new RequestPanel(requestList.get(2));
		requestPanelList.add(requestPanel3);
		centerPanel.add(requestPanel3);
		requestPanel3.getDetail().addMouseListener(mainuilistener);
		
		RequestPanel requestPanel4 = new RequestPanel(requestList.get(3));
		requestPanelList.add(requestPanel4);
		centerPanel.add(requestPanel4);
		requestPanel4.getDetail().addMouseListener(mainuilistener);
		
		RequestPanel requestPanel5 = new RequestPanel(requestList.get(4));
		requestPanelList.add(requestPanel5);
		centerPanel.add(requestPanel5);
		requestPanel5.getDetail().addMouseListener(mainuilistener);
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
		return jbFootPrint;
	}

	public void setJbWanted(JButton jbWanted) {
		this.jbFootPrint = jbWanted;
	}

	public JButton getJbNews() {
		return jbChat;
	}

	public void setJbNews(JButton jbNews) {
		this.jbChat = jbNews;
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


}
