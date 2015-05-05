package panel;

import java.awt.*;

import javax.swing.*;

public class MedicalChart extends JFrame
{
	private int shortLineLength = 10;
	private int longLineLength = 25;
	private int defaultCols = 50;
	private int defaultRows = 5;
	
	private GridLayout medicalChart = new GridLayout(17, 2);
	private JPanel panel = new JPanel();
	private JPanel medicalPanel = new JPanel();
	
	//medical chart labels
	private JLabel patientFirst = new JLabel("First");
    private JLabel patientLast = new JLabel("Last");
    private JLabel doctorFirst = new JLabel("Dr.");
    //private JLabel doctorLast = new JLabel("");
    private JLabel sex = new JLabel("Gender");
    private JLabel birthday = new JLabel("DOB");
    private JLabel pressure = new JLabel("Pressure");
    private JLabel bpm = new JLabel("Heart Rate");
    private JLabel temp = new JLabel("Temperature");
    private JLabel hgt = new JLabel("Height");
    private JLabel wgt = new JLabel("Weight");
    private JLabel reason= new JLabel("Reason For Visit:");
    private JLabel history= new JLabel("Patient History");
	
    //medical chart fields
	private JTextField patientFirstName = new JTextField(longLineLength);
	private JTextField patientLastName = new JTextField(longLineLength);
	private JTextField doctorFirstName = new JTextField(longLineLength);
	private JTextField doctorLastName = new JTextField(longLineLength);
	private JTextField gender = new JTextField(shortLineLength);
	private JTextField birthDate = new JTextField(longLineLength);
	private JTextField bloodPressure = new JTextField(longLineLength);
	private JTextField pulse = new JTextField(longLineLength);
	private JTextField temperature = new JTextField(longLineLength);
	private JTextField height = new JTextField(shortLineLength);
	private JTextField weight = new JTextField(shortLineLength);
	private JTextArea reasonForVisit= new JTextArea(defaultRows, defaultCols);
	private JTextArea patientHistory= new JTextArea(defaultRows, defaultCols);
	
	public void registerListeners(MedicalChartController mc)
	{
		
	}
	
}