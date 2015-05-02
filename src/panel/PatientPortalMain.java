package panel;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PatientPortalMain {
	
	private static InputStream startupStream;
	private static AudioStream startup;

	public static void main(String[] args) {
		// arraylist of abstract users
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		/* hardcoded users and fields for testing */
		PatientModel p = new PatientModel("john", "doe", "john", null,
				"john@gmail.com", "123 address", "111-111-1111");
		p.setPassword("password");
		PatientModel q = new PatientModel("patient", "name", "patient", null,
				"patient@gmail.com", "321 address", "222-222-2222");
		q.setPassword("password2");
		StaffModel s = new StaffModel("stephen", "leija", "imp859", null,
				"sleija@gmail.com", "742 Saipan", "111-222-3333");
		s.setPassword("password3");
		users.add(p);
		users.add(q);
		users.add(s);
		Dimension minimumSize = new Dimension(800, 600);
		// create the login screen and initialize controller
		LoginPanel lp = new LoginPanel();
		LoginController lc = new LoginController(lp, users);

		lp.registerListeners(lc);
		
		try {
			startupStream = new FileInputStream("src/panel/startup.wav");
			startup = new AudioStream(startupStream);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		AudioPlayer.player.start(startup);

		lp.setSize(800, 600);
		lp.setMinimumSize(minimumSize);
		lp.setResizable(true);
		lp.setVisible(true);
		lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}