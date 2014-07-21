package client.ui;

import javax.swing.JFrame;

public class MainUI extends JFrame{

	public static void main(String[] args){
		MainUI ui=new MainUI();
		
	}
	
	public MainUI(){
		
		this.setSize(350, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		
		this.setVisible(true);
		
	}
}
