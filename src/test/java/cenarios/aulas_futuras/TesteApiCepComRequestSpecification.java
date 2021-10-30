package cenarios.aulas_futuras;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TesteApiCepComRequestSpecification {

	private static RequestSpecification requestSpec;

	@BeforeClass
	public static void requestSpecification() {

		requestSpec = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us").build();
	}

	@Test
	public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills_withRequestSpec() {

		given()
		.spec(requestSpec)
		.when().get("us/90210")
		.then().assertThat().statusCode(200);
	}

}
