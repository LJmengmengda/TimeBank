package client.ui;

import java.awt.Color;
import java.awt.Dimension;
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
	
	//保存本地所有request对象的队列
	public static ArrayList<Request> requests = new ArrayList<Request>();
	
	public static void main(String[] args) {
		MainUI ui = new MainUI();
	}

	public MainUI() {

		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo.png").getImage());// 设置窗体的图标
		// this.setBackground(Color.white);// 设置背景为白色
		this.getContentPane().setBackground(Color.white);

		// // 北边面板
		// JPanel northPane = this.createnorthPanel();
		// this.add(northPane, BorderLayout.NORTH);
		// // 中间面板
		// JPanel centerPane = createcenterPanel();
		// this.add(centerPane, BorderLayout.CENTER);
		// // 南边面板
		// JPanel southPanel = createsouthPanel();
		// this.add(southPanel,BorderLayout.SOUTH);

		this.setVisible(true);

	}

	private JPanel createsouthPanel() {
		JPanel southPanel = new JPanel();
		// 设置下方面板的尺寸
		southPanel.setPreferredSize(new Dimension(350, 70));
		// 添加按钮
		JButton jb1 = new JButton("租凭");
		southPanel.add(jb1);
		JButton jb2 = new JButton("出租");
		southPanel.add(jb2);
		JButton jb3 = new JButton("消息");
		southPanel.add(jb3);
		JButton jb4 = new JButton("我");
		southPanel.add(jb4);

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
		centerPanel.setPreferredSize(new Dimension(350, 500));
		// 设置背景色
		centerPanel.setBackground(Color.white);
		// 添加上一页，下一页的按钮
		JButton jb1 = new JButton("上一页");
		centerPanel.add(jb1);
		JButton jb2 = new JButton("下一页");
		centerPanel.add(jb2);
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
		northPanel.setPreferredSize(new Dimension(350, 30));
		// 添加图片，标签，按钮图片
		ImageIcon logo = new ImageIcon("images/logo3.png");// 时间银行logo
		JLabel jlogo = new JLabel(logo);
		northPanel.add(jlogo);

		JLabel jText = new JLabel("TimeBank");
		northPanel.add(jText);

		JButton jb = new JButton("设置");
		northPanel.add(jb);

		return northPanel;
	}

}
