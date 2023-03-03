package tests.page_objects;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.*;
import org.openqa.selenium.*;

public class CardOnePageForm extends Form {
	private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password");
	private final ITextBox txbYourEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email name");
	private final ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain");
	private final IComboBox cmbDropdown = getElementFactory().getComboBox(By.className("dropdown__header"), "Dropdown");

	private final IButton btnTopLevelDomain = getElementFactory().getButton(By.xpath("//div[" + "@class='dropdown__list-item'" + " and " + "contains(., '.org')" + "]"), "Top Level Domain");
	private final ICheckBox chbBoxAcceptTerms = getElementFactory().getCheckBox(By.className("checkbox__box"), "Accept Terms CheckBox");

	private final IButton btnNext = getElementFactory().getButton(By.className("button--secondary"), "Button Next");
	public CardOnePageForm() {
		super(By.className("login-form"), "Login Form");
	}

	public void setPassword(String password) {
		txbPassword.clearAndType(password);
	}

	public void setEmail(String email, String domain) {
		txbYourEmail.clearAndType(email);
		txbDomain.clearAndType(domain);
	}

	public void setTopLevelDomain() {
		cmbDropdown.click();
		btnTopLevelDomain.click();
	}

	public void acceptTerms() {
		chbBoxAcceptTerms.toggle();
	}

	public void clickNext() {
		btnNext.click();
	}
}
