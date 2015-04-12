package panel;

public class PatientModel extends UserModel{

	//private ArrayList<String> userName;
	//private ArrayList<String> userPassword;
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

	@Override
	public int getUserType() {
		return 1;
	}

	@Override
	public void addUser(String name, String password) {
		// TODO Auto-generated method stub
		
	}
	
}
