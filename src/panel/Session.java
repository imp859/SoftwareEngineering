package panel;

public class Session {
	
	private boolean canMakeAppt;
	private boolean canSeePatientView;
	private boolean loggedIn;
	
	public Session(){
		canMakeAppt = false;
		canSeePatientView = false;
		loggedIn = false;
	}
	
	public void getSession(int type){
		loggedIn = true;
		if(type == 1){
			canMakeAppt = true;
			canSeePatientView = true;
		}
	}
	
	public boolean getSessionStatus(){
		return loggedIn;
	}
	
	public void logOut(){
		loggedIn = false;
	}

	public boolean isCanMakeAppt() {
		return canMakeAppt;
	}

	public boolean isCanSeePatientView() {
		return canSeePatientView;
	}
	
}

