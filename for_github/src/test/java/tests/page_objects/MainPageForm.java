package tests.page_objects;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.*;
import org.openqa.selenium.*;

public class MainPageForm extends Form {
	private final ILink linkToGamePageForm = getElementFactory().getLink(By.className("start__link"), "Password");

	public MainPageForm() {
		super(By.className("start__button"), "Main page");
	}

	public void clickLinkToGamePageForm() {
		linkToGamePageForm.clickAndWait();
	}
}