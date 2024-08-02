package tests;

import manager.DataProviderUser;
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
    @Test (dataProvider = "loginData", dataProviderClass = DataProviderUser.class)   //............+ list
    public  void  LoginSuccess(String email, String password){ //..........
      logger.info("Start methot loginSuccess");
      logger.info("Test data");
     app.getHelperUser().openLoginForm();
     app.getHelperUser().fillLoginForm(email,password);    //.........
     app.getHelperUser().submit();
         //Assert --> if element with text "Logged in success" is present

     app.getHelperUser().LoggedInSuccess(); //clickOkButton
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        // app.getHelperUser().clickOkButton();
    // Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test (dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)   //............+ list
    public  void  LoginSuccess(User user){
        logger.info("Start methot loginSuccess");
        logger.info("Test data");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().LoggedInSuccess(); //clickOkButton
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }



    @Test (dataProvider = "loginModels", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
         logger.info("test data--" + user.toString());

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("pap@gmail.com", "@1234567Qq@");
        app.getHelperUser().submit();
        //Assert --> if element with text "Logged in success" is present
        // Assert.assertTrue(app.getHelperUser().isLogged());

        //Assert --> if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
        //app.getHelperUser().clickOkButton();
    }

        @Test
        public void loginWrongEmail(User user){
            logger.info("test data-->" + user.toString());
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("papgmail.com","@1234567Qq@");
            app.getHelperUser().submit();
            //cw
            Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
            Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        }

        @Test
        public void loginWrongPassword(){
                                 //.withEmail               .withPassword
            User user = new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@"); //+ method fillLogin with user

//        user.setEmail("pap@gmail.com");
//        user.setPassword("@1234567Qq@");

            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("pap@gmail.com","@1234567q@");
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");// (new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@"))
         //   Assert.assertEquals(app.getHelperUser().getMessage(), "Login or Password incorrect");//"

    }

    @Test
    public void loginIsEmpty(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("","@1234567Qq@");
        app.getHelperUser().submit();
        //cw
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
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
             app.getHelperUser().submit();
             Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

@AfterMethod
    public  void postCondition(){
   //   app.getHelperUser().clickOkButton();
}

    }

