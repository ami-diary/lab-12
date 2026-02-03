package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage {
    private WebDriver driver;

    // Локаторы
    private By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // Получить элемент dropdown
    public Select getDropdown() {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        return new Select(dropdownElement);
    }

    // Выбрать опцию по видимому тексту
    public void selectOptionByText(String text) {
        getDropdown().selectByVisibleText(text);
    }

    // Выбрать опцию по индексу
    public void selectOptionByIndex(int index) {
        getDropdown().selectByIndex(index);
    }

    // Получить все опции
    public List<WebElement> getAllOptions() {
        return getDropdown().getOptions();
    }

    // Получить выбранную опцию
    public String getSelectedOption() {
        return getDropdown().getFirstSelectedOption().getText();
    }
}