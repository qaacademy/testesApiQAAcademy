package cenarios;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;

public class TesteUsandoWireMock {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

	@Test
	public void exemploPostWireMockTest() {
		stubFor(post("/api/teste").withHeader("Content-Type", containing("json")).willReturn(
				ok().withHeader("Content-Type", "application/json").withBody("Usuario cadastrado com sucesso!")));

		RestAssured.given().header("Content-Type", "application/json")
		.when().post("http://localhost:8089/api/teste") // endereço
				.then().assertThat().log().all().body(Matchers.equalTo("Usuario cadastrado com sucesso!"));

	}
	
	@Test
	public void exemploDeleteWireMockTest() {
		stubFor(delete("/api/teste").withHeader("Content-Type", containing("json")).willReturn(
				ok().withHeader("Content-Type", "application/json").withBody("Usuario apagado com sucesso!")));

		RestAssured.given().header("Content-Type", "application/json")
		.when().delete("http://localhost:8089/api/teste") // endereço
				.then().assertThat().log().all().body(Matchers.equalTo("Usuario apagado com sucesso!"));

	}
	
	@Test
	public void exemploPutWireMockTest() {
		stubFor(delete("/api/teste").withHeader("Content-Type", containing("json")).willReturn(
				ok().withHeader("Content-Type", "application/json").withBody("Usuario adicionado com sucesso!")));

		RestAssured.given().header("Content-Type", "application/json")
		.when().delete("http://localhost:8089/api/teste") // endereço
				.then().assertThat().log().all().body(Matchers.equalTo("Usuario adicionado com sucesso!"));

	}
	
	
	
}
