package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ShoppingBasketPage
extends PageObject {

    @FindBy(css = "tr[id^=product_]")
    public List<WebElementFacade> shoppingBasketContainer;

    public static final By CART_PRODUCT_NAME = By.cssSelector("p.product-name > a");

    public static final By CART_DESCRIPTION = By.cssSelector("small:nth-child(3)");

    public static final By CART_QUANTITY =By.cssSelector("input.cart_quantity_input.form-control.grey");

    public static final By CART_PRODUCT_UNIT_PRICE =By.cssSelector("td.cart_total > span");
}
