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
			  //TODO 增加相关详细数据窗体创建
		  }else if(e.getSource().equals(mainui.getP2().getDetail())){
			  System.out.println("bbbbb");
			  //TODO 增加相关详细数据窗体创建
		  }else if(e.getSource().equals(mainui.getP3().getDetail())){
			  System.out.println("ccccc");
			  //TODO 增加相关详细数据窗体创建
		  }else if(e.getSource().equals(mainui.getP4().getDetail())){
			  System.out.println("ddddd");
			  //TODO 增加相关详细数据窗体创建
		  }else if(e.getSource().equals(mainui.getP5().getDetail())){
			  System.out.println("eeeee");
			  //TODO 增加相关详细数据窗体创建
		  }else if(e.getSource().equals(mainui.getLarrow())){
			  System.out.println("上一页");
			//TODO 更新相关request信息
		  }else if(e.getSource().equals(mainui.getRarrow())){
			  System.out.println("下一页");
			//TODO 更新相关request信息
		  }
	  }
	
	
	
}
