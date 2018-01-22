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

	
	 @Rule 
	 public ExpectedException exception = ExpectedException.none();
	 
	 private static TimeTable timeTable;
	 
	 @BeforeClass
	 public static void beforeClass() {
		 timeTable = new TimeTable();
	 }
	 
	 @Test
	  public void test01()  throws Throwable  
	 {
		// exception.expect(DateOutOfRangeException.class);
		// exception.expectMessage("");
		// TimeTable.getApptRange(null, GregorianCalendar, null);
		 
		 
		 
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable current = new TimeTable();
		    System.out.println(current);
		    assertEquals("today:", current, new TimeTable());
		 
    }
    
//add more unit tests as you needed
}
