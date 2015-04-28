package panel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

public class PatientPortalMain {

	public static void main(String[] args) {
		// arraylist of abstract users
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		/* hardcoded users and fields for testing */
		PatientModel p = new PatientModel("john", "doe", "john", null,
				"john@gmail.com", "123 address", "111-111-1111");
		p.setPassword("password");
		PatientModel q = new PatientModel("patient", "name", "patient", null,
				"patient@gmail.com", "321 address", "222-222-2222");
		q.setPassword("password2");
		// add two patients to user list
		users.add(p);
		users.add(q);
		Dimension minimumSize = new Dimension(800, 600);
		// create the login screen and initialize controller
		LoginPanel lp = new LoginPanel();
		LoginController lc = new LoginController(lp, users);

		lp.registerListeners(lc);

		lp.setSize(800, 600);
		lp.setMinimumSize(minimumSize);
		lp.setResizable(true);
		lp.setVisible(true);
		lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
