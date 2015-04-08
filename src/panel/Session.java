package panel;

public class Session {
	
	private boolean canMakeAppt;
	private boolean canSeePatientView;
	
	public Session(){
		canMakeAppt = false;
		canSeePatientView = false;
	}
	
	public void getSession(int type){
		if(type == 1){
			canMakeAppt = true;
			canSeePatientView = true;
		}
	}

	public boolean isCanMakeAppt() {
		return canMakeAppt;
	}

	public boolean isCanSeePatientView() {
		return canSeePatientView;
	}
	
}

