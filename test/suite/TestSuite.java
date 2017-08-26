package suite;

import new_topic.NewTopic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import user_profile.UserProfile;

/**
 *
 * @author Dejan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UserProfile.class, NewTopic.class})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
