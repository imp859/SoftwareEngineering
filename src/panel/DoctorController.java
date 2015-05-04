package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;

public class DoctorController implements ActionListener, WindowListener{

	private DoctorView view;
	private UserModel model;
	private Session session;
	private ChooseDoctorView mainDoctorSessionView;
	
	// passed patientview and user model
	public DoctorController(DoctorView view, UserModel userModel, Session session, ChooseDoctorView otherView){
		this.view = view;
		this.model = userModel;
		this.session = session;
		this.mainDoctorSessionView = otherView;
	}

	public void actionPerformed(ActionEvent e) {
		// changes first name and last name of patient. just a test. will be changed to modify address, etc.
		if(e.getActionCommand().equals("Update Info")){
			model.setEmail(view.getEmailText());
		} else if(e.getActionCommand().equals("Change Password")){
			// TODO
		} else if(e.getActionCommand().equals("View Calendar")){
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

