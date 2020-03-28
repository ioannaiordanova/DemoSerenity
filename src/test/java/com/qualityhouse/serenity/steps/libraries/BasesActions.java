package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasesActions
{
    private BasePage currentPage;

    @Step( "Enters '{1}' in field {0}" )
    protected void fillsFieldWithData( WebElementFacade fieldElement,
                                       String data )
    {
        if ( data != null )
        {
            fieldElement.waitUntilEnabled()
                        .type( data );
        }
    }

    @Step( "Selects '{1}' item from drop down {0}" )
    protected void selectsFromDropDownAnItemByValue( WebElementFacade dropDownElement,
                                                     String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByValue( itemValue );
        }
    }

    protected void fillsFieldWithData( By fieldElement,
                                       String data )
    {
        fillsFieldWithData( (WebElementFacade) currentPage.find( fieldElement ),
                            data );
    }

    protected void selectsFromDropDownAnItemByValue( By dropDownLocator,
                                                     String itemValue )
    {
        this.selectsFromDropDownAnItemByValue( (WebElementFacade) currentPage.find( dropDownLocator ),
                                               itemValue );
    }

    protected void selectsFromDropDownAnItemByVisibleText( By dropDownLocator,
                                                           String itemValue )
    {
        this.selectsFromDropDownAnItemByVisibleText( (WebElementFacade) currentPage.find( dropDownLocator ),
                                                     itemValue );
    }

    @Step( "Selects '{1}' item from drop down {0}" )
    protected void selectsFromDropDownAnItemByVisibleText( WebElementFacade dropDownElement,
                                                           String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByVisibleText( itemValue );
        }
    }

    @Step
    protected void clicksOn( WebElementFacade buttonOrLink )
    {
        buttonOrLink.waitUntilClickable()
                    .click();
    }

    @Step
    public boolean canSeeElement( WebElementFacade webElement )
    {
        return webElement.isVisible();
    }

    @Step
    public String readsTextFrom( WebElementFacade webElement )
    {
        return webElement.waitUntilVisible()
                         .getText()
                         .trim();
    }

    @Step
    public void clicksOn( final By locator )
    {
        currentPage.find( locator )
                   .waitUntilClickable()
                   .click();
    }

    public void clicksOnXY(WebElementFacade element,Integer xOffset,Integer yOffset) {

        Actions act = new Actions(currentPage.getDriver());
        act.moveToElement(element,xOffset,yOffset).click().build().perform();

    }

    public void selectFromUnorderedListATagByName(By locator,String Tag ,String itemValue){

        String searchText = "AppraisersGroupTest";
        WebElementFacade ulList = currentPage.find(locator);
        List<WebElementFacade> options = ulList.thenFindAll(By.tagName(Tag));
        for (WebElementFacade option : options)
        {
            if (option.getAttribute("Name").equals(itemValue))
            {
                option.click(); // click the desired option
                break;
            }
        }

    }

    public WebElementFacade returnParentWithGivenTag(WebElementFacade child,String parentTag){
       By locatorParent = new By.ByXPath("./ancestor::"+parentTag+"[last()]");
       return  child.find(locatorParent);
         }

    public WebElementFacade getFromUnorderedListWebElementByText(By locator,String elementTag ,String visibleText){

        String searchText = "AppraisersGroupTest";
        WebElementFacade ulList = currentPage.find(locator);
        List<WebElementFacade> elements = ulList.thenFindAll(By.tagName(elementTag));
        for (WebElementFacade element : elements)
        {
            if (element.getText().equals(visibleText))
            {
                return element;
            }
        }
        return null;
    }

    public String readsTextFrom( By locator )
    {
        return readsTextFrom( (WebElementFacade) currentPage.find( locator ) );
    }

    @Step
    public List<String> readsTextFromList( By listItemsLocator )
    {
        List<WebElementFacade> errorsItemsElements = currentPage.findAll( listItemsLocator );
        List<String> errorMessages = new ArrayList<>( errorsItemsElements.size() );

        for ( WebElementFacade item : errorsItemsElements )
        {
            errorMessages.add( item.getText()
                                   .trim() );
        }
        return errorMessages;
    }


    public String getValueFrom(By locator)
    {
        return getValueFrom((WebElementFacade) currentPage.find(locator));
    }

    @Step
    public String getValueFrom(WebElementFacade webElement){
        return webElement
                .waitUntilVisible()
                .getValue();
    }

}
