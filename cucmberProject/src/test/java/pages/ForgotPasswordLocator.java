package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgotPasswordLocator {
    public WebElement emailELE(WebDriver driver) {
        return driver.findElement(By.name("Email"));}

    public By recovermessage() {
        return By.className("content");}

    public WebElement password(WebDriver driver) {
        return driver.findElement(By.name("OldPassword"));
    }

    public WebElement newPassword(WebDriver driver) {
        return driver.findElement(By.name("NewPassword"));
    }
    public WebElement confirmPassword(WebDriver driver) {
        return driver.findElement(By.name("ConfirmNewPassword"));
    }
    public WebElement email(WebDriver driver) {
        By email = By.name("Email");
        WebElement emailEle= driver.findElement(email);
        return emailEle;
    }

    public WebElement passwordforlogin(WebDriver driver) {
        return driver.findElement(By.name("Password"));
    }
}
