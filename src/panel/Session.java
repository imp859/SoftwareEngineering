package panel;

public class Session {
	
	private boolean canMakeAppt;
	private boolean canSeePatientView;
	private boolean loggedIn;
	private String firstName, lastName, password, userName;
	
	public Session(){
		canMakeAppt = false;
		canSeePatientView = false;
		loggedIn = false;
	}
	/* when this method is called we set logged in to true. once set to true
	 	another user should not be allowed to log in until logout method is called*/
	public void getSession(int type){
		loggedIn = true;
		// this user is a patient
		if(type == 1){
			canMakeAppt = true;
			canSeePatientView = true;
		}
	}
	
	public boolean getSessionStatus(){
		return loggedIn;
	}
	
	// logs a user out
	public void logOut(){
		loggedIn = false;
	}

	public boolean isCanMakeAppt() {
		return canMakeAppt;
	}

	public boolean isCanSeePatientView() {
		return canSeePatientView;
	}
	
	// ignore for now
	public void initSession(String firstName, String lastName, String passWord,
			String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = passWord;
		this.userName = userName;
	}
	
}

