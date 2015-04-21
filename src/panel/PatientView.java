package panel;

import java.awt.*;

import javax.swing.*;

public class PatientView extends JFrame{

	private JLabel patientFirstName, patientLastName;
	private JLabel greeting;
	private JButton scheduleAppt, updateInfo;
	private JTextField firstNameText, lastNameText;
	private JPanel panel;
	private GridBagConstraints g;
	
	// constructor passes in the patients information
	public PatientView(String userNameText, String firstName, String lastName, String passWord){
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
		//g.anchor = GridBagConstraints.PAGE_START;
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(this.patientLastName, g);
		
		// textfields hold patients info.
		this.firstNameText = new JTextField(firstName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.anchor = GridBagConstraints.LINE_START;
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 1;
		panel.add(this.firstNameText, g);
		
		this.lastNameText = new JTextField(lastName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(lastNameText, g);
		
		this.updateInfo = new JButton("Update Info");
		g.weighty = 10;
		g.anchor = GridBagConstraints.FIRST_LINE_START;
		g.gridx = 2;
		g.gridy = 2;
		g.gridwidth = 1;
		panel.add(updateInfo, g);
		
		greeting = new JLabel("Patient HomePage", SwingConstants.CENTER);
		greeting.setHorizontalTextPosition(SwingConstants.CENTER);
		scheduleAppt = new JButton("Schedule Appointment");
		
		add(greeting, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(scheduleAppt, BorderLayout.SOUTH);
	}
	
	public void registerListeners(PatientController pc){
		this.updateInfo.addActionListener(pc);
	}
	
	public String getFirstNameText(){
		return this.firstNameText.getText();
	}
	
	public String getLastNameText(){
		return this.lastNameText.getText();
	}
	
}
