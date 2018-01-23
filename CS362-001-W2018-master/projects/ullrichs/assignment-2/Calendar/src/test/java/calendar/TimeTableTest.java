package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
//import calendar.TimeTable.lastDay;

import static org.junit.Assert.*;


public class TimeTableTest {

	/*
	 @Rule 
	 public ExpectedException exception = ExpectedException.none();
	 
	 private static TimeTable timeTable;
	 
	 @BeforeClass
	 public static void beforeClass() {
		 timeTable = new TimeTable();
	 }
	 
	 @Test
	  public void testGetApptRange()  throws Throwable  
	 {
		 TimeTable current = new TimeTable();
		 System.out.println(current);
		 exception.expect(DateOutOfRangeException.class);
		 exception.expectMessage("Second date specified is not  before the first date specified.");
		 //TimeTable.getApptRange(null, null, null);
		 		 
	 }

	 @Test
	  public void testGetApptRange2()  throws Throwable  {
		 		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 		int day = 3;
				int month = 05;
				int year = 1981;
				calendar.CalDay.setDay(day);
			
				
		        final GregorianCalendar firstDay = new GregorianCalendar(2004, 6, 9, 13, 45);
		        final GregorianCalendar lastDay = new GregorianCalendar(2004, 6, 9, 13, 45);
		        assertTrue(TimeTable.getApptRange(LinkedList<CalDay>, firstDay, lastDay));
		        lastDay.add(Calendar.DAY_OF_YEAR, 1);
		        assertFalse(TimeTable.getApptRange(firstDay, lastDay));
		        firstDay.add(Calendar.DAY_OF_YEAR, 1);
		        assertTrue(TimeTable.getApptRange(firstDay, lastDay));
		        lastDay.add(Calendar.YEAR, 1);
		        assertFalse(TimeTable.getApptRange(firstDay, lastDay));
    }
	  
	  @Test
	  public void testGetApptOccurences()  throws Throwable  {
		  
		  
	  }
	  
	  @Test(expected = IllegalArgumentException.class)
	    public void testIsSameDay_DateNullNull() throws Exception {
	        TimeTable.result((Date) null, (Date) null);
	    }

	  */
    
//add more unit tests as you needed
}
