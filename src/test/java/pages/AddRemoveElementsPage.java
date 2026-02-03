package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddRemoveElementsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By addElementButton = By.xpath("//button[text()='Add Element']");
    private By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Нажать кнопку Add Element
    public void clickAddElementButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addElementButton)).click();
    }

    // Получить все кнопки Delete
    public List<WebElement> getDeleteButtons() {
        return driver.findElements(deleteButtons);
    }

    // Получить количество кнопок Delete
    public int getDeleteButtonsCount() {
        return getDeleteButtons().size();
    }

    // Нажать на первую кнопку Delete
    public void clickFirstDeleteButton() {
        List<WebElement> buttons = getDeleteButtons();
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
    }
}