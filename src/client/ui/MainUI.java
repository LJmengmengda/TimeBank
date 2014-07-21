package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.common.Request;

/**
 * 主界面
 * 
 * @author 徐意
 * 
 */
public class MainUI extends JFrame {

	JButton jbPageUp;// 上一页
	JButton jbPageDown;// 下一页
	JButton jbRequest;//租赁
	JButton jbWanted;//出租
	JButton jbNews;//消息
	JButton jbMe;//我
	JButton jbSetting;//设置
	
	JLabel Larrow;
	JLabel Rarrow;
	
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
		this.setUndecorated(true);

		// 北边面板
		JPanel northPane = this.createnorthPanel();
		this.add(northPane, BorderLayout.NORTH);
		// 中间面板
		JPanel centerPane = createcenterPanel();
		this.add(centerPane, BorderLayout.CENTER);
		//西边面板
		JPanel westPanel = createwestPanel();
		this.add(westPanel, BorderLayout.WEST);
		
		//东边面板
		JPanel eastPanel = createeastPanel();
		this.add(eastPanel, BorderLayout.EAST);
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
		southPanel.setPreferredSize(new Dimension(350, 40));
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
		
		
		RequestPanel p1 = new RequestPanel("逗比","2014.7.21","5min","需求一逗比共商逗比大业");
		centerPanel.add(p1);
		RequestPanel p2 = new RequestPanel("逗比","2014.7.21","5min","需求一逗比共商逗比大业");
		centerPanel.add(p2);
		RequestPanel p3 = new RequestPanel("逗比","2014.7.21","5min","需求一逗比共商逗比大业");
		centerPanel.add(p3);
		RequestPanel p4 = new RequestPanel("逗比","2014.7.21","5min","需求一逗比共商逗比大业");
		centerPanel.add(p4);
		RequestPanel p5 = new RequestPanel("逗比","2014.7.21","5min","需求一逗比共商逗比大业");
		centerPanel.add(p5);
		
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
		northPanel.setPreferredSize(new Dimension(350, 60));
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
		Larrow.setBackground(Color.black);
		westPanel.add(Larrow);
		westPanel.setOpaque(false);
		return westPanel;
	}

	private JPanel createeastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(25,300));
		eastPanel.setLayout(null);
		eastPanel.setBackground(Color.black);
		ImageIcon r = new ImageIcon("images/Rarrows.png");
		Rarrow = new JLabel(r);
		Rarrow.setBounds(0, 220, 25, 25);
		Rarrow.setBackground(Color.black);
		eastPanel.add(Rarrow);
		eastPanel.setOpaque(false);
		return eastPanel;
	}
	
}

class RequestPanel extends JPanel{
	
	JLabel name;
	JLabel time;
	JLabel cost;
	JLabel content;
	JLabel detail;
	ImageIcon detailimage = new ImageIcon("images/next.png");
	Graphics g;
	
	public RequestPanel(String name,String time,String cost,String content){
		this.setPreferredSize(new Dimension(300,90));
//		this.setBackground(Color.white);
		this.setLayout(null);
		
		
		this.name = new JLabel();
		this.time = new JLabel();
		this.cost = new JLabel();
		this.content = new JLabel();
		this.detail = new JLabel();
		
		this.content.setText(content);
		this.content.setBounds(0, 0, 270, 70);
		this.name.setText(name);
		this.name.setBounds(0, 70, 50, 20);
		this.time.setText(time);
		this.time.setBounds(40, 70, 60, 20);
		this.cost.setText(cost);
		this.cost.setBounds(260, 70, 80, 20);
		
		this.detail = new JLabel(detailimage);
		this.detail.setBounds(250, 0, 50, 70);
		
		this.add(this.name);
		this.add(this.time);
		this.add(this.cost);
		this.add(this.content);
		this.add(this.detail);
	}
}
