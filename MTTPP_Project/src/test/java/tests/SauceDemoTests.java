package tests;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SauceDemoTests extends BaseTest {

    @Test(description = "Uspješna prijava")
    public void testLogin() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test(description = "Neuspješna prijava")
    public void testFailedLogin() {
        new LoginPage(driver).login("standard_user", "kriva_sifra");
        String error = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(error.contains("do not match"));
    }

    @Test(description = "Dodavanje u košaricu")
    public void testAdd() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        InventoryPage inv = new InventoryPage(driver);
        inv.addBackpack();
        Assert.assertEquals(inv.getCartCount(), "1");
    }

    @Test(description = "Uklanjanje iz košarice")
    public void testRemove() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        InventoryPage inv = new InventoryPage(driver);
        inv.addBackpack();
        inv.removeBackpack();
        Assert.assertFalse(inv.isBadgePresent());
    }

    @Test(description = "Checkout")
    public void testCheckout() {

        new LoginPage(driver).login("standard_user", "secret_sauce");
        InventoryPage inv = new InventoryPage(driver);
        inv.addBackpack();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;

        org.openqa.selenium.WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_link")));
        js.executeScript("arguments[0].click();", cart);
        org.openqa.selenium.WebElement checkoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout")));
        js.executeScript("arguments[0].click();", checkoutBtn);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys("Ivan");
        driver.findElement(By.id("last-name")).sendKeys("Test");
        driver.findElement(By.id("postal-code")).sendKeys("31000");


        org.openqa.selenium.WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("continue")));
        js.executeScript("arguments[0].click();", continueBtn);

        org.openqa.selenium.WebElement finishBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        js.executeScript("arguments[0].click();", finishBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
        String successMessage = driver.findElement(By.className("complete-header")).getText();

        Assert.assertEquals(successMessage, "Thank you for your order!");
    }
}