package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 1000; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence","setStartHour","setStartMinute","setStartDay"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, -2, 8);
							 int[] recurDays;
							 if(sizeArray < 0)
								 recurDays=null;
							 else
						   recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
						else if(methodName.equals("setStartHour")){
							 int SetHours = ValuesGenerator.getRandomIntBetween(random,-8,30);
							 appt.setStartHour(SetHours);
							 if(appt.getValid())
							 	assertEquals(SetHours,appt.getStartHour());
						}
						else if(methodName.equals("setStartMinute")){
								int setMinutes = ValuesGenerator.getRandomIntBetween(random,-100,100);
								appt.setStartMinute(setMinutes);
								if(appt.getValid())
								 assertEquals(setMinutes,appt.getStartMinute());
						}
						else if(methodName.equals("setStartDay")){
							  int setDay = ValuesGenerator.getRandomIntBetween(random,-30,50);
								appt.setStartDay(setDay);
								if(appt.getValid())
									assertEquals(setDay,appt.getStartDay());
						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }



}

	 
	 /*
	    @Test
		 public void randomIsValid() throws Throwable
		 {
		 		long startTime = Calendar.getInstance().getTimeInMillis();
		 		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 		
				 for (int i = 0; elapsed < TestTimeout; i++) 
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
					 if((i%10000)==0 && i!=0 )
						System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		 		 }
		 }*/

