package panel;

/**
 * user models(i.e. staff, patient, nurse, doctor) will
 * implement this class to we can have one arraylist of 
 * abstracted users. also simplifies the specific user models.
 * @author Stephen's Laptop
 *
 */

public abstract class UserModel {
	
	public abstract int getUserType();
	public abstract void addUser(String name, String password);
	public abstract String getFirstName();
	public abstract void setFirstName(String name);
	public abstract void setLastName(String name);
	public abstract void setEmail(String email);
	public abstract void setPhoneNum(String phoneNum);
	public abstract void setAddress(String address);
	public abstract String getLastName();
	public abstract String getPassword();
	public abstract String getUserName();
	public abstract void setAppt(String date);
	public abstract String getAppt();
	public abstract String getEmail();
	public abstract String getPhoneNum();
	public abstract String getAddress();
	public abstract void setMessage(String message);
	public abstract String getUserMessage();
	public abstract void fromUser(String user);
	public abstract String getPatientName();
}
