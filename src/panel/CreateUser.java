package panel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

/***
 * called from logincontroller. used to
 * authenticate and create new users.
 * @author Stephen's Laptop
 *
 */

public class CreateUser {

	private PatientModel patientModel;
	private PatientController pc;
	private DoctorModel doctorModel;
	private PatientView patientView;
	private DoctorView doctorView;
	private LoginPanel loginPanel;
	private ArrayList<UserModel> users;
	private JCalendar calendar;
	private JDateChooser dateChooser;
	private Gateway gateway;
	
	public CreateUser(LoginPanel lp, ArrayList<UserModel> users, Gateway gateway){
		loginPanel = lp;
		this.users = users;
		calendar = new JCalendar();
		dateChooser = new JDateChooser();
		this.gateway = gateway;
	
	}
	
	public PatientModel createPatient(){		
		PatientModel pm = new PatientModel(loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), loginPanel.getNewPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress(), gateway);
		gateway.insertDB(pm.getUserType(), loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), pm.getPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		return pm;
	}
	
	public void createPatientView(int index, Session session){
		patientView = new PatientView(users.get(index).getUserName(), users
				.get(index).getFirstName(), users.get(index).getLastName(),
				users.get(index).getPassword(), users.get(index).getEmail(),
				users.get(index).getPhoneNum(), users.get(index).getAddress(), users.get(index).getUserMessage(),
				dateChooser);
		pc = new PatientController(patientView, users.get(index), session, users);
		patientView.registerListeners(pc);
		patientView.setVisible(true);
		patientView.setSize(500, 300);
		patientView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public DoctorModel createDoctor(){
		DoctorModel dm = new DoctorModel(loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), loginPanel.getNewPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		gateway.insertDB(dm.getUserType(),loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), dm.getPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		return dm;
	}
	
	public void createDoctorView(int index, Session session){
		// create new Doctor View
		ArrayList<UserModel> patientList = new ArrayList<UserModel>();
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUserType() == 0){
				patientList.add(users.get(i)); // only add patients to list
			}
		}
		ChooseDoctorView chooseDoctorView = new ChooseDoctorView(users.get(index).getUserName(), users
				.get(index).getFirstName(), users.get(index).getLastName(),
				users.get(index).getPassword(), users.get(index).getEmail(),
				patientList, calendar);
		DoctorController dc = new DoctorController(chooseDoctorView.getDoctorView(),
				users.get(index), session, chooseDoctorView);
		CalendarController cc = new CalendarController(chooseDoctorView.getCalendarView(), users);
		chooseDoctorView.registerViewListeners(dc, cc);
		chooseDoctorView.setSize(600, 350);
		chooseDoctorView.setVisible(true);
		chooseDoctorView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public NurseModel createNurse(){
		NurseModel nm = new NurseModel(loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), loginPanel.getNewPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		gateway.insertDB(nm.getUserType(), loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), nm.getPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		return nm;
	}
	
	public void createNurseView(int index, Session session){
		ArrayList<UserModel> patientList = new ArrayList<UserModel>();
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUserType() == 0){
				patientList.add(users.get(i)); // only add patients to list
			}
		}
		NurseView nurseView = new NurseView(users.get(index).getUserName(), users
				.get(index).getFirstName(), users.get(index).getLastName(),
				users.get(index).getPassword(), users.get(index).getEmail(),
				patientList);
		NurseController nc = new NurseController(nurseView, users.get(index), session);
		nurseView.registerListeners(nc);
		nurseView.setVisible(true);
		nurseView.setSize(600, 350);
		nurseView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public StaffModel createStaff(){
		StaffModel sm = new StaffModel(loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), loginPanel.getNewPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress(), gateway);
		gateway.insertDB(sm.getUserType(), loginPanel.getNewFirstName(), loginPanel.getNewLastName(),
				loginPanel.getNewUserName(), sm.getPassword(), loginPanel.getNewUserEmail(),
				loginPanel.getNewUserPhoneNum(), loginPanel.getNewUserAddress());
		return sm;
	}
	
	public void createStaffView(int index, Session session){
		ArrayList<UserModel> patientList = new ArrayList<UserModel>();
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUserType() == 0){
				patientList.add(users.get(i)); // only add patients to list
			}
		}
		StaffView staffView = new StaffView(users.get(index).getUserName(), users
				.get(index).getFirstName(), users.get(index).getLastName(),
				patientList, users.get(index).getUserMessage(), users.get(index).getPatientName());
		StaffController sc = new StaffController(staffView, users.get(index), session, users);
		staffView.registerListeners(sc);
		staffView.setVisible(true);
		staffView.setSize(600, 350);
		staffView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
