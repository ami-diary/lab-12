package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends TestBase {

    @Test
    public void testDropdown() {
        // Переходим на страницу
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Создаем объект страницы
        DropdownPage page = new DropdownPage(driver);

        // 1. Проверяем количество опций в dropdown
        Assert.assertEquals(page.getAllOptions().size(), 3,
                "В dropdown должно быть 3 опции");

        // 2. Проверяем наличие всех нужных опций
        String option1 = page.getAllOptions().get(1).getText();
        String option2 = page.getAllOptions().get(2).getText();

        Assert.assertEquals(option1, "Option 1", "Должна быть опция 'Option 1'");
        Assert.assertEquals(option2, "Option 2", "Должна быть опция 'Option 2'");

        // 3. Выбираем Option 1 и проверяем
        page.selectOptionByIndex(1);
        Assert.assertEquals(page.getSelectedOption(), "Option 1",
                "Должна быть выбрана Option 1");

        // 4. Выбираем Option 2 и проверяем
        page.selectOptionByIndex(2);
        Assert.assertEquals(page.getSelectedOption(), "Option 2",
                "Должна быть выбрана Option 2");

        System.out.println("Тест DropdownTest пройден успешно!");
    }
}