import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestParent {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver= new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //______________________________________________

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public boolean isElementPresent1(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    //_______________________________________________

    public void type(By locator, String text) {
        if(text != null){

            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text); }

    }

    public void click(By locator) {

        driver.findElement(locator).click();
    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //________________________________________

    public void fillLoginRegistrationForm(String first_name, String last_name, String email, String password, String confirm_password) {
        type(By.cssSelector("#FirstName"),first_name);
        type(By.cssSelector("#LastName"),last_name);
        type(By.cssSelector("#Email"), email);
        type(By.cssSelector("#Password"), password);
        type(By.cssSelector("#ConfirmPassword"), confirm_password);
    }



    @AfterMethod(enabled = false)


    public void tearDawn(){
        driver.quit();
    }
}
