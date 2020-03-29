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

    public  static final By MAIN_MENU =  By.cssSelector("ul[class^='sf-menu']");

    public static final By CATALOG_UL = By.cssSelector("ul.product_list.grid.row");


}
