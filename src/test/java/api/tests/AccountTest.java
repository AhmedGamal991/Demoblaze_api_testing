package api.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.AccountsEndPoints;
import api.payload.Account;
import io.restassured.response.Response;

public class AccountTest {

	Faker faker;
	Account Accountpayload;
	@BeforeClass
	public void setupDate() {
		faker = new Faker();
		Accountpayload = new Account();
		Accountpayload.setUsername(faker.name().username());
		Accountpayload.setPassword(faker.internet().password());
		
	}
		@Test(priority = 1)
		public void testSingUp() {
			Response response = AccountsEndPoints.singUp(Accountpayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
		}
		@Test(priority = 2)
		public void testSingIn() {
			Response response = AccountsEndPoints.singIn(Accountpayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
		}
		

}
