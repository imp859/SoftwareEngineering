package panel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class CalendarController implements PropertyChangeListener {
	
	private CalendarView view;
	private ArrayList<UserModel> users;
	
	public CalendarController(CalendarView view, ArrayList<UserModel> users){
		this.view = view;		
		this.users = users;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String tmp1 = view.getJCalendar().getDate().toString().substring(0, 10);
		String tmp2 = view.getJCalendar().getDate().toString().substring(24, 28);
		String date = tmp1 + " " + tmp2;
		int index = -1;
		if (evt.getNewValue() != null) {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getAppt() != null
						&& users.get(i).getAppt().equals(date)) {
					index = i;
					break;
				}
			}
			if(index != -1){
				view.setIsPatientScheduled(users.get(index).getFirstName()
						+ " " + users.get(index).getLastName());
			} else{
				view.setIsPatientScheduled("No Patient Scheduled");
			}
		}
	}
}
