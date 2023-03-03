package tests;

import aquality.selenium.browser.*;
import org.testng.*;
import org.testng.annotations.*;
import tests.page_objects.*;
import tests.store.*;
import tests.utils.*;

public class TaskTests extends BaseTest {
	@Test
	public void test1() {
		AqualityServices.getBrowser().maximize();
		AqualityServices.getBrowser().goTo(JsonReaderStorage.getSiteUrl());

		MainPageForm mainPageForm = new MainPageForm();

		Assert.assertTrue(mainPageForm.state().waitForDisplayed(), "Welcome page is open.");
		mainPageForm.clickLinkToGamePageForm();

		CardOnePageForm cardOnePageForm = new CardOnePageForm();
		Assert.assertTrue(cardOnePageForm.state().waitForDisplayed(), "The '1' card is open.");
		cardOnePageForm.setPassword(StringUtil.getPassword());
		cardOnePageForm.setEmail(StringUtil.getEmail(), StringUtil.getDomain());
		cardOnePageForm.setTopLevelDomain();
		cardOnePageForm.acceptTerms();

		cardOnePageForm.clickNext();

		CardTwoPageForm cardTwoPageForm = new CardTwoPageForm();
		Assert.assertTrue(cardTwoPageForm.state().waitForDisplayed(), "The '2' card is open.");
		cardTwoPageForm.pressUpload();

		SystemUtil.getAvatar(JsonReaderStorage.getAvatarPrePath());
		SystemUtil.sendImageByDialogWindow();

		cardTwoPageForm.chooseInterests();
		cardTwoPageForm.clickNext2();

		CardThreePageForm cardThreePageForm = new CardThreePageForm();
		Assert.assertTrue(cardThreePageForm.state().waitForDisplayed(), "The '3' card is open.");
	}

	@Test
	public void test2() {
		AqualityServices.getBrowser().maximize();
		AqualityServices.getBrowser().goTo(JsonReaderStorage.getSiteUrl());

		MainPageForm mainPageForm = new MainPageForm();
		Assert.assertTrue(mainPageForm.state().waitForDisplayed(), "Welcome page is open.");
		mainPageForm.clickLinkToGamePageForm();

		GamePageForm gamePageForm = new GamePageForm();
		gamePageForm.hideHelpForm();
		Assert.assertTrue(gamePageForm.isFormHidden(), "Form content is hidden.");
	}

	@Test
	public void test3() {
		AqualityServices.getBrowser().maximize();
		AqualityServices.getBrowser().goTo(JsonReaderStorage.getSiteUrl());

		MainPageForm mainPageForm = new MainPageForm();
		Assert.assertTrue(mainPageForm.state().waitForDisplayed(), "Welcome page is open.");
		mainPageForm.clickLinkToGamePageForm();

		GamePageForm gamePageForm = new GamePageForm();

		gamePageForm.acceptCookies();
		Assert.assertFalse(gamePageForm.isFormExist(), "Form is closed.");
	}

	@Test
	public void test4() {
		AqualityServices.getBrowser().maximize();
		AqualityServices.getBrowser().goTo(JsonReaderStorage.getSiteUrl());

		MainPageForm mainPageForm = new MainPageForm();
		mainPageForm.clickLinkToGamePageForm();

		GamePageForm gamePageForm = new GamePageForm();
		Assert.assertEquals(gamePageForm.getTimer(), JsonReaderStorage.getTimerTemplate(), "Validate that timer starts from 00:00");
	}
}
