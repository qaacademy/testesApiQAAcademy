package cenarios;

import org.junit.Test;

import io.restassured.RestAssured;
import  io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import  org.hamcrest.Matchers.*;

public class TesteApiCep {

	@Test
	public void testeApiCorreios() {
		RestAssured.given().log().all()// pre condição
				.when() // Disparo
				.get("https://viacep.com.br/ws/05794400/json/") // endereço
				.then().log().all() // Validação
				.statusCode(200); // codigo retornado

	}

	@Test
	public void testeApiCorreiosBody() {
		RestAssured.given().log().all().when().get("https://viacep.com.br/ws/05794400/json/").then().log().all().statusCode(200)
				.assertThat().body("cep", Matchers.equalTo("05794-400"));

	}

}
