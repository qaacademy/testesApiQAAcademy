package cenarios;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

public class TesteApiCep {
	
	@Test
	public void testeApiCorreios() {
		RestAssured.given().log().all()//pre condição
		.when() //Disparo
		.get("https://viacep.com.br/ws/05794400/json/") //endereço
		.then().log().all() //Validação
		.statusCode(200); // codigo retornado
	
	}
	
	@Test
	public void testeApiCorreiosBody() {
		RestAssured.given().log().all()
		.when()
		.get("https://viacep.com.br/ws/05794400/json/") 
		.then().log().all() 
		.statusCode(200)
		.assertThat()
		.body(equalTo("05794-400"));
		
	
	}
	
	
	
	

}
