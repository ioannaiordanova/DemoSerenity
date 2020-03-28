package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Item;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.utils.prepareCustomByCSS;
import org.openqa.selenium.By;


public class AddToCartActions extends BasesActions {

    @Step
    public void navigatedToPage(String link_item){
         By CUSTOM_MENUITEM_BY = prepareCustomByCSS.returnPreparedBySelector(HomePage.MENUITEM,link_item);
         clicksOn(CUSTOM_MENUITEM_BY);
    }

    @Step
    public void selectedProductByNumber(String articleTitle){

           WebElementFacade a_to_be_selected = getFromUnorderedListWebElementByText(HomePage.CATALOG_UL,"a",articleTitle);
           WebElementFacade li = returnParentWithGivenTag(a_to_be_selected,"li");
           By byTagName = new By.ByTagName("img");
           WebElementFacade img1 = li.findBy(byTagName);
           clicksOnXY(img1,-30,-30);

    }

    @Step
    public void selectedTheItemFeaturesAndAddToCart(Item article){

        fillsFieldWithData(HomePage.INPUT_QUANTITY_WANTED,article.getQuantity());
        selectsFromDropDownAnItemByVisibleText(HomePage.SELECT_SIZE_WANTED,article.getSize());
        selectFromUnorderedListATagByName(HomePage.SELECT_COLOR_WANTED,"a",article.getColor());
        clicksOn(HomePage.ADD_TO_CART_BTN);
        clicksOn(HomePage.PROCEED_TO_CHECKOUT_BTN);
    }
}
