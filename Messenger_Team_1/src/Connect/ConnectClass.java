package Connect;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import form.IPForm;
import form.LoginForm;
import thread.RecvThread;


public class ConnectClass {
	IPForm ipForm;
	String ip;
	String port;
	public Socket socket;
	
	public InputStream in;
	public OutputStream out;
	public ObjectInputStream oin;
	public ObjectOutputStream oout;
	public LoginForm login ;
	
	public ConnectClass(IPForm ipForm) {
		this.ipForm = ipForm;
		
		ip = ipForm.ipF.getText();
		port = ipForm.portF.getText();
		int port =Integer.parseUnsignedInt(ipForm.portF.getText());
		try {
			socket = new Socket(ip,port);
			in = socket.getInputStream();
			out = socket.getOutputStream();
			oout = new ObjectOutputStream(out);
			oin = new ObjectInputStream(in);
		} catch (Exception e1) {
			System.exit(0);
		} 
		
		ipForm.setVisible(false);
		
		login = new LoginForm(this);
		new RecvThread(this, login).start();

	}

}
