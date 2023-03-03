package tests.page_objects;

import aquality.selenium.forms.*;
import org.openqa.selenium.*;

public class CardThreePageForm extends Form {
	public CardThreePageForm() {
		super(By.xpath("//h3[text()='Personal details']"), "Header 3");
	}
}
