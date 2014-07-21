package client.ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainUI extends JFrame{

	public static void main(String[] args){
		
	}
	
	public MainUI(){
		
		this.setSize(350, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());//设置为流布局
		
		
		this.setVisible(true);
		
	}
}
