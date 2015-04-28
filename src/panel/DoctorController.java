package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DoctorController implements ActionListener, WindowListener{

	private DoctorView view;
	private UserModel model;
	private Session session;
	
	// passed patientview and user model
	public DoctorController(DoctorView view, UserModel userModel, Session session){
		this.view = view;
		this.model = userModel;
		this.session = session;
	}

	public void actionPerformed(ActionEvent e) {
		// changes first name and last name of patient. just a test. will be changed to modify address, etc.
		if(e.getActionCommand().equals("Update Info")){
			model.setEmail(view.getEmailText());
		} else if(e.getActionCommand().equals("Change Password")){
			// TODO
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

