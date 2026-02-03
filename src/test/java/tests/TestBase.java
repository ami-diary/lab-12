package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Автоматическая загрузка драйвера Chrome
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра драйвера
        driver = new ChromeDriver();

        // Настройка ожиданий (явные ожидания - 10 секунд)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Максимизация окна браузера
        driver.manage().window().maximize();

        // Переход на базовый URL
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Закрытие браузера после каждого теста
        if (driver != null) {
            driver.quit();
        }
    }
}