package com.google;

import com.google.pages.PageFactoryGoogle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;

public class Tests extends BaseTest{

    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @CsvSource({"гладиолус"})
    public void resultContainsTest(String value) {
        driver.get("https://www.google.com/");
        PageFactoryGoogle google = PageFactory.initElements(driver, PageFactoryGoogle.class);
        google.find(value);
        google.checkUrlInResults("https://ru.wikipedia.org");
    }
}
