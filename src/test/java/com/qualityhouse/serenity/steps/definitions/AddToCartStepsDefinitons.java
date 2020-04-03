package com.qualityhouse.serenity.steps.definitions;


import com.qualityhouse.serenity.page_objects.ItemPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.qualityhouse.serenity.steps.libraries.AddToCartActions;
import net.thucydides.core.annotations.Steps;
import com.qualityhouse.serenity.entities.Item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class AddToCartStepsDefinitons {
    public static List<Item> items = new ArrayList<>();

    @Steps
    private AddToCartActions dimo;

    @Given("^John is on the home page$")
    public void johnIsOnTheHomePage() {
        dimo.navigateToPage();
    }



    @When("^John adds products from \"([^\"]*)\" catalog to his cart with the following details:$")
    public void thenChooseItsQuantitySizeAndColorAndSubmittedToCart(String menuName, List<Item> data) {

        for (Item item : data) {
            dimo.navigatedToMenu(menuName);
            dimo.selectedProductByName(item.getArticle());
            item.setPrice(dimo.getPriceFromCurrency(ItemPage.SELECTED_UNIT_PRICE).toString());
            dimo.selectedTheItemFeaturesAndAddToCart(item);
            items.add(item);
        }
    }

    @Then("^he should see what has ordered on the Shopping Cart Summary Page:$")
    public void heShouldSeeWhatHasOrderedOnTheShoppingCartSummaryPage() {

        dimo.assertItemsInShoppingBasket();
    }


}
