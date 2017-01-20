package steps;

import components.Followers;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class FollowersTests extends BaseTest{

    Followers followers = new Followers();

    @Test
    @Parameters("testUser1")
    public void verifyFollowersDetails() {
        Response foundFollowers = followers.getUserFollowers(testUser);
        String[] expectedFollowers = {"ekdevdes", "PivotLogix", "shilch"};
        assertEquals(200, foundFollowers.getStatusCode());
        assertEquals(Arrays.asList(expectedFollowers), followers.getUserFollowersNames(testUser));
    }

}
