package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a[href^='/login']"));
        //click(By.xpath("//*[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submit() {
        click(By.cssSelector("button[type='submit']"));
        //  click(By.xpath("//*[@type='submit']"));
    }

    public void LoggedInSuccess() {
        click(By.cssSelector("[type='button']"));


    }
    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))){
        click(By.xpath("//button[text()='Ok']"));}
    }
    public String getMessage() {
     //   pause(1000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
        //if need pause to wait need to use // multithreading // --> Helper Base --> method pause

     //   WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
      //  String text = element.getText();
      //  return text;
    }
    public boolean isLogged() {
        return isElementPresent(By.cssSelector("a[href^='/logout']"));
    }

    public void logout() {
        click(By.cssSelector("a[href^='/logout']"));

    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
     boolean res = isElementPresent(By.cssSelector("button[disabled]"));

     WebElement element = wd.findElement(By.cssSelector("button[type='submit'"));
     boolean result = element.isEnabled();

     return res && !result;

    }

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() { //box
       // click(By.id("terms-of-use")); 0*0

       //2
       // click(By.cssSelector("label[for='terms-of-use']")); //Terms of use

        //3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");


    }
     public  void  checkPolicyXY(){
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) { //check if unchek ceknutui ili ne cheknutui
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rect = label.getRect(); //getRect - all coordinats  of element
            int w = rect.getWidth();

            // Dimension size = wd.manage().window().getSize(); - size of window coordinat

            int xOffSet = -w / 2; //to the left -

            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();

        }
     }
}

