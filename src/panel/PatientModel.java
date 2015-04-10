package panel;

public class PatientModel extends UserModel{

	//private ArrayList<String> userName;
	//private ArrayList<String> userPassword;
	private int appt;
	private String firstname, lastname;
	
	public PatientModel(){
		// store string temporarily to test authentication.
		userName.add("patient1");
		userPassword.add("password");
		
		userName.add("patient2");
		userPassword.add("password2");
		
		userName.add("patient3");
		userPassword.add("password3");
	}	
	
	public void addUser(String name, String password){
		userName.add(name);
		userPassword.add(password);
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
	
	// call this when clicking schedule appointment
	public void setAppt(){
		appt = 1;
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
	
	// for the staff and doctor(maybe?) view
	public int getAppt(){
		return appt;
	}

	@Override
	public int getUserType() {
		return 1;
	}
	
}
