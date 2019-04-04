package com.test.automation.businessflows;

import com.test.automation.screens.ResultScreen;

public class Result {

     public void clickOnResultsLinkByText(String resultTextToBeClicked) {
            ResultScreen.getInstance().clickOnResultByLinkText(resultTextToBeClicked);
     }
}
