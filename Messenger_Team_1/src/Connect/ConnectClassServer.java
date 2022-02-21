package Connect;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database.DBManager;
import form.IPForm;
import form.LoginForm;

public class ConnectClassServer {
	IPForm ipForm;
	String ip;
	String port;
	public Socket socket;
	public InputStream in;
	public OutputStream out;
	public ObjectInputStream oin;
	public ObjectOutputStream oout;
	public LoginForm login;
	
	public ConnectClassServer(String ip, String port) {
		this.ip = ip;
		this.port = port;
		int portInt =Integer.parseUnsignedInt(port);
		try {
			socket = new Socket(ip,portInt);
			in = socket.getInputStream();
			out = socket.getOutputStream();
			oout = new ObjectOutputStream(out);
			oin = new ObjectInputStream(in);
		} catch (Exception e1) {
			System.exit(0);
		} 
		new RecvThreadServer(this).start();
	}
}
class RecvThreadServer extends Thread{
	ConnectClassServer con;
	ChattingFormServer chat;
	DBManager dm;
	public RecvThreadServer(ConnectClassServer con) {
		dm = new DBManager();
		this.con = con;
		this.chat = new ChattingFormServer(con);
	}
	@Override
	public void run() {
		try {
			while(true) {
				HashMap<String , Object> response = (HashMap<String , Object>)con.oin.readObject();
				if(response.isEmpty()) {
					break;
				}
				switch((int)response.get("protocol")) {
				case 1201:
					LocalDate now = LocalDate.now();
					dm.saveLog("["+now+"]",(String)response.get("msg"));
					chat.area.append((String)response.get("msg")+"\r\n");
					break;
					}
				} 
			}
			catch (Exception e) {
				try {
					con.in.close();
					con.out.close();
					con.oin.close();
					con.oout.close();
					con.socket.close();
					}
				catch (Exception e1) {}
		}
	}
}
class ChattingFormServer extends JFrame{
	public ConnectClassServer con;
	public JTextArea area;
	JScrollPane sp;
	public JTextField field;
	
	public ChattingFormServer(ConnectClassServer con) {
		this.con = con;
		setTitle("[서버로그] 채팅로그 관리창");
		this.setLayout(new BorderLayout());
		area = new JTextArea();
		area.setEditable(false);
		sp = new JScrollPane(area); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field = new JTextField();
		ChatEventServer chatEvt = new ChatEventServer(this);
		field.addActionListener(chatEvt);
		this.add("Center",sp);
		this.add("South",field);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

class ChatEventServer implements ActionListener{

	ChattingFormServer chatF;
	public ChatEventServer(ChattingFormServer chatF) {
		this.chatF = chatF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = chatF.field.getText();
		if(msg == null || msg.length() == 0) {
			return;
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("protocol", 1201);
		map.put("msg", msg);
		try {
			chatF.con.oout.writeObject(map);
		} catch (Exception e1) {}
		
		chatF.field.setText("");
	}
	
}