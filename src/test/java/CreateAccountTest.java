import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestParent{

    public void ensurePreconditions() {
        //precondition: user should be logged out
        if (!isElementPresent(By.xpath(""))){
            click(By.xpath(""));
        } else {
            //click on LOGIN link
            click(By.xpath(""));
        }
    }

    @Test
    public void createAccountMaleTest(){
        int i = (int) ((System.currentTimeMillis()/1000) % 3600);
        //assert is registration form displayed
        Assert.assertTrue(isElementPresent1(By.cssSelector("a.ico-register")));
        click(By.cssSelector("a.ico-register"));
        click(By.cssSelector("[value='M']"));
        fillLoginRegistrationForm("An"+ i,"Ivanov","email"+ i +"@gmail.com", "Aa12345~","Aa12345~");
        click(By.cssSelector("#register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".button-1.register-continue-button")));
        click(By.cssSelector(".button-1.register-continue-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector("a.ico-logout")));
    }

    @Test
    public void createAccountFemaleTest(){
        int i = (int) ((System.currentTimeMillis()/1000) % 3600);
        //assert is registration form displayed
        Assert.assertTrue(isElementPresent1(By.cssSelector("a.ico-register")));
        click(By.cssSelector("a.ico-register"));
        click(By.cssSelector("[value='F']"));
        fillLoginRegistrationForm("An"+ i,"Ivanova","email"+ i +"@gmail.com", "Aa12345~","Aa12345~");
        click(By.cssSelector("#register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".button-1.register-continue-button")));
        click(By.cssSelector(".button-1.register-continue-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector("a.ico-logout")));
    }


}
