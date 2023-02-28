package hm4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    private final By PRICE_BTN = By.xpath(".//span [@onclick = 'setLang();']");

    private final By RESERVATION_INFO = By.xpath(".//span[@class = 'bTxt']");

    private final By BOOK_BTN = By.xpath(".//div [@class = 'infoBox']/span");

    private final By SEAT = By.xpath(".//div [@class = 'seat']");
    private final By YOUR_SEAT = By.xpath("//div [@class = 'line']");

    private final By BOOK_BTN_TWO = By.xpath(".//div [@class = 'infoBox']/span[2]");

    private WebDriver browser;
    private WebDriverWait wait;


    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("http://www.qaguru.lv:8089/tickets/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        select(FROM, "RIX");
        select(TO, "SFO");

        browser.findElement(GO_BTN).click();

        List<WebElement> destFrom = browser.findElements(RESERVATION_INFO);
        String text = destFrom.get(0).getText();
        if (text.contains("RIX")) {
            System.out.println("first page RIX found");
        } else {
            System.out.println("doesnt work");
        }

        List<WebElement> destTo = browser.findElements(RESERVATION_INFO);
        String textOne = destTo.get(1).getText();
        if (textOne.contains("SFO")) {
            System.out.println("first page SFO found");
        } else {
            System.out.println("doesnt work");
        }

        type(FIRST_NAME, "Nataha");
        type(LAST_NAME, "Koska");
        type(DISCOUNT, "Code");
        type(ADULTS, "3");
        type(CHILDREN, "2");
        type(BAG, "1");
        select(FLIGHT, "11");

        browser.findElement(PRICE_BTN).click();

        List<WebElement> firstDestFrom = browser.findElements(RESERVATION_INFO);
        String firstTextFrom = firstDestFrom.get(0).getText();
        if (firstTextFrom.contains("RIX")) {
            System.out.println("second page first line RIX found");
        } else {
            System.out.println("doesnt work");
        }

        List<WebElement> firstDestTo = browser.findElements(RESERVATION_INFO);
        String firstTextTo = firstDestTo.get(1).getText();
        if (firstTextTo.contains("SFO")) {
            System.out.println("second page first line SFO found");
        } else {
            System.out.println("doesnt work");
        }

        List<WebElement> secondDestFrom = browser.findElements(RESERVATION_INFO);
        String secondTextFrom = secondDestFrom.get(3).getText();
        if (secondTextFrom.contains("RIX")) {
            System.out.println("second page second line RIX found");
        } else {
            System.out.println("doesnt work");
        }

        List<WebElement> secondDestTo = browser.findElements(RESERVATION_INFO);
        String secondTextTo = secondDestTo.get(4).getText();
        if (secondTextTo.contains("SFO")) {
            System.out.println("second page second line SFO found");
        } else {
            System.out.println("doesnt work");
        }

        List<WebElement> name = browser.findElements(RESERVATION_INFO);
        String nameText = name.get(2).getText();
        if (nameText.contains("Nataha")) {
            System.out.println("name is here");
        } else {
            System.out.println("no name");
        }

        browser.findElement(BOOK_BTN).click();

        List<WebElement> seat = browser.findElements(SEAT);
        seat.get(5).click();

        WebElement yourSeat = browser.findElement(YOUR_SEAT);
        String seatText = yourSeat.getText();
        if (seatText.contains("Your seat is: 6")) {
            System.out.println("your seat is correct");
        } else {
            System.out.println("no your seat");
        }

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
