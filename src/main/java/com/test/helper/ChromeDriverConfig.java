package com.test.helper;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.test.constant.ProjectConstant;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ChromeDriverConfig {

	public static WebDriver initialiseChromeDrive() {
		ChromeOptions capability = new ChromeOptions(); //
		// capability.addArguments("headless");
		capability.setExperimentalOption("useAutomationExtension", false);
		capability.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.addArguments("--disable-notifications");

		ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver(capability);
		driver.manage().window().maximize();
		driver.get(ProjectConstant.BASE_URL);

		return driver;
	}

}