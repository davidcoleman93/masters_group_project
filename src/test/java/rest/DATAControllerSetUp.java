package contoller;

import com.jayway.restassured.RestAssured;
import controller.DATAController;
import org.junit.BeforeClass;

public class DATAControllerSetUp {
    private DATAController dataController;


    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if(basePath == null){
            basePath = "/data/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");

        if(baseHost == null){
            baseHost = "http://localhost/LteFailureSystem-0.0.1-SNAPSHOT/api";
        }
        RestAssured.baseURI = baseHost;
    }
}