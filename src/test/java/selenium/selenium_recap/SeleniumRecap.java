package selenium.selenium_recap;

import org.openqa.selenium.WebDriver;

public class SeleniumRecap {

    /*

    1. What is Selenium?

        Selenium is a testing tool, it is used to automate web applications for testing purposes
        It is an open source tool.

        Why it is widely used by companies is because it is free to use. And also it is one of leading
        testing tools.


        Advantages:

            --Free to use
            --It supports multiple browsers (Chrome, MS Edge, Safari, FireFox etc)
            --It is supported by many programming languages (Java, Python, C++, C# etc)
            --Big community (support comes from here)

        Disadvantages:

            --We cannot automate CAPTCHA (make research about this how to bypass this. Normally, this is turned off during testing),
                PICTURES, VIDEOS, BUILT IN APPLICATION, MOBILE APPLICATION
            --There is no customer support line
            --It is limited to test only web application (websites)
            --It does not have built report system (We have to use TestNG Report, Cucumber report, Spark Report etc.)

       2. What type of testing can you perform with Selenium?

            -Smoke test                             --Regression Test                       Functional test (positive/negative)

       3. What kind of testing you are not able to perform with Selenium?

             --Performance Testing
             --Manual Testing
             --Non-Functional Testing (load, stress testings)

       4. What are the locators types? What is a locator?

            Locator is way to locate web elements in the DOM (Document Object Model). Locators are basically address of web element on the website

            Locators are as follows:

                -ID
                -LinkText
                -ClassName
                -TagName
                -Name
                -PartialLinkText
                -CSS locators
                -XPATH


         5. How do you handle dynamic elements?

            We can use multiple ways of locating web elements. But as of now, we already have unique elements found, and they're pretty much stable.
            However, back in the days when we were starting, we used to face challenges while locating web elements. There I can say that we used
            'parent/child relationship, following-sibling, preceding-sibling, and contains text xpath'

         6. What is the difference between driver.get(); and driver.navigate().to();?

            NavigateTo -- it does not wait for web elements to be loaded on the web page

                          navigate has some methods such as:
                            refresh, back, forward


           driver.get(); -- it waits certain amount of time for the web page to be loaded.

                        -- this does not have methods as navigateTo does.

           7. What is the difference between driver.close and driver.quit?

             The main difference is driver.close closes only the current window where driver is located/looking at.
             Other remaining windows will stay open.

             But in driver.quit, it shuts down all opened windows (windows that were opened with selenium)


           8. What is XPATH?

                Basically, it is a way of locating web elements in the web page. It is a set of chars that is passed as an address/location of a
                web element in the web page.

           8.1 What types of XPATH do you know?

                Absolute XPATH -- it starts from the beginning of a html to the desired location

                Relative XPATH -- it directly goes to the desired location (child)

           8.2 And which one of these do you use most often?

                Obviously, I use Relative Xpath since it is reliable and focuses on parent/child location whereas Absolute xpath
                is not quite reliable since web page might get updated and would break my xpath.

          9. How do you handle dropdowns? How do you handle static dropdowns?

                First, when I inspect the DOM I normally check if this dropdown tag name is 'select', if it is
                then I have implemented re-usable methods that handle dropdown. It is implemented with Select class.

                If the tag name is not select, then I will try to sendKeys or use Action class methods to hover and click

          9.1 Select Methods

                Select select = new Select(element);

                selecting options from the dropdown:
                visibleText
                value
                index

                Other methods withing the same class:
                getOptions
                getFirstSelectedOption
                etc.

            10. What kind of Exceptions have you faced while doing automation?

                NuSuchElementException
                StaleElementReferenceException
                NullPointerException
                ElementNotIntractableException --> element is not visible
                TimeOutException
                NoSuchFrameException
                NoSuchWindowException
                UnHandledAlertException
                etc

            11. How do you handle alerts? (Popups/JS Alerts)

                We have couple type of alerts.

                One is JS Alert

                    For this type we can use some methods from Alert interface
                    Alert alert = driver.switchTo.alert();
                    alert.accept();
                    alert.dismiss();
                    alert.getText();
                    alert.sendKeys("text goes here");

                    I already have re-usable methods that I implemented very recently

                Second one is html alert

                    I treat it as normal html where I inspect and find the location of closing button



                OS Alerts - this is usually pops up from your machine/laptop/computer
                It is an alert that is built in to your machine

                    We can use Robot class.

              12. How do you handle iFrames?

                We can switch our driver to that specific iFrame either with id or name or find xpath for the iframe.

                NOTE: if you directly go inside the iframe and ignored switching your driver and locate one specific element, and when you run your automation, it will
                throw NoSuchElementException. 
                
                NOTE: if you made a mistake and provided wrong iframe id or name or xpath, you will get NoSuchFrameException
                
                12.1 How to switch the driver?
                
                    driver().switchTo.frame("id or name or xpath");
                    if we pass id or name of the iframe, it runs little slower
                    if we pass xpath of the iframe it runs little faster comparing to id/name
                    
               12.2 How do you handle nested iframes?
               
               We need to switch our driver as long as needed to the desired iframe. 
                    driver().switchTo.frame("id/name/xpath");     
                    driver().switchTo.frame("id/name/xpath");     
              
              To bring back the driver to original state:
                    driver().switchTo.defaultContent();
                    driver().parent      
                    
             13. Keyboard and mouse actions
             
                We can use Actions class. This class helps to manipulate with mouse and keyboard on the webpage
                
                Action actions = new Actions(driver);      
                actions.
                    -MoveByOffset(x,y) - moves based on the x, y off of element
                    -DoubleClick()     - double clicks
                    -SendKeys          - inputs some text into input field
                    -ContextClick      - right-click on the web element      
                    -ClickAndHold      - clicks and hold an element
                    -release           - it will release whatever it has been holding
                    -DragAndDrop       - drags an element drops
                    -MoveToElement     - it hovers over the element
                    -ScrollByAmount    - scrolls the page based on the numbers (int) provided in the method
                    -PERFORM           - this will be followed at the end of methods. MUST HAVE IT!!!
                    
                    Keyboard action  
                    
                            sendKeys("text" keys.ENTER)    
                            
              14. What is the difference between findElement and findElements?
              
                findElement  - returns single web element     -> if it fails, it throws NoSuchElementException
                
                findElements - returns list of web elements   -> if it fails, it returns empty list      
                
             
              15. Can you tell me some methods from driver and webElement?
              
               driver methods:
                    driver.get();                                                   - opens up the web page
                    driver.navigate()To()                                           - opens up web page
                    driver.manage.wait.timeouts.implicitWait(DurationofSeconds(10)) - waits for 10 seconds
                    driver.manage.window.maximize/minimize                          - maximizes/minimizes windows
                    driver.getTitle();                                              - returns string for the title
                    driver.getCurrentUrl                                            - returns string for the url
                    driver.getPageSource                                            - returns html structure
                    switchToWindow/frame/alert                                      - switches driver to desired locations
                    findElement/s                                                   - finds elements on the web page    
                    quit                                                            - shuts down all opened windows
                    close                                                           - closes current opened window
                    getWindowHandle/s                                               - returns unique set of ids
                    
          
               WebElement methods:     
               
                    getText()     - gets a text from the web page          
                    sendKeys      -inputs text into the input field
                    click         -clicks on a web element  
                    clear         -clears text from input field
                    isDisplayed   -boolean, checks if web element is displayed
                    isEnabled     -boolean, checks if element is enabled
                    getAttribute  -returns attribute's value as a string
                    getCSSValue   -returns some value from CSS (hex, back ground color etc.)
                    
               16. How do you handle multiple windows?
               
                   Get unique id of the window with the help of getWindowHandle/s
                   
                   Set<String> ids = driver.getWindowHandles - all unique id 
                   String id = driver.getWindowHandle
                   
                   I have re - usable methods to switch my driver if I need to
                   
                   We can also switch by window title if there are more than 2 windows
                   
                17. How do you scroll the page?
                
                    I can use Actions clas
                    I can use Point class
                    I can use javaScript method
                    
                18. How do you upload a file?
                    
                    I just simply sendKeys into the upload button by providing file location (/users/kuba/downloads/folder/image.png)
                    
                19. Difference between SoftAssert and hard Assert?
                
                    SoftAssert skips failure while our automation is running whereas hard Assert it stops the execution
                    However, SoftAssert has a method called assertAll, if this method is skipped, then we won't be able 
                    to see where assertion is failed. If we use this method, then we need to use it at the very end 
                    of our code. And then it will indicate where our assertion had failed when our automation ran.

                    In order to use SoftAssert, we just simply create an object from SoftAssert class:
                    SoftAssert softAssert = new SoftAssert();

                    In order to use hard Assert, we just simply use it's static method
                    Assert.assertEquals("actualData","expectedData", "informative message")

                 20. Singleton design

                    It is a way of centralizing our driver by encapsulating it. This means I use one driver across the framework.
                    Driver is initiated only from one place.

                 21. Tell me some TestNG annotations?

                    @BeforeMethod
                    @Test
                    @BeforeClass
                    @BeforeSuite
                    @AfterMethod
                    @AfterClass
                    @AfterSuite
                    @Parameters     - widely used in xml files for parametrizing test data, or setting up test suites
                    @DataProvider   - widely used for testing the same test with different sets of data


                  22. Wait times -- Synchronization Issues

                      ImplicitWaits
                            This is general wait for the web page to be loaded
                            We can specify wait time as seconds

                      ExplicitWaits
                            This is specific wait for specific element with specific conditions
                            This needs driver and web element.
                            WebDriverWait wait = new WebDriverWait(Duration.ofSeconds(10));
                           element = wait.until(ExpectedConditions.visibilityOf(element))
                            element.click();
                            if it fails based on location issue, then we will get TimeOutException


                      FluentWaits
                            This will work exactly the same as explicit wait except it adds frequency(periodically) on how often
                            one specific element is available/visible


                    
               
                         























     */


}
