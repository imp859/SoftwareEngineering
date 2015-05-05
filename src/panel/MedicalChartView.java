package panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MedicalChartView
{
	
	private int shortLineLength = 10;
	private int longLineLength = 25;
	private int defaultCols = 50;
	private int defaultRows = 5;
	
	private GridLayout medChart;
	private JPanel medicalPanel;

	//medical chart labels
	private JLabel patientFirst;
	private JLabel patientLast;
	private JLabel doctorFirst;
	private JLabel sex;
	private JLabel birthday;
	private JLabel pressure;
	private JLabel bpm;
	private JLabel temp;
	private JLabel hgt;
	private JLabel wgt;
	private JLabel reason;
	private JLabel history;

	//medical chart fields
	private JTextField patientFirstName;
	private JTextField patientLastName;
	private JTextField doctorFirstName;
	private JTextField doctorLastName;
	private JTextField gender;
	private JTextField birthDate;
	private JTextField bloodPressure;
	private JTextField pulse;
	private JTextField temperature;
	private JTextField height;
	private JTextField weight;
	private JTextArea reasonForVisit;
	private JTextArea patientHistory;
	
	public MedicalChartView()
	{
		medChart = new GridLayout(17, 2);
		medicalPanel = new JPanel();
		patientFirst = new JLabel("First");
		patientLast = new JLabel("Last");
		doctorFirst = new JLabel("Dr.");
		sex = new JLabel("Gender");
		birthday = new JLabel("DOB");
		pressure = new JLabel("Pressure");
		bpm = new JLabel("Heart Rate");
		temp = new JLabel("Temperature");
		hgt = new JLabel("Height");
		wgt = new JLabel("Weight");
		reason= new JLabel("Reason For Visit:");
		history= new JLabel("Patient History");
		
		patientFirstName = new JTextField(longLineLength);
		patientLastName = new JTextField(longLineLength);
		doctorFirstName = new JTextField(longLineLength);
		doctorLastName = new JTextField(longLineLength);
		gender = new JTextField(shortLineLength);
		birthDate = new JTextField(longLineLength);
		bloodPressure = new JTextField(longLineLength);
		pulse = new JTextField(longLineLength);
		temperature = new JTextField(longLineLength);
		height = new JTextField(shortLineLength);
		weight = new JTextField(shortLineLength);
		
		reasonForVisit = new JTextArea(defaultRows, defaultCols);
		patientHistory = new JTextArea(defaultRows, defaultCols);
	}
	
	public void registerListeners(MedicalChartController mc)
	{
		// do something
	}
	
}