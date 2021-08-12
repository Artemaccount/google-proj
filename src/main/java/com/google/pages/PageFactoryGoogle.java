package com.google.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageFactoryGoogle {
    @FindBy(xpath = "//input[@title='Поиск']")
    WebElement googleSearchForm;

    @FindBy(xpath = "//input[@value='Поиск в Google']")
    WebElement googleSearchButton;

    @FindBy(xpath = "//*[@class='g']")
    List<WebElement> searchResult;

    public PageFactoryGoogle(WebDriver driver) {
        driver.get("https://www.google.com/");
    }

    public void find(String input) {
        googleSearchForm.click();
        googleSearchForm.sendKeys(input);
        googleSearchButton.click();
    }

    public void checkUrlInResults(String url) {
        Assertions.assertTrue(searchResult.stream()
                .anyMatch(s -> s.findElement(By.tagName("a"))
                        .getAttribute("href").contains(url)),
                "В результатах поиска Google нет ссылки: " + url);
    }
}
