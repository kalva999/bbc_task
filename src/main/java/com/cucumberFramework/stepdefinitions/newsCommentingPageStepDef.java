package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.pageObjects.newsCommentingPage;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


public class newsCommentingPageStepDef extends TestBase {

	newsCommentingPage newsPage = new newsCommentingPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);

	@Given("^I am on the BBC page URL ([^\"]*)$")
	public void loadBBCUrl(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Then("^I click on sign in button and wait for sign in page$")
	public void clickOnSignInButton() throws Throwable {
		newsPage.clickSignInButton();
	}

	@Then("^I accept the cookie$")
	public void acceptCookie() throws Throwable {
		newsPage.acceptCookies();
	}

	@When("^I enter username as ([^\"]*)$")
	public void i_enter_username_as(String arg1) throws Throwable {
		newsPage.enterUserName(arg1);
	}

	@When("^I enter password as ([^\"]*)$")
	public void i_enter_password_as(String arg1) throws Throwable {
		newsPage.enterPassword(arg1);
	}

	@When("^I click on login button$")
	public void click_on_login_button() throws Throwable {
		newsPage.clickLoginButton();
	}

	@When("^I Click on a article with comment button from homePage$")
	public void clickOnAArticleWithCommentIcon() {
		newsPage.acceptCookies();
		newsPage.clickOnANewsWithComments();
	}

	@Then("^I Click on the view Comment button of the article$")
	public void clickOnViewCommentButton() throws Throwable {
		newsPage.clickOnViewCommentsButton();
	}

	@When("^I Verify the commenting is enabled$")
	public void verifyCommentingIsEnabled() throws Throwable {
		Assert.assertEquals(newsPage.commentFieldIsEnabled(), "Text box is editable");
		driver.quit();
	}
}