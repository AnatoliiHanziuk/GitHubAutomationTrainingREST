package steps;

import components.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class UserTests extends BaseTest {

    User user = new User();

    @Test
    public void verifyUserDetails() {
        Response foundUsers = user.getUser(testUser);
        assertEquals(200, foundUsers.getStatusCode());
        assertEquals(704535, user.getUserId(testUser));
        assertEquals(9, user.getAmountOfUserRepos(testUser));
        assertEquals(3, user.getAmountOfUserFollowers(testUser));
        assertEquals(6, user.getAmountOfUserFollowing(testUser));
    }
}
