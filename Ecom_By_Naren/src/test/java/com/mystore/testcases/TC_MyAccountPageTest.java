package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;


public class TC_MyAccountPageTest extends BaseClass {


	@Test
	public void verifyRegistrationAndLogin()
	{

		logger.info("=====================  Verify Registration and Login starts   ========================="); 


		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterCreateEmailAddress("narendrap@gmail.com");
		logger.info("--------------------------------Email address entered in create account section.---------------------------------------------");

		myAcpg.clickSubmitCreate();

		logger.info("clicked on create an account button");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);

		accCreationPg.selectTitleMr();
		logger.info("----------------------------------clicked on Title mr. radio button--------------------------------");
		accCreationPg.enterCustomerFirstName("Narendra");
		logger.info("----------------------------------Entered firtname --------------------------------");
		accCreationPg.enterCustomerLastName("Pawle");
		logger.info("----------------------------------Entered Lastname --------------------------------");
		accCreationPg.enterPassword("GulabJamun@123");
		logger.info("----------------------------------Entered password correctly --------------------------------");
		accCreationPg.enterAddressFirstName("Narendra");
		logger.info("----------------------------------Entered Address firstname--------------------------------");
		accCreationPg.enterAddressLastName("Pawle");
		logger.info("----------------------------------Entered Address Lastname--------------------------------");
		accCreationPg.enterAddress("My dream place,VSSC veli, trivendrum, Kerala ");
		logger.info("----------------------------------Entered Address --------------------------------");

		accCreationPg.enterCity("Trivendrum");
		logger.info("----------------------------------Entered city --------------------------------");
		accCreationPg.selectState("kerala");
		logger.info("---------------------------------Entered State --------------------------------");

		accCreationPg.enterPostcode("00000");
		logger.info("----------------------------------Entered postcode--------------------------------");
		accCreationPg.selectCountry("India");
		logger.info("----------------------------------Entered country-------------------------------");
		accCreationPg.enterMobilePhone("1234567890");
		logger.info("----------------------------------Entered mobile number-------------------------------");
		accCreationPg.enterAlias("Home");
		logger.info("----------------------------------Entered Alias-------------------------------");

		logger.info("------------------------------------------entered ALL user details on account creation page-------------------------------------------------.");

		accCreationPg.clickOnRegister();
		logger.info("clicked on Register button");

		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();

		Assert.assertEquals("Narendra Pawle", userName);

		logger.info("***************TestCase Verify Registration and Login ends*****************"); 

	}

	@Test(enabled = false)
	public void VerifyLogin() throws IOException 
	{

		logger.info("***************TestCase Verify Login starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress("narendrapawle@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("GulabJamun@123");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");


		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();


		if(userName.equals("Narendra Pawle"))
		{
			logger.info("VerifyLogin - Passed");
			regUser.clickOnSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		}

		logger.info("******************TestCase Verify Login ends**********************"); 


	}


	@Test(enabled = false)
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress("narendrapawle@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("GulabJamun@123");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");


		registeredUserAccount regUser = new registeredUserAccount(driver);
		regUser.clickOnSignOut();

		if(pg.getPageTitle().equals("Login - My Store"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("******************************TestCase Verify Sign out ends************************************"); 

	}


}
