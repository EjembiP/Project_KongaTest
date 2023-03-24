import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 PROCESS FLOW
 We want to automate the ordering flow of Konga as an existing customer following the steps described below
 - Visit the URL Konga
 - Sign in to Konga Successfully
 - From the Categories, click on the “Computers and Accessories”
 - Click on the Laptop SubCategory
 - Click on the Apple MacBooks
 - Add an item to the cart
 - Select Address
 - Continue to make payment
 - Select a Card Payment Method
 - Input invalid card details
 - Print Out the error message: Invalid card number
 - Close the iFrame that displays the input card Modal
 - Quit the browser.
 */

public class Konga_Product_Purchase_Test {

    private WebDriver driver;
    private By modalBtn = By.xpath(".//*[@id=\"channel-template\"]/div[2]/div/div[2]/button");
    private By checkOut_iFrame = By.xpath("//*[@id='kpg-frame-component']");


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver(chromeOptions);
        //2. Visit the URL Konga
        driver.get("https://www.konga.com");
        //Test1. Verify the user input the right url and is on the right page site
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            System.out.println("correct page site");
        else
            //Fail
            System.out.println("Wrong page site");
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
    }


    @Test (priority = 0)
    public void Login() throws InterruptedException {
        //5. Input email on the user email field
        driver.findElement(By.id("username")).sendKeys("@gmail.com");
        //6. Input password on the user password field
        driver.findElement(By.id("password")).sendKeys("password@");
        //7. Click on the signup button
       driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        String expectedURL = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedURL))
            //Pass
            System.out.println("correct Login details");
        else
            //Fail
            System.out.println("Wrong Login details");
        Thread.sleep(7000);




    }
    @Test (priority = 1)
    public void Computers_and_accessories() throws InterruptedException {
        //8. Click on Computers_and_accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
        //9. Click on the Laptop
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        //10. Click on the Apple MacBooks
        Thread.sleep(7000);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(7000);
        //11.Add an Apple MacBook to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(7000);
        String expectedURL = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedURL))
            //Pass
            System.out.println("Right product MacBooks Selected");
        else
            //Fail
            System.out.println("Wrong product MacBooks Selected");
        Thread.sleep(7000);



    }
;
    @Test (priority = 2)
    public void Go_To_Cart() throws InterruptedException {

        //12. Go to cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        String expectedURL = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedURL))
            //Pass
            System.out.println("Right product added to cart");
        else
            //Fail
            System.out.println("Wrong product added to cart");
        Thread.sleep(10000);

    }


    @Test(priority = 3)
    public void Address() throws InterruptedException {
        //click on checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
        //Test7 Select address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(7000);
        //click on pickup address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(7000);
        //choose canal street
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(7000);
        //Pay now button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        //click on continue payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        String expectedURL = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedURL))
            //Pass
            System.out.println("payment page passed");
        else
            //Fail
            System.out.println("payment page failed");
        Thread.sleep(15000);


    }

    @Test(priority = 4)
        //16. Select a card payment method
    public void clickOnPaymentType() throws InterruptedException {
        WebElement checkOutFrame = this.driver.findElement(this.checkOut_iFrame);
        this.driver.switchTo().frame(checkOutFrame);
        this.driver.findElement(this.modalBtn).click();

        Thread.sleep(3000L);


    }

    @Test (priority = 5)
    public void CardDetails () throws InterruptedException {
        //17. Input invalid card details
        //Locate the card number field and input card number
        driver.findElement(By.id("card-number")).sendKeys("4920690007049288");
        //Locate the password field and Input your password on the username field
        driver.findElement(By.id("expiry")).sendKeys("0724");
        //input cvv
        driver.findElement(By.id("cvv")).sendKeys("327");
        Thread.sleep(5000);
        // Click on the pay mow button
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);

        //Test 11 Print Out the error message: Invalid card number
        System.out.println("Invalid Card Number");

    }


    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();

    }



}