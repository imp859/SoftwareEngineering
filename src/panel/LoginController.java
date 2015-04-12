package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class LoginController implements ActionListener {

	private LoginPanel view;
	private Session session;
	private PatientModel patientModel;
	private ArrayList<UserModel> users;
	private String patient;
	private int index;

	public LoginController(LoginPanel otherView, ArrayList otherUserModel) {
		this.view = otherView;
		//this.patientModel = otherPatientModel;
		session = new Session();
		this.users = otherUserModel;
	}

	// temporary boolean method. will probably return a session state of a user
	// later.
	// these parameters passed from view
	public Session checkCredentials(String userName, char[] passwordArray)
			throws Exception {
		// one user can be logged in at a time
		if(session.getSessionStatus() == true){
			throw new Exception();
		}
		//boolean flag = false;
		String password = new String(passwordArray);
		// check is kind of a hack. will need to test more
		/*
		for (int i = 0; i < patientModel.listSize(); i++) {
			if (userName.equals(patientModel.getUserName(i))
					&& password.equals(patientModel.getUserPassword(i))) {
				int userTypeID = patientModel.getUserType();
				patient = patientModel.getUserName(i);
				Session session = new Session();
				session.getSession(userTypeID);
				return session;
			}
		}*/
		for (int i = 0; i < users.size(); i++) {
			if (userName.equals(users.get(i).getUserName())
					&& password.equals(users.get(i).getPassword())) {
				index = i; // gives the particular user when logging in and scheduling appt.
				patient = users.get(i).getUserName(); // username shown at log in
				//Session session = new Session();
				session.getSession(users.get(i).getUserType()); // session type depends on user
				return session;
			}
		}
		/*
		 * TODO throw exception in view. maybe JOptionPane?
		 */
		throw new Exception();
	}
	
	public PatientModel initNewUser(){
		// pass fields from view into patient model
		PatientModel newUser = new PatientModel(view.getNewFirstName(), view.getNewLastName(), view.getNewUserName());
		String password = new String(view.getNewPassword());
		newUser.setPassword(password);
		return newUser;
		
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("New User")) {
			view.getMainPanel().setVisible(false);
			view.getNewUserPanel().setVisible(true);
			view.getLoginPanel().setVisible(false);
		} else if (action.equals("Submit")) {
			view.getMainPanel().setVisible(true);
			view.getLoginPanel().setVisible(false);
			view.getNewUserPanel().setVisible(false);
			PatientModel p = initNewUser();
			users.add(p); // add user to arraylist
			view.resetFields();
		} else if (action.equals("Login")) {
			view.getMainPanel().setVisible(false);
			view.getNewUserPanel().setVisible(false);
			view.getLoginPanel().setVisible(true);
		} else if (action.equals("Sign In")) {
			view.checkUser(this);
			view.getPatientTitleText().setText(patient);
			view.getPatientTitleText().setHorizontalAlignment(SwingConstants.CENTER);
			view.resetPassword();
		} else if (action.equals("Schedule Appointment")){
			// check if this user has permission to schedule appt.
			if(users.get(index).getUserType() == 1){
			  users.get(index).setAppt();
			}
			view.setApptNotification(users.get(index).getUserType());
		}
		else {
			view.resetFields();
			view.getMainPanel().setVisible(true);
			view.getNewUserPanel().setVisible(false);
			view.getLoginPanel().setVisible(false);
			view.getPatientPanel().setVisible(false);
			// log out the user when they hit the home button
			session.logOut();
		}
	}

}
