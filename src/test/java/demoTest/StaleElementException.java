package demoTest;

import java.net.SocketException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class StaleElementException {
	@Test
	public void clickTest() throws InterruptedException, SocketException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://goldeneye.axisrooms.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("demo@axisrooms.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Axisrooms321#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// for filter
		
		WebElement ele = driver.findElement(By.xpath("(//select[@class='select2-hidden-accessible'])[1]"));
		Select select = new Select(ele);
		select.selectByVisibleText("19VillaMira, Pondicherry, India");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='refreshWidget']")).click();

		List<WebElement> findElements = driver.findElements(By.xpath(
				"//ge-header/div[1]/div[2]/div[3]/div[1]/ge-refresh[1]/div[1]/div[1]/div[2]/div[2]/div[3]/ul[3]/li/label"));
		for (int i = 0; i < findElements.size(); i++) {
			if (findElements.get(i).getText().equalsIgnoreCase("7 Days")) {
				findElements.get(i).click();
			}

		}

		driver.findElement(By.xpath(
				"//ge-header/div[1]/div[2]/div[3]/div[1]/ge-refresh[1]/div[1]/div[1]/div[2]/div[2]/div[3]/ul[3]/li[6]/input[1]"))
				.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(3000);
		
		Thread.sleep(300000);
		
		driver.findElement(By.xpath("//ge-header/div[1]/div[2]/div[3]/div[1]/div[1]/ge-autoload[1]/button[1]")).click();
		Thread.sleep(3000);
		
		       
		        // Store the initial running statuses in a map
		   /*     Map<String, String> initialStatusMap = new HashMap<>();
		    

		        // Set an initial timeout and interval for checking statuses
		        int timeoutInSeconds = 60;
		        int intervalInSeconds = 5;

		        // Keep track of the start time
		        long startTime = System.currentTimeMillis();

		        try {
		            // Create an instance of the Actions class
		            Actions actions = new Actions(driver);
		            
		          

		            // Flag to track if all statuses have changed from "data running"
		            boolean allStatusesChanged = false;

		            // Enter the monitoring loop
		            while (!allStatusesChanged) {
		                allStatusesChanged = true; // Assume all statuses have changed

		                // Wait for the circles to load (adjust the locator as needed)
		              	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
		                List<WebElement> circles = driver.findElements(By.xpath("//*[name()='circle']"));

		                for (WebElement circle : circles) {
		                    // Perform mouse hover over the circle
		                    actions.moveToElement(circle).perform();

		                    try {
		                        // Explicitly wait for the pop-up to appear (adjust the timeout as needed)
		                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		                        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));

		                        // Extract the current running status from the pop-up
		                        String popupText = popup.getText();

		                        // Extract circle text
		                        String circleText = circle.getText();

		                        String initialStatus = initialStatusMap.get(circleText);

		                        if (!popupText.equals(initialStatus)) {
		                            allStatusesChanged = false; // Set to false if any status has changed
		                            initialStatusMap.put(circleText, popupText);
		                        }

		                        // Move the mouse away from the circle to close the pop-up
		                        actions.moveByOffset(0, 0).perform();
		                    } catch (org.openqa.selenium.StaleElementReferenceException e) {
		                        // Handle StaleElementReferenceException by refreshing the page
		                        driver.navigate().refresh();
		                        break; // Exit the loop after refresh
		                    }
		                    
		                }

		                // If all statuses have changed, break the loop
		                if (allStatusesChanged) {
		                    break;
		                }

		                // Sleep for the specified interval before checking again
		                Thread.sleep(intervalInSeconds * 1000);
		            }

		            // Calculate and print the time taken for the scenario
		            long endTime = System.currentTimeMillis();
		            long totalTimeInSeconds = (endTime - startTime) / 1000;
		            System.out.println("Time taken for the scenario: " + totalTimeInSeconds + " seconds");
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Close the WebDriver
		            driver.quit();
		        }
		    }
}*/




        // Store the initial running statuses in a map
    /*    Map<String, String> initialStatusMap = new HashMap<>();

        // Set an initial timeout and interval for checking statuses
        int timeoutInSeconds = 60;
        int intervalInSeconds = 5;
        int maxRetryCount = 3; // Maximum number of retries for SocketException

        // Keep track of the start time
        long startTime = System.currentTimeMillis();

        try {
            // Create an instance of the Actions class
            Actions actions = new Actions(driver);

            // Flag to track if all statuses have changed from "data running"
            boolean allStatusesChanged = false;
            int retryCount = 0; // Initialize retry count

            // Enter the monitoring loop
            while (!allStatusesChanged && retryCount < maxRetryCount) {
                allStatusesChanged = true; // Assume all statuses have changed

                // Wait for the circles to load (adjust the locator as needed)
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
                List<WebElement> circles = driver.findElements(By.xpath("//*[name()='circle']"));

                for (WebElement circle : circles) {
                    try {
                        // Perform mouse hover over the circle
                        actions.moveToElement(circle).perform();

                        // Explicitly wait for the pop-up to appear (adjust the timeout as needed)
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));

                        // Extract the current running status from the pop-up
                        String popupText = popup.getText();

                        // Extract circle text
                        String circleText = circle.getText();

                        String initialStatus = initialStatusMap.get(circleText);

                        if (!popupText.equals(initialStatus)) {
                            allStatusesChanged = false; // Set to false if any status has changed
                            initialStatusMap.put(circleText, popupText);
                        }

                        // Move the mouse away from the circle to close the pop-up
                        actions.moveByOffset(0, 0).perform();
                    } catch (org.openqa.selenium.StaleElementReferenceException e) {
                        // Handle StaleElementReferenceException by refreshing the page
                        driver.navigate().refresh();
                        break; // Exit the loop after refresh
                    }
                }

                // If all statuses have changed, break the loop
                if (allStatusesChanged) {
                    break;
                }

                // Sleep for the specified interval before checking again
                Thread.sleep(intervalInSeconds * 1000);
            }

            // Calculate and print the time taken for the scenario
            long endTime = System.currentTimeMillis();
            long totalTimeInSeconds = (endTime - startTime) / 1000;
            System.out.println("Time taken for the scenario: " + totalTimeInSeconds + " seconds");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}*/

Map<String, String> initialStatusMap = new HashMap<>();

// Set an initial timeout and interval for checking statuses
int timeoutInSeconds = 60;
int intervalInSeconds = 5;

// Keep track of the start time
long startTime = System.currentTimeMillis();

try {
    // Wait for the circles to load (adjust the locator as needed)
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    List<WebElement> circles = driver.findElements(By.xpath("//*[name()='circle']"));

    // Create an instance of the Actions class
    Actions actions = new Actions(driver);

    // Flag to track if all statuses have changed from "data running"
    boolean allStatusesChanged = false;

    // Initialize the flag to false, assuming all statuses start as "data running"
    for (WebElement circle : circles) {
    	
    	try {   // Perform mouse hover over the circle
        actions.moveToElement(circle).perform();

        // Explicitly wait for the pop-up to appear (adjust the timeout as needed)
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));

        // Extract the current running status from the pop-up
        String popupText = popup.getText();
        
        // Extract circle text
        String circleText = circle.getText();
        
        System.out.println(circleText);
        System.out.println(popupText);

        initialStatusMap.put(circleText, popupText);

        // Move the mouse away from the circle to close the pop-up
        actions.moveByOffset(0, 0).perform();
    	}catch (StaleElementReferenceException e) {
             // Handle StaleElementReferenceException by refreshing the page
             driver.navigate().refresh();
             break; // Exit the loop after refresh
         }
    	
    }

    // Enter the monitoring loop
    while (!allStatusesChanged) {
        allStatusesChanged = true; // Assume all statuses have changed

        for (WebElement circle : circles) {
        	
        try {
            // Perform mouse hover over the circle
            actions.moveToElement(circle).perform();

            // Explicitly wait for the pop-up to appear (adjust the timeout as needed)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));

            // Extract the current running status from the pop-up
            String popupText = popup.getText();
            
            // Extract circle text
            String circleText = circle.getText();

            String initialStatus = initialStatusMap.get(circleText);
            System.out.println(circleText+"2nd");
          
            System.out.println(popupText+"2nd");
          
            
            

            if (!popupText.equals(initialStatus)) {
                allStatusesChanged = false; // Set to false if any status has changed
                initialStatusMap.put(circleText, popupText);
                System.out.println(circleText+"3rd");
                System.out.println(popupText+"3rd");
            }

            // Move the mouse away from the circle to close the pop-up
            actions.moveByOffset(0, 0).perform();
        }catch(StaleElementReferenceException e) {
			driver.navigate().refresh();
			break;
		}
        
         
      
        }

        // If all statuses have changed, break the loop
        if (allStatusesChanged) {
            break;
        }

        // Sleep for the specified interval before checking again
        Thread.sleep(intervalInSeconds * 1000);
    }

    // Calculate and print the time taken for the scenario
    long endTime = System.currentTimeMillis();
    long totalTimeInSeconds = (endTime - startTime) / 1000;
    System.out.println("Time taken for the scenario: " + totalTimeInSeconds + " seconds");
} catch (Exception e) {
    e.printStackTrace();
}

finally {
    // Close the WebDriver
    driver.quit();
}
}
}


 





