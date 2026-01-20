package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;
    public InventoryPage(WebDriver driver) { this.driver = driver; }

    By cartBadge = By.className("shopping_cart_badge");
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By removeBtn = By.id("remove-sauce-labs-backpack");

    public void addBackpack() { driver.findElement(addToCartBtn).click(); }
    public void removeBackpack() { driver.findElement(removeBtn).click(); }
    public String getCartCount() { return driver.findElement(cartBadge).getText(); }
    public boolean isBadgePresent() { return driver.findElements(cartBadge).size() > 0; }
}