package any;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class any2 extends Parameters {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void MyBeforeTest() {

		driver.get(Url);
		WebElement UserNameElemnt = driver.findElement(By.id("user-name"));
		WebElement PasswordElemnt = driver.findElement(By.id("password"));
		UserNameElemnt.sendKeys(UserName);
		PasswordElemnt.sendKeys(Pass);
		driver.findElement(By.id("login-button")).click();
		driver.manage().window().maximize();
	}

	@Test
	public void FirstTest() {
		List<WebElement> Price = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> proNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> addproduct = driver.findElements(By.className("btn"));

		for (int i = 0; i < addproduct.size(); i++) {
			if (proNames.get(i).getText().contains("Sauce Labs Backpack") || proNames.get(i).getText().contains("Sauce Labs Bike Light")
					
					|| proNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
				continue;
			} else {
				addproduct.get(i).click();
				Price.get(i).getText();
				System.out.println(Price.get(i).getText());
				
				String lastprice = Price.get(i).getText().replace("$", " ");
				double PriceAsDouble = Double.parseDouble(lastprice);
				double Tax = 0.10;
				
				double thelastPrice = PriceAsDouble * Tax + PriceAsDouble;
				if ((int) thelastPrice % 2 == 0) {
					
					System.out.println("the final price is even number and the value of this number " + thelastPrice);
				} else {
					
					System.out.println("the final price is an odd number and the value of this price " + thelastPrice);
				}
			}

		}
	}

	@AfterTest
	public void MyAfterTest() {

	}

}