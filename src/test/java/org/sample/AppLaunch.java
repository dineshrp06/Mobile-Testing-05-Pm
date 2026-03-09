package org.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppLaunch {

	public static void main(String[] args) throws MalformedURLException {

		// Create Object for DesiredCapabilities
		DesiredCapabilities caps = new DesiredCapabilities();

		// platformName
		caps.setCapability("appium:platformName", "android");

		// platformVersion
		caps.setCapability("appium:platformVersion", "16");

		// deviceName
		caps.setCapability("appium:deviceName", "RZCX814Z9WV");

		// automationName
		caps.setCapability("appium:automationName", "UiAutomator2");

		// appPackage
		caps.setCapability("appium:appPackage", "com.omr_branch");

		// appActivity
		caps.setCapability("appium:appActivity", "com.omr_branch.MainActivity");

		// connecting to the server
		URL url = new URL("http://127.0.0.1:4723/");

		AndroidDriver androidDriver = new AndroidDriver(url, caps);

	}

}
