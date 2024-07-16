package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests  extends TestBase{

    @BeforeMethod
    public  void  preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

        @Test
    public  void RegistrationSuccess(){
        int i = new Random().nextInt(1000) +1000;
            System.out.println(i);
         //2
            System.out.println(System.currentTimeMillis());
         //3

            int z = (int) ((System.currentTimeMillis()/1000)%3600);
            System.out.println(z);

            User user = new User()
                    .setFirstName("popi")
                    .setLastName("pop")
                    .setEmail("pop"+z+"@gmail.com")
                    .setPassword("l!sdlQ123&");

            app.getHelperUser().openRegistrationForm();
            app.getHelperUser().fillRegistrationForm(user);
            //app.getHelperUser().checkPolicy();
            app.getHelperUser().checkPolicyXY();
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
        }
//      app.getHelperUser().openRegistrationForm();
//      app.getHelperUser().fillRegistrationForm("el", "z","pa@gmail.com","@Q1234567q@");
//      app.getHelperUser().isRegistered();
//
//        Assert.assertTrue(app.getHelperUser().isRegistered());
//    }

      @Test
    public  void registrationEmptyName(){

          User user = new User()
                  .setFirstName("")
                  .setLastName("pop")
                  .setEmail("pop@gmail.com")
                  .setPassword("l!sdlQ123&");
          app.getHelperUser().openRegistrationForm();
          app.getHelperUser().fillRegistrationForm(user);
          app.getHelperUser().checkPolicyXY();
          app.getHelperUser().submit();
          Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
          Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");

      }
    @Test
    public  void registrationEmptyLastName(){
        User user = new User()
                .setFirstName("popi")
                .setLastName("")
                .setEmail("pop@gmail.com")
                .setPassword("l!sdlQ123&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Last name is required");
    }
    @Test
    public  void registrationWrongEmail(){
        User user = new User()
                .setFirstName("popi")
                .setLastName("pop")
                .setEmail("popgmail.com")
                .setPassword("l!sdlQ123&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));

    }
    @Test
    public  void registrationEmptyEmail(){
        User user = new User()
                .setFirstName("popi")
                .setLastName("pop")
                .setEmail("")
                .setPassword("l!sdlQ123&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");

    }

    @Test
    public  void registrationWrongPassword(){
        User user = new User()
                .setFirstName("popi")
                .setLastName("pop")
                .setEmail("pop@gmail.com")
                .setPassword("dl123&");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");

    }

    @Test
    public  void registrationEmptyPassword(){
        User user = new User()
                .setFirstName("popi")
                .setLastName("pop")
                .setEmail("pop@gmail.com")
                .setPassword("");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");

    }
    @Test
    public void registrationWithoutCheckbox(){
        User user = new User()
                .setFirstName("pop")
                .setLastName("pop")
                .setEmail("pop@gmail.com")
                .setPassword("l!sdlQ13&");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public  void postConditions(){
     app.getHelperUser().clickOkButton();
    }
}
