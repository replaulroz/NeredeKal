package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utilities.Driver;

import java.net.MalformedURLException;


public class mainSteps {

    MainPage mainPage = new MainPage();

    @Before
    public void start() throws MalformedURLException {
        mainPage.initializeTest();
    }

    @After
    public void tearDown() {
        mainPage.tearDownTest();
    }
    @Given("Anasayfa goruntulenir")
    public void anaSayfaGoruntulenir() {
        mainPage.directToMainPage();
    }

    @And("^(.*) link butonuna tiklanir$")
    public void linkButonunaTiklanir(String text) {
        mainPage.clickLinkButtonByText(text);
    }

    @When("^(.*) uzerine imlec getirilir$")
    public void uzerineImlecGetirilir(String text) {
        mainPage.hoverToElementByText(text);
    }

    @And("^(.*) alanina (.*) girilir$")
    public void alaninaEpostaGirilir(String alan , String deger) {
        mainPage.enterValueByText(alan, deger);
    }

    @Then("Giris yapildigi gorulur")
    public void girisYapildigiGorulur() {
        mainPage.confirmTheLogin();
    }

    @Then("Giris ve cikis tarihi bugun ve yarin olarak secilir")
    public void girisVeCikisTarihiBugunVeYarinOlarakSecilir() {
        mainPage.selectCheckInAndDepartureDates();
    }

    @When("^Arama cubuguna (.*) yazilir$")
    public void aramaCubugunaYazilir(String text) {
        mainPage.enterValueInSearchBox(text);
    }

    @And("ARA butonuna tiklanir")
    public void araButonunaTiklanir() {
        mainPage.clickSearchButton();
    }

    @And("^Arama onerilerinden (.*) secilir$")
    public void aramaOnerilerindenSecilir(String text) {
        mainPage.selectFromSuggestions(text);
    }
}
