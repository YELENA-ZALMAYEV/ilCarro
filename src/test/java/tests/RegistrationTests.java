package tests;

import models.User;
import org.testng.Assert;
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


}
