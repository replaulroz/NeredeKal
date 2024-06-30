package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoryPage;

public class CategorySteps {

    CategoryPage categoryPage = new CategoryPage();

    @Then("^(.*) sayfasi gorulur$")
    public void sayfasiGorulur(String text) {
        categoryPage.confirmTheSubTitle(text);
    }

    @When("Siralama menusune tiklanir")
    public void siralamaMenusuneTiklanir() {
        categoryPage.clickOrderMenu();
    }

    @Then("Fiyatlarda en dusukten yukariya dogru artis olduğu gorlur")
    public void fiyatlardaEnDusuktenYukariyaDogruArtisOlduğuGorlur() {
        categoryPage.verifyThePricesAsOrderingLowertoUpper();
    }
}
