package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddRequestDetail extends JFrame{

	/**
	 * 添加消息界面
	 * @author 王丹
	 */
	public static void main(String[] args) {
		AddRequestDetail ard = new AddRequestDetail();
		ard.initGUI();
	}

	public void initGUI() {
		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo.png").getImage());// 设置窗体的图标
		this.getContentPane().setBackground(Color.white);
		
		// 北边面板
		JPanel northPane = this.createnorthPanel();
		this.add(northPane, BorderLayout.NORTH);
//		// 中间面板
		JPanel centerPane = createcenterPanel();
		this.add(centerPane, BorderLayout.CENTER);
		
//		JPanel westPane = createwestPanel();
//		this.add(westPane,BorderLayout.WEST);
//		JPanel eastPane = createeastPanel();
//		this.add(eastPane,BorderLayout.EAST);
		
		this.setVisible(true);
	}

	private JPanel createeastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(50, 0));
		return eastPanel;
	}

	private JPanel createwestPanel() {
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(50, 0));
		return westPanel;
	}

	private JPanel createcenterPanel() {
		JPanel centerPanel=new JPanel();
		centerPanel.setPreferredSize(new Dimension(350,500));
		centerPanel.setLayout(null);
		centerPanel.setOpaque(false);
		
		JLabel co = this.setJLabel("额度：");
		co.setBounds(Config.FirstX, Config.FirstY, Config.LSizeW, Config.SizeH);
		JTextField cost = new JTextField(17);
		cost.setBounds(Config.FirstX+60, Config.FirstY, Config.TSizeW, Config.SizeH);
		
		JLabel po = this.setJLabel("地点：");
		po.setBounds(Config.FirstX, Config.Second,Config.LSizeW, Config.SizeH);
		JPasswordField position = new JPasswordField(17);
		position.setBounds(Config.FirstX+60, Config.Second, Config.TSizeW, Config.SizeH);
		
		JLabel con = this.setJLabel("内容：");
		con.setBounds(Config.FirstX, Config.Third,Config.LSizeW, Config.SizeH);
		JTextArea ja = new JTextArea();//实例化一个JTextArea
		JScrollPane content = new JScrollPane(ja);
		content.setBounds(Config.FirstX+60, Config.Third, Config.TSizeW,Config.SizeH*2);
		ja.setLineWrap(true);//设置大于宽度后换行
		
		JButton submit = new JButton("发布");
		submit.setBounds(Config.FirstX+60, Config.Fiveth, Config.TSizeW, Config.SizeH);
		
		
		centerPanel.add(co);
		centerPanel.add(cost);
		centerPanel.add(po);
		centerPanel.add(position);
		centerPanel.add(con);
		centerPanel.add(content);
		centerPanel.add(submit);
		
		centerPanel.setOpaque(false);
		
		return centerPanel;
	}

	private JPanel createnorthPanel() {
		JPanel northPanel=new JPanel();
		//设置上方面板的尺寸
		northPanel.setPreferredSize(new Dimension(350,40));
		northPanel.setLayout(null);//绝对布局
		
		JButton jb=new JButton("退出");
		jb.setBounds(Config.XL,Config.YL, 60, 25);
		
		ImageIcon set = new ImageIcon("images/logo3.png");//设置按钮
		JLabel Set = new JLabel(set);
		Set.setPreferredSize(new Dimension());
		Set.setBounds(Config.XR, Config.YR, 30, 30);
		
		northPanel.add(jb);
		northPanel.add(Set);
		
		return northPanel;
	}
	
	/**
	 * 设置标签字体大小及类型
	 * @param name 标签的名字
	 * @return 标签
	 */
	private JLabel setJLabel(String name){
		JLabel jl = new JLabel(name);
		jl.setFont(new Font("微软雅黑", Font.BOLD, 16));// 设置标签字体
		jl.setForeground(Color.black);// 设置字体颜色
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setVerticalAlignment(JLabel.CENTER);
		return jl;
	}

}
