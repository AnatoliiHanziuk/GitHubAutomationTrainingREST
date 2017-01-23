package steps;

import components.Followers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class FollowersTests {

    @BeforeClass
    public static void setupURL() {
        RestAssured.baseURI = "https://api.github.com";
    }

    Followers followers = new Followers();

    @Parameters({"userName", "expectedFollowers"})
    @Test
    public void verifyFollowersDetails(String userName, String expectedFollowers) {
        Response foundFollowers = followers.getUserFollowers(userName);
        String[] expectedFollowersArray = expectedFollowers.split(", ");

        assertEquals(200, foundFollowers.getStatusCode());
        assertEquals(Arrays.asList(expectedFollowersArray), followers.getUserFollowersNames(userName));
    }

}
