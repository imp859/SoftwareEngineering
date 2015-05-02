package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class StaffController implements ActionListener, WindowListener{

	private StaffView view;
	private ArrayList<UserModel> patients;
	private UserModel model;
	private UserModel patient;
	private Session session;
	
	public StaffController(StaffView view, UserModel model, Session session, ArrayList<UserModel> patients){
		this.view = view;
		this.model = model;
		this.patients = patients;
		this.session = session;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Check/Send Patient Message")) {
			view.showMessage();
		} else if (e.getActionCommand().equals("Back")) {
			view.showStaffInfo();
		} else if (e.getActionCommand().equals("Send Message")) {
			String userName = view.getPatientUserName();
			int index = -1;
			for (int i = 0; i < patients.size(); i++) {
				if (userName.equals(patients.get(i).getUserName())) {
					index = i;
					break;
				}
			}
			if (index != -1) {
				patients.get(index).setMessage(view.getMessage());
			} else {
				view.invalidMessage();
			}
		}
	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		this.session.logOut();
	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
