package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSTest {
    private static WebDriver driver;
    private static final String url = "https://www.mts.by";
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeAll
    public static void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        handleCookies();
    }

    public static void handleCookies(){
        WebElement cookiesForm = driver.findElement(By.xpath("//div[@class='cookie show']"));

        WebElement acceptButton = cookiesForm.findElement(By.id("cookie-agree"));
        acceptButton.click();
    }

    private void navigateToOnlinePaymentSection() {
        WebElement onlinePaymentSection = driver.findElement(By.xpath
                ("//h2[text()='Онлайн пополнение ']"));
        onlinePaymentSection.click();
    }

    @Test
    public void testCheckLabelsInPaymentFields() {
        servicesTest("//p[text()='Услуги связи']");
        internetTest("//p[text()='Домашний интернет']");
        installmentTest("//p[text()='Рассрочка']");
        deptTest("//p[text()='Задолженность']");
    }

    private void servicesTest(String paymentType) {
        navigateToOnlinePaymentSection();

        WebElement showPaymentTypeTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='select__arrow']")));
        showPaymentTypeTab.click();

        WebElement paymentTypeTab = driver.findElement(By.xpath(paymentType));
        paymentTypeTab.click();

        WebElement headerElement = driver.findElement(By.xpath(paymentType));
        String actualHeader = headerElement.getText();
        assertTrue(actualHeader.contains("Услуги связи"));

        WebElement phoneNumberLabel = driver.findElement(By.className("phone"));
        String actualNumber = phoneNumberLabel.getAttribute("value");
        assertTrue(actualNumber.contains(""));

        WebElement sumLabel = driver.findElement(By.className("total_rub"));
        String actualSum = sumLabel.getAttribute("value");
        assertTrue(actualSum.contains(""));

        WebElement emailLabel = driver.findElement(By.className("email"));
        String actualEmail = emailLabel.getAttribute("value");
        assertTrue(actualEmail.contains(""));
    }

    private void internetTest(String paymentType) {
        navigateToOnlinePaymentSection();

        WebElement showPaymentTypeTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='select__arrow']")));
        showPaymentTypeTab.click();

        WebElement paymentTypeTab = driver.findElement(By.xpath(paymentType));
        paymentTypeTab.click();

        WebElement headerElement = driver.findElement(By.xpath(paymentType));
        String actualHeader = headerElement.getText();
        assertTrue(actualHeader.contains("Домашний интернет"));

        WebElement phoneNumberLabel = driver.findElement(By.className("phone"));
        String actualNumber = phoneNumberLabel.getAttribute("value");
        assertTrue(actualNumber.contains(""));

        WebElement sumLabel = driver.findElement(By.className("total_rub"));
        String actualSum = sumLabel.getAttribute("value");
        assertTrue(actualSum.contains(""));

        WebElement emailLabel = driver.findElement(By.className("email"));
        String actualEmail = emailLabel.getAttribute("value");
        assertTrue(actualEmail.contains(""));
    }

    private void installmentTest(String paymentType) {
        navigateToOnlinePaymentSection();

        WebElement showPaymentTypeTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='select__arrow']")));
        showPaymentTypeTab.click();

        WebElement paymentTypeTab = driver.findElement(By.xpath(paymentType));
        paymentTypeTab.click();

        WebElement headerElement = driver.findElement(By.xpath(paymentType));
        String actualHeader = headerElement.getText();
        assertTrue(actualHeader.contains("Рассрочка"));

        WebElement phoneNumberLabel = driver.findElement(By.className("score"));
        String actualNumber = phoneNumberLabel.getAttribute("value");
        assertTrue(actualNumber.contains(""));

        WebElement sumLabel = driver.findElement(By.className("total_rub"));
        String actualSum = sumLabel.getAttribute("value");
        assertTrue(actualSum.contains(""));

        WebElement emailLabel = driver.findElement(By.className("email"));
        String actualEmail = emailLabel.getAttribute("value");
        assertTrue(actualEmail.contains(""));
    }

    private void deptTest(String paymentType) {
        navigateToOnlinePaymentSection();

        WebElement showPaymentTypeTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='select__arrow']")));
        showPaymentTypeTab.click();

        WebElement paymentTypeTab = driver.findElement(By.xpath(paymentType));
        paymentTypeTab.click();

        WebElement headerElement = driver.findElement(By.xpath(paymentType));
        String actualHeader = headerElement.getText();
        assertTrue(actualHeader.contains("Задолженность"));

        WebElement phoneNumberLabel = driver.findElement(By.className("score"));
        String actualNumber = phoneNumberLabel.getAttribute("value");
        assertTrue(actualNumber.contains(""));

        WebElement sumLabel = driver.findElement(By.className("total_rub"));
        String actualSum = sumLabel.getAttribute("value");
        assertTrue(actualSum.contains(""));

        WebElement emailLabel = driver.findElement(By.className("email"));
        String actualEmail = emailLabel.getAttribute("value");
        assertTrue(actualEmail.contains(""));
    }

    @Test
    public void testServicesPayment() {
        WebElement showPaymentTypeTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='select__arrow']")));
        showPaymentTypeTab.click();

        WebElement paymentTypeTab = driver.findElement(By.xpath("//p[text()='Услуги связи']"));
        paymentTypeTab.click();

        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.sendKeys("15");

        WebElement continueButton = driver.findElement(By.xpath
                ("//button[contains(text(),'Продолжить')]"));
        continueButton.click();

        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//iframe[contains(@class, 'bepaid-iframe')]")));
        driver.switchTo().frame(iframeElement);

        WebElement amountInFrame = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        String displayedAmountInFrame = (String) ((JavascriptExecutor) driver).executeScript
                ("return arguments[0].innerText;", amountInFrame);
        String expectedAmount = "15.00 BYN";
        assertEquals(expectedAmount, displayedAmountInFrame);

        WebElement operationIdInFrame = driver.findElement(By.xpath
                ("//p[@class='header__payment-info']"));
        String operationId =(String) ((JavascriptExecutor) driver).executeScript
                ("return arguments[0].innerText;", operationIdInFrame);
        String expectedOperationId = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(expectedOperationId, operationId);
        driver.switchTo().defaultContent();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

