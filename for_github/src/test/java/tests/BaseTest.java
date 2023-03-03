package tests;

import aquality.selenium.browser.*;
import aquality.selenium.elements.interfaces.*;
import org.testng.annotations.*;

public abstract class BaseTest {
	protected final IElementFactory elementFactory;

	protected BaseTest() {
		elementFactory = AqualityServices.getElementFactory();
	}

	@BeforeMethod
	protected void beforeMethod() {
	}

	@AfterMethod
	public void afterTest() {
		if (AqualityServices.isBrowserStarted()) AqualityServices.getBrowser().quit();
	}
}
