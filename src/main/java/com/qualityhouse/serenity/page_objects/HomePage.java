package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class HomePage
        extends PageObject
{
    @FindBy( css = "nav a.logout" )
    public WebElementFacade logOutMenu;

    @FindBy( css = "nav a.account" )
    public WebElementFacade userMenu;

    //"#block_top_menu > ul > li:nth-child(1) > a"
    //"//*[@id="block_top_menu"]/ul/li[1]/a"
    public  static final String MENUITEM =  "ul[class^='sf-menu clearfix menu-content'] > li > a[title='#item_to_substitute#']";

    //ul > li:nth-child(#item_to_substitute#) > div > div.left-block > div > a.product_img_link > img
    public static final By CATALOG_UL = By.cssSelector("ul.product_list.grid.row");

    public static final By INPUT_QUANTITY_WANTED = By.id("quantity_wanted");

    public static final By SELECT_SIZE_WANTED = By.id("group_1");

    public static final By SELECT_COLOR_WANTED = By.id("color_to_pick_list");

    public static final By ADD_TO_CART_BTN = By.id("add_to_cart");

    public static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector("div.button-container > a");

    public static final By PRODUCT_TYPE = By.cssSelector("td.cart_description > p");
    //td cart description
    public static final By CART_DESCRIPTION = By.cssSelector("td.cart_description > small:nth-child(3)");

    public static final By CART_QUANTITY =By.cssSelector("input.cart_quantity_input.form-control.grey");

}
