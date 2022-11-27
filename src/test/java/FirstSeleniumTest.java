import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {
    private static final String HOME_PAGE_URL = "https://www.facebook.com/";

    public static WebDriver driver;

    @BeforeAll
    public static void classSetUp() {
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        SharedDriver.closeDriver();
    }

    @AfterEach
    public void testTearDown() {
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void homePageURLTest() {

        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");
    }

    @Test
    public void findEmailFieldTest() {
        //WebElement element = driver.findElement(By.id("email"));
        //WebElement element = driver.findElement(By.name("email"));
        //WebElement element = driver.findElement(By.linkText("Create a Page"));
        //WebElement element = driver.findElement(By.partialLinkText("a Page"));
        //WebElement element = driver.findElement(By.cssSelector("#email"));
        //WebElement element = driver.findElement(By.className("inputtext"));
        List<WebElement> element = driver.findElements(By.className("inputtext"));
        System.out.println(element.size());
        assertNotNull(element);
    }

    @Test
    public void findElementByXpathTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type ='submit']"));
        assertNotNull(loginButtonElement);
        WebElement forgotPassElement = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
        assertNotNull(forgotPassElement);
// ;
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccButton);
    }

    @Test
    public void loginScreenTest() {
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnaya@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnaya@gmail.com", emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type ='submit']"));
        assertNotNull(loginButtonElement);
        loginButtonElement.click();
    }

    @Test
    public void createNewAccTest() throws InterruptedException {
        WebElement createNewAccElement = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Alina");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Alina", firstNameValue);


        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name= 'lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Schnitzer");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Schnitzer", lastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnaya@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnaya@gmail.com", emailValue);


        WebElement passwordElement = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);


        WebElement genderFemaleElement = driver.findElement(By.xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement genderMaleElement = driver.findElement(By.xpath("//input[@value = '2']"));
        assertNotNull(genderMaleElement);
        genderMaleElement.click();

        WebElement genderCustomElement = driver.findElement(By.xpath("//input[@value = '-1']"));
        assertNotNull(genderCustomElement);
        genderCustomElement.click();
        Thread.sleep(2000);


        WebElement genderCustomOptionalElement = driver.findElement(By.xpath("//input[@name = 'custom_gender']"));
        assertNotNull(genderCustomOptionalElement);
        genderCustomOptionalElement.click();
        genderCustomOptionalElement.sendKeys("Beauty");
        String genderCustomOptionalValue = genderCustomOptionalElement.getAttribute("value");
        assertEquals("Beauty", genderCustomOptionalValue);

        WebElement signUpButtonElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }

    @Test
    public void longTextTest() throws InterruptedException {

        WebElement createNewAccElement = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement longTextFirstNameElement = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        assertNotNull(longTextFirstNameElement);
        longTextFirstNameElement.sendKeys("Asdfghjkl");
        String longTextFirstNameValue = longTextFirstNameElement.getAttribute("value");
        assertEquals("Asdfghjkl", longTextFirstNameValue);

        WebElement longTextLastNameElement = driver.findElement(By.xpath("//input[@name= 'lastname']"));
        assertNotNull(longTextLastNameElement);
        longTextLastNameElement.sendKeys("Sdfghjjklqwertty");
        String longTextLastNameValue = longTextLastNameElement.getAttribute("value");
        assertEquals("Sdfghjjklqwertty", longTextLastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnaya@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnaya@gmail.com", emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);

        WebElement genderFemaleElement = driver.findElement(By.xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement signUpButtonElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }

    @Test
    public void specialChartTest() throws InterruptedException {

        WebElement createNewAccElement = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement longTextFirstNameElement = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        assertNotNull(longTextFirstNameElement);
        longTextFirstNameElement.sendKeys("!@#$%%^^&");
        String longTextFirstNameValue = longTextFirstNameElement.getAttribute("value");
        assertEquals("!@#$%%^^&", longTextFirstNameValue);

        WebElement longTextLastNameElement = driver.findElement(By.xpath("//input[@name= 'lastname']"));
        assertNotNull(longTextLastNameElement);
        longTextLastNameElement.sendKeys("!@#$%%^^&");
        String longTextLastNameValue = longTextLastNameElement.getAttribute("value");
        assertEquals("!@#$%%^^&", longTextLastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnaya@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnaya@gmail.com", emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);

        WebElement genderFemaleElement = driver.findElement(By.xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement signUpButtonElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }


    @Test
    public void invalidEmailTest() throws InterruptedException {
        WebElement createNewAccElement = driver.findElement(By.xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Alina");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Alina", firstNameValue);


        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name= 'lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Schnitzer");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Schnitzer", lastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnayagmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnayagmail.com", emailValue);


        WebElement passwordElement = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);


        WebElement genderFemaleElement = driver.findElement(By.xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement signUpButtonElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();

    }


}
