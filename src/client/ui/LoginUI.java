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

import client.backup.login.LoginListener;
/**
 * 登陆界面
 * @author pc
 *
 */

public class LoginUI extends JFrame{
	
	public static void main(String[] args){
		new LoginUI();
	}
	
	private JComboBox<String> UserNameField;//用户名输入框
	private JPasswordField PassWordField;//密码输入框
	private JCheckBox RememberPWD;//记住密码
	private JButton SignUp;//注册
	private JButton Login;//登陆
	
	public JComboBox<String> getUserNameField() {
		return UserNameField;
	}
	public void setUserNameField(JComboBox<String> userNameField) {
		UserNameField = userNameField;
	}
	public JPasswordField getPassWordField() {
		return PassWordField;
	}
	public void setPassWordField(JPasswordField passWordField) {
		PassWordField = passWordField;
	}
	public JCheckBox getRememberPWD() {
		return RememberPWD;
	}
	public void setRememberPWD(JCheckBox rememberPWD) {
		RememberPWD = rememberPWD;
	}
	public JButton getSignUp() {
		return SignUp;
	}
	public void setSignUp(JButton signUp) {
		SignUp = signUp;
	}
	
	
	LoginListener loginListener;
	
	public LoginUI(){
		this.setSize(350,600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setUndecorated(false);
		this.setLayout(new BorderLayout());
//		this.setBackground();
		
		loginListener = new LoginListener(this);
		
		
		
		
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
	
	
	
	public JPanel createcenterPanel(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		JLabel UserName = new JLabel("用户名");
		
		
		UserNameField = new JComboBox<String>();
		UserNameField.setEditable(true);
		UserNameField.setPreferredSize(new Dimension(190,25));
		
		
		
		
		
		JLabel PassWord = new JLabel("密码");
		
		PassWordField =new JPasswordField(17);
		
		RememberPWD = new JCheckBox("记住密码");
		RememberPWD.setOpaque(false);
		
		
		centerPanel.add(UserName);
		centerPanel.add(UserNameField);
	
		centerPanel.add(PassWord);
		centerPanel.add(PassWordField);
		centerPanel.add(RememberPWD);
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
		
		SignUp = new JButton("注册");
		Login = new JButton("登陆");
		
		
	    southPanel.add(Login);
	    Login.addActionListener(loginListener);
	    southPanel.add(SignUp);
	    
	    return southPanel;
	}
	
	
	private void setBackground(){
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imageLabel = new JLabel(image);
		imageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		
		JPanel content = (JPanel) this.getContentPane();
		content.setOpaque(false);
	}
	

	

}
