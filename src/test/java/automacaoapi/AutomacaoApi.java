package automacaoapi;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;


public class AutomacaoApi {

    @Test
    //metódo get validando o conteúdo retornado em um array
    public void test_Get_Sistema_Reqres(){
        when().
                //endereço que a requisição busca
                get("https://reqres.in/api/users?page=2").
                then().
                //resultado do statuscode, onde 200 OK é o esperado - sucesso
                statusCode(200)
                //validação do retorno de cada campo do json referente ao id 12
                .body("data[5].id", is(12))
                .body("data[5].email", is("rachel.howell@reqres.in"))
                .body("data[5].first_name", is("Rachel"))
                .body("data[5].last_name", is("Howell"))
                .body("data[5].avatar", is("https://reqres.in/img/faces/12-image.jpg"));

    }
}
