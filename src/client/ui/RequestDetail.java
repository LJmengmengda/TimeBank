package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * RequestDetail界面
 * @author 李湘识
 *
 */

public class RequestDetail extends JFrame{

	// 主函数
	public static void main(String[] args) {
		RequestDetail rd = new RequestDetail();
	}

	// 构造方法
	public RequestDetail()
	{
		this.setSize(350, 600);
		this.setTitle("时间银行");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  // 设置关闭
		this.setLocationRelativeTo(null);      // 居中显示
		this.setIconImage(new ImageIcon("images/logo3.png").getImage());   // 设置窗体的图标
		
		/**
		 * JFrame默认是BorderLayout
		 */
		// 创建北部面板
		JPanel northPanel = this.createNorthPanel();
		this.add(northPanel, BorderLayout.NORTH);
		// 创建中部面板
		JPanel centerPanel = this.createCenterPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);      // 设置窗体可见
	}
	
	// 创建北边面板方法
	private JPanel createNorthPanel()
	{
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(350, 40));
		// 北部面板设置为绝对布局
		northPanel.setLayout(null);
		// 退出按钮
		JButton jb = new JButton("退出");  
		jb.setBounds(new Rectangle(10, 8, 60, 25));
		northPanel.add(jb);
		// 图片标签
		JLabel jl = new JLabel(new ImageIcon("images/logo3.png"));    // 图片按钮
		jl.setBounds(new Rectangle(290, 5, 30, 30));
		northPanel.add(jl);
		return northPanel;
	}
	
	// 创建中间面板方法
	private JPanel createCenterPanel()
	{
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        // 中部面板设置成绝对布局
        centerPanel.setLayout(null);
        
        /**
         * 设置各种标签文本输入框
         */
        JLabel nameLabel = new JLabel("姓   名：");
        nameLabel.setBounds(50, 50, 80, 30);
        JTextField nameTF = new JTextField();
        nameTF.setBounds(100, 50, 180, 28);
        
        JLabel costLabel = new JLabel(" cost  ：");
        costLabel.setBounds(50, 120, 80, 30);
        JTextField costTF = new JTextField();
        costTF.setBounds(100, 120, 180, 28);
        
        JLabel addressLabel = new JLabel("地  点：");
        addressLabel.setBounds(50, 190, 80, 30);
        JTextField addressTF = new JTextField();
        addressTF.setBounds(100, 190, 180, 28);
        
        JLabel contentLabel = new JLabel("内  容：");
        contentLabel.setBounds(50, 260, 80, 30);
        JTextArea contentTA = new JTextArea();      
        contentTA.setLineWrap(true);
        JScrollPane contentSP = new JScrollPane(contentTA);     // 滚动条
        contentSP.setBounds(100, 260, 180, 100);
        
        // 设置接受按钮
        JButton acceptBtn = new JButton("接  受");
        acceptBtn.setBounds(135, 450, 80, 30);
        
        /**
         * 将各种组件添加到中部面板里
         */
        centerPanel.add(nameLabel);
        centerPanel.add(nameTF);
        
        centerPanel.add(costLabel);
        centerPanel.add(costTF);
        
        centerPanel.add(addressLabel);
        centerPanel.add(addressTF);
        
        centerPanel.add(contentLabel);
        centerPanel.add(contentSP);
           
        centerPanel.add(acceptBtn);
        
		return centerPanel;
	}
	
}
