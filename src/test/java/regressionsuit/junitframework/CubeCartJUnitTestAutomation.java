package regressionsuit.junitframework;

import com.unitedcodernigar.jsonfile.FunctionLibrary;
import com.unitedcodernigar.jsonfile.LoginUser;
import com.unitedcodernigar.jsonfile.Customer;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CubeCartJUnitTestAutomation extends FunctionLibrary {

    LoginUser loginUser;
    Customer customer;
    @BeforeAll
    public static void setUp(){
        openBrowser();
    }

    @Test
    public void loginTest(){
      loginUser = new LoginUser("testautomation1","automation123!");
      login(loginUser);
    }

    @Test
    public void addCustomer(){
        customer = new Customer("adil"+getCurrentTimeStamp(),"abrahan"+getCurrentTimeStamp(),
                "adil32"+getCurrentTimeStamp()+"@gmail.com");
        boolean isCustomerAdded = addCustomer(customer);
        Assertions.assertTrue(isCustomerAdded);
    }
    @AfterAll
    public static void tearDown(){
        logOut();
        closeBrowser();
    }
}
