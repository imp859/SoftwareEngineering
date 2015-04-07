package panel;

import java.awt.Dimension;

import javax.swing.JFrame;

public class PatientPortalMain {

	public static void main(String[] args) {
		Dimension minimumSize = new Dimension(700, 500);
		LoginPanel lp = new LoginPanel();
		PatientModel pm = new PatientModel();
		LoginController lc = new LoginController(lp, pm);
		
		lp.registerListeners(lc);
		
		lp.setSize(700, 500);
		lp.setMinimumSize(minimumSize);
		lp.setResizable(true);
		lp.setVisible(true);
		lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
