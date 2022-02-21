package form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connect.ConnectClass;


public class IPForm extends JFrame{
	
	JLabel ipL,portL,titleL;
	public JTextField ipF,portF;
	JButton connectBtn;
	
	public IPForm() {
		setTitle("채팅방 주소&포트 입력창");
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		titleL = new JLabel("접속할 채팅방 IP&PORT 입력");	
		ipL = new JLabel("IP : ");
		portL = new JLabel("PORT : " );
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.add(titleL);
		p1.setLayout(new GridLayout(2,1));
		p1.add(ipL);
		p1.add(portL);
		
		JPanel p2 = new JPanel();
		ipF = new JTextField();
		portF = new JTextField();
		p2.setLayout(new GridLayout(2,1));
		p2.add(ipF);
		p2.add(portF);
		
		connectBtn = new JButton("접속");
		connectBtn.addActionListener(e->{
			if(ipF.getText().length()==0 || portF.getText().length()==0) {
				JOptionPane.showMessageDialog(IPForm.this, "아이피와 포트를 입력하세요.");
			}else {
				new ConnectClass(IPForm.this);
			}
			
		});
		JPanel p01 = new JPanel();
		p01.setLayout(new BorderLayout());
		p01.add("North",p);
		p01.add("West",p1);
		p01.add("Center",p2);
		p01.add("East",connectBtn);
		p01.setBorder(BorderFactory.createEmptyBorder(10 , 15 , 50 , 15));
		this.add(p01);
		this.setSize(350,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
