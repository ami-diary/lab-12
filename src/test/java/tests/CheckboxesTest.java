package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    @Test
    public void testCheckboxes() {
        // Переходим на страницу с чекбоксами
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Создаем объект страницы
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);

        // 1. Проверяем, что первый чекбокс НЕ выбран (unchecked)
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(0),
                "Первый чекбокс должен быть unchecked");

        // 2. Кликаем на первый чекбокс
        checkboxesPage.clickCheckbox(0);

        // 3. Проверяем, что первый чекбокс ВЫБРАН (checked)
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(0),
                "Первый чекбокс должен быть checked после клика");

        // 4. Проверяем, что второй чекбокс ВЫБРАН (по условию на странице он уже checked)
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(1),
                "Второй чекбокс должен быть checked изначально");

        // 5. Кликаем на второй чекбокс (снимаем выбор)
        checkboxesPage.clickCheckbox(1);

        // 6. Проверяем, что второй чекбокс НЕ выбран (unchecked)
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(1),
                "Второй чекбокс должен быть unchecked после клика");

        System.out.println("Тест CheckboxesTest пройден успешно!");
    }
}