import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LojinhaAPITest {
	private String token;
	
	@Before
	public void setUp() {
		RestAssured.baseURI = "http://165.227.93.41";
		RestAssured.basePath = "lojinha";
		
		token = RestAssured
				.given()
					.contentType(ContentType.JSON)
					.body("{\r\n" + 
							"\"usuariologin\": \"andressa.santos\",\r\n" + 
							"\"usuariosenha\": \"123456\"\r\n" + 
							"}")
				.when()
					.post("login")
				.then()
					.extract()// capturo meu token
						.path("data.token");
	}
	
	@Test
	public void testBuscarDadosDeUmProdutoEspecifico() {
		RestAssured
			.given()
				.header("token", token)
			.when()
				.get("produto/7235")
			.then()
				.assertThat()
					.statusCode(200)
					.body("data.produtonome", Matchers.equalTo("PS5"))
					.body("data.componentes[0].componentenome", Matchers.equalTo("controle"))
					.body("message", Matchers.equalTo("Detalhando dados do produto"));
		
	}
	@Test
	public void testBuscarDadosDeUmComponenteEspecifico() {
		RestAssured
		.given()
			.header("token", token)
		.when()
			.get("produto/7265/componente/2242")
		.then()
			.assertThat()
				.statusCode(200)
				.body("data.componentenome", Matchers.equalTo("fone topzera da sony"))
				.body("data.componentequantidade", Matchers.equalTo(2))
				.body("message", Matchers.equalTo("Detalhando dados do componente de produto"));
	}
	
}
