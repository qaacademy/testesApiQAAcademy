package cenarios;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class TesteCpf {
	
	
	
	@Test
	public void testeCpfValido() {
		
		String cpf = "11144477735"; 
		
		RestAssured
		.given()
			.log().all()
			.queryParam("cpf", cpf)
		.when()
			.get("http://localhost:8080/exercicios/validarCpf")
		.then()
			.log().all()
			.assertThat()
			.body(Matchers.containsString("Valido"))
			.statusCode(200);
		

	}
	
	@Test
	public void testeCpfInvalido() {
		
		String cpf = "11144477734"; 
		
		RestAssured
		.given()
			.log().all()
			.queryParam("cpf", cpf)
		.when()
			.get("http://localhost:8080/exercicios/validarCpf")
		.then()
			.log().all()
			.assertThat()
			.body(Matchers.containsString("Invalido"))
			.statusCode(200);
		

	}
	
	@Test
	public void testeCpfValidoURLIncorreta() {
		
		String cpf = "11144477735"; 
		
		RestAssured
		.given()
			.log().all()
			.queryParam("cpf", cpf)
		.when()
			.get("http://localhost:8080/exercicio/validarCpf")
		.then()
			.log().all()
			.statusCode(404);
		

	}
	

}
