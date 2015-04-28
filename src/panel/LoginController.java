package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class LoginController implements ActionListener {

	private LoginPanel view;
	private PatientView patientView;
	private Session session;
	private PatientModel patientModel;
	private CreateUser createUser;
	private ArrayList<UserModel> users;
	private String patient;
	private int index;
	
	//passed the home screen view and arraylist of users
	public LoginController(LoginPanel otherView, ArrayList otherUserModel) {
		this.view = otherView; // assign this view to the view that was passed
		session = new Session(); //create new session
		createUser = new CreateUser(otherView, otherUserModel);
		this.users = otherUserModel;
	}

	
	// returns Session state of a user. parameters passed from view
	public Session checkCredentials(String userName, char[] passwordArray)
			throws Exception {
		// one user can be logged in at a time
		if(session.getSessionStatus() == true){
			throw new Exception();
		}
		// convert password from char[] into string
		String password = new String(passwordArray);
		// goes through arraylist and returns a session of a valid user
		for (int i = 0; i < users.size(); i++) {
			// match is found
			if (userName.equals(users.get(i).getUserName())
					&& password.equals(users.get(i).getPassword())) {
				index = i; // gives the particular user when logging in and scheduling appt.
				patient = users.get(i).getUserName(); // username shown at log in
				session.getSession(users.get(i).getUserType()); // session type depends on user
				session.initSession(users.get(i).getFirstName(), users.get(i)
						.getFirstName(), users.get(i).getPassword(),
						users.get(i).getUserName());
				return session;
			}
		}
		//throwing exception which generates JOptionPane in view. user was not found
		throw new Exception();
	}
	
	/*public PatientModel initNewUser() {
		// pass fields from view into patient model
		// ignore this if statement
		if (view.getComboBoxSelection().equalsIgnoreCase("Doctor")) {
			System.out.println("you selected doctor");
		}
		// create new user with information in home screen textfields
		PatientModel newUser = new PatientModel(view.getNewFirstName(),
				view.getNewLastName(), view.getNewUserName(),
				view.getNewPassword(), view.getNewUserEmail(), view.getNewUserPhoneNum(),
				view.getNewUserAddress());
		return newUser;

	}*/

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("New User")) {
			// sets the new info panel visible 
			view.getMainPanel().setVisible(false);
			view.getNewUserPanel().setVisible(true);
			view.getLoginPanel().setVisible(false);
		} else if (action.equals("Submit")) {
			// creates a new user and returns to home screen
			view.getMainPanel().setVisible(true);
			view.getLoginPanel().setVisible(false);
			view.getNewUserPanel().setVisible(false);
			if(view.getComboBoxSelection().equals("Patient")){
				users.add(createUser.createPatient()); // add user to arraylist
			} else if(view.getComboBoxSelection().equals("Doctor")){
				if(createUser.authenticateNewUser() == 1){
					users.add(createUser.createDoctor()); // Create doctor
				}
			} else if(view.getComboBoxSelection().equals("Nurse")){
				if(createUser.authenticateNewUser() == 2){
					//Create nurse
				}
			} else if(view.getComboBoxSelection().equals("Staff")){
				if(createUser.authenticateNewUser() == 3){
					//Create staff
				}
			}
			view.resetFields(); // set textfields to "" string
		} else if (action.equals("Login")) {
			// sets existing patient login screen visible
			view.getMainPanel().setVisible(false);
			view.getNewUserPanel().setVisible(false);
			view.getLoginPanel().setVisible(true);
		} else if (action.equals("Sign In")) {		
			// make sure this user is a patient						
				if(view.checkUser(this) == 1){
				/* pass information about patient from model into patients view*/
					createUser.createPatientView(index, session);
				/*patientView = new PatientView(users.get(index).getUserName(),
						users.get(index).getFirstName(), users.get(index)
								.getLastName(), users.get(index).getPassword(),
						users.get(index).getEmail(), users.get(index)
								.getPhoneNum(), users.get(index).getAddress());
				/*initialize patient controller with the patient view and the specific patient model at index
				PatientController pc = new PatientController(patientView, users.get(index), session);
				patientView.registerListeners(pc);
				patientView.setVisible(true);
				patientView.setSize(350, 300);
				patientView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				*/}			
			view.resetPassword();
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
