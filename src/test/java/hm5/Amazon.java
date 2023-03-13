package hm5;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Amazon {
    private WebDriver browser;
    private WebDriverWait wait;

    private final By ACCEPT_COOKIE = By.id("sp-cc-accept");
    private final By NOTIFICATION_CONTINUE_BTN = By.xpath(".//input [@class = 'a-button-input']");

    private final By BEST_SELLERS_BTN = By.xpath(".//a [@class = 'nav-a  ']");

    private final By COOKIE_BTN_NEXT_PAGE = By.id("sp-cc-accept");

    private final By BOOKS_BTN = By.xpath("//a [@href = '/-/en/gp/bestsellers/books/ref=zg_bs_nav_0']");
    //div [@role = 'group']/div[8]
    ////div [@class = '_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL']
//a [contains (text(), 'Books')]
    //div [@role = 'treeitem']/a
    private final By NR_BLOCK = By.xpath("//span [@class = 'zg-bdg-text']");
    private final By STARS = By.xpath("//span [@class = 'a-icon-alt']");

    private final By BOOK_FOUR_BLOCK = By.id("p13n-asin-index-3");
    private final By BLOCK_FOUR = By.id("gridItemRoot");

    @Test
    public void openAmazon() {

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE));
        browser.findElement(ACCEPT_COOKIE).click();
        browser.findElement(NOTIFICATION_CONTINUE_BTN).click();

        //browser.findElement(BEST_SELLERS_BTN).click();

        List<WebElement> mainMenu = browser.findElements(BEST_SELLERS_BTN);
        for (WebElement we : mainMenu) {
            if (we.getText().equals("Best Sellers")) {
                wait.until(ExpectedConditions.elementToBeClickable(we));
                we.click();
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(BOOKS_BTN));
        browser.findElement(BOOKS_BTN).click();
        //List<WebElement> leftMenu = browser.findElements(BOOKS_BTN);
        //for (WebElement we : leftMenu) {
        //    if (we.getText().startsWith("Books")) {
        //        wait.until(ExpectedConditions.elementToBeClickable(we));
        //        we.click();
        //        break;
        //    } else {
        //        System.out.println("WTF v 4om problem to");
        //        break;
        //    }
        //}


        List<WebElement> star = browser.findElements(STARS);
        String text = star.get(3).getText();
        System.out.println(text);
        //public String getStarsCount() {
        //    String text = browser.findElement(BOOK_FOUR_BLOCK).getText();
        //    return StringUtils.substringBetween(text, "for ", " EUR");
//
        //}

    }
}

