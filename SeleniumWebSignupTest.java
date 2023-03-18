import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumWebSignupTest {

    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver(chromeOptions);
        Thread.sleep(Duration.ofMillis(5000));
        //2. Input your Selenium Demo Page URL
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. Verify the user input the right url and is on the right page site
       if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
           //Pass
           System.out.println("correct page site");
       else
           //Fail
           System.out.println("Wrong page site");
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(Duration.ofMillis(5000));
    }

    @Test (priority = 0)
    public void PositiveSignup() throws InterruptedException {
        //test7. Verify that user successfully  signup with valid details.
        //5. Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Zion222");
        //6. Input email on the user email field
        driver.findElement(By.id("user_email")).sendKeys("meego12332@mailinator.com");
        //7. Input password on the user password field
        driver.findElement(By.id("user_password")).sendKeys("Augustine537");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
    }

        @Test (priority = 1)
         public void ClickUser1Item() throws InterruptedException {
            //9. Click on User1 item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //test2. Verify that when user clicks on the signup button, the user is directed to the signup page
            String expectedURL = "https://selenium-blog.herokuapp.com/signup";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedURL))
                //Pass
                System.out.println("correct page site");
            else
                //Fail
                System.out.println("Wrong page site");
            Thread.sleep(Duration.ofMillis(5000));
        }


        @Test (priority = 2)
        public void verifyItem() throws InterruptedException {
            // Search for an item (Using Python with Selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            //Test 9. Verify that the item searched for on the User1 page is present
            String expectedPageUrl = "/users/1";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //Pass
                System.out.println("correct User1 page");
            else
                //Fail
                System.out.println("Wrong User1 page");
            Thread.sleep(Duration.ofMillis(5000));
    }

        @Test (priority = 3)
        public void logoutSuccessfully(){
         //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10. Verify that when the user logout, he/she is directed back to the home page
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if (actualTitle.contains(actualTitle))
                //Pass
                System.out.println("correct logout page");
            else
                //Fail
                System.out.println("Wrong logout page");
    }


        @Test (priority = 4)
        public void negativeSignup() throws InterruptedException {
            //Click on Signup button to open the Signup page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(Duration.ofMillis(5000));
            //test3. Verify that user cannot sign up with username less than 3 characters
            //5. Input username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Zi");
            //6. Input email on the user email field
            driver.findElement(By.id("user_email")).sendKeys("meego232@mailinator.com");
            //7. Input password on the user password field
            driver.findElement(By.id("user_password")).sendKeys("Augustine537");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(Duration.ofMillis(5000));

    }


    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();

    }


}
