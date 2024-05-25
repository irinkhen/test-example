package suites;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class UISuite extends BaseSuite {
    private final static String BASE_URL = "https://duckduckgo.com/";

    public static void initUI() {
        open(BASE_URL);
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @BeforeEach
    public void before() {
        initUI();
    }

    @AfterEach
    public void tearDown() {
        quit();
    }

    @AfterAll
    public static void quit() {
        closeWebDriver();
    }
}
