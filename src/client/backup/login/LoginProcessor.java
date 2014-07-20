package client.backup.login;

import server.common.packages.LoginRequestPackage;
import server.common.packages.ServerConfig;
import server.common.packages.ServerPackage;
import client.backup.main.Launcher;
import client.common.IProcessor;
import client.common.Sender;
import client.common.packages.RequestPackage;
import client.common.packages.TypeConfig;
import client.ui.MainUI;

public class LoginProcessor implements IProcessor{
	
	@Override
	public void process(ServerPackage sp) {
		
		LoginRequestPackage p = (LoginRequestPackage)sp;
		if(p.getState() == ServerConfig.LOGIN_REQUEST_STATE_SUCCESS){
			Launcher.iflogin = true;
			RequestPackage userdata = new RequestPackage(TypeConfig.REQUEST_GET_USERDATA);
			Sender.packagelist.add(userdata);
			Launcher.loginui.dispose();
			
			//INIT 主界面第一次实例化
			Launcher.mainui = new MainUI();
			
		}else if(p.getState() == ServerConfig.LOGIN_REQUEST_STATE_FAILURE){
			
		}else if(p.getState() == ServerConfig.LOGIN_REQUEST_STATE_OTHER){
			
		}
		
	}

	

}
