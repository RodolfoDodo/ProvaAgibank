package br.ce.agibank.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import br.ce.agibank.rest.core.BaseTest;

public class TypicodeTest extends BaseTest{

	@Test
	public void cadastrandoRecurso(){
		given()
		.log().all()
		.body("{\"title\": \"Rodolfo Farley\", \"body\": \"Adora andar de moto\", \"userId\": 50 }")
	.when()
		.post("/posts")
	.then()
		.log().all()
		.statusCode(201)
		.body("title", is("Rodolfo Farley"))
		.body("body", is("Adora andar de moto"))
		.body("userId", is(50))
		.body("id", is(notNullValue()))
		;
	}
	
	@Test
	public void atualizandRecurso(){
		given()
		.log().all()
		.body("{\"title\": \"Rodolfo Farley\", \"body\": \"Adora andar de carro\", \"userId\": 50, \"id\": 1 }")
	.when()
		.put("/posts/3")
	.then()
	.log().all()
	.statusCode(200)
	.body("title", is("Rodolfo Farley"))
	.body("body", is("Adora andar de carro"))
	.body("userId", is(50))
	.body("id", is(notNullValue()))
	;
}
	
	@Test
	public void excluindoRecurso(){
		given()
		.log().all()
		.body("{\"title\": \"Rodolfo Farley\", \"body\": \"Adora andar de moto\", \"userId\": 50, \"id\": 30 }")
	.when()
		.delete("/posts/1")
	.then()
	.log().all()
	.statusCode(200)
	;
}
	
	@Test
	public void listandoRecursoAlbuns(){
		given()
		.log().all()
		.body("{\"title\": \"saepe unde necessitatibus rem\", \"userId\": 1, \"id\": 9 }")
	.when()
		.get("users/1/albums")
	.then()
	.log().all()
	.statusCode(200)	
	 ;
	}
}





