import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class FirstSeleniumTest {
    private static final String HOME_PAGE_URL = "https://www.facebook.com/";

    private static WebDriver driver;

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
        List<WebElement> element = driver.findElements(className("inputtext"));
        System.out.println(element.size());
        assertNotNull(element);
    }

    @Test
    public void findElementByXpathTest() {
        WebElement emailElement = driver.findElement(xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        WebElement loginButtonElement = driver.findElement(xpath("//button[@type ='submit']"));
        assertNotNull(loginButtonElement);
        WebElement forgotPassElement = driver.findElement(xpath("//a[text()='Forgot password?']"));
        assertNotNull(forgotPassElement);
// ;
        WebElement createNewAccButton = driver.findElement(xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccButton);
    }

    @Test
    public void loginScreenTest() {
        WebElement emailElement = driver.findElement(xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnaya@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnaya@gmail.com", emailValue);

        WebElement passwordElement = driver.findElement(xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);

        WebElement loginButtonElement = driver.findElement(xpath("//button[@type ='submit']"));
        assertNotNull(loginButtonElement);
        loginButtonElement.click();
    }

    @Test
    public void createNewAccTest() throws InterruptedException {
        WebElement createNewAccElement = driver.findElement(xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement firstNameElement = driver.findElement(xpath("//input[@name = 'firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Alina");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Alina", firstNameValue);


        WebElement lastNameElement = driver.findElement(xpath("//input[@name= 'lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Schnitzer");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Schnitzer", lastNameValue);

        WebElement emailElement = driver.findElement(xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnaya@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnaya@gmail.com", emailValue);


        WebElement passwordElement = driver.findElement(xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);


        WebElement genderFemaleElement = driver.findElement(xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement genderMaleElement = driver.findElement(xpath("//input[@value = '2']"));
        assertNotNull(genderMaleElement);
        genderMaleElement.click();

        WebElement genderCustomElement = driver.findElement(xpath("//input[@value = '-1']"));
        assertNotNull(genderCustomElement);
        genderCustomElement.click();
        Thread.sleep(2000);


        WebElement genderCustomOptionalElement = driver.findElement(xpath("//input[@name = 'custom_gender']"));
        assertNotNull(genderCustomOptionalElement);
        genderCustomOptionalElement.click();
        genderCustomOptionalElement.sendKeys("Beauty");
        String genderCustomOptionalValue = genderCustomOptionalElement.getAttribute("value");
        assertEquals("Beauty", genderCustomOptionalValue);

        WebElement signUpButtonElement = driver.findElement(xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdfghjklqwertyuiop"})
    public void longTextTest(String longTextInput) throws InterruptedException {

        WebElement createNewAccElement = driver.findElement(xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement longTextFirstNameElement = driver.findElement(xpath("//input[@name = 'firstname']"));
        assertNotNull(longTextFirstNameElement);
        longTextFirstNameElement.sendKeys(longTextInput);
        String longTextFirstNameValue = longTextFirstNameElement.getAttribute("value");
        assertEquals(longTextInput, longTextFirstNameValue);

        WebElement longTextLastNameElement = driver.findElement(xpath("//input[@name= 'lastname']"));
        assertNotNull(longTextLastNameElement);
        longTextLastNameElement.sendKeys(longTextInput);
        String longTextLastNameValue = longTextLastNameElement.getAttribute("value");
        assertEquals(longTextInput, longTextLastNameValue);

        WebElement emailElement = driver.findElement(xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys(longTextInput);
        String emailValue = emailElement.getAttribute("value");
        assertEquals(longTextInput, emailValue);

        WebElement passwordElement = driver.findElement(xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys(longTextInput);
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals(longTextInput, passwordValue);

        WebElement genderFemaleElement = driver.findElement(xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement signUpButtonElement = driver.findElement(xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#$%%^^&"})
    public void specialChartTest(String specialCharacterInput) throws InterruptedException {

        WebElement createNewAccElement = driver.findElement(xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement longTextFirstNameElement = driver.findElement(xpath("//input[@name = 'firstname']"));
        assertNotNull(longTextFirstNameElement);
        longTextFirstNameElement.sendKeys(specialCharacterInput);
        String longTextFirstNameValue = longTextFirstNameElement.getAttribute("value");
        assertEquals(specialCharacterInput, longTextFirstNameValue);

        WebElement longTextLastNameElement = driver.findElement(xpath("//input[@name= 'lastname']"));
        assertNotNull(longTextLastNameElement);
        longTextLastNameElement.sendKeys(specialCharacterInput);
        String longTextLastNameValue = longTextLastNameElement.getAttribute("value");
        assertEquals(specialCharacterInput, longTextLastNameValue);

        WebElement emailElement = driver.findElement(xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys(specialCharacterInput);
        String emailValue = emailElement.getAttribute("value");
        assertEquals(specialCharacterInput, emailValue);

        WebElement passwordElement = driver.findElement(xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys(specialCharacterInput);
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals(specialCharacterInput, passwordValue);

        WebElement genderFemaleElement = driver.findElement(xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement signUpButtonElement = driver.findElement(xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }


    @Test
    public void invalidEmailTest() throws InterruptedException {
        WebElement createNewAccElement = driver.findElement(xpath("//*[text() = 'Create new account']"));
        assertNotNull(createNewAccElement);
        createNewAccElement.click();
        Thread.sleep(2000);

        WebElement firstNameElement = driver.findElement(xpath("//input[@name = 'firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Alina");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Alina", firstNameValue);


        WebElement lastNameElement = driver.findElement(xpath("//input[@name= 'lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Schnitzer");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Schnitzer", lastNameValue);

        WebElement emailElement = driver.findElement(xpath("//input[@name= 'reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("alinahijnayagmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("alinahijnayagmail.com", emailValue);


        WebElement passwordElement = driver.findElement(xpath("//input[@name = 'reg_passwd__']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("1234567");
        String passwordValue = passwordElement.getAttribute("value");
        assertEquals("1234567", passwordValue);


        WebElement genderFemaleElement = driver.findElement(xpath("//input[@value = '1']"));
        assertNotNull(genderFemaleElement);
        genderFemaleElement.click();

        WebElement signUpButtonElement = driver.findElement(xpath("//button[@name='websubmit']"));
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }

    @Test
    public void signUpTest() {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
    }

    @Test
    public void gendersTest() throws InterruptedException {
        String femaleXpath = "//*[@name= 'sex' and @value= 1]";
        String maleXpath = "//*[@name= 'sex' and @value= 2]";

        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        //verify female gender is checked
        WebElement femaleButton = driver.findElement(By.xpath(femaleXpath));
        femaleButton.click();
        String isFemaleChecked = driver.findElement(By.xpath(femaleXpath)).getAttribute("checked");
        assertNotNull(isFemaleChecked);
        assertEquals("true", isFemaleChecked);


        //verify male gender is checked
        WebElement maleButton = driver.findElement(By.xpath(maleXpath));
        maleButton.click();
        String isMaleChecked = driver.findElement(By.xpath(maleXpath)).getAttribute("checked");
        assertNotNull(isMaleChecked);
        assertEquals("true", isMaleChecked);
    }

    @Test
    public void errorMessageTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//* [@name = 'websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label = 'Mobile number or email']")).click();
        WebElement error = driver.findElement(By.xpath("//*[contains(text(),'to reset')]"));
        assertNotNull(error);

        driver.findElement(By.xpath("//*[@aria-label= 'First name']")).click();
        WebElement errorFirstNameBox = driver.findElement(By.xpath("//*[contains(text(), 'your name')]"));
        assertNotNull(errorFirstNameBox);

        driver.findElement(By.xpath("//*[@aria-label= 'Last name']")).click();
        WebElement errorLastNameBox = driver.findElement(By.xpath("//*[contains(text(), 'your name')]"));
        assertNotNull(errorLastNameBox);

        driver.findElement(By.xpath("//*[@aria-label= 'New password']")).click();
        WebElement errorPasswordBox = driver.findElement(By.xpath("//*[contains(text(), 'at least six')]"));
        assertNotNull(errorPasswordBox);

        driver.findElement(By.xpath("//*[@data-name= 'birthday_wrapper']")).click();
        WebElement errorBirthDayBox = driver.findElement(By.xpath("//*[contains(text(), 'real birthday')]"));
        assertNotNull(errorBirthDayBox);


    }


    @Test
    public void yearTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@title = 'Year']")).click();
        driver.findElement(By.xpath("//*[text()= '1990']")).click();
        String yearValue = driver.findElement(By.xpath("//*[@title = 'Year']")).getAttribute("value");
        assertEquals("1990", yearValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Jan", "Jun", "Dec"})
    public void monthTest(String monthInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@title = 'Month']")).click();
        driver.findElement(By.xpath("//*[text() = '" + monthInput + "']")).click();
        String monthValue = driver.findElement(By.xpath("//*[@title = 'Month']")).getAttribute("value");
        assertNotNull(monthInput, monthValue);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "31"})
    public void birthDayTest(String birthDayInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@title = 'Day']")).click();
        driver.findElement(By.xpath("//*[text() = '" + birthDayInput + "']")).click();
        String birthDayValue = driver.findElement(By.xpath("//*[@title = 'Day']")).getAttribute("value");
        assertNotNull(birthDayInput, birthDayValue);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1905", "1950", "2022"})

    public void yearTestParametrized(String yearInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@title = 'Year']")).click();
        driver.findElement(By.xpath("//*[text()= '" + yearInput + "']")).click();
        String yearValue = driver.findElement(By.xpath("//*[@title = 'Year']")).getAttribute("value");
        assertEquals(yearInput, yearValue);
    }
     // find element by sibling
    @Test
    public void radioButtonsTestSiblings() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Female']//following-sibling::*[@type='radio']")).click();
        driver.findElement(By.xpath("//*[text()='Male']//following-sibling::*[@type='radio']")).click();
        driver.findElement(By.xpath("//*[text()='Custom']//following-sibling::*[@type='radio']")).click();


        driver.findElement(By.xpath("//input[@type='radio']//preceding-sibling::*[text()='Female']")).click();
        driver.findElement(By.xpath("//input[@type='radio']//preceding-sibling::*[text()='Male']")).click();
        driver.findElement(By.xpath("//input[@type='radio']//preceding-sibling::*[text()='Custom']")).click();

        pause();
    }

    //find by parent/child
    @Test
    public void radioButtonBirthDayTest () throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

//        driver.findElement(By.xpath("//*[@data-name='birthday_wrapper']//descendant::*[@id='month']")).click();
//        driver.findElement(By.xpath("//*[@data-name='birthday_wrapper']//descendant::*[@id='day']")).click();
//        driver.findElement(By.xpath("//*[@data-name='birthday_wrapper']//descendant::*[@id='year']")).click();



       driver.findElement(By.xpath("//*[@id='month']//ancestor::*[@data-name='birthday_wrapper']")).click();
       driver.findElement(By.xpath("//*[@id='day']//ancestor::*[@data-name='birthday_wrapper']")).click();
       driver.findElement(By.xpath("//*[@id='year']//ancestor::*[@data-name='birthday_wrapper']")).click();
        pause();
    }

    @Test
    public void termsLinkTest () throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id ='terms-link']")).click();
        for (String terms : driver.getWindowHandles()) {
            driver.switchTo().window(terms);
        }
        driver.getCurrentUrl();
    }
    @Test
            public void policyLinkTest() throws InterruptedException {

        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id ='privacy-link']")).click();
        for (String terms : driver.getWindowHandles()) {
            driver.switchTo().window(terms);
        }
        driver.getCurrentUrl();
    }

    @Test
            public void cookiesLinkTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(xpath("//*[text() = 'Sign Up']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id ='cookie-use-link']")).click();
        for(String terms : driver.getWindowHandles()){
            driver.switchTo().window(terms);
        }
        driver.getCurrentUrl();

    }



    @Test
    public void davikHomeButtonTest (){
        driver.navigate().to("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = driver.findElement(By.xpath("//a[text()= 'Home']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Home']"))).click();
        pause();
    }

    @Test
    public void davikCompanyButtonTest (){
        driver.navigate().to("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = driver.findElement(By.xpath("//a[text()= 'Company']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Company']"))).click();
        pause();
    }
    @Test
    public void davikProductsButtonTest (){
        driver.navigate().to("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = driver.findElement(By.xpath("//a[text()= 'Products']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Products']"))).click();
        pause();
    }

    @Test
    public void davikIndustriesButtonTest (){
        driver.navigate().to("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = driver.findElement(By.xpath("//a[text()= 'Industries']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Industries']"))).click();
        pause();
    }

    @Test
    public void davikKnowledgeCenterButtonTest (){
        driver.navigate().to("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = driver.findElement(By.xpath("//a[text()= 'Knowledge Center']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Knowledge Center']"))).click();
        pause();
    }

    @Test
    public void davikContactButtonTest (){
        driver.navigate().to("https://www.daviktapes.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = driver.findElement(By.xpath("//*[text()= 'CONTACT']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='CONTACT']"))).click();
        pause();
    }



    @Test
    public void actionTest() {
        driver.get("https://www.daviktapes.com/");
//        pause();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Company']")));
      //  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='Company']")));

        WebElement element = driver.findElement(By.xpath("//a[text()='Company']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    @Test
    public void waitAndClickTest() {
        driver.get("https://www.daviktapes.com/");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        //   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Company']"))).click();
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Company']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Company']"))).click();

        pause();
    }


    public void pause() {
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            System.out.println("Something went wrong");
        }
    }

    public void smallPause() {
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println("Something went wrong");
        }
    }

    public void largePause() {
        try {
            Thread.sleep(10000);
        } catch (Exception err) {
            System.out.println("Something went wrong");
        }
    }


}