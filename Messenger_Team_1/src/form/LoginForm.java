package form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import com.sun.tools.javac.Main;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connect.ConnectClass;
import event.LoginEvent;

public class LoginForm extends JFrame{
	private static final ActionListener Join = null;
	public JTextField idF;
	public JPasswordField pwF;
	JButton loginBtn, loginBtn2;
	JLabel logoL;
	public ConnectClass con;
	BufferedImage background = null;
	ImageIcon icon;
	LoginForm lf;
	private JPanel contentPane;
	
	public LoginForm(ConnectClass con) {
		setTitle("로그인창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.con = con;
		this.setLayout(new BorderLayout());
		
		JLabel lblLogin = new JLabel("userID");
		lblLogin.setBounds(41, 250, 69, 35);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 301, 69, 35);
		contentPane.add(lblPassword);

		idF = new JTextField();
		idF.setBounds(157, 250, 176, 35);
		contentPane.add(idF);
		idF.setColumns(10);
		
		pwF = new JPasswordField();
		pwF.setColumns(10);
		pwF.setBounds(157, 301, 176, 35);
		contentPane.add(pwF);

		LoginEvent lEvt = new LoginEvent(this);
		pwF.addActionListener(lEvt);
		
		
		loginBtn2 = new JButton("회원가입");
		loginBtn2.setBounds(229, 354, 104, 29);
		contentPane.add(loginBtn2);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(108, 354, 106, 29);
		contentPane.add(loginBtn);
		loginBtn.addActionListener(lEvt);
		
		
		logoL = new JLabel(new ImageIcon("src/backgroundImage/LoginBackground.png"));
		
		this.add("Center",logoL);
		this.setVisible(true);

		loginBtn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Join j = new Join();
		}
	});
	}
}

