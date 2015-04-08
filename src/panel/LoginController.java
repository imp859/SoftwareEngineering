package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

	private LoginPanel view;
	private PatientModel patientModel;

	public LoginController(LoginPanel otherView, PatientModel otherPatientModel) {
		this.view = otherView;
		this.patientModel = otherPatientModel;
	}

	// temporary boolean method. will probably return a session state of a user
	// later.
	// these parameters passed from view
	public boolean checkCredentials(String userName, char[] passwordArray)
			throws Exception {
		boolean flag = false;
		String password = new String(passwordArray);
		// check is kind of a hack. will need to test more
		System.out.println(patientModel.listSize());
		for (int i = 0; i < patientModel.listSize(); i++) {
			if (userName.equals(patientModel.getUserName(i))
					&& password.equals(patientModel.getUserPassword(i))) {
				flag = true;
				break;
			}
		}
		/*
		 * TODO throw exception in view. maybe JOptionPane?
		 */
		if (flag == false){
			throw new Exception();
		}		

		return flag;
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
			view.resetFields();
		} else if (action.equals("Login")) {
			view.getMainPanel().setVisible(false);
			view.getNewUserPanel().setVisible(false);
			view.getLoginPanel().setVisible(true);
			// TODO call controller checkCredenials in view
		} else if (action.equals("Sign In")) {
			view.checkUser(this);
			view.resetPassword();
		} else {
			view.resetFields();
			view.getMainPanel().setVisible(true);
			view.getNewUserPanel().setVisible(false);
			view.getLoginPanel().setVisible(false);
			view.getPatientPanel().setVisible(false);
		}
	}

}
