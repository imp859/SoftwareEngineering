package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffController implements ActionListener{

	private StaffView view;
	private UserModel model;
	private Session session;
	
	public StaffController(StaffView view, UserModel model, Session session){
		this.view = view;
		this.model = model;
		this.session = session;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Check/Send Patient Message")){
			view.showMessage();
		} else if(e.getActionCommand().equals("Back")){
			view.showStaffInfo();
		}
	}

}
