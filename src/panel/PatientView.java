package panel;

import java.awt.*;

import javax.swing.*;

public class PatientView extends JFrame{

	private JLabel patientFirstName, patientLastName, firstNameText, lastNameText,
					email, phoneNum, address;
	private JLabel greeting;
	private JButton scheduleAppt, updateInfo, changePassword;
	private JTextField emailText, phoneNumText, addressText;
	private JPanel panel;
	private GridBagConstraints g;
	
	// constructor passes in the patients information
	public PatientView(String userNameText, String firstName, String lastName, String passWord,
			String email, String phoneNum, String address){
		super("Welcome " + userNameText + "!");
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
		
		greeting = new JLabel("Patient HomePage", SwingConstants.CENTER);
		greeting.setHorizontalTextPosition(SwingConstants.CENTER);
		scheduleAppt = new JButton("Schedule Appointment");
		
		add(greeting, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(scheduleAppt, BorderLayout.SOUTH);
	}
	
	public void registerListeners(PatientController pc){
		this.updateInfo.addActionListener(pc);
		this.changePassword.addActionListener(pc);
		this.addWindowListener(pc);
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
	
	
}
