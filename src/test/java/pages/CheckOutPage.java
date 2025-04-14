package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement zipCode;
	
	@FindBy(id = "continue")
	WebElement contChckOutBtn;
	
	@FindBy(id = "cancel")
	WebElement cancelBtn;
	
	@FindBy(id = "finish")
	WebElement fnshBtn;
	
	@FindBy(css = "h2.complete-header")
	WebElement successMsg;
	
	
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void provideDetails(String strfName, String StrlName, String pCode) {
		firstName.sendKeys(strfName);
		lastName.sendKeys(StrlName);
		zipCode.sendKeys(pCode);
	}
	
	public void ContinueCheckout() {
		contChckOutBtn.click();
	}
	
	public void CancelCheckout() {
		cancelBtn.click();
	}
	
	public void FinishCheckout() {
		fnshBtn.click();
	}
	
	public boolean isOrderSuccess() {
		return successMsg.isDisplayed();
	}
}
