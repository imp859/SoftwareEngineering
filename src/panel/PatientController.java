package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class PatientController implements ActionListener, WindowListener{

	private PatientView view;
	private UserModel model;
	private ArrayList<UserModel> users;
	private Session session;
	
	// passed patientview and user model
	public PatientController(PatientView view, UserModel userModel, Session session, ArrayList<UserModel> users){
		this.view = view;
		this.model = userModel;
		this.users = users;
		this.session = session;
	}

	public void actionPerformed(ActionEvent e) {
		// changes first name and last name of patient. just a test. will be changed to modify address, etc.
		if(e.getActionCommand().equals("Update Info")){
			model.setEmail(view.getEmailText());
			model.setPhoneNum(view.getPhoneNumText());
			model.setAddress(view.getAddressText());
		} else if(e.getActionCommand().equals("Change Password")){
			// TODO
		} else if(e.getActionCommand().equals("Send/Check Message")){
			view.showMessageArea();			
		} else if(e.getActionCommand().equals("Back")){
			view.showInfoArea();
		} else if(e.getActionCommand().equals("Send Message")){
			for(int i = 0; i < users.size(); i++){
				if(users.get(i).getUserType() == 3){
					users.get(i).setMessage(view.getMessageText());
					users.get(i).fromUser(view.getUserName());
				}
			}
		} else if(e.getActionCommand().equals("Schedule Appointment")){
			String userName = view.getUserName();
			int index = -1;
			for(int i = 0; i < users.size(); i++){
				if(userName.equals(users.get(i).getUserName())){
					index = i;
					break;
				}
			}
			if(index != -1){
				users.get(index).setAppt(view.getDate());
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
