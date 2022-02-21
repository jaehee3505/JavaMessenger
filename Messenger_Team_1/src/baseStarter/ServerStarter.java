package baseStarter;
import Connect.ConnectClassServer;
import serverClass.ChatServer;
import database.DBManager;

public class ServerStarter {
	public static void main(String[] args) {
		// ** DBManager에 들어가서 데이터 베이스를 꼭 자신꺼에 맞게 미리 설정해둘것 ** //
		new ChatServer(8000);
		new ConnectClassServer("localhost","8000");
		// ** DBManager에 들어가서 데이터 베이스를 꼭 자신꺼에 맞게 미리 설정해둘것 ** //
		
	}
}
