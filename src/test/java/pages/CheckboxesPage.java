package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage {
    private WebDriver driver;

    // Локаторы
    private By checkboxesLocator = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для получения всех чекбоксов
    public List<WebElement> getAllCheckboxes() {
        return driver.findElements(checkboxesLocator);
    }

    // Метод для клика по чекбоксу по индексу (0 или 1)
    public void clickCheckbox(int index) {
        List<WebElement> checkboxes = getAllCheckboxes();
        if (index >= 0 && index < checkboxes.size()) {
            checkboxes.get(index).click();
        }
    }

    // Метод для проверки, выбран ли чекбокс
    public boolean isCheckboxSelected(int index) {
        List<WebElement> checkboxes = getAllCheckboxes();
        if (index >= 0 && index < checkboxes.size()) {
            return checkboxes.get(index).isSelected();
        }
        return false;
    }
}