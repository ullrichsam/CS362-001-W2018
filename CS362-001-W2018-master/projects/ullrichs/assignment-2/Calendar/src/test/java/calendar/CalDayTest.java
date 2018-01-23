package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 private LinkedList<Appt> appts;

	@Test
	  public void CalDayMethodTest(GregorianCalendar cal)  throws Throwable  {
		 CalDay calDay = new CalDay();
		 
		assertEquals(cal.get(cal.DAY_OF_MONTH), calDay.getDay());
		assertEquals(cal.get(cal.MONTH), calDay.getMonth());
		assertEquals(cal.get(cal.YEAR), calDay.getYear());
		assertTrue(calDay.isValid());
	 }
	 
	 @Test
	  public void addApptTest(Appt appt)  throws Throwable  {
		 CalDay AddAppt = new CalDay();
		 assertTrue(AddAppt.getAppts().add(appt));
	 }
	 
	  @Test
	  public void setApptsTest(LinkedList<Appt> appts)  throws Throwable  {
		  CalDay SetAppt = new CalDay();
		  assertTrue(SetAppt.isValid());
		  if(appts!=null)
				this.appts = appts;
		  assertEquals(appts,SetAppt.appts);	  
	  }
//add more unit tests as you needed	
}
