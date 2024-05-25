package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class GoogleStartPage {
    private final SelenideElement title = $x("(//a[@aria-label=\"Learn about DuckDuckGo\"])[1]");
    private final SelenideElement searchField = $x("//input[@aria-controls=\"listbox--searchbox_homepage\"]");
    private final SelenideElement submitSearchButton = $x("//button[@aria-label=\"Search\"]");
    private final SelenideElement tryToGuessButton = $x("(//span[contains(text(), 'Menu')])[1]");

    @Step("Check that page elements were loaded")
    public GoogleStartPage pageIsLoaded() {
        title.shouldBe(visible);
        searchField.shouldBe(visible).type("123");
        submitSearchButton.shouldBe(visible);
        tryToGuessButton.shouldBe(visible);
        return this;
    }

    @Step("Type search request to search field")
    public GoogleStartPage typeToSearch(String searchRequestText) {
        searchField.clear();
        searchField.sendKeys(searchRequestText);
        return this;
    }

    @Step("Click on submit button")
    public ResultsPage clickSubmitSearchButton() {
        submitSearchButton.click();
        return page(ResultsPage.class);
    }

}
