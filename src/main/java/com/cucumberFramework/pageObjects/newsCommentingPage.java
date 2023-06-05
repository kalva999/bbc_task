package com.cucumberFramework.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.WaitHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newsCommentingPage {

	private WebDriver driver;

	@FindBy(xpath="//input[@type='email']")
	public WebElement userName;

	@FindBy(xpath="//input[@type='password']")
	public WebElement password;

	@FindBy(id="submit-button")
	WebElement loginButton;

	@FindBy(xpath="//div[contains(@class,'ConsentBanner')]//button[text()='Yes, I agree']")
	WebElement acceptCookieButton;

	@FindBy(css=".ssrcss-13ox91y-NavigationLink-AccountLink.e1gviwgp13 svg")
	WebElement SignInfromNav;

	@FindBy(xpath="(//div[text()='Comments']/ancestor::div[contains(@class,'PromoWrapper')])[1]")
	WebElement newsWithComments;

	@FindBy(xpath="//span[text()='View Comments']/parent::button")
	WebElement viewCommentsButton;

	@FindBy(css="div[class='comments__user-interactions-container'] span div textarea[placeholder='Add your comment…']")
	WebElement commentsBox;

	WaitHelper waitHelper;

	public newsCommentingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void clickSignInButton(){
		try {
			SignInfromNav.click();
		} catch(StaleElementReferenceException e) {
			driver.findElement(By.cssSelector(".ssrcss-13ox91y-NavigationLink-AccountLink.e1gviwgp13 svg")).click();
		}
	}
	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}

	public void enterPassword(String password){
		this.password.sendKeys(password);
	}

	public void clickLoginButton(){
		loginButton.click();
	}

	public WebElement acceptCookies(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			return wait.until(ExpectedConditions.visibilityOf(acceptCookieButton));
		}catch (NoSuchElementException e){
			throw new RuntimeException("Web element not visible within given time" + acceptCookieButton);
		}
	}

	public void clickOnANewsWithComments(){
		newsWithComments.click();
	}

	public void clickOnViewCommentsButton(){
		scrollToElement(viewCommentsButton);
		viewCommentsButton.click();
	}
	public void scrollToElement(WebElement ele){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center',inline:'nearest'});", ele);
	}

	public String commentFieldIsEnabled(){
		Actions builder = new Actions(driver);
		builder.moveToElement(commentsBox).build().perform();
		commentsBox.click();
		commentsBox.clear();
		boolean isEditable = commentsBox.isEnabled();
		if (isEditable) {
			return("Text box is editable");
		} else {
			return ("Text box is not editable");
		}
	}
}

