package panel;

import java.util.ArrayList;

public class PatientModel {

	private ArrayList<String> userName;
	private ArrayList<String> userPassword;
	
	public PatientModel(){
		userName = new ArrayList<String>();
		userPassword = new ArrayList<String>();
		// store string temporarily to test authentication.
		userName.add("patient");
		userPassword.add("password");
		
		userName.add("patient2");
		userPassword.add("password2");
		
		userName.add("patient3");
		userPassword.add("password3");
	}
	
	public int listSize(){
		return this.userName.size();
	}
	
	public String getUserName(int index){
		return this.userName.get(index);
	}
	
	public String getUserPassword(int index){
		return this.userPassword.get(index);
	}
	
}
