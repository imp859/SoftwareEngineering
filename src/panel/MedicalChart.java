package panel;

import java.util.regex.Pattern;

public class MedicalChart
{
	private String first;
	private String last;
	private String sex;
	private String birthday ;
	private String history;
	private double pressure;
	private double bpm;
	private double temp;
	private double hgt;
	private double wgt;
	
	
	public MedicalChart(PatientModel patient)
	{
		first = new String(patient.getFirstName());
		last = new String(patient.getLastName());
		sex = new String("");
		setBirthday(new String(patient.getDOB()));
		history = new String("");
	}
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String gender)
	{
		sex = gender;
	}
	
	public void addHistory(String newHistory)
	{
		history.concat((newHistory.concat("\n\n")));
	}
	
	public double getHeight ()
	{
		return hgt;
	}
	
	public void setHeight (String height)
	{
		Pattern std = Pattern.compile("\"|\'");
		String[] tmp = std.split(height);
		hgt = (12.0 * Integer.parseInt(tmp[0]) + Double.parseDouble(tmp[1]));
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getBpm() {
		return bpm;
	}

	public void setBpm(double bpm) {
		this.bpm = bpm;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getWeight() {
		return wgt;
	}

	public void setWeight(double wgt) {
		this.wgt = wgt;
	}
}