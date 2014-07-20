package client.backup.signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.common.Sender;
import client.common.packages.SignupPackage;
import client.ui.LoginUI;
import client.ui.SignupUI;

public class SignupListener implements ActionListener {

	private SignupUI parent;

	public SignupListener(SignupUI parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {

		String com = e.getActionCommand();
		if ("注册用户".equals(com)) {
				if(ifblank()){
					JOptionPane.showMessageDialog(parent, "输入不能为空！");
				}else{
					// 判读两个密码是否相同
					// 相同，新建注册数据包并加入到链表
					if (new String(parent.getPassWordField1().getPassword())
							.equals(new String(parent.getPassWordField2().getPassword()))) {
		
						SignupPackage signuppack = new SignupPackage(parent
								.getUserNameField().getText(), new String(parent
								.getPassWordField1().getPassword()));
		
						Sender.packagelist.add(signuppack);
					}// 两次输入结果不相同
					else {
		
						JOptionPane.showMessageDialog(parent, "两次密码输入不同！");
						parent.getPassWordField1().setText("");
						parent.getPassWordField2().setText("");
					}
				}

		}

	}

	public boolean ifblank() {
		if (parent.getUserNameField().getText() == null
				|| parent.getPassWordField1().getPassword().length == 0
				|| parent.getPassWordField2().getPassword().length == 0) {
			return true;
		} else {
			return false;
		}
	}

}
