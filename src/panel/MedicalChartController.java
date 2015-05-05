package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MedicalChartController implements ActionListener, WindowListener
{
	private MedicalChartView view;
	private MedicalChart model;
	private Session session;
	
	public MedicalChartController (MedicalChartView view, MedicalChart model, Session session)
	{
		this.view = view;
		this.model = model;
		this.session = session;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Close"))
		{
			// TODO
		} 
		else if(e.getActionCommand().equals("Update Chart"))
		{
			// TODO
		}
		
	}
	
	public void windowOpened (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowActivated (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated (WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}