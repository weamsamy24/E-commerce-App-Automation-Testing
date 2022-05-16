package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterLocator {
    public WebElement Gendermale(WebDriver driver) {
        return driver.findElement(By.id("gender-male"));}


    public WebElement userName(WebDriver driver) {
        return driver.findElement(By.name("FirstName"));}

    public WebElement Name(WebDriver driver) {
        return driver.findElement(By.name("LastName"));}

    public WebElement emailELE(WebDriver driver) {
        return driver.findElement(By.name("Email"));}

    public WebElement COMname(WebDriver driver) {
        return driver.findElement(By.name("Company"));}

    public By Newsletter() {
        return By.name("Newsletter");}

    public WebElement passwordELE(WebDriver driver) {
        return driver.findElement(By.name("Password"));}

    public WebElement confirmPasswordELE(WebDriver driver) {
        return driver.findElement(By.name("ConfirmPassword"));}

    public WebElement RegisterELE(WebDriver  driver) {
        return driver.findElement(By.name("register-button"));}



    }






