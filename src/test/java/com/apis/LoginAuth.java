package com.apis;

	

	import java.util.ArrayList;
	import java.util.List;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.http.Header;
	import io.restassured.http.Headers;
	import io.restassured.response.Response;

	public class LoginAuth extends BaseClass { 
		String logtoken;

		@Test(priority = 2)
		private void addAddress() {

			List<Header> lstHeader = new ArrayList<>();

			Header h1 = new Header("accept", "application/json");
			Header h2 = new Header("Authorization", "Bearer " + logtoken);
			Header h3 = new Header("Content-Type", "application/json");

			lstHeader.add(h1);
			lstHeader.add(h2);
			lstHeader.add(h3);

			Headers headers = new Headers(lstHeader);

			addHeaders(headers);

			AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Arun", "Surya",
					"9894240979", "2", 101, 333, 106, "611001", "New Street", "Home");
			addReqBody(addUserAddress_Input_Pojo);

			Response response = addReqType("POST", "https://omrbranch.com/api/addUserAddress");

			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200, "Verify status code");

			AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);

			String message = addUserAddress_Output_Pojo.getMessage();
			Assert.assertEquals(message, "Address added successfully", "Verify Address added successfully");
		}

		@Test(priority = 1)

		public void Login() {

			// 1.Header:
			addHeader("accept", "application/json");

			// 2.Basic Auth:
			addBasicAuth("arunsuryamb@gmail.com", "242118MB@s");

			// 3.Req Type:
			addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

			// 4. Status Code:
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200, "Verify status Code");

			Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
			String first_name = login_Output_Pojo.getData().getFirst_name();
			Assert.assertEquals(first_name, "Arun", "Verify first name");

			logtoken = Login_Output_Pojo.getData().getLogtoken();

			// 5. Pretty String:

			// String resBodyAsPrettyString = getResBodyAsPreettyString(response);
			// System.out.println(resBodyAsPrettyString);

		}

	}


	