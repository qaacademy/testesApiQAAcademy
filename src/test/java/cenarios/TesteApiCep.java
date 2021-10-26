package cenarios;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

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
	public void testeApiCorreiosValidaContentType() {
		RestAssured.given().log().all()// pre condição
				.when() // Disparo
				.get("https://viacep.com.br/ws/05794400/json/") // endereço
				.then().log().all() // Validação
				.contentType(ContentType.JSON); // codigo retornado

	}

	@Test
	public void testeApiCorreiosBody() {
		RestAssured.given().log().all().when().get("https://viacep.com.br/ws/05794400/json/").then().log().all()
				.statusCode(200).assertThat().body("cep", Matchers.equalTo("05794-400"));

	}

	// Fazer import Statico
	@Test
	public void testeApiCorreiosBodyValidacaoRespostasComplexas() {
		RestAssured.given().log().all().when().get("https://api.zippopotam.us/BR/01000-000").then().log().all()
				.statusCode(200).assertThat().body("'post code'", Matchers.equalTo("01000-000")).and()
				.body("country", Matchers.equalTo("Brazil"))// Detalhe para validar palavras com espaco usar as ' '
				.body("places[0].'place name'", Matchers.equalTo("São Paulo"));
	}

	@Test
	public void testeApiCorreiosBodyComExtract() {

		String placeName =

				RestAssured.given()
				.when().get("http://zippopotam.us/us/90210")
				.then()
				.extract()// Palavrinha para
				.path("places[0].'place name'"); // qual o endeço que deseja Extrair

		Assert.assertEquals("Beverly Hills", placeName);
	}
	
	
	@Test
	public void testeApiCorreiosBodyComHeader() {

				Map<String, String> header = new HashMap();
				RestAssured.given().headers(header)
				.when().get("http://zippopotam.us/us/90210")
				.then()
				.log().all();

	}
}
