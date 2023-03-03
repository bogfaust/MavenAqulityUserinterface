package tests.utils;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.nio.file.*;

public class SystemUtil {
	public static void sendImageByDialogWindow() {
		Robot robot;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public static void getAvatar(String prePath) {
		Path path = Paths.get(prePath);
		Path absolutePath = path.toAbsolutePath();

		StringSelection stringSelection = new StringSelection(absolutePath.toString());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
