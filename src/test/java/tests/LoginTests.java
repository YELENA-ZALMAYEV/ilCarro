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
     //Assert --> if element with text "Logged in success" is present
     app.getHelperUser().LoggedInSuccess(); //clickOkButton

       // Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        // app.getHelperUser().clickOkButton();
     Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("pap@gmail.com","@1234567Qq@");
        app.getHelperUser().submitLogin();
        //Assert --> if element with text "Logged in success" is present
        Assert.assertTrue(app.getHelperUser().isLogged());

        //Assert --> if element with text "Logged in success" is present
       // Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOkButton();
        //app.getHelperUser().clickOkButton();

    }
//    @Test
//    public  void RegistrationSuccess(){
//      app.getHelperUser().openRegistrationForm();
//      app.getHelperUser().fillRegistrationForm("el", "z","pa@gmail.com","@Q1234567q@");
//      app.getHelperUser().isRegistered();
//
//        Assert.assertTrue(app.getHelperUser().isRegistered());
//    }
}
