package steps;

import components.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class UserTests {

    @BeforeClass
    public static void setupURL() {
        RestAssured.baseURI = "https://api.github.com";
    }

    User user = new User();

    @Parameters({"userName", "userId", "amountOfUserRepos", "amountOfUserFollowers", "amountOfUserFollowing"})
    @Test
    public void verifyUserDetails(String userName,
                                  int userId,
                                  int amountOfUserRepos,
                                  int amountOfUserFollowers,
                                  int amountOfUserFollowing) {
        Response foundUsers = user.getUser(userName);

        assertEquals(200, foundUsers.getStatusCode());
        assertEquals(userId, user.getUserId(userName));
        assertEquals(amountOfUserRepos, user.getAmountOfUserRepos(userName));
        assertEquals(amountOfUserFollowers, user.getAmountOfUserFollowers(userName));
        assertEquals(amountOfUserFollowing, user.getAmountOfUserFollowing(userName));
    }
}
