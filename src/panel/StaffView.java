package panel;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class StaffView extends JFrame{
	
	private JTextArea messageText;
	private JLabel fromPatient;
	private JLabel userLabel, firstName, lastName, greeting;
	private JLabel firstNameText, lastNameText, messageLabel;
	private JButton message, back, sendButton;
	private JList patients;
	private JScrollPane scrollPane;
	private JPanel panel, westPanel;
	private ArrayList<String> tmpArray;
	private GridBagConstraints g;	
	
	public StaffView(String username, String firstName, String lastName, ArrayList<UserModel> patientList,
					String userMessage, String patientName){
		super("Welcome " + username + "!");
		this.setBackground(Color.WHITE);
		greeting = new JLabel("Staff HomePage", SwingConstants.CENTER);
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		
		g = new GridBagConstraints();
		
		this.firstName = new JLabel("First Name: ");
		g.anchor = GridBagConstraints.PAGE_START;
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
		g.gridy = 2;
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
		g.gridy = 2;
		g.gridwidth = 1;
		panel.add(this.lastNameText, g);
		
		this.message = new JButton("Check/Send Patient Message");
		g.weightx = 0.5;
		g.weighty = 10;
		g.gridx = 0;
		g.gridy = 4;
		g.gridwidth = 1;
		panel.add(this.message, g);
		
		this.messageLabel = new JLabel("Message: ");
		g.weightx = 0.5;
		g.weighty = 10;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		this.messageLabel.setVisible(false);
		panel.add(messageLabel, g);
		
		this.messageText = new JTextArea(userMessage, 10, 20);
		this.scrollPane = new JScrollPane(messageText);
		g.weightx = 0.5;
		g.weighty = 10;
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 1;
		panel.add(this.scrollPane, g);
		this.scrollPane.setVisible(false);
		
		if (patientName == null) {
			this.fromPatient = new JLabel("No Message");
			g.weightx = 0.5;
			g.weighty = 0.5;
			g.gridx = 4;
			g.gridy = 0;
			g.gridwidth = 1;
			this.fromPatient.setVisible(false);
			panel.add(this.fromPatient, g);
		} else{
			this.fromPatient = new JLabel(patientName);
			g.weightx = 0.5;
			g.weighty = 0.5;
			g.gridx = 4;
			g.gridy = 0;
			g.gridwidth = 1;
			this.fromPatient.setVisible(false);
			panel.add(this.fromPatient, g);
		}
		
		this.back = new JButton("Back");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		back.setVisible(false);
		panel.add(back, g);
		
		this.sendButton = new JButton("Send Message");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 2;
		g.gridwidth = 1;
		sendButton.setVisible(false);
		panel.add(sendButton, g);
		
		tmpArray = new ArrayList<String>();
		for(int i = 0; i < patientList.size(); i++){
			tmpArray.add(patientList.get(i).getUserName());
		}	
		
		westPanel = new JPanel();
		westPanel.setBackground(Color.GREEN);
		this.patients = new JList(tmpArray.toArray());
		this.patients.setVisibleRowCount(5);
		this.patients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		westPanel.add(this.patients);
		
		add(westPanel, BorderLayout.WEST);		
		add(greeting, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}
	
	public void registerListeners(StaffController sc){
		this.message.addActionListener(sc);
		this.back.addActionListener(sc);
		this.sendButton.addActionListener(sc);
		this.addWindowListener(sc);
		//this.patients.addActionListener(sc);
	}
	
	public void showMessage(){
		this.firstName.setVisible(false);
		this.firstNameText.setVisible(false);
		this.lastName.setVisible(false);
		this.lastNameText.setVisible(false);
		this.message.setVisible(false);
		this.messageLabel.setVisible(true);
		this.scrollPane.setVisible(true);
		this.back.setVisible(true);
		this.sendButton.setVisible(true);
		this.fromPatient.setVisible(true);
	}
	
	public void showStaffInfo(){
		this.firstName.setVisible(true);
		this.firstNameText.setVisible(true);
		this.lastName.setVisible(true);
		this.lastNameText.setVisible(true);
		this.message.setVisible(true);
		this.messageLabel.setVisible(false);
		this.scrollPane.setVisible(false);
		this.back.setVisible(false);
		this.sendButton.setVisible(false);
		this.fromPatient.setVisible(false);
	}
	
	public ArrayList getPatientsList(){
		return tmpArray;
	}
	
	public String getPatientUserName(){
		return (String)this.patients.getSelectedValue();
	}
	
	public String getMessage() {
		if(this.messageText.getText().length() < 255){
			return this.messageText.getText();
		}
		return null;
	}
	
	public void invalidMessage(){
		JOptionPane.showMessageDialog(this, "Message must be shorter than 256 characters");
	}
	
	public void fromPatientMessage(String patient){
		this.fromPatient.setText(patient);
	}
	
}
