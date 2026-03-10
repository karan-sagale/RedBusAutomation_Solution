package com.redbus.automation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAutomationScript {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30)); // Synchronizing the WebDriver!!

		wd.get("https://www.redbus.in");

		By sourceButtonLocator = By.xpath("(//div[contains(@class,\"srcDestWrapper\")])[1]");
		WebElement sourceButton = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceButtonLocator));
		sourceButton.click();

		By searchSuggestionSectionLocator = By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionSectionLocator));

		selectLocation(wd, wait, "Mumbai"); // For From Location
		selectLocation(wd, wait, "Pune"); // For To Location

		By searchButtonLocator = By.xpath("//button[contains(@class,\"searchButtonWrapper\")]");
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
		searchButton.click();

		By proceedButtonLocator = By.xpath("//button[contains(@class,\"primaryButton\") and @aria-label=\"Proceed\"]");
		WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(proceedButtonLocator));
		proceedButton.click();

		By primoBusButtonLocator = By.xpath("//div[contains(text(),\"Primo Bus\")]");
		WebElement primoBus = wait.until(ExpectedConditions.elementToBeClickable(primoBusButtonLocator));
		primoBus.click();

		By eveningButtonLocator = By.xpath("//div[contains(text(),\"18:00-24:00\")]");
		WebElement eveningButton = wait.until(ExpectedConditions.elementToBeClickable(eveningButtonLocator));
		eveningButton.click();

		By tuppleWrapperLocator = By.xpath("//li[contains(@class,\"tupleWrapper\")]"); // Found the row locator
		By busesNameLocator = By.xpath(".//div[contains(@class,\"travelsName\")]"); // Bus name locator
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tuppleWrapperLocator));

		By subTitleLocator = By.xpath("//span[contains(@class,\"subtitle\")]");

		WebElement subTitle = null;
		if (wait.until(ExpectedConditions.textToBePresentInElementLocated(subTitleLocator, "buses"))) {
			subTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(subTitleLocator));
		}
		System.out.println("Total number of Buses found: " + subTitle.getText());

		List<WebElement> rowList = new ArrayList<>();
		JavascriptExecutor js = (JavascriptExecutor) wd;

		while (true) { // Lazy Loading to get the rows from the webpage!!
			rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tuppleWrapperLocator));
			List<WebElement> endOfList = wd.findElements(By.xpath("//span[contains(text(),\"End of list\")]"));

			if (!endOfList.isEmpty()) {
				break; // Exit condition for while loop!!
			}
			js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'})", rowList.get(rowList.size() - 3));
		}

		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'})", rowList.get(rowList.size() - 1));

		rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tuppleWrapperLocator));
		for (WebElement row : rowList) {
			String busName = row.findElement(busesNameLocator).getText();
			System.out.println("\n" + busName);
		}
		System.out.println(
				"\nTotal number of Buses available with \"Primo Bus\" and \"Evening\" Filter are: " + rowList.size());

		wd.quit();
	}

	public static void selectLocation(WebDriver wd, WebDriverWait wait, String locationData) {
		WebElement searchTextBoxElement = wd.switchTo().activeElement();
		searchTextBoxElement.sendKeys(locationData);

		By searchCategoryLocator = By.xpath("//div[contains(@class,\"searchCategory\")]");
		List<WebElement> searchList = wait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator, 2));
		WebElement locationSearchResult = searchList.get(0);

		By locationNameLocator = By.xpath(".//div[contains(@class,\"listHeader\")]");
		List<WebElement> fromLocationList = locationSearchResult.findElements(locationNameLocator);

		for (WebElement fromLocation : fromLocationList) {
			if (fromLocation.getText().equalsIgnoreCase(locationData)) {
				fromLocation.click();
				break;
			}
		}
	}

}
