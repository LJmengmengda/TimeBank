package client.backup.login;

import java.awt.event.ActionEvent;

/**
 * 监听器
 */
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.backup.main.Launcher;
import client.common.Sender;
import client.common.packages.LoginPackage;
import client.ui.LoginUI;
import client.ui.SignupUI;

/**
 * 登录界面的监听器
 * 
 * @author pc
 * 
 */
public class LoginListener implements ActionListener {
	private LoginUI parent;

	/**
	 * @param parent 传入监听的界面
	 */
	public LoginListener(LoginUI parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if ("登陆".equals(com)) {
			if(ifblank()){
				JOptionPane.showMessageDialog(parent, "输入不能为空");
			}else{
				LoginPackage loginPack = new LoginPackage(parent
						.getUserNameField().getText(), new String(parent
						.getPassWordField().getPassword()));
	
				Sender.packagelist.add(loginPack);
			}
		} else if ("注册".equals(com)) {
			// INIT 注册界面第一次实例化
			Launcher.signupui = new SignupUI();
			Launcher.signupui.init();
		}

	}

	public boolean ifblank() {
		if (parent.getUserNameField().getText() == null
				|| parent.getPassWordField().getPassword().length == 0) {
				return true;
		}else{
			return false;
		}
	}
}
