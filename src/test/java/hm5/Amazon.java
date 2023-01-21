package hm5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {
    private WebDriver browser;
    private WebDriverWait wait;

    private final By ACCEPT_COOKIE = By.id("sp-cc-accept");
    private final By NOTIFICATION_CONTINUE_BTN = By.xpath(".//input [@class = 'a-button-input']");

    private final By BEST_SELLERS_BTN = By.xpath(".//div[@id = 'nav-xshop']/a[1]");

    private final By COOKIE_BTN_NEXT_PAGE = By.id("sp-cc-accept");

    private final By BOOKS_BTN = By.xpath(".//a [contains(@href, '/-/en/gp/bestsellers/books/ref=zg_bs_nav_0')]");

    @Test
    public void openAmazon() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.amazon.de");

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE));
        browser.findElement(ACCEPT_COOKIE).click();
        browser.findElement(NOTIFICATION_CONTINUE_BTN).click();

        browser.findElement(BEST_SELLERS_BTN).click();

        wait.until(ExpectedConditions.elementToBeClickable(COOKIE_BTN_NEXT_PAGE));
        browser.findElement(COOKIE_BTN_NEXT_PAGE).click();

        wait.until(ExpectedConditions.elementToBeClickable(BOOKS_BTN));
        browser.findElement(BOOKS_BTN).click();


    }
    private void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }
    private void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);

    }
}
