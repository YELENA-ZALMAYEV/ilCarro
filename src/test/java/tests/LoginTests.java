package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @BeforeMethod
    public  void  preCondition(){
      if (app.getHelperUser().isLogged()){
          app.getHelperUser().logout();
      }
  }
    @Test
    public  void  LoginSuccess(){
     app.getHelperUser().openLoginForm();
     app.getHelperUser().fillLoginForm("pap@gmail.com","@1234567Qq@");
     app.getHelperUser().submitLogin();

     Assert.assertTrue(app.getHelperUser().isLogged());

    }

//    @BeforeMethod
//    public void preCondition(){
//        if (app.getHelperUser().isRegistered()){
//            app.getHelperUser().logout();
//        }
//    }
//    @Test
//    public  void RegistrationSuccess(){
//      app.getHelperUser().openRegistrationForm();
//      app.getHelperUser().fillRegistrationForm("el", "z","pa@gmail.com","@Q1234567q@");
//      app.getHelperUser().isRegistered();
//
//        Assert.assertTrue(app.getHelperUser().isRegistered());
//    }
}
