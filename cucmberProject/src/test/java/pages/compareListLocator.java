package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class compareListLocator {
    public WebElement email(WebDriver driver) {
        By email = By.name("Email");
        WebElement emailEle= driver.findElement(email);
        return emailEle;
    }

    public WebElement password(WebDriver driver) {
        return driver.findElement(By.name("Password"));
    }

    public WebElement SelectProduct(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[4]/div/div[2]/div[3]/div[2]/button[2]"));
    }

    public WebElement com(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));
    }
}
