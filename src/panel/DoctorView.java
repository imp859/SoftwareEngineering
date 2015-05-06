package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;



import javax.swing.*;
import javax.swing.event.ListSelectionListener;


public class DoctorView{
	
	private JButton checkCalendar;
	private JPanel mainPanel;
	
	private JLabel doctorFirstName, doctorLastName, firstNameText, lastNameText,
	email, phoneNum, address;
	private JLabel greeting;
	private JButton updateInfo, changePassword, viewCalendar;
	private JTextField emailText;
	private JList patients;
	private JPanel panel, westPanel, dateView;
	private GridBagConstraints g;
	
	// constructor passes in the patients information
	public DoctorView(String userNameText, String firstName, String lastName,
			String passWord, String email, ArrayList<UserModel> patientList) {
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);
		
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
		panel.add(this.lastNameText, g);

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
		
		ArrayList<String> tmpArray = new ArrayList<String>();
		for(int i = 0; i < patientList.size(); i++){
			tmpArray.add((patientList.get(i).getFirstName().concat
					(" ".concat(patientList.get(i).getLastName()))));
		}
		
		westPanel = new JPanel();
		westPanel.setBackground(Color.GREEN);
		this.patients = new JList(tmpArray.toArray());
		this.patients.setVisibleRowCount(5);
		this.patients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		westPanel.add(this.patients);
		mainPanel.add(westPanel, BorderLayout.WEST);
	
		greeting = new JLabel("Doctor Home Page", SwingConstants.CENTER);
		greeting.setHorizontalTextPosition(SwingConstants.CENTER);
		
		mainPanel.add(greeting, BorderLayout.NORTH);
		mainPanel.add(panel, BorderLayout.CENTER);
	}

	public void registerListeners(DoctorController dc){
		this.updateInfo.addActionListener(dc);
		this.changePassword.addActionListener(dc);
		this.viewCalendar.addActionListener(dc);
		this.patients.addListSelectionListener(new ListSelectionListener());
	}
	
	public JPanel getPanel(){
		return this.mainPanel;
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
