package client.backup.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.ui.MainUI;

public class MainUIListener extends MouseAdapter{

	MainUI mainui;
	//构造函数
	public MainUIListener(MainUI mainui){
		this.mainui=mainui;
	}
	
	  public void mouseClicked(MouseEvent e) {
		  if(e.getSource().equals(mainui.getP1().getDetail())){
			  System.out.println("aaaaa");
		  }
	  }
	
	
	
}
