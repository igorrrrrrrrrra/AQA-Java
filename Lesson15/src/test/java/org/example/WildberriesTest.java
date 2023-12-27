package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WildberriesTest {
    private static WebDriver driver;
    private static final String url = "https://www.wildberries.by";
    private static JavascriptExecutor js;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1536, 824));
        js.executeScript("window.scrollTo(0,300)");

        int productIndex = 1;

        while (productIndex <= 3) {
            if (addToCartWithDeliveryCheck(String.valueOf(productIndex))) {
                productIndex++;
            }
        }
    }

    private boolean addToCartWithDeliveryCheck(String productIndex) throws InterruptedException {
        int maxProducts = 3;

        for (int currentIndex = Integer.parseInt(productIndex); currentIndex <= maxProducts; currentIndex++) {
            String selector = String.format(".card-cell:nth-child(%d) .btn", currentIndex);
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));

            Thread.sleep(500);

            String deliveryInfoSelector = String.format(".small-cards-row:nth-child(%d) > .card-cell:nth-child(%d) .b-card__delivery > span",
                    currentIndex, currentIndex);
            WebElement deliveryInfo = driver.findElement(By.cssSelector(deliveryInfoSelector));
            Thread.sleep(500);

            System.out.println("Текущий индекс: " + currentIndex);
            System.out.println("Текущий селектор кнопки: " + selector);
            System.out.println("Текущий селектор информации о доставке: " + deliveryInfoSelector);
            System.out.println("Текущая информация о доставке: " + deliveryInfo.getText());

            if (deliveryInfo.getText().contains("Послезавтра")) {
                button.click();
                Thread.sleep(1000);
                return true;
            } else {
                System.out.println("Товар с индексом " + currentIndex + " не имеет доставку 'послезавтра'");
            }
        }

        System.out.println("Достигнуто максимальное количество товаров. Прекращаем добавление в корзину.");
        return false;
    }


    @Test
    public void checkProductDetailsInCart() throws InterruptedException {
        List<String> products = getProductsDetails();

        List<String> product1 = new ArrayList<>();
        product1.add("3");
        product1.add(products.get(0));
        product1.add(products.get(1));

        List<String> product2 = new ArrayList<>();
        product2.add("2");
        product2.add(products.get(2));
        product2.add(products.get(3));

        List<String> product3 = new ArrayList<>();
        product3.add("1");
        product3.add(products.get(4));
        product3.add(products.get(5));

        goToCart();

        Thread.sleep(1000);

        assertProductDetailsInCart(product1);
        assertProductDetailsInCart(product2);
        assertProductDetailsInCart(product3);
    }

    private void goToCart() {
        js.executeScript("window.scrollTo(0,0)");
        WebElement cartLink = driver.findElement(By.xpath("//span[text()='Корзина']"));
        cartLink.click();
    }

    private List<String> getProductsDetails() throws InterruptedException {
        WebElement main = driver.findElement(By.xpath("//a[@class='header__logo']"));
        main.click();

        List<String> products = new ArrayList<>();

        Thread.sleep(1000);

        WebElement firstCardPrice = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(1) .price__lower > span:nth-child(2)"));
        String firstCard = firstCardPrice.getText().toUpperCase();
        products.add(firstCard);

        WebElement firstCardName = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(1) .b-card__name"));
        firstCard = firstCardName.getText().toUpperCase();
        products.add(firstCard);

        Thread.sleep(1000);

        WebElement secondCardPrice = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(2) .price__lower > span:nth-child(2)"));
        String secondCard = secondCardPrice.getText().toUpperCase();
        products.add(secondCard);

        WebElement secondCardName = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(2) .b-card__name"));
        secondCard = secondCardName.getText().toUpperCase();
        products.add(secondCard);

        Thread.sleep(1000);

        WebElement thirdCardPrice = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(3) .price__lower > span:nth-child(2)"));
        String thirdCard = thirdCardPrice.getText().toUpperCase();
        products.add(thirdCard);

        WebElement thirdCardName = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(3) .b-card__name"));
        thirdCard = thirdCardName.getText().toUpperCase();
        products.add(thirdCard);

        return products;
    }

    private void assertProductDetailsInCart(List<String> product) {
        int id = Integer.parseInt(product.get(0));
        js.executeScript("window.scrollTo(0,300)");
        WebElement cartProductName = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(".b-item:nth-child(" + id + ") .b-item__title > span")));

        WebElement cartProduct = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".b-item:nth-child(" + id + ")")));
        String priceId = cartProduct.getAttribute("data-id");

        WebElement cartProductPrice = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'b-item')" +
                        " and contains(@data-id, '" + priceId + "')]/" +
                        "div[contains(@class, 'b-item__total')]//" +
                        "div[@class='b-item-price__lower' and @data-tag='salePrice']")));


        assertEquals(cartProductName.getText().toUpperCase(), product.get(2));
        assertEquals(cartProductPrice.getText().toUpperCase(), product.get(1));

    }

    @Test
    public void sumAndCountTest(){
        WebElement firstCardPrice = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(1) .price__lower > span:nth-child(2)"));
        String priceText = firstCardPrice.getText().replaceAll("[^\\d.]", "");
        double firstCard = Double.parseDouble(priceText);

        WebElement thirdCardPrice = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(3) .price__lower > span:nth-child(2)"));
        priceText = thirdCardPrice.getText().replaceAll("[^\\d.]", "");
        double thirdCard = Double.parseDouble(priceText);

        WebElement secondCardPrice = driver.findElement(By.cssSelector
                (".small-cards-row:nth-child(1) > .card-cell:nth-child(2) .price__lower > span:nth-child(2)"));
        priceText = secondCardPrice.getText().replaceAll("[^\\d.]", "");
        double secondCard = Double.parseDouble(priceText);

        double sum = firstCard + secondCard + thirdCard;

        goToCart();

        WebElement cartSum = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='basket-summary__total-value']")));
        priceText = cartSum.getText().replaceAll("[^\\d.]", "");
        double cSum = Double.parseDouble(priceText);
        assertEquals(sum, cSum);

        WebElement count = driver.findElement(By.cssSelector(".basket__items-counter"));
        assertEquals("3",  count.getText());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}