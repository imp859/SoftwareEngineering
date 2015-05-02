package panel;

/**
 * will hold doctors information
 * @author Stephen's Laptop
 *
 */

public class NurseModel extends UserModel{

	private int appt;
	private String firstname, lastname, password, userName, email, address, phoneNum;
	
	public NurseModel(String firstName, String lastName, String userName,
			char[] otherPassword, String email, String address, String phoneNum){
		this.firstname = firstName;
		this.lastname = lastName;
		if(otherPassword != null){
			String tmpPassword = new String(otherPassword);
			this.password = tmpPassword;
		}
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	
	@Override
	public int getUserType() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void setAppt() {
		appt = 1;
	}

	public void setPassword(String otherPassword) {
		password = otherPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String name) {
		firstname = name;
	}

	public void setLastName(String name) {
		lastname = name;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getUserName() {
		return this.userName;
	}

	// for the staff and doctor(maybe?) view
	public int getAppt() {
		return appt;
	}

	public String getLastName() {
		return this.lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void addUser(String name, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUserMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
