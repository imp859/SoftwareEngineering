package panel;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class NurseView extends JFrame{
	
	private JButton checkCalendar;
	private JButton viewMedicalChart;
	private JLabel greeting;
	
	private JLabel firstName, lastName, firstNameText, lastNameText;
	
	private JList patientList;
	private JPanel mainPanel;
	private JPanel westPanel;
	
	private GridBagConstraints g;
	
	
	public NurseView(String userNameText, String firstName, String lastName, String passWord,
			String email, ArrayList<UserModel> patientList){
		super("Welcome " + userNameText + "!");
		
		this.setLayout(new BorderLayout());
		
		mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(Color.WHITE);
		g = new GridBagConstraints();
		
		this.firstName = new JLabel("First Name: ");
		g.anchor = GridBagConstraints.PAGE_START;
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		mainPanel.add(this.firstName, g);
		
		this.lastName = new JLabel("Last Name: ");
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		mainPanel.add(this.lastName, g);
		
		this.firstNameText = new JLabel(firstName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 1;
		mainPanel.add(this.firstNameText, g);
		
		this.lastNameText = new JLabel(lastName, 10);
		g.weightx = 0.5;
		g.weighty = 0.5;
		g.gridx = 2;
		g.gridy = 1;
		g.gridwidth = 1;
		mainPanel.add(this.lastNameText, g);
		
		this.viewMedicalChart = new JButton("View Medical Chart");
		g.weightx = 0.5;
		g.weighty = 10;
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 1;
		mainPanel.add(this.viewMedicalChart, g);
		
		this.checkCalendar = new JButton("View Calendar");
		g.gridx = 2;
		g.gridy = 3;
		g.gridwidth = 1;
		mainPanel.add(this.checkCalendar, g);
		
		greeting = new JLabel("Nurse Home Page");
		
		ArrayList<String> tmpArray = new ArrayList<String>();
		for(int i = 0; i < patientList.size(); i++){
			tmpArray.add(patientList.get(i).getFirstName() + " " + patientList.get(i).getLastName());
		}
		
		westPanel = new JPanel();
		westPanel.setBackground(Color.GREEN);
		this.patientList = new JList(tmpArray.toArray());
		this.patientList.setVisibleRowCount(5);
		this.patientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		westPanel.add(this.patientList);
		
		add(greeting, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(mainPanel, BorderLayout.CENTER);
	}
	
	public void registerListeners(NurseController nc){
		this.checkCalendar.addActionListener(nc);
		this.viewMedicalChart.addActionListener(nc);
	}
}
