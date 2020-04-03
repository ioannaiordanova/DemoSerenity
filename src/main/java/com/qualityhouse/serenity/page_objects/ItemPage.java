package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ItemPage extends PageObject {
    public static final By INPUT_QUANTITY_WANTED = By.id("quantity_wanted");

    public static final By SELECT_SIZE_WANTED = By.id("group_1");

    public static final By SELECT_COLOR_WANTED = By.id("color_to_pick_list");

    public static final By ADD_TO_CART_BTN = By.id("add_to_cart");

    public static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector("div.button-container > a");

    public static final By SELECTED_UNIT_PRICE =  By.id("our_price_display");

    //@FindBy(css = ".product-container")
    //public List<WebElementFacade> productContainer;

}
