package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTableTest 
{
//checks getApptRange and getApptOccurences and getNextApptOccurrence function
	 @Test
	  public void test01()  throws Throwable  
	 {
		 TimeTable t = new TimeTable();
         LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 Appt appt1 = new Appt(1,1,1,1,1, "1", "1st appointment");
		 Appt appt2 = new Appt(2,2,2,2,2, "2", "2nd appointment");
		 Appt appt3 = new Appt(3,3,3,3,3, "3", "3rd appointment");
		 Appt appt4 = new Appt(4,4,4,4,4, "4", "4th appointment");
		 Appt appt5 = new Appt(5,5,5,5,5, "5", "5th appointment");
		 
		 LinkedList<Appt> ListAppts1 = new LinkedList<Appt>();
		 ListAppts1.add(appt1);
		 ListAppts1.add(appt2);
		 ListAppts1.add(appt3);
		 ListAppts1.add(appt4);
		 ListAppts1.add(appt5);
		 
		 Appt appt7 = new Appt(7,7,7,7,7, "7", "7th appointment");
		 LinkedList<Appt> ListAppts2 = new LinkedList<Appt>();
		 ListAppts2.add(appt7);
		 ListAppts2.add(appt2);
		 
		 Appt appt_invalid = new Appt(26,1,1,1,1, null, null);
		 LinkedList<Appt> ListAppts3 = new LinkedList<Appt>();
  		 ListAppts3.add(appt_invalid);
		 ListAppts3.add(appt2);
		 
 		 int[] s = {0};
 
		 Appt appt_recurMonthly = new Appt(2,2,11,1,4, "Monthly", "Monthly");
		 appt_recurMonthly.setRecurrence(s, appt_recurMonthly.RECUR_BY_MONTHLY,1,2);
		 LinkedList<Appt> ListAppts4 = new LinkedList<Appt>();
		 ListAppts4.add(appt_recurMonthly);
		 
		 Appt appt_recurWeekly = new Appt(2,2,4,1,4, "Weekly", "Weekly");
		 appt_recurWeekly.setRecurrence(s, appt_recurWeekly.RECUR_BY_WEEKLY,1,2);
		 LinkedList<Appt> ListAppts5 = new LinkedList<Appt>();
		 ListAppts5.add(appt_recurWeekly);
		 
		 Appt appt_recurYearly = new Appt(2,2,11,2,3, "Yearly", "Yearly");
		 appt_recurYearly.setRecurrence(s, appt_recurYearly.RECUR_BY_YEARLY,1,2);
		 LinkedList<Appt> ListAppts6 = new LinkedList<Appt>();
		 ListAppts6.add(appt2);
		 ListAppts6.add(appt_recurYearly);

		 GregorianCalendar Day1 = new GregorianCalendar(1,1,1);
		 GregorianCalendar Day2 = new GregorianCalendar(2,2,2);
		 GregorianCalendar Day4 = new GregorianCalendar(4,2,12);
		 
		 try {
		 calDays = t.getApptRange(ListAppts1, Day2, Day1);
		 fail("Second date specified is not  before the first date specified.");
		 }catch(DateOutOfRangeException e) {}
		 
  		 assertEquals(appt2, t.getApptRange(ListAppts1, Day2, Day4).get(0).appts.get(0));		 
		 assertNotSame(appt7, t.getApptRange(ListAppts2, Day2, Day4).get(0).appts.get(0));		 
		 assertNotSame(appt_invalid, t.getApptRange(ListAppts3, Day2, Day4).get(0).appts.get(0));	 		 
		 assertEquals(appt_recurYearly, t.getApptRange(ListAppts6, Day1, Day4).getLast().appts.get(0));
	 }

//Tests getAppRange
	 @Test
	 public void test02()  throws Throwable  
	 {
	 Calendar cal = Calendar.getInstance();
	 int year;
	 int month;
	 int day;
	 year = cal.get(Calendar.YEAR);
	 month = cal.get(Calendar.MONTH)+1;
	 day = cal.get(Calendar.DAY_OF_MONTH);
	 
     GregorianCalendar today = new GregorianCalendar(year, month, day);
     GregorianCalendar next = new GregorianCalendar(year, month, 30);	 
     LinkedList<Appt> appts = new LinkedList<Appt>();
     TimeTable t = new TimeTable();
     LinkedList<CalDay> days =  t.getApptRange(appts, today, next);
	 }
	 
//checks deleteAppt
	 @Test
	  public void test03()  throws Throwable  {
	 TimeTable t = new TimeTable();
	 LinkedList<Appt> ListAppts2 = new LinkedList<Appt>();
	 Appt appt1 = new Appt(1,1,1,1,1, "1", "1st appointment");
	 Appt appt2 = new Appt(2,2,2,2,2, "2", "2nd appointment");
	 Appt appt3 = new Appt(3,3,3,3,3, "3", "3rd appointment");
	 Appt appt4 = new Appt(4,4,4,4,4, "4", "4th appointment");
	 Appt appt5 = new Appt(5,5,5,5,5, "5", "5th appointment");
		 Appt appt_invalid = new Appt(26,1,1,1,1, null, null);
		 Appt appt_exception = new Appt(6,6,6,6,6, null, null);
		 Appt appt_new = new Appt(1,1,1,1,1,null, null); 
		 LinkedList<Appt> ListAppts = new LinkedList<Appt>();
		 ListAppts.add(appt1);
		 ListAppts.add(appt2);
		 ListAppts.add(appt3);
		 ListAppts.add(appt4);
		 ListAppts.add(appt5);
		 
		 assertNull(t.deleteAppt(null, appt1));
		 assertNull(t.deleteAppt(ListAppts, null));
		 assertNull(t.deleteAppt(ListAppts, appt_invalid));
		 assertNull(t.deleteAppt(ListAppts, appt_exception));
		 try {
		 appt_new = t.deleteAppt(ListAppts, appt1).get(0);
		 }catch(NullPointerException e) {} 
	}
	
//checks permute	 
	 @Test
	 public void test04()  throws Throwable  
	 {
		 TimeTable t = new TimeTable();
		 Appt appt1 = new Appt(1,1,1,1,1, "1", "1st appointment");
		 Appt appt2 = new Appt(2,2,2,2,2, "2", "2nd appointment");
		 Appt appt3 = new Appt(3,3,3,3,3, "3", "3rd appointment");
		 Appt appt4 = new Appt(4,4,4,4,4, "4", "4th appointment");
		 Appt appt5 = new Appt(5,5,5,5,5, "5", "5th appointment");
		 
		 LinkedList<Appt> ListAppts = new LinkedList<Appt>();
		 LinkedList<Appt> ListAppts2 = new LinkedList<Appt>();
	
		 ListAppts.add(appt3);
		 ListAppts.add(appt4);
		 ListAppts.add(appt1);
		 ListAppts.add(appt5);
		 ListAppts.add(appt2);
		 
		 int[] pv = {2,3,0,4,1};
	
		 assertFalse((t.permute(ListAppts, pv)).get(0).equals(appt1));
		 assertFalse((t.permute(ListAppts, pv)).get(1).equals(appt2));
		 assertFalse((t.permute(ListAppts, pv)).get(2).equals(appt3));
		 assertFalse((t.permute(ListAppts, pv)).get(3).equals(appt4));
		 assertFalse((t.permute(ListAppts, pv)).get(4).equals(appt5));
		 
		 int[] pv_2 = {1,2,3,4,5,6};
		 
		 try 
		 {
		 ListAppts2 = t.permute(ListAppts, pv_2);
		 fail("Expecting exception: IllegalArgumentException");
		 	 } catch (IllegalArgumentException e) {}
 	}
}

	


