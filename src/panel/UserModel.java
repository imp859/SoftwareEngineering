package panel;

import java.util.ArrayList;

public abstract class UserModel {

	//protected ArrayList<String> userName = new ArrayList<String>();
	//protected ArrayList<String> userPassword = new ArrayList<String>();
	
	public abstract int getUserType();
	public abstract void addUser(String name, String password);
	public abstract String getFirstName();
	public abstract String getPassword();
	public abstract String getUserName();
	public abstract void setAppt();
}
