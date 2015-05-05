package panel;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class CalendarView{

	private JPanel mainPanel;
	private JCalendar calendar;
	private JPanel panel, southPanel;
	private JLabel patientLabel, patient;
	private ArrayList<UserModel> patientList;
	
	public CalendarView(JCalendar calendar, ArrayList<UserModel> patientList){
		mainPanel = new JPanel(new BorderLayout());
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE);
		this.calendar = calendar;
		panel.add(this.calendar, BorderLayout.CENTER);
		
		
		southPanel = new JPanel();
		southPanel.setBackground(Color.WHITE);
		this.patientLabel = new JLabel("Patient Scheduled: ");
		southPanel.add(this.patientLabel);
		this.patient = new JLabel("");
		southPanel.add(this.patient);
		
		mainPanel.add(panel);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
	}
	
	public JPanel getPanel(){
		return this.mainPanel;
	}
	
	public void registerListeners(CalendarController cc){
		this.calendar.addPropertyChangeListener(cc);
	}
	
	public JCalendar getJCalendar(){
		return this.calendar;
	}
	
	public void setIsPatientScheduled(String user){
		this.patient.setText(user);
	}
}
