package com.test.automation.businessflows;

import com.test.automation.screens.SearchScreen;

public class Search {

    public void searchText(String text) {
        SearchScreen.getInstance().searchText(text);
    }

}
