package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainUI extends JFrame{

	public static void main(String[] args){
		MainUI ui=new MainUI();
	}
	
	public MainUI(){
		
		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭
		this.setLocationRelativeTo(null);// 居中显示
		this.setUndecorated(false);// 禁用此窗体装饰
		this.setIconImage(new ImageIcon("images/logo.png").getImage());// 设置窗体的图标
//		this.setBackground(Color.white);// 设置背景为白色
		this.getContentPane().setBackground(Color.white);
		
//		// 北边面板
//		JPanel northPane = this.createnorthPanel();
//		this.add(northPane, BorderLayout.NORTH);
//		// 中间面板
//		JPanel centerPane = createcenterPanel();
//		this.add(centerPane, BorderLayout.CENTER);
//		// 南边面板
//		JPanel southPanel = createsouthPanel();
//		this.add(southPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}

	
	private JPanel createsouthPanel() {
		return null;
	}

	private JPanel createcenterPanel() {
		return null;
	}

	private JPanel createnorthPanel() {
		return null;
	}
}
