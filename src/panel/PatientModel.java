package panel;


/***
 * stores information about a patient. bunch
 * of getters and setters
 * @author Stephen's Laptop
 *
 */

public class PatientModel extends UserModel{

	private int appt;
	private String firstname, lastname, password, userName;
	
	
	//eventually all textfield info from view will be passed into constructor
	public PatientModel(String firstName, String lastName, String userName){
		// TODO enforce better constraints
		this.firstname = firstName;
		this.lastname = lastName;
		this.userName = userName;
	}	
	
	
	// call this when clicking schedule appointment
	public void setAppt(){
		appt = 1;
	}
	
	public void setPassword(String otherPassword){
		password = otherPassword;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setFirstName(String name){
		firstname = name;
	}
	
	public void setLastName(String name){
		lastname = name;
	}
	
	public String getFirstName(){
		return firstname;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	// for the staff and doctor(maybe?) view
	public int getAppt(){
		return appt;
	}
	
	public String getLastName(){
		return this.lastname;
	}

	public int getUserType() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void addUser(String name, String password) {
		// TODO Auto-generated method stub
		
	}
}
