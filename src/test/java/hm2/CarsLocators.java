package hm2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarsLocators {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    @Test
    public void openCarsPage() {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.discovercars.com/");

        browser.findElement(ACCEPT_COOKIES_BTN).click();

    }
}
