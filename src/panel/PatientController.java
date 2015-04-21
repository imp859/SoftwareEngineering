package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientController implements ActionListener{

	private PatientView view;
	private UserModel model;
	
	// passed patientview and user model
	public PatientController(PatientView view, UserModel userModel){
		this.view = view;
		this.model = userModel;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// changes first name and last name of patient. just a test. will be changed to modify address, etc.
		if(e.getActionCommand().equals("Update Info")){
			model.setFirstName(view.getFirstNameText());
			model.setLastName(view.getLastNameText());
		}
		
	}
}
