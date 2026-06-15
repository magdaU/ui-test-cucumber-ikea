package com.ikea.uitestcucumberikeadk.steps;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class IkeaHomepageSteps {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Given("user opens the IKEA Denmark website")
    public void userOpensIkeaDkWebsite() {
        driver.get("https://www.ikea.com/dk/da/");
    }

    @Then("the page title contains {string}")
    public void pageTitleContains(String expectedTitle) {
        assertThat(driver.getTitle()).contains(expectedTitle);
    }

    @And("the cookie consent banner is visible")
    public void cookieConsentBannerIsVisible() {
        boolean bannerVisible = !driver.findElements(
                By.id("onetrust-accept-btn-handler")
        ).isEmpty();
        assertThat(bannerVisible).isTrue();
    }

    @When("user types {string} in the search box")
    public void userTypesInSearchBox(String searchTerm) {
        WebElement searchInput = driver.findElement(By.id("ikea-search-input"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("search results contain {string}")
    public void searchResultsContain(String expectedText) {
        // poczekaj aż wyniki się załadują
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("search"));
        assertThat(driver.getPageSource()).containsIgnoringCase(expectedText);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}