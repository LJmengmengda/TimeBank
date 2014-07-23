package client.backup.login;

import javax.swing.JOptionPane;

import server.common.packages.LoginRequestPackage;
import server.common.packages.ServerConfig;
import server.common.packages.ServerPackage;
import client.backup.main.Launcher;
import client.common.IProcessor;
import client.common.Sender;
import client.common.packages.RequestPackage;
import client.common.packages.TypeConfig;
import client.ui.MainUI;

public class LoginProcessor implements IProcessor {

	@Override
	public void process(ServerPackage sp) {

		LoginRequestPackage p = (LoginRequestPackage) sp;
		if (p.getState() == ServerConfig.LOGIN_REQUEST_STATE_SUCCESS) {
			Launcher.iflogin = true;
		
			// 发送用户信息请求
			RequestPackage userdata = new RequestPackage(
					TypeConfig.REQUEST_GET_USERDATA);
			Sender.packagelist.add(userdata);
			//发送需求信息请求
			RequestPackage requestListdata = new RequestPackage(
					TypeConfig.REQUEST_GET_QEQUESTS);
			Sender.packagelist.add(requestListdata);
			
			//关闭登陆界面
			Launcher.loginui.dispose();
			// INIT 主界面第一次实例化
			Launcher.mainui = new MainUI();
			

		} else if (p.getState() == ServerConfig.LOGIN_REQUEST_STATE_FAILURE) {
			// 登陆失败处理
			JOptionPane.showMessageDialog(Launcher.loginui, "用户名密码输入有误！");
		} else if (p.getState() == ServerConfig.LOGIN_REQUEST_STATE_OTHER) {
			//
		}

	}
}
