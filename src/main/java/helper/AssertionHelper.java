package helper;

import org.testng.Assert;

public class AssertionHelper {

	
	public static void verifyText(String s1, String s2){
		
		Assert.assertEquals(s1, s1);
	}
	
	public static void markPass(){
		
		Assert.assertTrue(true);
	}
	
	public static void markPass(String message){
		
		Assert.assertTrue(true, message);
	}
	
	public static void markFail(){
		
		Assert.assertTrue(false);
	}
	
	public static void markFail(String message){
		
		Assert.assertTrue(false, message);
	}
	
	public static void verifyTrue(boolean status){
		Assert.assertTrue(status);
	}
	
	public static void verifyFalse(boolean status){
		Assert.assertFalse(status);
	}
	
	public static void verifyNull(String s1){
	   
		Assert.assertNull(s1);
	}
	
	public static void verifyNotNull(String s1){
		
		Assert.assertNotNull(s1);
	}
	
	public static void fail(){
		Assert.assertTrue(false);
	}
	
	public static void pass(){
		Assert.assertTrue(true);
	}
	
	public static void updateTestStatus(boolean status){
		if(status){
			pass();
		}
		else{
			fail();
		}
	}
}
