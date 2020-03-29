package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ArticlePage extends PageObject {
    public static final By INPUT_QUANTITY_WANTED = By.id("quantity_wanted");

    public static final By SELECT_SIZE_WANTED = By.id("group_1");

    public static final By SELECT_COLOR_WANTED = By.id("color_to_pick_list");

    public static final By ADD_TO_CART_BTN = By.id("add_to_cart");

    public static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector("div.button-container > a");

}
