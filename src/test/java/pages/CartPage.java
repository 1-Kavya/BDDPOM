package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
//	@FindBy(className = "cart_item")
//	WebElement cartOne;
	
	//instead of WebElements we can use WebElements and find all elements
	@FindAll(value = @FindBy(css = "div.cart_item"))
	List<WebElement> items;
	
	@FindBy(css = "button[data-test='continue-shopping']")
	WebElement contBtn;
	
	@FindBy(css = "button[data-test='checkout']")
	WebElement chkoutBtn;
	
	@FindBy(id = "remove-sauce-labs-fleece-jacket")
	WebElement removeBtn;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isItemsAdded() {
		if(items.size() > 0) 
			return true;
		else
			return false;
	}
	
	public void checkoutItems() {
		chkoutBtn.click();
	}
	
	public void continueShopping() {
		contBtn.click();
	}
	
	public void deleteItem() {
		removeBtn.click();
	}

}
