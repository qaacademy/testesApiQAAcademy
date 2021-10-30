package cenarios.correcao_aulas;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class TesteApiQAAcademy_ParImpar {

	@Test
	public void testeParOuImparComQueryParam() {
		// http://localhost:8080/exrecicios/parOuImpar
		String var_numero = "10";

		RestAssured
		.given()
			.log().all()
			.queryParam("numero", var_numero)
		.when()
			.get("http://localhost:8080/exercicios/parOuImpar")
		.then()
			.assertThat().log().all()
			.body(Matchers.equalTo("O numero 10 é par")).statusCode(200);
	}

}
