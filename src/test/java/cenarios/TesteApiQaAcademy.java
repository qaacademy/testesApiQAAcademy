package cenarios;

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
		.statusCode(500); // codigo retornado
	
	}
	
}
