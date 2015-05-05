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
		Gateway gateway = new Gateway();
		gateway.readDB(users);
		Dimension minimumSize = new Dimension(800, 600);
		// create the login screen and initialize controller
		LoginPanel lp = new LoginPanel();
		LoginController lc = new LoginController(lp, users, gateway);

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