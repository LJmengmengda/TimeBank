package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.backup.login.LoginListener;
import client.backup.signup.SignupListener;

/**
 * 注册界面
 * 
 * @author 王丹
 * 
 */
public class SignupUI extends JFrame {

	// 测试
	public static void main(String[] arg) {
		SignupUI SU = new SignupUI();
		SU.init();
	}

	// 属性
	private JTextField UserNameField;// 姓名输入框
	private JPasswordField PassWordField1;// 密码输入框
	private JPasswordField PassWordField2;// 密码输入检测框
	private JButton SignUp;// 注册按钮

	private SignupListener signupListener;
	
	/**
	 * 注册界面初始化
	 */
	public void init() {
		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo.png").getImage());// 设置窗体的图标
		this.setBackground(Color.white);// 设置背景为白色
//		this.setResizable(false);// 设置不可改变大小

		signupListener = new SignupListener(this);
		
		// 北
		JPanel northPane = this.createnorthPanel();
		this.add(northPane, BorderLayout.NORTH);
		// 中间
		JPanel centerPane = createcenterPanel();
		this.add(centerPane, BorderLayout.CENTER);

		 JPanel westPane = createwestPanel();
		 this.add(westPane,BorderLayout.WEST);
		 JPanel eastPane = createeastPanel();
		 this.add(eastPane,BorderLayout.EAST);
		 JPanel southPanel = createsouthPanel();
		 this.add(southPanel,BorderLayout.SOUTH);

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
	/**
	 * 中间部分
	 */
	public JPanel createcenterPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());

		JLabel UserName = new JLabel("用户名");

		UserNameField = new JTextField(17);
		UserNameField.setEditable(true);
		UserNameField.setPreferredSize(new Dimension(190, 30));

		JLabel PassWord1 = new JLabel("密码");
		PassWordField1 = new JPasswordField(17);
		PassWordField1.setPreferredSize(new Dimension(190, 30));

		JLabel PassWord2 = new JLabel("密码确认");
		PassWordField2 = new JPasswordField(17);
		PassWordField2.setPreferredSize(new Dimension(190, 30));
		
		//下划线
		JLabel underline = new JLabel();
		underline.setBackground(Color.black);
		underline.setPreferredSize(new Dimension(80,2));
		
		centerPanel.add(UserName);
		centerPanel.add(UserNameField);

		centerPanel.add(PassWord1);
		centerPanel.add(PassWordField1);
		centerPanel.add(PassWord2);
		centerPanel.add(PassWordField2);
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
		southPanel.setPreferredSize(new Dimension(0, 130));
		southPanel.setOpaque(false);
		SignUp = new JButton("注册用户");
		southPanel.add(SignUp);
		SignUp.addActionListener(signupListener);
		
			
	  
	    southPanel.add(SignUp);
	    
	    
	    return southPanel;
	}

	// 设置背景图片的方法
	private void setBackground() {
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imageLabel = new JLabel(image);
		imageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());

		this.getLayeredPane().add(imageLabel, new Integer(Integer.MIN_VALUE));

		JPanel content = (JPanel) this.getContentPane();
		content.setOpaque(false);
	}

	public JTextField getUserNameField() {
		return UserNameField;
	}

	public void setUserNameField(JTextField userNameField) {
		UserNameField = userNameField;
	}

	public JPasswordField getPassWordField1() {
		return PassWordField1;
	}

	public void setPassWordField1(JPasswordField passWordField1) {
		PassWordField1 = passWordField1;
	}

	public JPasswordField getPassWordField2() {
		return PassWordField2;
	}

	public void setPassWordField2(JPasswordField passWordField2) {
		PassWordField2 = passWordField2;
	}

	public JButton getSignUp() {
		return SignUp;
	}
	
	//set方法  : 注册按钮
	public void setSignUp(JButton signUp) {
		SignUp = signUp;
	}
	
}
