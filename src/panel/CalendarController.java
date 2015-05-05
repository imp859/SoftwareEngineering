package panel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalendarController implements PropertyChangeListener {
	
	private CalendarView view;
	
	public CalendarController(CalendarView view){
		this.view = view;		
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String date = view.getJCalendar().getDate().toString();
		System.out.println(date);
		if (evt.getNewValue() != null) {
			//System.out.println(view.getJCalendar().getDate());
		}
	}
}
