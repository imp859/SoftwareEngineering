package panel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalendarController implements PropertyChangeListener {
	
	private CalendarView view;
	
	public CalendarController(CalendarView view){
		this.view = view;		
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getNewValue() != null) {
			
		}
	}
}
