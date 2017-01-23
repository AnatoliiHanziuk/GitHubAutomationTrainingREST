package components;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

import static io.restassured.RestAssured.given;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class Followers {

    public Response getUserFollowers(String userName) {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/users/" + userName.toLowerCase() + "/followers");
        return response;
    }

    public JSONArray getUserFollowersNames(String userName) {
        return JsonPath.read(getUserFollowers(userName).asString(), "$..login");
    }
}
