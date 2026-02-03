package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends TestBase {

    @Test
    public void testAddRemoveElements() {
        // Переходим на страницу
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Создаем объект страницы
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);

        // 1. Проверяем, что изначально нет кнопок Delete
        Assert.assertEquals(page.getDeleteButtonsCount(), 0,
                "Изначально не должно быть кнопок Delete");

        // 2. Добавляем первый элемент
        page.clickAddElementButton();
        Assert.assertEquals(page.getDeleteButtonsCount(), 1,
                "Должна появиться одна кнопка Delete");

        // 3. Добавляем второй элемент
        page.clickAddElementButton();
        Assert.assertEquals(page.getDeleteButtonsCount(), 2,
                "Должно быть две кнопки Delete");

        // 4. Удаляем первый элемент
        page.clickFirstDeleteButton();
        Assert.assertEquals(page.getDeleteButtonsCount(), 1,
                "После удаления должна остаться одна кнопка Delete");

        // 5. Удаляем последний элемент
        page.clickFirstDeleteButton();
        Assert.assertEquals(page.getDeleteButtonsCount(), 0,
                "После удаления всех элементов не должно быть кнопок Delete");

        System.out.println("Тест AddRemoveElementsTest пройден успешно!");
    }
}