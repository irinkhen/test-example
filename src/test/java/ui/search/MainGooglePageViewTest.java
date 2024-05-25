package ui.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GoogleStartPage;
import suites.UISuite;

public class MainGooglePageViewTest extends UISuite {
    private GoogleStartPage googleStartPage;

    @BeforeEach
    public void initPages() {
        googleStartPage = new GoogleStartPage();
    }

    @Test
    public void checkMainPageView() {
        googleStartPage.pageIsLoaded();
    }
}
