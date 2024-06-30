package pages;

import common.Action;
import dev.failsafe.internal.util.Assert;
import dev.failsafe.internal.util.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class MainPage {
    Action action = new Action();

    public final By mainPageLogo = By.xpath("//img[@alt='Neredekal.com']");
    public final By myAccount = By.xpath("//div[@class='css-19p82hs']");

    public final By selectableFirstDate = By.xpath("(//div[@class='css-7t4wwb'])[1]");

    public final By selectedDate = By.xpath("//div[@class='css-13rgr3v']");

    public final By searchBox = By.xpath("//input[contains(@placeholder,'Konum ya da otel ismi girin')]");

    public final By searchButton = By.xpath("//div[contains(text(),'ARA')]/..");

    public void initializeTest() throws MalformedURLException{
        action.initializeTest();
    }
    public void tearDownTest(){
        action.tearDownTest();
    }
    public void directToMainPage(){
        action.isElementPresent(mainPageLogo);
    }

    public void clickLinkButtonByText(String text){
        action.clickByText(text,text + " butonuna tiklandi");
    }

    public void hoverToElementByText(String text) {
        action.hoverByText(text, text + "uzerine imlec getirildi");
    }

    public void enterValueByText(String textbox, String value) {
        action.enterByText(textbox, value, textbox + " alanina" + value + " degeri girildi");
    }

    public void confirmTheLogin() {
        action.hover(myAccount, "Hesabim butonu uzerine imlec getirildi");
        action.isElementPresentByText("Çıkış Yap");
    }

    public void selectCheckInAndDepartureDates() {
        action.clickByText("Giriş","Giris icin tarihler goruntulendi");
        action.click(selectableFirstDate,"giris tarihi secildi");
        action.isElementPresent(selectedDate);
        action.click(selectableFirstDate, "cikis tarihi secildi");
    }

    public void enterValueInSearchBox(String text) {
        action.enter(searchBox, text, text +" aratildi");
    }

    public void confirmTheSubTitle(String text) {
        action.confirmTheSubtitle(text);
    }

    public void clickSearchButton() {
        action.click(searchButton, "ara butonuna tiklandi");
    }

    public void selectFromSuggestions(String text) {
        By by = By.xpath("(//b[text()='"+ text +"'])[1]");
        action.click(by, text + " onerisi secildi");
    }
}
