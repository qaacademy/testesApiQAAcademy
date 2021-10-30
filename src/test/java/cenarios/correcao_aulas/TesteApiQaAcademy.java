package cenarios.correcao_aulas;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class TesteApiQaAcademy {
	
	@Test
	public void testeParOuImpar() {
		RestAssured.given()//pre condição
		.when() //Disparo
		.get("http://localhost:8080/exercicios/parOuImpar?numero=1") //endereço
		.then() //Validação
		.statusCode(200); // codigo retornado
	
	}
	
	
	@Test
	public void testeParOuImparStatus404() {
		RestAssured.given()//pre condição
		.when() //Disparo
		.get("http://localhost:8080/exercicios/parOuImpar?sdasdjashkdss=1") //endereço
		.then() //Validação
		.statusCode(400); // codigo retornado
	
	}
	
	@Test
	public void testeParOuImparStatus() {
		RestAssured.given()//pre condição
		.when() //Disparo
		.get("http://localhost:8080/exercicios/parOuImpar?numero=assured") //endereço
		.then() //Validação
		.statusCode(400); // codigo retornado
	
	}
	
	@Test
	public void testeParOuImparStatus500() {
		RestAssured.given()//pre condição
		.when() //Disparo
		.get("http://localhost:8080/exercicios/parOuImpar?numero=assured") //endereço
		.then() //Validação
		.statusCode(400); // codigo retornado
	
	}
	
	
	@Test
	public void testeParOuImparStatusQueryParam() {
		String numero = "10";

		RestAssured.given().queryParam("numero", numero)
				.when()
				.get("http://localhost:8080/exercicios/parOuImpar") //endereço
				.then().assertThat()
				.log().all();
			
	}
	
	@Test
	public void testeParOuImparStatusQueryParamPorMap() {
		String numero = "10";
		
		Map<String, String> queryParams = new HashMap();
		queryParams.put("numero", numero); 

		RestAssured.given().queryParams(queryParams)
				.when()
				.get("http://localhost:8080/exercicios/parOuImpar") //endereço
				.then().assertThat()
				.log().all();
			
	}
	
	
	
	@Test
	public void testeParOuImparStatusQueryParamComValidacao() {
		String numero = "10";

		RestAssured.given().queryParam("numero", numero)
				.when()
				.get("http://localhost:8080/exercicios/parOuImpar") //endereço
				.then().assertThat()
				.log().all()
				.body( Matchers.equalTo("O numero 10 é par"));
			
	}
	
	
	
	
}
