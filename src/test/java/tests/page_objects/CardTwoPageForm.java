package tests.page_objects;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.*;
import org.openqa.selenium.*;

import java.util.*;
import java.util.function.*;

public class CardTwoPageForm extends Form {
	private final IButton btnUpload = getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "Button Upload");

	private final ICheckBox chbUnselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "Label Unselect All");
	private final IButton btnNext2 = getElementFactory().getButton(By.xpath("//button[" + "@name='button'" + " and " + "contains(., 'Next')" + "]"), "Button Next 2");
	private final Supplier<List<ICheckBox>> getInterestCheckboxesList = () -> getElementFactory().findElements(By.xpath("//span[" + "contains(@class, 'checkbox')" + " and " + "contains(@class, 'small')" + "]"), "Example", ICheckBox.class);
	public CardTwoPageForm() {
		super(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "Upload button");
	}
	public void pressUpload() {
		btnUpload.click();
	}

	public void chooseInterests() {
		chbUnselectAll.check();

		List<ICheckBox> interestCheckboxesList = getInterestCheckboxesList.get();
		int indexOfLastElement = interestCheckboxesList.size() - 1;
		int indexOfSelectAllElement = indexOfLastElement - 3;
		interestCheckboxesList.remove(indexOfSelectAllElement);
		indexOfLastElement -= 1;
		interestCheckboxesList.remove(indexOfLastElement);

		Random random = new Random();
		Set<Integer> threeInterests = new LinkedHashSet<>();
		while (threeInterests.size() < 3) {
			threeInterests.add(random.nextInt(interestCheckboxesList.size() - 1));
		}

		for (int i : threeInterests)
			interestCheckboxesList.get(i).toggle();
	}

	public void clickNext2() {
		btnNext2.click();
	}
}
