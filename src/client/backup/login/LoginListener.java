package client.backup.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import client.backup.main.Launcher;
import client.common.packages.LoginPackage;
import client.ui.LoginUI;

public class LoginListener implements ActionListener{
	private LoginUI parent;
	public LoginListener(LoginUI parent){
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String com = e.getActionCommand();
		if("登陆".equals(com)){
			System.out.println("点击了登陆按钮！");
			String username = "t1174779123";
			String password = parent.getPassWordField().getText();
			LoginPackage p = new LoginPackage();
			System.out.println("创建了数据包");
			p.setUserName(username.getBytes());
			p.setUserNameLength(username.length());
			p.setPassWord(password.getBytes());
			p.setPassWordLength(password.length());
			Launcher.sender.send(p);
			
		}
		
	}
	
}
