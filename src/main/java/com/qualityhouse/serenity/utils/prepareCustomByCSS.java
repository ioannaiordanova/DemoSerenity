package com.qualityhouse.serenity.utils;

import org.openqa.selenium.By;

public class prepareCustomByCSS {





    public static By returnPreparedBySelector(String selectorString, String exactWordfortheCase){
      String preparedSelector = selectorString.replaceAll("#item_to_substitute#", exactWordfortheCase);
      return  By.cssSelector(preparedSelector);
    }
}
