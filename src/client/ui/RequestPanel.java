package client.ui;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.common.Request;


public class RequestPanel extends JPanel{
	
	private JLabel username;
	private JLabel time;
	private JLabel cost;
	private JLabel content;
	private JLabel detail;
	public JLabel getUsername() {
		return username;
	}

	

	ImageIcon detailimage = new ImageIcon("images/next.png");
	
	public RequestPanel(Request r){
		this.setPreferredSize(new Dimension(280,90));
		this.setLayout(null);
		
		
		this.username = new JLabel();
		this.time = new JLabel();
		this.cost = new JLabel();
		this.content = new JLabel();
		this.detail = new JLabel();
		
		this.content.setText(r.getContent());
		this.content.setBounds(0, 0, 270, 70);
		this.username.setText(r.getUserName());
		this.username.setBounds(0, 70, 50, 20);
		this.time.setText(r.getTime());
		this.time.setBounds(40, 70, 60, 20);
		this.cost.setText(r.getCost()+"min");
		this.cost.setBounds(240, 70, 80, 20);
		
		this.detail = new JLabel(detailimage);
		this.detail.setBounds(230, 0, 50, 70);
		
		this.add(this.username);
		this.add(this.time);
		this.add(this.cost);
		this.add(this.content);
		this.add(this.detail);
	}
	
	public void change(Request r){
		this.content.setText(r.getContent());
		this.content.setBounds(0, 0, 270, 70);
		this.username.setText(r.getUserName());
		this.username.setBounds(0, 70, 50, 20);
		this.time.setText(r.getTime());
		this.time.setBounds(40, 70, 60, 20);
		this.cost.setText(r.getCost()+"min");
		this.cost.setBounds(260, 70, 80, 20);
	}
	
	public void setUsername(JLabel username) {
		this.username = username;
	}

	public JLabel getTime() {
		return time;
	}

	public void setTime(JLabel time) {
		this.time = time;
	}

	public JLabel getCost() {
		return cost;
	}

	public void setCost(JLabel cost) {
		this.cost = cost;
	}

	public JLabel getContent() {
		return content;
	}

	public void setContent(JLabel content) {
		this.content = content;
	}

	public JLabel getDetail() {
		return detail;
	}

	public void setDetail(JLabel detail) {
		this.detail = detail;
	}


	public ImageIcon getDetailimage() {
		return detailimage;
	}

	public void setDetailimage(ImageIcon detailimage) {
		this.detailimage = detailimage;
	}
}
