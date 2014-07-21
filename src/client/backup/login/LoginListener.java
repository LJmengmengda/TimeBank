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

	public LoginListener(LoginUI parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

//	public void actionPerformed(ActionEvent e) {
//		String com = e.getActionCommand();
//		if ("登陆".equals(com)) {
//			if(ifblank()){
//				JOptionPane.showMessageDialog(parent, "输入不能为空");
//			}else{
				// TODO　创建登陆数据包并加入消息队列
//				LoginPackage loginPack = new LoginPackage((String) parent
//						.getUserNameField().getSelectedItem(), new String(parent
//						.getPassWordField().getPassword()));
//	
//				Sender.packagelist.add(loginPack);
//			}
//		} else if ("注册".equals(com)) {
//			// INIT 注册界面第一次实例化
//			Launcher.signupui = new SignupUI();
//		}
//
//	}

//	public boolean ifblank() {
//		if (parent.getUserNameField().getSelectedItem() == null
//				|| parent.getPassWordField().getPassword().length == 0) {
//				return true;
//		}else{
//			return false;
//		}
//	}
}
