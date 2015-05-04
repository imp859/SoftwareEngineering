package panel;

import java.awt.*;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class CalendarView{

	private JPanel mainPanel;
	private JCalendar calendar;
	private JPanel panel;
	private JLabel patient;
	
	public CalendarView(JCalendar calendar){
		mainPanel = new JPanel(new BorderLayout());
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE);
		this.calendar = calendar;
		panel.add(this.calendar, BorderLayout.CENTER);
		
		this.patient = new JLabel("Patient Scheduled: ");
		panel.add(this.patient, BorderLayout.SOUTH);
		
		mainPanel.add(panel);
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
}
