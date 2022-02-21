package serverClass;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import thread.AcceptThread;
import database.DBManager;


public class ChatServer {
	
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	JTextArea textArea;
	JTextField textField;
	
	public ServerSocket server;
	
	public ChatServer(int socketPort) {
		try {
			server = new ServerSocket(socketPort);
			System.out.println("[ "+InetAddress.getLocalHost()+" ] - 서버소켓 생성");
		}catch(Exception e) {
			System.out.println("::: 서버 소켓생성 오류 :::");
			System.exit(0);
		}
		new AcceptThread(this).start();
	}
	
}