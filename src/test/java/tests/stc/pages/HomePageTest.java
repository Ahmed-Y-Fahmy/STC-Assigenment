package tests.stc.pages;
import com.shaft.driver.SHAFT;
import data.LoadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.HomePage;


public class HomePageTest {
    SHAFT.GUI.WebDriver driver;
    HomePage homepage ;

    @Description("Validate the Data About the Saudi Arabia")
    @Test
    public void validateDataForSA() {
        homepage = new HomePage(driver);
        homepage.validateLitePackage("Lite" , "15" , "SAR");
        homepage.validateClassicPackage("Classic" , "25" , "SAR");
        homepage.validatePremiumPackage("Premium" , "60" , "SAR");

    }


    @Description("Validate the Data About the Kuwait")
    @Test
    public void validateDataForKuwait() {
        homepage = new HomePage(driver);
        homepage.changeCountryToBeKuwait();
        homepage.validateLitePackage("Lite" , "1.2" , "KWD");
        homepage.validateClassicPackage("Classic" , "2.5" , "KWD");
        homepage.validatePremiumPackage("Premium" , "4.8" , "KWD");

    }



    @Description("Validate the Data About the Baharin")
    @Test
    public void validateDataForBaharin() {
        homepage = new HomePage(driver);
        homepage.changeCountryToBeBaharin();
        homepage.validateLitePackage("Lite" , "2" , "BHD");
        homepage.validateClassicPackage("Classic" , "3" , "BHD");
        homepage.validatePremiumPackage("Premium" , "6" , "BHD");

    }


    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver ();
        driver.browser ().navigateToURL(LoadProperties.userData.getProperty("subscriptionUrl"));
    }

    @AfterClass
    public void afterClass() {
        driver.browser ().closeCurrentWindow();
    }

}
