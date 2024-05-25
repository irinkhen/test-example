package suites;

import static com.codeborne.selenide.Configuration.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public abstract class BaseSuite {
    public static void setUp() {
        chromedriver().setup();
        browser = "chrome";
        webdriverLogsEnabled = true;
        timeout = 10000;
        headless = false; //display is visible
    }
}
