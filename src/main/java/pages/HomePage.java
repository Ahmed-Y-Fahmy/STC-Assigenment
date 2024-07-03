package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class HomePage {


    SHAFT.GUI.WebDriver driver;

    By countryBtn = By.xpath("//a[@id='country-btn']") ;
    By baharinCountryIcon = By.id("bh");
    By kuwaitCountryIcon = By.id("kw");

    By typeLiteText = By.id("name-lite") ;
    By litePriceText = By.xpath("//*[@id='currency-lite']/b");
    By liteCurrencyText = By.xpath("//*[@id='currency-lite']/i");


    By typeClassicText = By.id("name-classic") ;
    By classicPriceText = By.xpath("//*[@id='currency-lite']/b");
    By classicCurrencyText = By.xpath("//*[@id='currency-lite']/i");

    By typePremmiumText = By.id("name-classic") ;
    By PremmiumPriceText = By.xpath("//*[@id='currency-premium']/b");
    By premiumCurrencyText = By.xpath("//*[@id='currency-premium']/i");


    @Step ("Select Baharin Country")
    public void changeCountryToBeBaharin()  {
        driver.element().click(countryBtn).waitToBeReady(baharinCountryIcon);
        driver.element().click(baharinCountryIcon);

    }
    @Step ("Select Kwuait Country")
    public void changeCountryToBeKuwait()  {
        driver.element().click(countryBtn).waitToBeReady(kuwaitCountryIcon);
        driver.element().click(kuwaitCountryIcon);
    }


    @Step ("Validate The Lite Package")
    public void validateLitePackage(String expectedType , String expectedPrice , String expectedCurrency)  {
        driver.verifyThat().element(typeLiteText).text().isEqualTo(expectedType);
        driver.verifyThat().element(litePriceText).text().isEqualTo(expectedPrice);
        driver.verifyThat().element(liteCurrencyText).text().isEqualTo(expectedCurrency);
    }


    @Step ("Validate The Classic Package")
    public void validateClassicPackage(String expectedType , String expectedPrice , String expectedCurrency)  {
        driver.verifyThat().element(typeClassicText).text().isEqualTo(expectedType);
        driver.verifyThat().element(classicPriceText).text().isEqualTo(expectedPrice);
        driver.verifyThat().element(classicCurrencyText).text().isEqualTo(expectedCurrency);

    }


    @Step ("Validate The Premium Package")
    public void validatePremiumPackage(String expectedType , String expectedPrice , String expectedCurrency)  {
        driver.verifyThat().element(typePremmiumText).text().isEqualTo(expectedType);
        driver.verifyThat().element(PremmiumPriceText).text().isEqualTo(expectedPrice);
        driver.verifyThat().element(premiumCurrencyText).text().isEqualTo(expectedCurrency);

    }



    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

}
