package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.steps.definitions.AddToCartStepsDefinitons;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.Thread.sleep;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasesActions
{
    private BasePage currentPage;

    protected void navigateToURL(){
        currentPage.open();
    }

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


    @Step ("Read the text from Web Element")
    public String readsTextFrom( WebElementFacade webElement )
    {
        return webElement.waitUntilVisible()
                         .getText()
                         .trim();
    }

    @Step ("Clicks on Web Element")
    public void clicksOn( final By locator )
    {
        currentPage.find( locator )
                   .waitUntilClickable()
                   .click();
    }

    public void moveToElementAndClicksOnXY(WebElementFacade element,Integer xOffset,Integer yOffset) {

        Actions act = new Actions(currentPage.getDriver());
        act.moveToElement(element,xOffset,yOffset).click().build().perform();

    }

    public void findLinkByParentAndNameAndClick(By locator,  String itemValue){

        WebElementFacade ulList = currentPage.find(locator);
        List<WebElementFacade> options = ulList.thenFindAll(By.tagName("a"));
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

    public WebElementFacade getLinkByParentAndVisibleText(By locator, String visibleText){

        WebElementFacade ulList = currentPage.find(locator);
        List<WebElementFacade> elements = ulList.thenFindAll(By.tagName("a"));
        for (WebElementFacade element : elements)
        {
            if (element.getText().equalsIgnoreCase(visibleText))
            {
                System.out.println("The element is found "+element.getText());
                return element;
            }
        }
        System.out.println("The element is not found");
        return null;
    }

    public String readsTextFrom( By locator )
    {
        return readsTextFrom( (WebElementFacade) currentPage.find( locator ) );
    }

    @Step ("Reads the text from Web Element")
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

    @Step ("Gets the value from Web Element")
    public String getValueFrom(WebElementFacade webElement){
        return webElement
                .waitUntilVisible()
                .getValue();
    }

    public Number getPriceFromCurrency(By locator){
        String numericText = readsTextFrom((WebElementFacade) currentPage.find(locator));
        NumberFormat number = NumberFormat.getCurrencyInstance(Locale.US);

        try {
            return number.parse(numericText);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't convert " + numericText + " to Double!");
        }

    }

    public Number getPriceFromCurrency(WebElementFacade element){
        String numericText = readsTextFrom(element);
        NumberFormat number = NumberFormat.getCurrencyInstance(Locale.US);

        try {
            return number.parse(numericText);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't convert " + numericText + " to Double!");
        }

    }

    public void setElementInVisibleScreen(By locator){

        WebElementFacade element= (WebElementFacade) currentPage.find(locator);
        Actions act = new Actions(currentPage.getDriver());
        act.moveToElement(element).build().perform();
    }

    public void setElementInVisibleScreen(WebElementFacade element){
        Actions act = new Actions(currentPage.getDriver());
        act.moveToElement(element).build().perform();
    }

    public Float parseStringToFloat(String str){
        return  Float.valueOf(str);
    }

}
