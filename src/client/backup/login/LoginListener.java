package client.backup.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import client.ui.LoginUI;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String com = e.getActionCommand();
		if ("登陆".equals(com)) {
			// TODO　创建登陆数据包并加入消息队列
			System.out.println("aaaa");
			// 一段时间以后

			// 成功
			parent.dispose();
			// 开启主界面
		}

	}

}
