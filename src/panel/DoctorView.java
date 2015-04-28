package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;

public class DoctorView extends JFrame{
	
	private JButton checkCalendar;
	
	private JLabel doctorFirstName, doctorLastName, firstNameText, lastNameText,
	email, phoneNum, address;
	private JLabel greeting;
	private JButton updateInfo, changePassword, viewCalendar;
	private JTextField emailText;
	private JComboBox patients;
	private JPanel panel;
	private GridBagConstraints g;

	// constructor passes in the patients information
	public DoctorView(String userNameText, String firstName, String lastName, String passWord,
			String email, ArrayList patientList){
		super("Welcome " + userNameText + "!");
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());

		panel = new JPanel(new GridBagLayout());
		g = new GridBagConstraints();
		panel.setBackground(Color.WHITE);

		this.doctorFirstName = new JLabel("First Name: ");	
		g.anchor = GridBagConstraints.LINE_END;
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		panel.add(this.doctorFirstName, g);

		this.doctorLastName = new JLabel("Last Name: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(this.doctorLastName, g);

		this.email = new JLabel("Email: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		panel.add(this.email, g);

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
		
		this.viewCalendar = new JButton("View Calendar");
		g.gridx = 3;
		g.gridy = 5;
		g.gridwidth = 1;
		panel.add(viewCalendar, g);
		
		this.patients = new JComboBox(patientList.toArray());
		add(patients, BorderLayout.WEST);

		greeting = new JLabel("Doctor Home Page", SwingConstants.CENTER);
		greeting.setHorizontalTextPosition(SwingConstants.CENTER);

		add(greeting, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}

	public void registerListeners(PatientController pc){
		this.updateInfo.addActionListener(pc);
		this.changePassword.addActionListener(pc);
		this.addWindowListener(pc);
	}

	public String getEmailText(){
		return this.emailText.getText();
	}

	public String getFirstNameText(){
		return this.firstNameText.getText();
	}

	public String getLastNameText(){
		return this.lastNameText.getText();
	}
}
