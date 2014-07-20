package client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
/**
 * 注册界面
 * @author 徐意
 *
 */

public class SignupUI extends JFrame{
	
	/**
	 * @param arg
	 */
	public static void main(String[] arg){
		SignupUI SU=new SignupUI();
		SU.init();
	}
	
	//属性
	
	private JComboBox<String> UserNameField;//用户名输入框
	private JPasswordField PassWordField1;//密码输入框
	private JPasswordField PassWordField2;//密码输入检测框
	
	private JButton SignUp;//注册
	private JButton Login;//登陆
	
	//界面初始化
	public void init(){
		this.setSize(350,600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setUndecorated(false);
		this.setLayout(new BorderLayout());
//		this.setBackground();
		
		JPanel centerPane = createcenterPanel();
		this.add(centerPane,BorderLayout.CENTER);
		JPanel northPane = createnorthPanel();
		this.add(northPane,BorderLayout.NORTH);
		JPanel westPane = createwestPanel();
		this.add(westPane,BorderLayout.WEST);
		JPanel eastPane = createeastPanel();
		this.add(eastPane,BorderLayout.EAST);
		JPanel southPanel = createsouthPanel();
		this.add(southPanel,BorderLayout.SOUTH);
		
		
		
		
		
		this.setVisible(true);
	}
	
	
	public JComboBox<String> getUserNameField() {
		return UserNameField;
	}

	public void setUserNameField(JComboBox<String> userNameField) {
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
	/**set方法
	 * @param signUp 注册按钮
	 */
	public void setSignUp(JButton signUp) {
		SignUp = signUp;
	}

	public JButton getLogin() {
		return Login;
	}

	public void setLogin(JButton login) {
		Login = login;
	}
	
	
	public JPanel createcenterPanel(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		JLabel UserName = new JLabel("用户名");
		
		
		UserNameField = new JComboBox<String>();
		UserNameField.setEditable(true);
		UserNameField.setPreferredSize(new Dimension(190,25));
		//TODO tianhjia
		
		
		
		
		JLabel PassWord1 = new JLabel("密码");
		
		PassWordField1 =new JPasswordField(17);
		
		JLabel PassWord2 = new JLabel("密码确认");
		PassWordField2 =new JPasswordField(17);
		
		centerPanel.add(UserName);
		centerPanel.add(UserNameField);
	
		centerPanel.add(PassWord1);
		centerPanel.add(PassWordField1);
		centerPanel.add(PassWord2);
		centerPanel.add(PassWordField2);
		centerPanel.setOpaque(false);
		
		
		return centerPanel;
	}
	
	
	public JPanel createnorthPanel(){
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(0,200));
		northPanel.setOpaque(false);
		return northPanel;
	}
	
	
	
	public JPanel createwestPanel(){
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(100, 0));
		westPanel.setOpaque(false);
		return westPanel;
	}
	
	public JPanel createeastPanel(){
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(100,0));
		eastPanel.setOpaque(false);
		return eastPanel;
	}
	
	public JPanel createsouthPanel(){
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(100,47));
		southPanel.setOpaque(false);
		
		SignUp = new JButton("注册用户");
		
		
		
	  
	    southPanel.add(SignUp);
	    
	    
	    return southPanel;
	}
	
	
	//设置背景图片的方法
	private void setBackground(){
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imageLabel = new JLabel(image);
		imageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		
		JPanel content = (JPanel) this.getContentPane();
		content.setOpaque(false);
	}
}
