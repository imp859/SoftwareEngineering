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
	
	//private PatientView patientView;
	private GridLayout loginLayout = new GridLayout(6, 0, 0, 5); //initial home screen layout
	private GridLayout infoLayout = new GridLayout(9, 2, 0, 1); // new user layout
	private GridLayout patientLayout = new GridLayout(2, 0, 0, 1);
	private ImageIcon logo = new ImageIcon("src/panel/pppicture.png");
	private JPanel panel = new JPanel(); // initial home screen panel
	private JPanel logoPanel = new JPanel();
	private JPanel newUserPanel = new JPanel();
	
	private JPanel loginPanel;
	private JButton signIn;
	private JLabel existingUserEnter;
	private JTextField existingUser;
	private JLabel existingPasswordEnter;
	private JPasswordField existingPassword;
	
	private JPanel patientPanel = new JPanel();
	private JLabel patientTitle; // = new JLabel("Welcome Patient!", SwingConstants.CENTER);
	private JButton scheduleAppt = new JButton("Schedule Appointment");
	
	private JButton logoButton = new JButton();
	private JButton newUser = new JButton("New User");
	private JButton login = new JButton("Login");
	private JButton submit = new JButton("Submit");
	private JLabel title = new JLabel("Welcome to the Patient Portal System!", SwingConstants.CENTER);
	private JLabel descriptionOne = new JLabel("If you are new to the system, please click \"NewUser\" to create an account", SwingConstants.CENTER);
	private JLabel descriptionTwo = new JLabel("Otherwise, please click \"Login\"", SwingConstants.CENTER);
	private JLabel nameOne = new JLabel("First Name:");
	private JLabel nameTwo = new JLabel("Last Name:");
	private JLabel emailEnter = new JLabel("Email:");
	private JLabel typeEnter = new JLabel("User Type:");
	private JLabel usernameEnter = new JLabel("Username:");
	private JLabel passwordEnter = new JLabel("Password:");
	private JLabel phoneNumberEnter = new JLabel("Phone Number:");
	private JLabel addressEnter = new JLabel("Address:");
	private JTextField firstName = new JTextField(20);
	private JTextField lastName = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JTextField userName = new JTextField(20);
	private JTextField phoneNumber = new JTextField(20);
	private JTextField address = new JTextField(20);
	private JPasswordField password = new JPasswordField(20);
	private String[] types = {"Patient", "Doctor", "Nurse", "Staff"};
	private JComboBox userType = new JComboBox(types);
	
	private InputStream chimeStream;
	private AudioStream chime;
	
	private InputStream noticeStream;
	private AudioStream notice;
	
	
	public LoginPanel(){
		super("Patient Portal");
		setLayout(new FlowLayout());

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

			//AudioPlayer.player.start(chime);

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
		JOptionPane.showMessageDialog(loginPanel, "UserName already exists in system");
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
