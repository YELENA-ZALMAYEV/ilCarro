package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {
     static ApplicationManager app = new ApplicationManager();

     @BeforeSuite
    public  void  setUp(){
         app.init();
     }

     @AfterSuite
    public void tearDown(){
         app.stop();
     }
}
