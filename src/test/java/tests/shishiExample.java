package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class shishiExample {

    @Test
    public  void  openPageUserMenu(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://shishi.co.il/auth/user/");

       // float ci_session;
        Cookie cookie = new Cookie("ci_session","8458b04e7eb6af84e567f78a2c3d4016cc06b460") ;
        driver.manage().addCookie(cookie);
      //  pause (5);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().refresh();

       //личный кабинет
       // driver.quit();

    }
//    private  void  pause (int time){
//        try {
//            Thread.sleep(time * 1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
