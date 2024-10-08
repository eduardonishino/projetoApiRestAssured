package filmesApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.loginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.BaseUtils;

public class filmesApiTest {

    public void validarLogin(){
        BaseUtils.setBaseURI("http://localhost:8080/");

        Response response = BaseUtils.post(json, ContentType.JSON, "auth");
    }

    @BeforeAll
    public static void validarLoginMap(){
        BaseUtils.setBaseURI("http://localhost:8080/");

        loginMap.initLogin();

        Response response = BaseUtils.post(loginMap.getLogin(), ContentType.JSON, "auth");
    }

    @Test
    public void validarConsultaCategorias(){

        Response response = BaseUtils.get(header, "categorias");
    }


}
