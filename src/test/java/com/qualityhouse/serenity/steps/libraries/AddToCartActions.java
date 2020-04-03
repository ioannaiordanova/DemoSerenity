package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Item;
import com.qualityhouse.serenity.page_objects.ItemPage;
import com.qualityhouse.serenity.page_objects.ShoppingBasketPage;
import com.qualityhouse.serenity.steps.definitions.AddToCartStepsDefinitons;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import com.qualityhouse.serenity.page_objects.HomePage;
import org.assertj.core.api.SoftAssertions;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class AddToCartActions extends BasesActions {
    private ShoppingBasketPage shoppingBasketPage;

    @Step ("Get on the URL ")
    public void navigateToPage(){
        navigateToURL();
    }

    @Step ( "Navigated to category: {0}" )
    public void navigatedToMenu(String menuName){
        WebElementFacade categoryLink = getLinkByParentAndVisibleText(HomePage.MAIN_MENU,menuName);
        clicksOn(categoryLink);
    }

    @Step ( "Selected article by given name: {0}" )
    public void selectedProductByName(String articleTitle){
           WebElementFacade aProduct = getLinkByParentAndVisibleText(HomePage.CATALOG_UL,articleTitle);
           clicksOn(aProduct);
    }

    @Step
    public void selectedTheItemFeaturesAndAddToCart(Item article){

        fillsFieldWithData(ItemPage.INPUT_QUANTITY_WANTED,article.getQuantity());
        selectsFromDropDownAnItemByVisibleText(ItemPage.SELECT_SIZE_WANTED,article.getSize());
        findLinkByParentAndNameAndClick(ItemPage.SELECT_COLOR_WANTED,article.getColor());
        clicksOn(ItemPage.ADD_TO_CART_BTN);
        clicksOn(ItemPage.PROCEED_TO_CHECKOUT_BTN);
    }

    @Step ("Get the Product Quantity from {0} row")
    public WebElementFacade getCartQuantityByIndex(int index){
      return  shoppingBasketPage.shoppingBasketContainer.get(index).findBy(ShoppingBasketPage.CART_QUANTITY);
    }

    @Step ("Get the Product Description from {0} row")
    public WebElementFacade getCartDescriptionByIndex(int index){
        return shoppingBasketPage.shoppingBasketContainer.get(index).findBy(ShoppingBasketPage.CART_DESCRIPTION);
    }

    @Step ("Get the Product Name from {0} row")
    public WebElementFacade getCartProductNameByIndex(int index){
        return shoppingBasketPage.shoppingBasketContainer.get(index).findBy(ShoppingBasketPage.CART_PRODUCT_NAME);
    }

    @Step ("Get the Product Price from {0} row")
    public WebElementFacade getCartUnitPriceByIndex(int index){
       return shoppingBasketPage.shoppingBasketContainer.get(index).findBy(ShoppingBasketPage.CART_PRODUCT_UNIT_PRICE);
    }

    @Step("The Value from the screen: {0}  has to contain the expected: {1}")
    public boolean ActualStringContainsExpected(String actual,String expected){
        return actual.contains(expected);
    }

    @Step("The Value from the screen: {0}  has to be equal ignoring case to {1}")
    public boolean ActualStringEqualIngoreCaseToExpected(String actual,String expected){
        return actual.equalsIgnoreCase(expected);
    }

    @Step("The Integer Value from the screen: {0}  has to be equal to Integer {1}")
    public boolean ActualIntegerEqualToExpected(Number actual, Float expected){
     return (actual.floatValue()==expected.floatValue());
    }

    public Float getPriceAgainstQuantity(int index){
       return parseStringToFloat(AddToCartStepsDefinitons.items.get(index).getPrice())*parseStringToFloat(AddToCartStepsDefinitons.items.get(index).getQuantity());
    }


    public void assertItemsInShoppingBasket(){
        SoftAssertions assertSoftly = new SoftAssertions();


        IntStream.range(0, shoppingBasketPage.shoppingBasketContainer.size()).forEach(index -> {

            WebElementFacade cartDescriptionActual = getCartDescriptionByIndex(index);
            setElementInVisibleScreen(cartDescriptionActual);
            assertSoftly.assertThat(ActualStringContainsExpected(readsTextFrom(cartDescriptionActual),AddToCartStepsDefinitons.items.get(index).getColor()));
            assertSoftly.assertThat(ActualStringContainsExpected(readsTextFrom(cartDescriptionActual),AddToCartStepsDefinitons.items.get(index).getSize()));


            WebElementFacade cartQuantityActual = getCartQuantityByIndex(index);
            assertSoftly.assertThat(ActualStringEqualIngoreCaseToExpected(getValueFrom(cartQuantityActual),AddToCartStepsDefinitons.items.get(index).getQuantity()));

            WebElementFacade cartProductNameActual = getCartProductNameByIndex(index);
            assertSoftly.assertThat(ActualStringEqualIngoreCaseToExpected(readsTextFrom(cartProductNameActual),AddToCartStepsDefinitons.items.get(index).getArticle()));

            WebElementFacade cartProductUnitPrice = getCartUnitPriceByIndex(index);

            assertSoftly.assertThat(ActualIntegerEqualToExpected(getPriceFromCurrency(cartProductUnitPrice), getPriceAgainstQuantity(index)));

        });
        assertSoftly.assertAll();
    }


}
