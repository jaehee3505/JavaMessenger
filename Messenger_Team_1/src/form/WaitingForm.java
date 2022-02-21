package form;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class WaitingForm extends JFrame{
	
	public WaitingForm(){
		JLabel label = new JLabel("Waiting");
		this.add("Center",label);
		this.setSize(200,100);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
