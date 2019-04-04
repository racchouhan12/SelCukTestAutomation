package com.test.automation.businessflows;

import com.test.automation.screens.SearchScreen;

public class Search {

    public void searchText(String searchText) {
        SearchScreen.getInstance().searchTextOnGoogleHomePage(searchText);
    }

}
