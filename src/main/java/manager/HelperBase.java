package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

//generate
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public  void click (By locator){
       // WebElement element = wd.findElement(locator);
       //  element.click();
        wd.findElement(locator).click();
    }

    public  void type (By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
       // element.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        clearNew(element);
       // element.sendKeys(Keys.DELETE);
        if (text != null){
            element.sendKeys(text);
        }
    }
    public  void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }
    public  void clearTextField(By locator){
        WebElement element = wd.findElement(locator);
        String os = System.getProperty("os.name");
        if (os.startsWith("Win")){
            element.sendKeys(Keys.CONTROL, "a");
        }else{
            element.sendKeys(Keys.COMMAND, "a");
        }
        element.sendKeys(Keys.DELETE);
    }

    public  String getMessege(){
        pause(1000);
        return  wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
        //        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        //        String text = element.getText();
        //        return text;
    }

    public void  submit(){
        click(By.xpath("//*[@type='submit']"));
    }

    public  boolean isElementPresent(By locator){
       // List <WebElement> list =  wd.findElements(locator);
     //   return list.size()>0;

        return wd.findElements(locator).size()>0;
    }

    public  void  pause(int time){
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public  boolean isAlertPresent (String message){
        Alert alert = new WebDriverWait(wd, 20).until(ExpectedConditions.alertIsPresent());
        if (alert!= null&& alert.getText().contains(message)){
            System.out.println(alert.getText());
            return true;
        }
        return false;
    }

    public void  getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));


        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled();

        return res && !result;
    }
    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();

    }
}
