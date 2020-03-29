package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingBasketPage
extends PageObject {

    public static final By CART_PRODUCT_NAME = By.cssSelector("tr:nth-of-type(1) > td.cart_description > p.product-name > a");

    public static final By CART_DESCRIPTION = By.cssSelector("tr:nth-of-type(1) > td.cart_description > small:nth-child(3)");

    public static final By CART_QUANTITY =By.cssSelector("tr:nth-of-type(1) > td > input.cart_quantity_input.form-control.grey");

}
