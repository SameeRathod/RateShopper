package demoTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClickActionTest {

	@Test(invocationCount = 1)
	public void clickTest() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://goldeneye.axisrooms.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("demo@axisrooms.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Axisrooms321#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// for filter

		/*
		 * WebElement forFilter =
		 * driver.findElement(By.xpath("//i[@class='fa fa-caret-right']"));
		 * Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(d -> forFilter.isDisplayed());
		 * driver.findElement(By.xpath("//i[@class='fa fa-caret-right']")).click();
		 * 
		 * // for month WebElement forMonth =
		 * driver.findElement(By.xpath("(//button[@id='dLabel'])[2]")); Wait<WebDriver>
		 * wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); wait1.until(d ->
		 * forMonth.isDisplayed());
		 * driver.findElement(By.xpath("(//button[@id='dLabel'])[2]")).click();
		 * 
		 * // for month click List<WebElement> findElements =
		 * driver.findElements(By.xpath("//button[@class='selectorfilter_checkbox']"));
		 * 
		 * for (int i = 0; i < findElements.size(); i++) {
		 * 
		 * if (findElements.get(i).getText().equalsIgnoreCase("Nov 2023")) {
		 * 
		 * findElements.get(i).click(); break;
		 * 
		 * } } //no of adultes
		 * driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
		 * 
		 * //no of nights
		 * driver.findElement(By.xpath("(//button[@id='dLabel'])[4]")).click();
		 * Thread.sleep(3000); driver.quit();
		 * 
		 * // driver.findElement(By.xpath("//i[@class='fa fa-caret-right']")).click();
		 */

		/* Thread.sleep(3000); */

		// driver.findElement(By.xpath("//button[normalize-space()='Reload']")).click();
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
		
		Thread.sleep(420000);
		
		driver.findElement(By.xpath("//ge-header/div[1]/div[2]/div[3]/div[1]/div[1]/ge-autoload[1]/button[1]")).click();
		Thread.sleep(3000);
		/*
		 * List<WebElement> findElements2 =
		 * driver.findElements(By.xpath("//*[name()='circle']")); for (int i=0;
		 * i<findElements2.size(); i++) { while(true) { Actions actions = new
		 * Actions(driver);
		 * actions.moveToElement(findElements2.get(i)).build().perform();
		 * if(findElements2.get(i).getText()!= "Job Running") { break; }
		 * 
		 * }
		 * 
		 * }
		 */

		// Store the initial running statuses in a map
		/*Map<String, String> initialStatusMap = new HashMap<>();

		// Set an initial timeout and interval for checking statuses
		int timeoutInSeconds = 60;
		int intervalInSeconds = 5;

		// Keep track of the start time
		long startTime = System.currentTimeMillis();

		try {
			// Wait for the circles to load (adjust the locator as needed)
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			List<WebElement> circles = driver.findElements(By.xpath("//*[name()='circle']"));

			// Create an instance of the Actions class
			Actions actions = new Actions(driver);

			for (WebElement circle : circles) {
				// Extract circle ID
				String circleId = circle.getAttribute("id");

				// Perform mouse hover over the circle
				actions.moveToElement(circle).perform();

				// Wait for the pop-up to appear (adjust the locator as needed)
				WebElement popup = driver.findElement(By.xpath("//div[@class='lastUpd']"));

				// Extract and store the initial running status
				String initialStatus = popup.getText();
				initialStatusMap.put(circleId, initialStatus);

				// Move the mouse away from the circle to close the pop-up
				actions.moveByOffset(0, 0).perform();
			}

			// Enter the monitoring loop
			while (true) {
				// Refresh the page to update circle statuses
				driver.navigate().refresh();

				// Wait for the circles to load
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				boolean allStatusesChanged = true;

				for (WebElement circle : circles) {
					String circleId = circle.getAttribute("id");

					// Perform mouse hover over the circle
					actions.moveToElement(circle).perform();

					// Wait for the pop-up to appear (adjust the locator as needed)
					WebElement popup = driver.findElement(By.xpath("//div[@class='lastUpd']"));

					// Extract the current running status
					String currentStatus = popup.getText();
					String previousStatus = initialStatusMap.get(circleId);

					if (!currentStatus.equals(previousStatus)) {
						allStatusesChanged = false;
						initialStatusMap.put(circleId, currentStatus);
					}

					// Move the mouse away from the circle to close the pop-up
					actions.moveByOffset(0, 0).perform();
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
		}*/
	
	
	
	
	//2nd code
	
	//Thread.sleep(180000);

	        // Store the initial running statuses in a map
	/*        Map<String, String> initialStatusMap = new HashMap<>();

	        // Set an initial timeout and interval for checking statuses
	        int timeoutInSeconds = 60;
	        int intervalInSeconds = 5;

	        // Keep track of the start time
	        long startTime = System.currentTimeMillis();

	        try {
	            // Wait for the circles to load (adjust the locator as needed)
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        	List<WebElement> circles = driver.findElements(By.xpath("//*[name()='circle']"));

	            // Create an instance of the Actions class
	            Actions actions = new Actions(driver);

	            for (WebElement circle : circles) {
	                // Extract circle ID
	                String circleId = circle.getAttribute("id");

	                // Perform mouse hover over the circle
	                actions.moveToElement(circle).perform();

	                // Wait for the pop-up to appear (adjust the locator as needed)
	                
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));
	               // WebElement popup = driver.findElement(By.xpath("//div[@class='lastUpd']"));

	                // Extract and store the initial running status
	                String initialStatus = popup.getText();
	                initialStatusMap.put(circleId, initialStatus);

	                // Move the mouse away from the circle to close the pop-up
	                actions.moveByOffset(0, 0).perform();
	            }

	            // Enter the monitoring loop
	            while (true) {
	               

	                // Wait for the circles to load
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	                boolean allStatusesChanged = true;

	                for (WebElement circle : circles) {
	                    String circleId = circle.getAttribute("id");

	                    // Perform mouse hover over the circle
	                    actions.moveToElement(circle).perform();

	                    try {
	                        // Wait for the pop-up to appear (adjust the locator as needed)
	                    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      	                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));
	                    	//WebElement popup = driver.findElement(By.xpath("//div[@class='lastUpd']"));

	                        // Extract the current running status
	                        String currentStatus = popup.getText();
	                        String previousStatus = initialStatusMap.get(circleId);

	                        if (!currentStatus.equals(previousStatus)) {
	                            allStatusesChanged = false;
	                            initialStatusMap.put(circleId, currentStatus);
	                        }

	                        // Move the mouse away from the circle to close the pop-up
	                        actions.moveByOffset(0, 0).perform();
	                    } catch (org.openqa.selenium.StaleElementReferenceException e) {
	                        // Handle StaleElementReferenceException
	                        // Element is no longer attached to the DOM, re-locate the element
	                        WebElement updatedCircle = driver.findElement(By.id(circleId));
	                        actions.moveToElement(updatedCircle).perform();
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
	
	

		      /*  // Set an initial timeout for implicit waits
		        int timeoutInSeconds = 10;

		        // Keep track of the running status change
		        boolean allStatusesChanged = false;

		        try {
		            // Wait for the circles to load (adjust the locator as needed)
		        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		            List<WebElement> circles = driver.findElements(By.xpath("//*[name()='circle']"));

		            // Create an instance of the Actions class
		            Actions actions = new Actions(driver);

		            // Keep track of the previous running statuses
		            String[] previousStatuses = new String[circles.size()];

		            while (!allStatusesChanged) {
		                // Hover over each circle to trigger the pop-up
		                for (int i = 0; i < circles.size(); i++) {
		                    WebElement circle = circles.get(i);

		                    // Hover over the circle to display the pop-up
		                    actions.moveToElement(circle).perform();

		                    // Find the pop-up element and get the running status
		                    WebElement popup = driver.findElement(By.xpath("//div[@class='lastUpd']"));
		                    String currentStatus = popup.getText();
		                    System.out.println(currentStatus);

		                    // Check if the running status has changed from the previous status
		                    if (!currentStatus.equalsIgnoreCase(previousStatuses[i])) {
		                        previousStatuses[i] = currentStatus;
		                    }
		                }

		                // Check if all statuses have changed from "running" to something else
		                allStatusesChanged = true;
		                for (String status : previousStatuses) {
		                    if ("Job Running".equalsIgnoreCase(status)) {
		                        allStatusesChanged = false;
		                        break;
		                    }
		                }

		                // If not all statuses have changed, wait for a while before checking again
		                if (!allStatusesChanged) {
		                    Thread.sleep(5000); // Sleep for 5 seconds before checking again
		                }
		            }

		            // All running statuses have changed, break the loop
		            System.out.println("All running statuses have changed.");

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Close the WebDriver
		            driver.quit();
		        }
		    }
		}
*/




        // Store the initial running statuses in a map
    /*    Map<String, String> initialStatusMap = new HashMap<>();

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
                // Perform mouse hover over the circle
                actions.moveToElement(circle).perform();

                // Explicitly wait for the pop-up to appear (adjust the timeout as needed)
                
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lastUpd']")));

                // Extract the current running status from the pop-up
                String popupText = popup.getText();
                
                // Extract circle text
                String circleText = circle.getText();

                initialStatusMap.put(circleText, popupText);

                // Move the mouse away from the circle to close the pop-up
                actions.moveByOffset(0, 0).perform();
            }

            // Enter the monitoring loop
            while (!allStatusesChanged) {
                allStatusesChanged = true; // Assume all statuses have changed

                for (WebElement circle : circles) {
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
        Map<String, String> initialStatusMap = new HashMap<>();

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

                // Refresh the page to update circle statuses
                driver.navigate().refresh();

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
                        // Handle StaleElementReferenceException by re-locating the elements
                        circle = driver.findElement(By.xpath("//div[@class='lastUpd']"));
                        actions.moveToElement(circle).perform();
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
}




	/*
	 * List<WebElement> findElements = driver.findElements(By.xpath(
	 * "//div[@class='modal-content']/div/section/div/h2/span/i")); for(int i=0;
	 * i<findElements.size(); i++) { if(i==1) { findElements.get(i).click(); break;
	 * } }
	 */
	// driver.findElement(By.xpath("//h6[normalize-space()='19VillaMira']//i[@title='Click
	// to open this hotel in Agoda']")).click();


