package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Item;
import com.qualityhouse.serenity.page_objects.ArticlePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import com.qualityhouse.serenity.page_objects.HomePage;
import org.openqa.selenium.By;


public class AddToCartActions extends BasesActions {

    @Step ( "Navigated to category: {0}" )
    public void navigatedToPage(String link_item){
        WebElementFacade category_link = getFromUnorderedListWebElementByText(HomePage.MAIN_MENU,"a",link_item);
        clicksOn(category_link);
    }

    @Step ( "Selected article by given name: {0}" )
    public void selectedProductByName(String articleTitle){

           WebElementFacade a_to_be_selected = getFromUnorderedListWebElementByText(HomePage.CATALOG_UL,"a",articleTitle);
           WebElementFacade li = returnParentWithGivenTag(a_to_be_selected,"li");
           By byTagName = new By.ByTagName("img");
           WebElementFacade img1 = li.findBy(byTagName);
           clicksOnXY(img1,-30,-30);

    }

    @Step
    public void selectedTheItemFeaturesAndAddToCart(Item article){

        fillsFieldWithData(ArticlePage.INPUT_QUANTITY_WANTED,article.getQuantity());
        selectsFromDropDownAnItemByVisibleText(ArticlePage.SELECT_SIZE_WANTED,article.getSize());
        selectFromUnorderedListATagByName(ArticlePage.SELECT_COLOR_WANTED,"a",article.getColor());
        clicksOn(ArticlePage.ADD_TO_CART_BTN);
        clicksOn(ArticlePage.PROCEED_TO_CHECKOUT_BTN);
    }
}
