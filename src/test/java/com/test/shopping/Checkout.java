package com.test.shopping;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.constant.ProjectConstant;
import com.test.helper.ChromeDriverConfig;

public class Checkout {

	static WebDriver driver;
	static Wait<WebDriver> wait;

	@BeforeTest
	void setup() {
		driver = ChromeDriverConfig.initialiseChromeDrive();
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(80L))
				.pollingEvery(Duration.ofSeconds(8L)).ignoring(NoSuchElementException.class);

	}

	@AfterTest
	void cleanup() {
		driver.quit();
	}

	static void jsClick(final WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	@Test
	public void validateAdjustQuantity() throws InterruptedException {

		// Add Product to Cart
		// Add Product to Cart
		jsClick(WaitUntilElement(
				"//li[@class='jsx-4161721015 header-section__ul-icon-search']//img[@src='https://pomelo-web-s3.pomelofashion.com/www/6.172.0/static/img/icons/system/search.svg']"));
		jsClick(WaitUntilElement("//*[@id='header-search-form']"));

		jsClick(WaitUntilElement("//input[@placeholder = 'What are you looking for today?...']"));

		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys("56319");
		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys(Keys.ENTER);

		// Product View
		jsClick(WaitUntilElement(
				"//div[@class='product-image__hover']//img[@alt='Short Sleeve Mandarin Collar Dress - Pink']"));

		WaitUntilElement("//button[.='L']").click();
		WaitUntilElement("//span[.='Add To Bag']").click();

		WaitUntilElement("//span[.='View My Shopping Bag']").click();

		// Adjust quantity of product
		Select qty = new Select(WaitUntilElement(
				"//div[@class='cart-item-info__quantity']//select[@class='jsx-2192573192 pml-dropdown__select subtitle2 full-width']"));
		qty.selectByVisibleText("2");

	}

	@Test
	public void validateSize() throws InterruptedException {
		driver.navigate().to(ProjectConstant.BASE_URL);

		// Add Product to Cart
		jsClick(WaitUntilElement(
				"//li[@class='jsx-4161721015 header-section__ul-icon-search']//img[@src='https://pomelo-web-s3.pomelofashion.com/www/6.172.0/static/img/icons/system/search.svg']"));
		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys("56319");
		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys(Keys.ENTER);

		// Product View
		jsClick(WaitUntilElement(
				"//div[@class='product-image__hover']//img[@alt='Short Sleeve Mandarin Collar Dress - Pink']"));

		jsClick(WaitUntilElement("//button[.='L']"));
		jsClick(WaitUntilElement("//span[.='Add To Bag']"));

		jsClick(WaitUntilElement("//span[.='View My Shopping Bag']"));

		// Adjust size of product
		Select size = new Select(WaitUntilElement(
				"//div[@class='jsx-958784943 pml-input-layout__container full-width cart-item-info__size']//select[@class='jsx-2192573192 pml-dropdown__select subtitle2 full-width']"));
		size.selectByVisibleText("XL");

	}

	@Test
	public void validateDelete() throws InterruptedException {
		driver.navigate().to(ProjectConstant.BASE_URL);

		// Add Product to Cart
		jsClick(WaitUntilElement(
				"//li[@class='jsx-4161721015 header-section__ul-icon-search']//img[@src='https://pomelo-web-s3.pomelofashion.com/www/6.172.0/static/img/icons/system/search.svg']"));
		jsClick(WaitUntilElement("//*[@id='header-search-form']"));

		jsClick(WaitUntilElement("//input[@placeholder = 'What are you looking for today?...']"));

		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys("56319");
		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys(Keys.ENTER);

		// Product View
		jsClick(WaitUntilElement(
				"//div[@class='product-image__hover']//img[@alt='Short Sleeve Mandarin Collar Dress - Pink']"));

		WaitUntilElement("//button[.='L']").click();
		WaitUntilElement("//span[.='Add To Bag']").click();

		WaitUntilElement("//span[.='View My Shopping Bag']").click();

		// Remove product
		WaitUntilElement("//img[@alt='cart-remove']").click();

	}

	@Test
	public void validatePromo() throws InterruptedException {
		driver.navigate().to(ProjectConstant.BASE_URL);

		// Add Product to Cart
		jsClick(WaitUntilElement(
				"//li[@class='jsx-4161721015 header-section__ul-icon-search']//img[@src='https://pomelo-web-s3.pomelofashion.com/www/6.172.0/static/img/icons/system/search.svg']"));
		jsClick(WaitUntilElement("//*[@id='header-search-form']"));

		jsClick(WaitUntilElement("//input[@placeholder = 'What are you looking for today?...']"));

		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys("56319");
		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys(Keys.ENTER);

		// Product View
		jsClick(WaitUntilElement(
				"//div[@class='product-image__hover']//img[@alt='Short Sleeve Mandarin Collar Dress - Pink']"));

		WaitUntilElement("//button[.='L']").click();
		WaitUntilElement("//span[.='Add To Bag']").click();

		WaitUntilElement("//span[.='View My Shopping Bag']").click();

		// Apply promo code
		WaitUntilElement("//input[@class='jsx-1695452889 body1 pml-input__input']").sendKeys("PROMOCODE");
		WaitUntilElement("//span[.='Apply']").click();

	}

	@Test
	public void validatePurchase() throws InterruptedException {
		driver.navigate().to(ProjectConstant.BASE_URL);

		// Add Product to Cart
		jsClick(WaitUntilElement(
				"//li[@class='jsx-4161721015 header-section__ul-icon-search']//img[@src='https://pomelo-web-s3.pomelofashion.com/www/6.172.0/static/img/icons/system/search.svg']"));
		jsClick(WaitUntilElement("//*[@id='header-search-form']"));

		jsClick(WaitUntilElement("//input[@placeholder = 'What are you looking for today?...']"));

		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys("56319");
		WaitUntilElement("//input[@class='jsx-1695452889 body2 pml-input__input']").sendKeys(Keys.ENTER);

		// Product View
		jsClick(WaitUntilElement(
				"//div[@class='product-image__hover']//img[@alt='Short Sleeve Mandarin Collar Dress - Pink']"));

		WaitUntilElement("//button[.='L']").click();
		WaitUntilElement("//span[.='Add To Bag']").click();

		WaitUntilElement("//span[.='View My Shopping Bag']").click();

		// Checkout
		WaitUntilElement("//span[.='Check out now']").click();

	}

	static WebElement WaitUntilElement(final String locatorString) {
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locatorString));

			}

		});

	}
}
