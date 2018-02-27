package calendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

// Random Test Generator  for TimeTable class.
public class TimeTableRandomTest 
{	
	
	 // Return a randomly selected method to be tests !. 
	 public static String RandomSelectMethod(Random random)
	 {
		 String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class
	    	 int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
	    	 return methodArray[n] ; // return the method name 
	 }
		
	// Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !. 
	public static int RandomSelectRecur(Random random)
	{
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
	    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	    return RecurArray[n] ; // return the value of the  appointments to recur 
	}	
		
	// Return a randomly selected appointments to recur forever or Never recur  !.	 
	public static int RandomSelectRecurForEverNever(Random random)
	{
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
	 	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	   return RecurArray[n] ; // return appointments to recur forever or Never recur 
	}	
	
	@Test
	public void radnomtest()  throws Throwable  
	{		 
		int TestTimeout = 30000;
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		
		System.out.println("Start testing...");
	 
		 try
		 {
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) 
			 {
				long randomseed =System.currentTimeMillis(); 
					
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
	
			 
			 TimeTable time = new TimeTable();
			 Appt appt = new Appt(hour, min, day, month, year, title, description);
			 Appt appt2 = new Appt(hour, min, day, month, year, title, description);
			 Appt appt3 = new Appt(hour, min, day, month, year, title, description);
			 Appt appt4 = new Appt(hour2, min2, day2, month2, year2, title2, description2);
			 int[] recurrence = new int[]{3};
			 int[] recurrence2 = new int[]{3};
			 int[] recurrence3 = new int[]{3};
			 appt.setRecurrence(recurrence, 0, 1, appt.RECUR_NUMBER_FOREVER);
			 appt2.setRecurrence(recurrence2, 2, 3, appt2.RECUR_NUMBER_FOREVER);
			 appt3.setRecurrence(recurrence3, 4, 5, 6);
			 LinkedList<Appt> listAppts = new LinkedList<Appt>();
			 LinkedList<Appt> listAppts2 = null;
			 GregorianCalendar calDay = new GregorianCalendar(year, month, day);
			 GregorianCalendar calDay2 = new GregorianCalendar(year2, month2, day2);
			 listAppts.add(appt);
			 listAppts.add(appt2);
			 listAppts.add(appt3);
			 
			 int sizeArray=ValuesGenerator.getRandomIntBetween(random, -1, 9);
			 int[] recurDays;
			 if(sizeArray < 0)
				 recurDays=null;
			 else
			 recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
			 int recur=ApptRandomTest.RandomSelectRecur(random);
			 int recurIncrement = ValuesGenerator.RandInt(random);
			 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
			 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
			 
			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		        //if((iteration%10000)==0 && iteration!=0 )
		              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);		 
			 try{
				 time.getApptRange(listAppts, calDay, calDay2);
	 	}catch(DateOutOfRangeException e){
	 		
		}
		 time.deleteAppt(listAppts, appt);
		 time.deleteAppt(listAppts, appt2);
		 time.deleteAppt(listAppts, appt3);
		 time.deleteAppt(listAppts, appt4);
		 time.deleteAppt(listAppts2, null);	
		 
	 }
			 
		 
	 }catch(NullPointerException e){
	 }
	 System.out.println("Done testing...");
	 }	
}
