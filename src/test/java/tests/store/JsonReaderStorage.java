package tests.store;

import aquality.selenium.core.utilities.*;

public class JsonReaderStorage {
	private static final ISettingsFile configData = new JsonSettingsFile(Constants.CONFIG_FILE_PATH);
	private static final String siteUrl= configData.getValue("/url").toString();

	private static final ISettingsFile testData = new JsonSettingsFile(Constants.TEST_DATA_FILE_PATH);
	private static final String prePath= testData.getValue("/avatar").toString();
	private static final String timerTemplate= testData.getValue("/timer").toString();
	public static String getSiteUrl(){
		return siteUrl;
	}
	public static String getAvatarPrePath(){
		return prePath;
	}
	public static String getTimerTemplate(){
		return timerTemplate;
	}
}
