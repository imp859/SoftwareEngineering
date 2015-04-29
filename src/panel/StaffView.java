package panel;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class StaffView extends JFrame{
	
	private JTextArea messageText;
	private JLabel userLabel, firstName, lastName, greeting;
	private JLabel firstNameText, lastNameText;
	private JButton message;
	private JComboBox patients;
	private JPanel panel;
	private GridBagConstraints g;	
	
	public StaffView(String username, String firstName, String lastName, ArrayList patientList){
		super("Welcome " + username + "!");
		this.setBackground(Color.WHITE);
		greeting = new JLabel("Staff HomePage", SwingConstants.CENTER);
		panel = new JPanel(new GridBagLayout());
		
		g = new GridBagConstraints();
		
		this.firstName = new JLabel("First Name: ");
		g.anchor = GridBagConstraints.LINE_END;
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		panel.add(this.firstName, g);
		
		this.lastName = new JLabel("Last Name: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(this.lastName, g);
		
		this.firstNameText = new JLabel(firstName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
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
		panel.add(this.lastNameText, 10);
		
		this.message = new JButton("Send Patient Message");
		g.weightx = 0.5;
		g.weighty = 10;
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		panel.add(this.message, g);
		
		this.patients = new JComboBox(patientList.toArray());
		
		add(greeting, BorderLayout.NORTH);
		add(patients, BorderLayout.WEST);
		add(panel, BorderLayout.CENTER);
	}
	
	public void registerListeners(StaffController sc){
		this.message.addActionListener(sc);
		this.patients.addActionListener(sc);
	}
	
	
}
