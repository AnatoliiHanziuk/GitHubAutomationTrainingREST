package components;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class User {

    private Response response = null;

    public Response getUser(String userName) {
        return  given()
                .contentType("application/json")
                .when()
                .get("/users/" + userName);
    }

    public int getUserId(String userName) {
        return JsonPath.read(getUser(userName).asString(), "$.id");
    }

    public int getAmountOfUserRepos(String userName) {
        return JsonPath.read(getUser(userName).asString(), "$.public_repos");
    }

    public int getAmountOfUserFollowers(String userName) {
        return JsonPath.read(getUser(userName).asString(), "$.followers");
    }

    public int getAmountOfUserFollowing(String userName) {
        return JsonPath.read(getUser(userName).asString(), "$.following");
    }
}
