package form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.DBManager;


public class Join extends JFrame {
	
	private JPanel contentPane;
	private JTextField tf_JoinId;
	private JTextField tf_JoinName;
	private JPasswordField pf_JoinPw;
	private DBManager dm;
	
	public Join() {
		dm = new DBManager();
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setBounds(100,100,300,205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setBounds(39,28,27,15);
		panel.add(lblID);
		
		tf_JoinId = new JTextField();
		tf_JoinId.setBounds(96,25,116,21);
		panel.add(tf_JoinId);
		tf_JoinId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PW :");
		lblNewLabel.setBounds(39,59,26,15);
		panel.add(lblNewLabel);
		
		pf_JoinPw = new JPasswordField();
		pf_JoinPw.setBounds(96,59,116,21);
		panel.add(pf_JoinPw);
		pf_JoinPw.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setBounds(39,90,45,15);
		panel.add(lblNewLabel_1);	
		
		tf_JoinName = new JTextField();
		tf_JoinName.setBounds(96, 87, 116, 21);
		panel.add(tf_JoinName);
		tf_JoinName.setColumns(10);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
		JButton btnJoinOk = new JButton("\uC644\uB8CC");
		btnJoinOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.registInfo(tf_JoinId.getText(), pf_JoinPw.getText(), tf_JoinName.getText());
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				dispose();
			}
		});
		btnJoinOk.setBounds(42, 118, 97, 23);
		panel.add(btnJoinOk);
		JButton btnJoinBack = new JButton("\uCDE8\uC18C");
		btnJoinBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnJoinBack.setBounds(149,118,97,23);
		panel.add(btnJoinBack);

	}

}
