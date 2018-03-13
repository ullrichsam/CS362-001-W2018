package calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

// Random Test Generator  for CalDay class.
public class CalDayRandomTest 
{
     // Generate Random Tests that tests CalDay Class.
	 @Test
	  public void radnomtest()  throws Throwable  
	 {
		 int TestTimeout = 30000;
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 System.out.println("Start testing...");
	
		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) 
			 {
				 long randomseed = System.currentTimeMillis();
				 Random random = new Random(randomseed);
				 int hour =ValuesGenerator.RandInt(random);
				 int min =ValuesGenerator.RandInt(random);
				 int day = ValuesGenerator.getRandomIntBetween(random, -20, 31);
				 int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int year = ValuesGenerator.RandInt(random);
				 String title=ValuesGenerator.getString(random);
				 String description=ValuesGenerator.getString(random);
				 int hour2 = 01;
				 int min2 = 30;
				 int day2 = 03;
				 int month2 = 05;
				 int year2 = 1981;
				 String title2 = "Birthday Party";
				 String description2 = "This is my birthday party.";
	
				 GregorianCalendar calDay = new GregorianCalendar(year, month, day);
				 CalDay c = new CalDay(calDay);
				 Appt appt = new Appt(hour, min, day, month, year, title, description);
				 Appt appt2 = new Appt(hour, min, day, month, year, title, description);
				 Appt appt3 = new Appt(hour , min, day, month, year, title, description);
				 Appt appt4 = new Appt(hour2 , min2, day2, month2, year2, title2, description2);
				 c.addAppt(appt);
				 c.addAppt(appt2);
				 c.addAppt(appt3);
				 c.addAppt(appt4);
				 
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 	}
		 
		 	}catch(NullPointerException e){
	
			}
		 System.out.println("Done testing...");	 
	 }	
}
