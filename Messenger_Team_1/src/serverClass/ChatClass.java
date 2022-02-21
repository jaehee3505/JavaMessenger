package serverClass;

import java.util.HashMap;

import thread.ClientThread;

/**
 * 
 * @author ������
 *	ä�� ���� ó�� Ŭ����
 */

public class ChatClass  {
	ClientThread client;
	public ChatClass(ClientThread client) {
		this.client = client;
	}
	
	public HashMap<String,Object> chatProc(HashMap<String, Object> request) {
		if(client.name == null) {
			client.name = "Server";
		}
		String msg = "[ "+ client.name + " ] " + (String)request.get("msg");
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("protocol", 1201);
		map.put("msg", msg);
		
		return map;
	
	}

}
