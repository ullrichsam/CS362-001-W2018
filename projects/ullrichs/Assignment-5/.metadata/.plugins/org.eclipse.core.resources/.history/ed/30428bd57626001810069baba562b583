package calendar;

/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class ApptTest 
{	
     // Test that the gets methods work as expected.
	 @Test
	  public void test01()  throws Throwable  
	 {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 int startHour1=03;
		 int startMinute1=30;
		 int startDay1=03;
		 int startMonth1=05;
		 int startYear1=1981;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 String title1="Title";
		 String description1="Description";
	 
     //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 Appt appt2 = new Appt(startHour1,
		          startMinute1 ,
		          startDay1 ,
		          startMonth1 ,
		          startYear1 ,
		          title1,
		         description1);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());   
		 assertEquals(63, appt.compareTo(appt2));
	 }

	// Test that the set methods work as expected.
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title=null;
		 String description=null;
	 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		 
	 //changes the appointment's member variables.
		 appt.setStartHour(startHour);
		 appt.setStartMinute(startMinute);
		 appt.setStartDay(startDay);
		 appt.setStartMonth(startMonth);
		 appt.setStartYear(startYear);
		 appt.setTitle(title);
		 appt.setDescription(description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("", appt.getTitle());
		 assertEquals("", appt.getDescription());  
		 
	// Tests line 222 - 225: setRecurrence
		 int[] recurringDays = null; 
		 appt.setRecurrence(recurringDays, 2, 1, 0);
	   	 assertEquals(2,appt.getRecurBy());
		 assertEquals(1,appt.getRecurIncrement());
		 assertEquals(0,appt.getRecurNumber());
		 assertNotNull((appt.getRecurDays()));
	 }

	 // Test that the isValid/getValid method work as expected.	 
	 @Test
	  public void test03()  throws Throwable  {
		  Appt valid_appt = new Appt(00, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		  Appt appt1 = new Appt(24,1,1,1,1, "none", "none");
		  Appt appt1_2 = new Appt(-1,1,1,1,1, "none", "none");
		  Appt appt2 = new Appt(1,61,1,1,1, "none", "none");
		  Appt appt2_2 = new Appt(1,-1,1,1,1, "none", "none");
		  Appt appt3 = new Appt(1,1,32,1,1, "none", "none");
		  Appt appt3_2 = new Appt(1,1,-1,1,1, "none", "none");
	  //can't test months due to call onto NumDaysInMonth
	  //this function doesn't validate title or description
		  
		  assertEquals(true, valid_appt.getValid());
		  assertEquals(false, appt1.getValid());
		  assertEquals(false, appt1_2.getValid());
		  assertEquals(false, appt2.getValid());
		  assertEquals(false, appt2_2.getValid());
		  assertEquals(false, appt3.getValid());
		  assertEquals(false, appt3_2.getValid());
		  
		  assertFalse(appt1.getValid());
		  appt1.setStartHour(9);
		  assertEquals(9,appt1.getStartHour());
		  appt1.setStartMinute(20);
		  assertEquals(20,appt1.getStartMinute());
		  appt1.setStartDay(21);
		  assertEquals(21,appt1.getStartDay());
		  appt1.setStartMonth(2);
		  assertEquals(2,appt1.getStartMonth());
		  appt1.setStartYear(2017);
		  assertEquals(2017,appt1.getStartYear());
		  assertEquals(0,appt1.getRecurNumber());
		  assertEquals(2,appt1.getRecurBy());
		  assertTrue(!appt1.isRecurring());
	  }
	 
	 // Test that the compareTo method work as expected.
	 @Test
	  public void test04()  throws Throwable  {
		  Appt appt1 = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		  Appt appt2 = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
		  assertEquals(0,appt1.compareTo(appt2));
		  
	  }
	  
	 // Test that the toString and represntationApp method work as expected.
	 @Test
	  public void test05()  throws Throwable  {
		 Appt appt1 = new Appt(21, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party.");
		  String testString1 = "\t" + 01 + "/" + 15 + "/" + 2018 +" at " + 9 + ":" + 30 + "pm" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n";
		 assertEquals(testString1, appt1.toString());
		 
		 Appt appt2 = new Appt(0, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party.");
		  String testString2 = "\t" + 01 + "/" + 15 + "/" + 2018 +" at " + 12 + ":" + 30 + "am" + " ," + "Birthday Party" + ", " + "This is my birthday party." + "\n";
		 assertEquals(testString2, appt2.toString());
	  }	
		 
}

