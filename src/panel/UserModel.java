package panel;

/**
 * user models(i.e. staff, patient, nurse, doctor) will
 * implement this class to we can have one arraylist of 
 * abstracted users. also simplifies the specific user models.
 * @author Stephen's Laptop
 *
 */

public abstract class UserModel {
	
	// users trying to create an account as a doctor will have to enter this doctor id
	protected String doctorID = "123";
	
	public abstract int getUserType();
	public abstract void addUser(String name, String password);
	public abstract String getFirstName();
	public abstract void setFirstName(String name);
	public abstract void setLastName(String name);
	public abstract String getLastName();
	public abstract String getPassword();
	public abstract String getUserName();
	public abstract void setAppt();
}
