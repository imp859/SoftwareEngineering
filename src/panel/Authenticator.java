package panel;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Authenticator {

	private LoginPanel view;
	private ArrayList<UserModel> users;
	
	public Authenticator(LoginPanel otherView, ArrayList<UserModel> users){
		view = otherView;
		this.users = users;
	}
	
	private boolean checkUserName() {
		char ch;
		for(int i = 0; i < view.getNewUserName().length(); i++){
			if((ch = view.getNewUserName().charAt(i)) == ' '){
				view.duplicateUserName();
				return false;
			}
		}
		for (int i = 0; i < users.size(); i++) {
			if (view.getNewUserName().equalsIgnoreCase(
					users.get(i).getUserName())) {
				view.duplicateUserName();
				return false;
			}
		}
		return true;
	}
	
	private boolean checkEmail(){
		int flag = 0;
		int countAt = 0;
		String email = view.getNewUserEmail();
		String sub = email.substring(email.length() - 4, email.length());
		if (sub.equalsIgnoreCase(".net") || sub.equalsIgnoreCase(".com")
				|| sub.equalsIgnoreCase(".org")) {
			char ch;
			for (int i = 0; i < email.length() - 4; i++) {
				ch = email.charAt(i);
				if ((i != 0) && (ch == '@')) {
					countAt++;
					flag = 1;
				}
			}
			if (flag == 0 || countAt > 1) {
				view.invalidEmail();
				return false;
			}
			return true;
		}
		return false;
	}
	
	private boolean checkPhoneNumber(){
		int length = view.getNewUserPhoneNum().length();
		String phoneNum = view.getNewUserPhoneNum();
		char ch;
		if (length < 9) {
			view.invalidPhoneNumber();
			return false;
		}
		// format accepted(1112223333, 111-222-3333, 1-222-333-4444)
		if (length == 10 || length == 12 || length == 14) {
			if (length == 9) {
				for (int i = 0; i < length; i++) {
					ch = phoneNum.charAt(i);
					if (Character.isLetter(ch) || !Character.isDigit(ch)) {
						view.invalidPhoneNumber();
						return false;
					}
				}
				return true;
			}
			if (length == 12) {
				if (phoneNum.charAt(3) != '-' || phoneNum.charAt(7) != '-') {
					view.invalidPhoneNumber();
					return false;
				}
				for (int i = 0; i < length; i++) {
					ch = phoneNum.charAt(i);
					if ((i != 3 && i != 7) && Character.isLetter(ch)) {
						view.invalidPhoneNumber();
						return false;
					}
				}
			}
			if (length == 14) {
				if (phoneNum.charAt(1) != '-' || phoneNum.charAt(5) != '-'
						|| phoneNum.charAt(9) != '-') {
					view.invalidPhoneNumber();
					return false;
				}
				for (int i = 0; i < length; i++) {
					ch = phoneNum.charAt(i);
					if ((i != 1 && i != 5 && i != 9) && Character.isLetter(ch)
							|| !Character.isDigit(ch)) {
						view.invalidPhoneNumber();
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean checkAddress(){
		String address = view.getNewUserAddress();
		
		return true;
	}
	
	public boolean checkNewUserFields(){
		if((checkEmail() == false) || (checkUserName() == false) ||
				(checkPhoneNumber() == false))
			return false;
		return true;
	}
	
	public int authenticateNewUser(){
		String validateID = new String();
		validateID = (String)JOptionPane.showInputDialog("Enter Credentials: ");		
		if(validateID.equalsIgnoreCase("52rys46")){
			return 1; // doctor
		} else if(validateID.equalsIgnoreCase("4t37zD8HT")){
			return 2; // nurse
		} else if(validateID.equals("345")){
			return 3; // staff
		}
		return -1;
	}
}
