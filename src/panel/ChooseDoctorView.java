package panel;

import java.util.ArrayList;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class ChooseDoctorView extends JFrame{

	private JTabbedPane tabPane;
	private DoctorView doctorView;
	private CalendarView calendarView;
	
	public ChooseDoctorView(String userNameText, String firstName, String lastName,
			String passWord, String email, ArrayList<UserModel> patientList, JCalendar calendar){
		super("Welcome " + userNameText + "!");
		
		tabPane = new JTabbedPane();
		
		doctorView = new DoctorView(userNameText, firstName, lastName,
				passWord, email, patientList);
		calendarView = new CalendarView(calendar);
		
		tabPane.addTab("Doctor Tab", doctorView.getPanel());
		tabPane.addTab("View Schedule", calendarView.getPanel());
		
		add(tabPane);
	}
	
	public void registerViewListeners(DoctorController dc, CalendarController cc){
		doctorView.registerListeners(dc);
		calendarView.registerListeners(cc);
		this.addWindowListener(dc);
	}
	
	public DoctorView getDoctorView(){
		return this.doctorView;
	}
	
	public CalendarView getCalendarView(){
		return this.calendarView;
	}
}
