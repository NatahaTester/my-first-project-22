package hm4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Airport {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By PRICE_BTN = By.xpath("//*[text() = 'Get Price']");

    private final By DEST_IS = By.xpath(".//span[@class = 'bTxt']");
    private final By DEST_TO = By.xpath(".//div[@class = 'infoTxt']/span[2]");

    //private final By MR_MS_NAME = By.xpath(".//div[@class = 'responsePrice']/span");
    //private final By PRICE = By.xpath();

    private final By BOOK_BTN = By.xpath(".//div [@class = 'infoBox']/span");

    private final By SEAT = By.xpath(".//*[text() = '9']");

    private final By BOOK_BTN_TWO = By.xpath(".//div [@class = 'infoBox']/span[2]");

    private WebDriver browser;
    private WebDriverWait wait;

    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        select(FROM, "RIX");
        select(TO, "SFO");

        browser.findElement(GO_BTN).click();

        type(FIRST_NAME, "Nataha");
        type(LAST_NAME, "Koska");
        type(DISCOUNT, "Code");
        type(ADULTS, "3");
        type(CHILDREN, "2");
        type(BAG, "1");
        select(FLIGHT, "11");

        browser.findElement(DEST_IS);
        browser.findElement(DEST_TO);

        browser.findElement(PRICE_BTN).click();

        browser.findElement(BOOK_BTN).click();

        browser.findElement(SEAT).click();

        browser.findElement(BOOK_BTN_TWO).click();
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
