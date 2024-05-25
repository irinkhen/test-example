package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsPage {
    private final ElementsCollection firstResultTitle = $$("a[data-testid=\"result-title-a\"]");
    private final ElementsCollection firstResultLink = $$("a[data-testid=\"result-extras-url-link\"]");

    @Step("Check first result data")
    public ResultsPage checkFirstSearchResult(String searchRequestText) {
        firstResultTitle.first().shouldHave(text(searchRequestText));
        firstResultLink.first().shouldHave(text(searchRequestText));
        return this;
    }

}
