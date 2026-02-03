package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage {
    private WebDriver driver;
    private By inputField = By.tagName("input");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Получить поле ввода
    public WebElement getInputField() {
        return driver.findElement(inputField);
    }

    // Ввести текст
    public void enterText(String text) {
        getInputField().clear();
        getInputField().sendKeys(text);
    }

    // Получить текущее значение поля
    public String getInputValue() {
        return getInputField().getAttribute("value");
    }

    // Нажать стрелку вверх
    public void pressArrowUp() {
        getInputField().sendKeys(Keys.ARROW_UP);
    }

    // Нажать стрелку вниз
    public void pressArrowDown() {
        getInputField().sendKeys(Keys.ARROW_DOWN);
    }
}