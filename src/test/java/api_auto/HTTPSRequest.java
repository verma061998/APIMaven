package api_auto;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import  java.util.HashMap;



public class HTTPSRequest {
	int id;
	@Test (priority =1)
void getuser() {
	given()
	.when()
	   .get("https://reqres.in/api/users/2")
	.then()
	.statusCode(200)
	.log().all();
}
	@Test (priority =2)
	void createUser()
	{
		HashMap hm = new HashMap();
		hm.put("name", "sudhanshu");
		hm.put("job", "Test Analyst");
		// key and value
	id =given()
			.contentType("application/json")
		    .body(hm)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		
		/*.then()
		.statusCode(200)
		.log().all();*/
	}
}
