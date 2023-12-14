package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSTest {
    private WebDriver driver;
    private final String url = "https://www.mts.by";

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void testOnlineRefillBlock() {
        WebElement cookiesForm = driver.findElement(By.xpath("//div[@class='cookie show']"));

        WebElement acceptButton = cookiesForm.findElement(By.id("cookie-agree"));
        acceptButton.click();

        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        assertTrue(blockTitle.isDisplayed());

        WebElement paymentSystems = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        assertTrue(paymentSystems.isDisplayed());

        WebElement learnMoreLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        learnMoreLink.click();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        WebElement backToMain = driver.findElement(By.xpath("//span[@itemprop='name']"));
        assertTrue(backToMain.isDisplayed());

        WebElement mainButton = driver.findElement(By.xpath("//span[@itemprop='name']"));
        mainButton.click();

        WebElement detailsPageTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']"));
        assertTrue(detailsPageTitle.isDisplayed());

        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.sendKeys("15");

        WebElement continueButton = driver.findElement(By.xpath
                ("//button[contains(text(),'Продолжить')]"));
        continueButton.click();
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}

