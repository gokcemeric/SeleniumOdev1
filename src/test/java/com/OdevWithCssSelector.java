package com;

        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class OdevWithCssSelector {

    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver","/Users/gokce.meric/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,30);
    }

    //Ödev 1
    @Test
    public void createIndividualUser() throws InterruptedException {


        driver.get("https://www.sahibinden.com/kayit");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
        WebElement username = driver.findElement(By.cssSelector("#name"));
        username.sendKeys( "Gökçe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#surname")));
        WebElement surname= driver.findElement(By.cssSelector("#surname"));
        surname.sendKeys("Meriç");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        WebElement email= driver.findElement(By.cssSelector("#email"));
        email.sendKeys("abc"+(Math.random()*100)+"@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        WebElement password =driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Password1");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#endUserLicenceAgreement').click()");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signUpButton")));
        WebElement signUpBotton = driver.findElement(By.cssSelector("#signUpButton"));
        signUpBotton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#confirmSubmit")));
        WebElement confirmSubmit = driver.findElement(By.cssSelector("#confirmSubmit"));
        confirmSubmit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#container .email-activation .email")));
        String returnEmail = driver.findElement(By.cssSelector("#container .email-activation .email")).getText();
        System.out.println(returnEmail);
    }
    //Ödev 2
    @Test
    public void createCorporateUser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/gokce.meric/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        driver.get("https://secure.sahibinden.com/kayit/kurumsal/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
        WebElement username = driver.findElement(By.cssSelector("#name"));
        username.sendKeys( "Gökçe");
        System.out.println(username.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#surname")));
        WebElement surname= driver.findElement(By.cssSelector("#surname"));
        surname.sendKeys("Meriç");
        System.out.println(surname.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        WebElement email= driver.findElement(By.cssSelector("#email"));
        email.sendKeys("abc"+(Math.random()*100)+"@gmail.com");
        System.out.println(email.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        WebElement password =driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Password1");
        System.out.println(password.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#category")));
        Select realEstateSelect = new Select(driver.findElement(By.cssSelector("#category")));
        realEstateSelect.selectByVisibleText("Emlak");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#city")));
        Select citySelect = new Select(driver.findElement(By.cssSelector("#city")));
        citySelect.selectByVisibleText("İstanbul");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#town")));
        Select townSelect = new Select(driver.findElement(By.cssSelector("#town")));
        townSelect.selectByVisibleText("Fatih");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#quarter")));
        Select quarterSelect = new Select(driver.findElement(By.cssSelector("#quarter")));
        quarterSelect.selectByVisibleText("Sümbül Efendi Mh.");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Limited veya Anonim Şirketi']")));
        driver.findElement(By.xpath("//label[text()='Limited veya Anonim Şirketi']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#taxOfficeCity")));
        Select taxOfficeCitySelect = new Select(driver.findElement(By.cssSelector("#taxOfficeCity")));
        taxOfficeCitySelect.selectByVisibleText("İstanbul");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#taxOffice")));
        Select taxOfficeSelect = new Select(driver.findElement(By.cssSelector("#taxOffice")));
        taxOfficeSelect.selectByVisibleText("Fatih Vergi Dairesi");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#taxNumber")));
        WebElement taxNumber = driver.findElement(By.cssSelector("#taxNumber"));
        taxNumber.sendKeys("7498365395");
        System.out.println(taxNumber.getAttribute("placeholder"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#endUserLicenceAgreement').click()");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signUpButton")));
        WebElement signUpBotton = driver.findElement(By.cssSelector("#signUpButton"));
        signUpBotton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#confirmSubmit")));
        WebElement confirmSubmit = driver.findElement(By.cssSelector("#confirmSubmit"));
        confirmSubmit.click();

    }
    @AfterEach
    public void afterEach(){
        driver.quit();

    }


}
