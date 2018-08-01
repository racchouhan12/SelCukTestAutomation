package com.test.automation.screens;

import org.openqa.selenium.By;

public class SearchScreen extends BaseScreen{

    public static SearchScreen getInstance() {
         return new SearchScreen();
    }

    public void searchText(String searchData) {
        sendText(By.name("q"), searchData);
    }

}
