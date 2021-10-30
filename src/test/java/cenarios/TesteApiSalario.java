package cenarios;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class TesteApiSalario {

	
	
	
	
	@Test
	public void testeSalarioComPAthParam() {
		
		String salario = "10000";
		String responseBody = "Salario bruto = 10000.0\n"
				+ "Salario liquido = 7265.2116000000005\n"
				+ "INSS =  854.1484000000002\n"
				+ "Imposto de Renda = 1880.6399999999999";
		
		RestAssured
		.given()
			.log().all()
		.when()
			.get("http://localhost:8080/exercicios/calculaSalario/"+salario)
		.then()
			.log().all()
			.assertThat()
			.body(Matchers.containsString(responseBody))
			.statusCode(200);
	}
	
}
