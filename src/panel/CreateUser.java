package panel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/***
 * called from logincontroller. used to
 * authenticate and create new users.
 * @author Stephen's Laptop
 *
 */

public class CreateUser {

	public PatientModel patientModel;
	public PatientController pc;
	public DoctorModel doctorModel;
	public PatientView patientView;
	public LoginPanel loginPanel;
	public ArrayList<UserModel> users;
	
	public CreateUser(LoginPanel lp, ArrayList<UserModel> users){
		loginPanel = lp;
		this.users = users;
	}
	
	public PatientModel createPatient(){
		PatientModel pm = new PatientModel(loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), loginPanel.getNewPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		return pm;
	}
	
	public void createPatientView(int index, Session session){
		patientView = new PatientView(users.get(index).getUserName(), users
				.get(index).getFirstName(), users.get(index).getLastName(),
				users.get(index).getPassword(), users.get(index).getEmail(),
				users.get(index).getPhoneNum(), users.get(index).getAddress());
		pc = new PatientController(patientView, users.get(index), session);
		patientView.registerListeners(pc);
		patientView.setVisible(true);
		patientView.setSize(350, 300);
		patientView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public DoctorModel createDoctor(){
		DoctorModel dm = new DoctorModel(loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), loginPanel.getNewPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		return dm;
	}
	
	public void createDoctorView(int index, Session session){
		// create new Doctor View
		
	}
	
	
	
	
	public int authenticateNewUser(){
		String validateID = new String();
		validateID = (String)JOptionPane.showInputDialog("Enter Credentials: ");
		if(validateID.equals("123")){
			return 1; // doctor
		} else if(validateID.equals("234")){
			return 2; // nurse
		} else if(validateID.equals("345")){
			return 3; // staff
		}
		return -1;
	}
	
}