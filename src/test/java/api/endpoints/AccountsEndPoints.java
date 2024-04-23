package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Account;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccountsEndPoints {

	public static Response singUp (Account payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.signUp_url);
		return response;
	}

	public static Response singIn (Account payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.logIn_url);
		return response;
	}


}
