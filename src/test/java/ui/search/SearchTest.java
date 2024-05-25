package ui.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GoogleStartPage;
import suites.UISuite;

public class SearchTest extends UISuite {
    private GoogleStartPage googleStartPage;

    @BeforeEach
    public void initPages() {
        googleStartPage = new GoogleStartPage();
    }

    @Test
    public void search() {
        String searchText = "abc";
        googleStartPage
                .typeToSearch(searchText)
                .clickSubmitSearchButton()
                .checkFirstSearchResult(searchText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "bca", "acb"})
    public void parametrizedTestWithStringValues(String searchText) {
        googleStartPage
                .typeToSearch(searchText)
                .clickSubmitSearchButton()
                .checkFirstSearchResult(searchText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/search_values/search_examples.csv"}, delimiter = ';')
    public void parametrizedTestWithCSVTable(String searchText, String searchResult) {
        googleStartPage
                .typeToSearch(searchText)
                .clickSubmitSearchButton()
                .checkFirstSearchResult(searchResult);
    }
}
