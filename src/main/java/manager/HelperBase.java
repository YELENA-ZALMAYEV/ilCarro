package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        if (text != null){
            element.sendKeys(text);
        }
    }
    public  boolean isElementPresent(By locator){
        List <WebElement> list =  wd.findElements(locator);
        return list.size()>0;

        //return wd.findElements(locator).size()>0;
    }

    public  void  pause(int time){
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
