import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
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
        $$("a[class='internal present']").findBy(text("Soft assertions")).shouldBe(visible).click();
        $$(".heading-element").findBy(text("JUnit5")).shouldBe(visible);
    }
}
