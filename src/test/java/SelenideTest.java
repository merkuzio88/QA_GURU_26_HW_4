import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void selenidePageTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $$("button").findBy(text("Show 3 more pages")).click();
        $$(".details-reset a").findBy(text("SoftAssertions")).scrollIntoView(true).click();
        $$(".markdown-heading").findBy(text("JUnit5")).sibling(0).scrollIntoView(true)
                .shouldHave(cssClass("highlight-source-java"));
    }
}
