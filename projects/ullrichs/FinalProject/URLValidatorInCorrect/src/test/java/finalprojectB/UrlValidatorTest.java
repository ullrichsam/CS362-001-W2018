// Hayato Yokoyama and Sam Ullrich
package finalprojectB;

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase 
{
	   public UrlValidatorTest(String testName) 
	   {
	      super(testName);
	   }	   
	    
	   public void testManualTest()
	   {
		   String[] schemes = {"http"}; 		   
		   UrlValidator urlVal = new UrlValidator( schemes, UrlValidator.ALLOW_ALL_SCHEMES);
		   UrlValidator urlVal2 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		   assertTrue(urlVal.isValid("http://google.com"));
		   assertTrue(urlVal2.isValid("http://google.com"));
		   
		   String[] schemes3 = {"http","https"}; 
		   UrlValidator urlVal3 = new UrlValidator(schemes3);
		   //if (urlVal3.isValid("ftp://foo.bar.com/")) {
		   assertTrue(urlVal3.isValid("ftp://foo.bar.com/"));
		   assertTrue(urlVal3.isValid("http://amazon.com"));
		   assertTrue(urlVal3.isValid("http://google.com"));
		   assertTrue(urlVal3.isValid("http://intel.com"));
			  
		      //System.out.println("URL is valid");
		   //} else {
			  assertFalse(urlVal3.isValid("ftp://foo.bar.com/"));
			  assertFalse(urlVal3.isValid("ht://amazon.com"));
			  assertFalse(urlVal3.isValid("001://google.com"));
			  assertFalse(urlVal3.isValid("////://intel.com"));
		      //System.out.println("URL is invalid");
		   	   
	   }
	   public void partitionTesting()
	   {
		   UrlValidator urlVal3 = new UrlValidator();
		   //partition testing for ports
		   assertFalse(urlVal3.isValid("http://google.com/-1"));
		   assertFalse(urlVal3.isValid("http://google.com/0"));
		   assertTrue(urlVal3.isValid("http://google.com/1"));
		   assertTrue(urlVal3.isValid("http://google.com/65535"));
		   assertFalse(urlVal3.isValid("http://google.com/65536"));
		   assertFalse(urlVal3.isValid("http://google.com/65537"));
		   assertFalse(urlVal3.isValid("http://google.com/asdf"));
		   
		   
		   //partition testing for authority
		   assertTrue(urlVal3.isValid("http://google.com"));
		   assertFalse(urlVal3.isValid("http://google"));
		   assertTrue(urlVal3.isValid("http://www.google.com"));
		   assertTrue(urlVal3.isValid("http://255.255.255.255"));
		   assertFalse(urlVal3.isValid("http://1.2.3.4.5"));
		   assertFalse(urlVal3.isValid("http://255.255.255.255.255"));
		   assertTrue(urlVal3.isValid("http://1.2.3.4"));
		   assertFalse(urlVal3.isValid("http://1.-1.-1.-3"));
		   assertFalse(urlVal3.isValid("http://256.256.256.256"));
		   assertFalse(urlVal3.isValid("http://"));
		   
		   //partition testing for schemes
		   assertTrue(urlVal3.isValid("http://google.com"));
		   assertFalse(urlVal3.isValid("//google.com"));
		   assertFalse(urlVal3.isValid("nope://google.com"));
		   
	   }	   
	   
		public void programmingBasedTesting()
		{
			 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

			  //SpecificSchemes 
			  assertTrue(urlVal.isValid("file://www.google.com/newFolder"));
			  assertTrue(urlVal.isValid("file://www.google.com"));
			  assertTrue(urlVal.isValid("file:///newFolder"));
			  assertTrue(urlVal.isValid("file:///"));
			 
			 
			 //ValidURLs
			    assertTrue(urlVal.isValid("https://www.goggle.com"));
			    assertFalse(urlVal.isValid("http://www.goggle.com!b=3")); 
			    assertFalse(urlVal.isValid("http://www.goggle.comq=4")); 
		        assertTrue(urlVal.isValid("http://www.goggle.com?query=MOON")); 
		        assertFalse(urlVal.isValid("http://www.goggle.com?c=5")); 
		        assertTrue(urlVal.isValid("http://www.goggle.com?q=BADDAYS"));	   
		        assertTrue(urlVal.isValid("http://gm}}}}}}}ail.com/re")); 
		        assertTrue(urlVal.isValid("http:/google.com")); 	       	        
		        assertTrue(urlVal.isValid("http://www.37.com")); 
		        assertFalse(urlVal.isValid("http://www.goggle.com/??")); 
		        assertTrue(urlVal.isValid("http://www.g%20le.com")); 
		        assertFalse(urlVal.isValid("http:///www.g%20le.com")); 
		        
			   // InvalidURLs
			   assertFalse(urlVal.isValid("://google"));
		       assertFalse(urlVal.isValid("0110tp://www.goggle.com"));
		       assertFalse(urlVal.isValid("http://goggle.com//////."));
		       assertFalse(urlVal.isValid("http://www.goggle.com:11")); 
		       assertFalse(urlVal.isValid("http://www.goggle.com:aa=22"));
		       
		       //ValidSchemes 
		       assertTrue(urlVal.isValid("http://www.goggle.com"));
		       assertTrue(urlVal.isValid("https://www.goggle.com"));
		       assertTrue(urlVal.isValid("ftp://www.goggle.com"));
		       assertTrue(urlVal.isValid("file://www.goggle.com"));
		       
		       //InvalidSchemes 
		       assertFalse(urlVal.isValid("/www.goggle.com"));
		       assertFalse(urlVal.isValid("http:\\www.goggle.com"));
		       assertFalse(urlVal.isValid("a:/b://www.goggle.com"));
		       
		       //ValidAuthorities 
		       assertTrue(urlVal.isValid("255.255.255.255")); // special broadcast address
		       assertTrue(urlVal.isValid("http://www.amazon.com"));
		       assertTrue(urlVal.isValid("intel.com"));
		       
		       //InvalidAuthorities 
		       assertFalse(urlVal.isValid("255.255.255"));
		       assertFalse(urlVal.isValid("google+.com"));
		       assertFalse(urlVal.isValid("google"));
		       
		       //ValidPorts
		       assertTrue(urlVal.isValid("http://www.goggle.com:11111"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:5"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:2018"));     
		       assertTrue(urlVal.isValid("http://www.goggle.com:-1"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:0"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:1"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:65535"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:65536"));
		       assertTrue(urlVal.isValid("http://www.goggle.com:65537"));
		       		       
		       //InvalidPorts
		       assertFalse(urlVal.isValid("http://www.goggle.com:30&4"));
		       assertFalse(urlVal.isValid("http://www.goggle.com:--22"));
		       assertFalse(urlVal.isValid("http://www.goggle.com::80"));
		       
		       UrlValidator urlVal2 = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);
			   assertTrue(urlVal2.isValid("http://www.google.com/pathQuery#Fragment")); // Valid URL
			   assertTrue(urlVal2.isValid("http://www.google.com//pathQuery#Fragment")); // Valid Path, "//" allowed
			   assertTrue(urlVal2.isValid("http://www.google.com////////pathQuery#Fragment"));
			   assertFalse(urlVal2.isValid("http://www.google.compathQuery#Fragment")); // Invalid Path, zero path slashes 
		
			   UrlValidator urlVal3 = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
			   assertTrue(urlVal3.isValid("http://google/"));
			   assertTrue(urlVal3.isValid("http://googlr/path.html"));
		}
}
