package form;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;


public class DownloadForm extends JFileChooser{
	JLabel l1;
	File file;
	ChattingForm chat;
	public DownloadForm(ChattingForm chat) {
		this.chat = chat;
	}
	
	public File downloadForm() {
		this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.showDialog(chat, null);
		file = this.getSelectedFile();
		return file;
	}

}
