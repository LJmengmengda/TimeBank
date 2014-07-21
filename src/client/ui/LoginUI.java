package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.backup.login.LoginListener;

/**
 * 登陆界面
 * 
 * @author pc
 * 
 */

public class LoginUI extends JFrame {

	public static void main(String[] args) {
		new LoginUI();
	}

	// 属性
	private JTextField userNameField;// 用户名输入框输入框
	private JPasswordField passWordField;// 密码输入框
	// private JCheckBox rememberPWD;// 记住密码
	private JButton signUp;// 注册
	private JButton login;// 登陆

	private LoginListener loginListener;

	public LoginUI() {
		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo.png").getImage());// 设置窗体的图标
		this.setBackground(Color.white);// 设置背景为白色
		// this.setResizable(false);// 设置不可改变大小

		loginListener = new LoginListener(this);

		// 北
		JPanel northPane = this.createnorthPanel();
		this.add(northPane, BorderLayout.NORTH);
		// 中间
		JPanel centerPane = createcenterPanel();
		this.add(centerPane, BorderLayout.CENTER);

		JPanel westPane = createwestPanel();
		this.add(westPane, BorderLayout.WEST);
		JPanel eastPane = createeastPanel();
		this.add(eastPane, BorderLayout.EAST);
		JPanel southPanel = createsouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	/**
	 * 北边部分
	 */
	public JPanel createnorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.setPreferredSize(new Dimension(0, 250));
		//注册logo设置
		ImageIcon logo = new ImageIcon("images/logo2.png");//注册logo
		JLabel jlogo = new JLabel(logo);
		jlogo.setBounds(65, 65, 200, 200);
		northPanel.add(jlogo,BorderLayout.CENTER);
		
		//TimeBanklogo设置
		JLabel tlogo = new JLabel("Time Bank");
		tlogo.setFont(new Font("微软雅黑", Font.BOLD, 28));// 设置标签字体
		tlogo.setForeground(Color.black);// 设置字体颜色
		tlogo.setHorizontalAlignment(JLabel.CENTER);
		tlogo.setVerticalAlignment(JLabel.CENTER);
		tlogo.setBounds(0, 0, 100, 30);
		northPanel.add(tlogo,BorderLayout.SOUTH);
		
		return northPanel;
	}
	
	public JPanel createcenterPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.setPreferredSize(new Dimension(0, 300));

		JLabel UserName = new JLabel("用户名");

		userNameField = new JTextField();
		userNameField.setEditable(true);
		userNameField.setPreferredSize(new Dimension(190, 30));

		JLabel PassWord = new JLabel("密码");
		passWordField = new JPasswordField(17);
		passWordField.setPreferredSize(new Dimension(190, 30));

		JLabel under = new JLabel();
		under.setPreferredSize(new Dimension(150,10));
		login = new JButton("登陆");
		login.setPreferredSize(new Dimension(190,30));
		JLabel forgetKey = new JLabel("忘记密码");
		JLabel underline = new JLabel("______________________");
		underline.setPreferredSize(new Dimension(160,15));
		
		login.addActionListener(loginListener);//给登陆按钮添加监听器
		
		// rememberPWD = new JCheckBox("记住密码");
		// rememberPWD.setOpaque(false);

		centerPanel.add(UserName);
		centerPanel.add(userNameField);
		centerPanel.add(PassWord);
		centerPanel.add(passWordField);
		// centerPanel.add(rememberPWD);
		centerPanel.add(under);
		centerPanel.add(login);
		centerPanel.add(forgetKey);
		centerPanel.add(underline);
		
		centerPanel.setOpaque(false);

		return centerPanel;
	}

	public JPanel createwestPanel() {
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(60, 0));
		westPanel.setOpaque(false);
		return westPanel;
	}

	public JPanel createeastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(60, 0));
		eastPanel.setOpaque(false);
		return eastPanel;
	}

	public JPanel createsouthPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(0, 47));
		southPanel.setOpaque(false);

		signUp = new JButton("注册");

		southPanel.add(signUp);
		signUp.addActionListener(loginListener);

		return southPanel;
	}

	private void setBackground() {
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imageLabel = new JLabel(image);
		imageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());

		this.getLayeredPane().add(imageLabel, new Integer(Integer.MIN_VALUE));

		JPanel content = (JPanel) this.getContentPane();
		content.setOpaque(false);
	}

	public JTextField getUserNameField() {
		return userNameField;
	}

	public void setUserNameField(JTextField userNameField) {
		this.userNameField = userNameField;
	}

	public JPasswordField getPassWordField() {
		return passWordField;
	}

	public void setPassWordField(JPasswordField passWordField) {
		this.passWordField = passWordField;
	}

	// public JCheckBox getRememberPWD() {
	// return rememberPWD;
	// }
	//
	// public void setRememberPWD(JCheckBox rememberPWD) {
	// this.rememberPWD = rememberPWD;
	// }

	public JButton getSignUp() {
		return signUp;
	}

	public void setSignUp(JButton signUp) {
		this.signUp = signUp;
	}

}
