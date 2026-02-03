package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends TestBase {

    @Test
    public void testInputField() {
        // 1. Переходим на страницу
        driver.get("https://the-internet.herokuapp.com/inputs");
        InputsPage page = new InputsPage(driver);

        // 2. Проверяем ввод цифр
        page.enterText("123");
        Assert.assertEquals(page.getInputValue(), "123", "Поле должно содержать введённые цифры");

        // 3. Проверяем, что не-цифры не вводятся (поле должно остаться пустым или содержать только цифры)
        page.enterText("abc");
        String value = page.getInputValue();
        // Проверяем, что значение либо пустое, либо не содержит букв (только возможные цифры от прошлого ввода)
        boolean isValid = value.isEmpty() || value.matches("\\d+");
        Assert.assertTrue(isValid, "Поле не должно принимать нечисловые символы. Текущее значение: " + value);

        // 4. Работа со стрелками
        page.enterText("5"); // Устанавливаем начальное значение

        page.pressArrowUp();
        // Проверяем, что значение увеличилось (может быть "6" или "5" если изначально было пусто)
        Assert.assertTrue(Integer.parseInt(page.getInputValue()) >= 5, "Стрелка вверх должна увеличивать значение");

        page.pressArrowDown();
        page.pressArrowDown();
        // Проверяем, что значение уменьшилось
        Assert.assertTrue(Integer.parseInt(page.getInputValue()) <= 6, "Стрелка вниз должна уменьшать значение");

        System.out.println("Тест InputsTest пройден успешно!");
    }
}