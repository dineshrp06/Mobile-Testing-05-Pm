package org.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class AppLaunch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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
		caps.setCapability("appium:appPackage", "com.google.android.apps.maps");

		// appActivity
		caps.setCapability("appium:appActivity", "com.google.android.maps.MapsActivity");

		// connecting to the server
		URL url = new URL("http://127.0.0.1:4723/");

		WebDriver driver = new AndroidDriver(url, caps);

		Thread.sleep(5000);

		System.out.println("App launched");

		Dimension size = driver.manage().window().getSize();

		int width = size.getWidth();

		int height = size.getHeight();

		System.out.println("Width : " + width);

		System.out.println("Height : " + height);

		int startX = (int) (width * 0.8);
		int startY = height / 2;

		int endX = (int) (width * 0.2);
		int endY = startY;

		// Scroll down
		// Create a finger
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		// Create a gesture sequence

		// scroll down
		Sequence swipe = new Sequence(input, 1);

		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));

		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		swipe.addAction(input.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, endY));

		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		((RemoteWebDriver) driver).perform(Arrays.asList(swipe));

		Thread.sleep(3000);

	}

}
