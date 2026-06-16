package com.ikea.uitestcucumberikeadk.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.ikea.uitestcucumberikeadk.pages.LisaboTablePage;
import com.ikea.uitestcucumberikeadk.utils.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step definitions for the LISABO table product page feature.
 */
public class LisaboTableSteps {

    private LisaboTablePage lisaboTablePage;

    private LisaboTablePage lisaboTablePage() {
        if (lisaboTablePage == null) {
            lisaboTablePage = new LisaboTablePage(DriverManager.getDriver());
        }
        return lisaboTablePage;
    }

    @Given("user opens the LISABO table product page in color {string}")
    public void userOpensTheLisaboTableProductPageInColor(String color) {
        lisaboTablePage().openInColor(color);
    }

    @When("user sets the quantity to {int}")
    public void userSetsTheQuantityTo(int quantity) {
        lisaboTablePage().setQuantity(quantity);
    }

    @Then("the price is {string}")
    public void thePriceIs(String expectedPrice) {
        assertThat(lisaboTablePage().getPrice()).isEqualTo(expectedPrice);
    }
}
