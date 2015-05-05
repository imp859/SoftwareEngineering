package panel;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

import sun.audio.*;

/***
 * initial screen to login or create a user.
 * @author Stephen's Laptop
 *
 */

public class LoginPanel extends JFrame{
	
	private int smallTxt = 26;
	
	//private PatientView patientView;
	private GridLayout loginLayout;
	private GridLayout infoLayout;
	private GridLayout patientLayout;
	private ImageIcon logo;
	private JPanel panel;
	private JPanel logoPanel;
	private JPanel newUserPanel;
	
	private JPanel loginPanel;
	private JButton signIn;
	private JLabel existingUserEnter;
	private JTextField existingUser;
	private JLabel existingPasswordEnter;
	private JPasswordField existingPassword;
	
	private JPanel patientPanel;
	private JLabel patientTitle;
	private JButton scheduleAppt;
	
	private JButton logoButton;
	private JButton newUser;
	private JButton login;
	private JButton submit;
	private JLabel title;
	private JLabel descriptionOne;
	private JLabel descriptionTwo;
	private JLabel nameOne;
	private JLabel nameTwo;
	private JLabel emailEnter;
	private JLabel typeEnter;
	private JLabel usernameEnter;
	private JLabel passwordEnter;
	private JLabel phoneNumberEnter;
	private JLabel addressEnter;
	private JLabel DOB;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField userName;
	private JTextField phoneNumber;
	private JTextField address;
	private JTextField birthday;
	private JPasswordField password;
	private String[] types;
	private JComboBox userType;
	
	private InputStream chimeStream;
	private AudioStream chime;
	
	private InputStream noticeStream;
	private AudioStream notice;
	
	
	public LoginPanel(){
		super("Patient Portal");
		//setLayout(new FlowLayout());
		
		loginLayout = new GridLayout(6, 0, 0, 5); //initial home screen layout
		infoLayout = new GridLayout(10, 2, 0, 1); // new user layout
		patientLayout = new GridLayout(2, 0, 0, 1);
		logo = new ImageIcon("src/panel/pppicture.png");
		panel = new JPanel(); // initial home screen panel
		logoPanel = new JPanel();
		newUserPanel = new JPanel();
		patientPanel = new JPanel();
		scheduleAppt = new JButton("Schedule Appointment");
		
		logoButton = new JButton();
		newUser = new JButton("New User");
		login = new JButton("Login");
		submit = new JButton("Submit");
		
		title = new JLabel("Welcome to the Patient Portal System!", SwingConstants.CENTER);
		descriptionOne = new JLabel("If you are new to the system, please click \"NewUser\" to create an account", SwingConstants.CENTER);
		descriptionTwo = new JLabel("Otherwise, please click \"Login\"", SwingConstants.CENTER);
		nameOne = new JLabel("First Name:");
		nameTwo = new JLabel("Last Name:");
		emailEnter = new JLabel("Email:");
		DOB = new JLabel("Date of Birth:");
		typeEnter = new JLabel("User Type:");
		usernameEnter = new JLabel("Username:");
		passwordEnter = new JLabel("Password:");
		phoneNumberEnter = new JLabel("Phone Number:");
		addressEnter = new JLabel("Address:");
		firstName = new JTextField(smallTxt);
		lastName = new JTextField(smallTxt);
		email = new JTextField(smallTxt);
		birthday = new JTextField(smallTxt);
		userName = new JTextField(smallTxt);
		phoneNumber = new JTextField(smallTxt);
		address = new JTextField(smallTxt);
		password = new JPasswordField(smallTxt);
		types = new String[]{"Patient", "Doctor", "Nurse", "Staff"};
		userType = new JComboBox<String>(types);

		int scale = 2;
		int width = logo.getIconWidth();
		int newWidth = width / scale;
		logoButton.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1, Image.SCALE_SMOOTH)));
		logoPanel.add(logoButton);
		// add layout and buttons to initial screen
		panel.setLayout(loginLayout);
		panel.add(title);
		panel.add(descriptionOne);
		panel.add(descriptionTwo);
		panel.add(newUser);
		panel.add(login);
		/*add layout, textfields, and buttons to new user panel*/
		newUserPanel.setLayout(infoLayout);
		newUserPanel.add(nameOne);
		newUserPanel.add(firstName);
		newUserPanel.add(nameTwo);
		newUserPanel.add(lastName);
		newUserPanel.add(emailEnter);
		newUserPanel.add(email);
		newUserPanel.add(DOB);
		newUserPanel.add(birthday);
		newUserPanel.add(typeEnter);
		newUserPanel.add(userType);
		newUserPanel.add(usernameEnter);
		newUserPanel.add(userName);
		newUserPanel.add(passwordEnter);
		newUserPanel.add(password);
		newUserPanel.add(phoneNumberEnter);
		newUserPanel.add(phoneNumber);
		newUserPanel.add(addressEnter);
		newUserPanel.add(address);
		newUserPanel.add(submit);
		// exisiting patient layout and panel
		patientPanel.setLayout(patientLayout);
		
		/*
		patientTitle = new JLabel();
		
		patientPanel.add(patientTitle);
		patientPanel.add(scheduleAppt);*/
		
		loginPanel = new JPanel(new GridLayout(3, 2, 0, 0));
		// creating relevant buttons and textfields
		existingUserEnter = new JLabel("UserName: ");
		existingUser = new JTextField(20);
		existingPasswordEnter = new JLabel("PassWord: ");
		existingPassword = new JPasswordField(20);
		signIn = new JButton("Sign In");		
		// adding them to panel
		loginPanel.add(existingUserEnter);
		loginPanel.add(existingUser);
		loginPanel.add(existingPasswordEnter);
		loginPanel.add(existingPassword);
		loginPanel.add(signIn);
		
		add(logoPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		add(newUserPanel, BorderLayout.SOUTH);
		add(loginPanel, BorderLayout.SOUTH);
		add(patientPanel, BorderLayout.SOUTH);
		// hide panels
		newUserPanel.setVisible(false);
		loginPanel.setVisible(false);
		patientPanel.setVisible(false);
	}
	
	// adds action listeners for relevant buttons
	public void registerListeners(LoginController lc){
		login.addActionListener(lc);
		newUser.addActionListener(lc);
		logoButton.addActionListener(lc);
		submit.addActionListener(lc);
		signIn.addActionListener(lc);
		scheduleAppt.addActionListener(lc);
	}
	// clears information in textfields. usually upon hitting home button
	public void resetFields(){
		firstName.setText("");
		lastName.setText("");
		email.setText("");
		userName.setText("");
		password.setText("");
		phoneNumber.setText("");
		address.setText("");
	}
	// returns true only if password has at least eight characters, consists of only letters
	// and numbers, and contains at least one digit.
	public boolean isValidPassword(String password){
		char c;
		boolean flag1,flag2,flag3;
		flag1 = flag2 = false;
		flag3 = true;
		if(password.length()<8)
			flag1 = true;
		for(int i = 0; i < password.length(); i++){
			c = password.charAt(i);
			if(!Character.isLetterOrDigit(c))
				flag2 = true;
			if(Character.isDigit(c)&&flag3 == true)
				flag3 = false;
		}
		if(flag1 || flag2 || flag3){
			JOptionPane.showMessageDialog(null, "Password Error:\n"
					+ "********************\n"
					+ "Password must:\n"
					+ "1) Have a length of 8 or more characters long,\n"
					+ "2) Contain only letters and numbers,\n"
					+ "3) Contain at least one number.\n"
					+ "********************\n"
					+ "Please try again.");
			return false;
		} 
		return true;
	}
		
	public String getComboBoxSelection(){
		return (String)userType.getSelectedItem();
	}
	
	/*returns the contents of a JTextField*/
	public String getNewFirstName(){
		return firstName.getText();
	}
	
	public String getNewLastName(){
		return lastName.getText();
	}
	
	public String getNewUserName(){
		return userName.getText();
	}
	
	public String getNewUserEmail(){
		return email.getText();
	}
	
	public String getNewUserDOB()
	{
		return birthday.getText();
	}
	
	public String getNewUserAddress(){
		return address.getText();
	}
	
	public String getNewUserPhoneNum(){
		return phoneNumber.getText();
	}
	
	public char[] getNewPassword(){
		return password.getPassword();
	}
	
	public void resetPassword(){
		existingUser.setText("");
		existingPassword.setText("");
	}
	
	public JLabel getPatientTitleText(){
		return this.patientTitle;
	}
	
	//temporary check method to test authentication
	public int checkUser(LoginController lc){
		// called in controller. checks for a valid user. catches error if invalid
		try {
			// passed the username and password into checkCredentials method in controller
			lc.checkCredentials(existingUser.getText(), existingPassword.getPassword());
			try {
				chimeStream = new FileInputStream("src/panel/chime.wav");
				chime = new AudioStream(chimeStream);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			AudioPlayer.player.start(chime);
			return 1;
		} catch (Exception e) {
			try {
				// error checks wav file
				noticeStream = new FileInputStream("src/panel/notice_chime.wav");
				notice = new AudioStream(noticeStream);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
			AudioPlayer.player.start(notice);
			// popup showing invalid credentials
			JOptionPane.showMessageDialog(signIn, "Invalid Credentials");
			return 0;
		}
	}

	/*returns a JPanel*/
	
	public void setApptNotification(){
		AudioPlayer.player.start(notice);
		JOptionPane.showMessageDialog(scheduleAppt, "Your appointment request has been sent");
	}

	public JPanel getLoginPanel(){
		return this.loginPanel;
	}
	
	public void duplicateUserName(){
		JOptionPane.showMessageDialog(loginPanel, "1. UserName already exists in system\n"
				+ "2. There cannot be a space in the user name");
	}
	
	public void invalidEmail(){
		JOptionPane.showMessageDialog(loginPanel, "Email must:\n"
				+ "1. Have one @ character\n"
				+ "2. End with .net, .com, or .org\n"
				+ "3. Cannot start with @ character");
	}
	
	public void invalidPhoneNumber(){
		JOptionPane.showMessageDialog(loginPanel, "Phone Number must "
				+ "have one of the following formats:\n"
				+ "1. 1112223333\n"
				+ "2. 111-222-3333\n"
				+ "3. 1-222-333-4444");
	}
	
	public JPanel getMainPanel(){
		return this.panel;
	}
	
	public JPanel getNewUserPanel(){
		return this.newUserPanel;
	}
	
	public JPanel getPatientPanel(){
		return this.patientPanel;
	}
	
}