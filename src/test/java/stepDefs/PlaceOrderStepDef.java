package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderStepDef {
	
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage chkoutPage;
	
	public PlaceOrderStepDef() {
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		chkoutPage = new CheckOutPage(driver);
	}
	

@Given("User is on login Page")
public void user_is_on_login_page() {
	TestBase.openUrl("https://www.saucedemo.com/");
}

@When("user enters {string} and {string}")
public void user_enters_and(String strUser, String strPwd) {
	loginPage.loginIntoApp(strUser, strPwd);
}

@Given("User should be on Home Page")
public void user_is_on_home_page() {
	Assert.assertTrue(listPage.isOnProducts());
}

@When("user add item to cart")
public void user_add_item_to_cart() {
    listPage.addItemToCart();
}

@Then("Item must be added")
public void item_must_be_added() {
	listPage.viewCart();
	Assert.assertTrue(cartPage.isItemsAdded());
}


@Given("User is on Cart Page")
public void user_is_on_cart_page() {
    listPage.viewCart();
}

@When("User do Checkout")
public void user_do_checkout() {
    cartPage.checkoutItems();
    
}

@Then("Should navigate to checkout page")
public void should_navigate_to_checkout_page() {
	chkoutPage.provideDetails("Test","User","22535");
	chkoutPage.ContinueCheckout();
	chkoutPage.FinishCheckout();
	Assert.assertTrue(chkoutPage.isOrderSuccess());
    
}


@Given("Cart must have items")
public void cart_must_have_items() {
	listPage.viewCart();
    
}

@When("User Delete an item")
public void user_delete_an_item() {
    cartPage.deleteItem();
    
}

@Then("Should delete item from cart")
public void should_delete_item_from_cart() {
    //cart size can be implemented
    cartPage.isItemsAdded();
}


}
