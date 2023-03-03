package tests.page_objects;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.*;
import org.openqa.selenium.*;

public class GamePageForm extends Form {
	private final ILabel hiddenHelpForm = getElementFactory().getLabel(By.xpath("//span[" + "contains(@class, 'help-form')" + " and " + "contains(@class, 'is-hidden')" + "]"), "Help Form");

	private final IButton btnSendToBottom = getElementFactory().getButton(By.className("discrete"), "Send to bottom Button");

	private final IButton btnAcceptCookies = getElementFactory().getButton(By.xpath("//button[" + "@name='button'" + " and " + "contains(., 'Not really, no')" + "]"), "Button Accept Cookies");

	private final ILabel elementCookiesForm = getElementFactory().getLabel(By.xpath("//div[@class='cookies']"), "Cookies Form");
	private final ILabel elementTimer = getElementFactory().getLabel(By.xpath("//div[starts-with(@class,'timer')]"), "Timer");

	public GamePageForm() {
		super(By.className("login-form"), "Login Form");
	}

	public void hideHelpForm() {
		btnSendToBottom.click();
	}

	public boolean isFormHidden() {
		return hiddenHelpForm.getElement() != null;
	}

	public void acceptCookies() {
		btnAcceptCookies.state().waitForExist();
		btnAcceptCookies.click();
	}

	public boolean isFormExist() {
		elementCookiesForm.state().waitForNotExist();
		return elementCookiesForm.state().isExist();
	}

	public String getTimer() {
		return elementTimer.getText();
	}
}