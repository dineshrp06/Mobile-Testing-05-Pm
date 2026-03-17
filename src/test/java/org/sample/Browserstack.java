package org.sample;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Browserstack {

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "Android");

		HashMap<String, Object> bstackOptions = new HashMap<>();

		bstackOptions.put("deviceName", "Samsung Galaxy S22");
		bstackOptions.put("platformVersion", "12.0");
		bstackOptions.put("userName", "srinivasan_paDb8H");
		bstackOptions.put("accessKey", "HcAwHmkjyG4fCLD9bmMx");

		caps.setCapability("bstack:options", bstackOptions);

		// uploaded apk
		caps.setCapability("appium:app", "bs://b25616d57fd2759d2f558e25968ceb97107f7071");

		AndroidDriver driver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps);

		Thread.sleep(5000);

		driver.quit();
		
		System.out.println("Done");
	}
}