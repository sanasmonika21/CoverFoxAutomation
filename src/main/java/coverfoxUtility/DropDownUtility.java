package coverfoxUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {

	public static void selectByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	public static void selectByContainsVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByContainsVisibleText(text);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public static void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public static void deselectByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByValue(text);
	}

	public static void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public static void deSelectByContainsVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deSelectByContainsVisibleText(text);
	}
}
