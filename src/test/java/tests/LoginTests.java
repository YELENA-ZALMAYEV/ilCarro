package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        // app.getHelperUser().clickOkButton();
    // Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("pap@gmail.com", "@1234567Qq@");
        app.getHelperUser().submitLogin();
        //Assert --> if element with text "Logged in success" is present
        // Assert.assertTrue(app.getHelperUser().isLogged());

        //Assert --> if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
        //app.getHelperUser().clickOkButton();
    }

        @Test
        public void loginWrongEmail(){
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("papgmail.com","@1234567Qq@");
            app.getHelperUser().submitLogin();
            //cw
            Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
            Assert.assertTrue(app.getHelperUser().clickOnButtonYallaIsNotActive());
        }

        @Test
        public void loginWrongPassword(){
                                 //.withEmail               .withPassword
            User user = new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@"); //+ method fillLogin with user

//        user.setEmail("pap@gmail.com");
//        user.setPassword("@1234567Qq@");

            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("pap@gmail.com","@1234567q@");
            app.getHelperUser().submitLogin();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");// (new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@"))
         //   Assert.assertEquals(app.getHelperUser().getMessage(), "Login or Password incorrect");//"

    }

    @Test
    public void loginIsEmpty(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("","@1234567Qq@");
        app.getHelperUser().submitLogin();
        //cw
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().clickOnButtonYallaIsNotActive());
    }
//    @Test
//    public void passwordIsEmpty(){
//        app.getHelperUser().openLoginForm();
//        app.getHelperUser().fillLoginForm("papgmail.com","");
//        app.getHelperUser().submitLogin();
//        //cw
//        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
//        Assert.assertTrue(app.getHelperUser().clickOnButtonYallaIsNotActive());
//    }

         @Test
         public void loginUnregistered(){
             app.getHelperUser().openLoginForm();
             app.getHelperUser().fillLoginForm("qqq@gmail.com","qqq234567Qq@");
             app.getHelperUser().submitLogin();
             Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

@AfterMethod
    public  void postCondition(){
      app.getHelperUser().clickOkButton();
}

    }
//    @Test
//    public  void RegistrationSuccess(){
//      app.getHelperUser().openRegistrationForm();
//      app.getHelperUser().fillRegistrationForm("el", "z","pa@gmail.com","@Q1234567q@");
//      app.getHelperUser().isRegistered();
//
//        Assert.assertTrue(app.getHelperUser().isRegistered());
//    }

