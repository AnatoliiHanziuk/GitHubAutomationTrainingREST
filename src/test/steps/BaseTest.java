package steps;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.DataLoader;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class BaseTest {

    public String testUser = DataLoader.getTestUserName();

    @BeforeClass
    public static void setupURL() {
        RestAssured.baseURI = "https://api.github.com";
    }
}
