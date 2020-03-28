package com.qualityhouse.serenity.steps.definitions;



import com.qualityhouse.serenity.page_objects.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.qualityhouse.serenity.steps.libraries.AddToCartActions;
import net.thucydides.core.annotations.Steps;
import com.qualityhouse.serenity.entities.Item;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class AddToCartStepsDefinitons {
        @Steps
        private AddToCartActions dimo;

        @When("^John navigate to \"([^\"]*)\" menu$")
        public void navigate_to_page(String By_to_navigate){
               dimo.navigatedToPage(By_to_navigate);
        };

        @When("^then John selected to \"([^\"]*)\" product$")
        public void thenJhonSelectedToProduct(String product_number) {
              dimo.selectedProductByNumber(product_number);
        }

         @When("^then choose its quantity,size and color and submitted to cart:$")
         public void thenChooseItsQuantitySizeAndColorAndSubmittedToCart(List<Item> data) {
             Item article = data.get(0);
             dimo.selectedTheItemFeaturesAndAddToCart(article);
        }

    @Then("^he should see what has ordered on the Shopping Cart Summary Page:$")
    public void heShouldSeeWhatHasOrderedOnTheShoppingCartSummaryPage(List<Item> data) {
        Item article = data.get(0);
        SoftAssertions assertSoftly = new SoftAssertions();
        assertSoftly.assertThat(dimo.getValueFrom(HomePage.CART_QUANTITY)).isEqualTo(article.getQuantity());
        assertSoftly.assertThat(dimo.readsTextFrom(HomePage.CART_DESCRIPTION).contains(article.getColor()));
        assertSoftly.assertThat(dimo.readsTextFrom(HomePage.CART_DESCRIPTION).contains(article.getSize()));

        assertSoftly.assertAll();
    }
}
