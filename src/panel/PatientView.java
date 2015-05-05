package panel;

import java.awt.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class PatientView extends JFrame{

	private JLabel patientFirstName, patientLastName, firstNameText, lastNameText,
					email, phoneNum, address;
	private JLabel greeting, messageLabel;
	private JButton scheduleAppt, updateInfo, changePassword, checkMessage,
		backButton, sendButton;
	private JTextField emailText, phoneNumText, addressText;
	private JTextArea messageText;
	private JScrollPane messageScroll;
	private JPanel panel, southPanel;
	private GridBagConstraints g;
	private String userName;
	private JDateChooser dateChooser;
	
	// constructor passes in the patients information
	public PatientView(String userNameText, String firstName, String lastName, String passWord,
			String email, String phoneNum, String address, String message,
			JDateChooser dateChooser){
		super("Welcome " + userNameText + "!");
		this.userName = userNameText;
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		panel = new JPanel(new GridBagLayout());
		g = new GridBagConstraints();
		panel.setBackground(Color.WHITE);
		
		this.patientFirstName = new JLabel("First Name: ");	
		g.anchor = GridBagConstraints.LINE_END;
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		panel.add(this.patientFirstName, g);
		
		this.patientLastName = new JLabel("Last Name: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(this.patientLastName, g);
		
		this.email = new JLabel("Email: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		panel.add(this.email, g);
		
		this.phoneNum = new JLabel("Phone Number: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 1;
		panel.add(this.phoneNum, g);
		
		this.address = new JLabel("Address: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 4;
		g.gridwidth = 1;
		panel.add(this.address, g);
		
		// textfields hold patients info.
		this.firstNameText = new JLabel(firstName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.anchor = GridBagConstraints.LINE_START;
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 1;
		panel.add(this.firstNameText, g);
		
		this.lastNameText = new JLabel(lastName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(lastNameText, g);
		
		this.emailText = new JTextField(email, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 2;
		g.gridwidth = 1;
		panel.add(this.emailText, g);
		
		this.phoneNumText = new JTextField(phoneNum, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 3;
		g.gridwidth = 1;
		panel.add(this.phoneNumText, g);
		
		this.addressText = new JTextField(address, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 4;
		g.gridwidth = 1;
		panel.add(this.addressText, g);
		
		this.updateInfo = new JButton("Update Info");
		g.weighty = 10;
		g.anchor = GridBagConstraints.FIRST_LINE_START;
		g.gridx = 0;
		g.gridy = 5;
		g.gridwidth = 1;
		panel.add(updateInfo, g);
		
		this.changePassword = new JButton("Change Password");
		g.gridx = 2;
		g.gridy = 5;
		g.gridwidth = 1;
		panel.add(changePassword, g);
		
		this.checkMessage = new JButton("Send/Check Message");
		g.gridx = 4;
		g.gridy = 5;
		g.gridwidth = 1;
		panel.add(checkMessage, g);
		
		this.messageLabel = new JLabel("Message: ");
		g.anchor = GridBagConstraints.PAGE_START;
		g.weightx = 0.5;
		g.weighty = 15;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		messageLabel.setVisible(false);
		panel.add(messageLabel, g);
		
		this.messageText = new JTextArea(message, 10, 25);
		this.messageScroll = new JScrollPane(messageText);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 1;
		messageScroll.setVisible(false);
		panel.add(messageScroll, g);
		
		this.backButton = new JButton("Back");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		this.backButton.setVisible(false);
		panel.add(backButton, g);
		
		this.sendButton = new JButton("Send Message");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 2;
		g.gridwidth = 1;
		this.sendButton.setVisible(false);
		panel.add(sendButton, g);
		
		greeting = new JLabel("Patient HomePage", SwingConstants.CENTER);
		greeting.setHorizontalTextPosition(SwingConstants.CENTER);
		southPanel = new JPanel();
		scheduleAppt = new JButton("Schedule Appointment");
		this.scheduleAppt.setVisible(true);
		southPanel.add(scheduleAppt);
		this.dateChooser = dateChooser;
		southPanel.add(dateChooser);
		southPanel.setBackground(Color.GREEN);
		add(greeting, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public void registerListeners(PatientController pc){
		this.updateInfo.addActionListener(pc);
		this.changePassword.addActionListener(pc);
		this.checkMessage.addActionListener(pc);
		this.backButton.addActionListener(pc);
		this.sendButton.addActionListener(pc);
		this.scheduleAppt.addActionListener(pc);
		this.addWindowListener(pc);
	}
	
	public String getDate(){
		return this.dateChooser.getDate().toString();
	}
	
	public void showMessageArea(){
		this.patientFirstName.setVisible(false);
		this.firstNameText.setVisible(false);
		this.patientLastName.setVisible(false);
		this.lastNameText.setVisible(false);
		this.email.setVisible(false);
		this.emailText.setVisible(false);
		this.address.setVisible(false);
		this.addressText.setVisible(false);
		this.phoneNum.setVisible(false);
		this.phoneNumText.setVisible(false);
		this.updateInfo.setVisible(false);
		this.changePassword.setVisible(false);
		this.messageLabel.setVisible(true);
		this.messageScroll.setVisible(true);
		this.scheduleAppt.setVisible(false);
		this.backButton.setVisible(true);
		this.sendButton.setVisible(true);
		this.checkMessage.setVisible(false);
		this.southPanel.setVisible(false);
	}
	
	public void showInfoArea(){
		this.patientFirstName.setVisible(true);
		this.firstNameText.setVisible(true);
		this.patientLastName.setVisible(true);
		this.lastNameText.setVisible(true);
		this.email.setVisible(true);
		this.emailText.setVisible(true);
		this.address.setVisible(true);
		this.addressText.setVisible(true);
		this.phoneNum.setVisible(true);
		this.phoneNumText.setVisible(true);
		this.updateInfo.setVisible(true);
		this.changePassword.setVisible(true);
		this.messageLabel.setVisible(false);
		this.messageScroll.setVisible(false);
		this.scheduleAppt.setVisible(true);
		this.backButton.setVisible(false);
		this.sendButton.setVisible(false);
		this.checkMessage.setVisible(true);
		this.southPanel.setVisible(true);
	}
	
	public String getEmailText(){
		return this.emailText.getText();
	}
	
	public String getPhoneNumText(){
		return this.phoneNumText.getText();
	}
	
	public String getAddressText(){
		return this.addressText.getText();
	}
	
	public String getFirstNameText(){
		return this.firstNameText.getText();
	}
	
	public String getLastNameText(){
		return this.lastNameText.getText();
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public String getMessageText(){
		if(this.messageText.getText().length() < 255)
			return this.messageText.getText();
		return null;
	}
	
}
