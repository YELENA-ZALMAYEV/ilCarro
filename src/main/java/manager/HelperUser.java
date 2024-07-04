package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));
    }

    public void LoggedIn() {
        click(By.cssSelector("[type='button']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.cssSelector("a[href^='/logout']"));
    }

    public void logout() {
        click(By.cssSelector("a[href^='/logout']"));

    }
//
//    public  void  openRegistrationForm(){
//        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Sign up']"));
//    }
//
//    public void fillRegistrationForm (String name, String lastName, String email, String password){
//        type(By.id("name"), name);
//        type(By.id("lastName"), lastName);
//        type(By.id("email"),email);
//        type(By.id("password"), password);
//      //  click(By.tagName("input='opacity: 1'"));
//
//    }
//    public  void submitResistrButton(){
//        click(By.cssSelector("button[type='submit']"));
//
//    }
//   //public  void LoggedIn() {
//     //  click(By.name("Ok"));
//   ///}
//    public boolean isRegistered() {
//       return isElementPresent(By.xpath("//button[text()='Delete account']"));
//    }


   // public  void logout(){
   //     click(By.xpath("//button[text()='Logout']"));
    }

