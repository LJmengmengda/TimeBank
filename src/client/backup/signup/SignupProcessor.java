package client.backup.signup;

import javax.swing.JOptionPane;

import server.common.packages.*;
import client.backup.main.Launcher;
import client.common.IProcessor;

public class SignupProcessor implements IProcessor{

	@Override
	public void process(ServerPackage sp) {
		//强制转型
		SignRequestPackage p = (SignRequestPackage)sp;
		if(p.getState() == ServerConfig.SIGN_REQUEST_STATE_SUCCESS){
			//显示注册成功
			JOptionPane.showMessageDialog(Launcher.signupui, "注册成功！");
			Launcher.signupui.dispose();
			
			
		}
		
	}

}
