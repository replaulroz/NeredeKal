package pages;

import common.Action;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage {

    Action action = new Action();
    public final By orderMenu = By.xpath("//div[text()='En Çok Tavsiye Ettiklerimiz']/../div[2]");


    public void confirmTheSubTitle(String text) {
        action.confirmTheSubtitle(text);
    }

    public void clickOrderMenu() {
        action.staticWait(10000);
        action.click(orderMenu,"siralama menusu acildi");
    }

    public void verifyThePricesAsOrderingLowertoUpper() {
        List<WebElement> elements = Action.webDriver.findElements(By.xpath("//div[@class='css-1epzwqf']"));
        List <Double> prices = new ArrayList<>();

        for(int i=0; i<elements.size();i++){
            String priceText = elements.get(i).getText().split(" ")[0];
            Double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        for(int i=0; i<prices.size()-1;i++){
            Assert.isTrue(prices.get(i) <= prices.get(i+1),"filtreye uygun siralanmadi");
        }

    }
}
