package tests;

import manager.DataProviderCars;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends  TestBase{

    @BeforeClass
    public void preсonditions(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@"));
        }
    }

      @Test (dataProvider = "addCarSuccess", dataProviderClass = DataProviderCars.class)
    public  void  AddNewCarSuccess(Car car){
        logger.info("Method add car Success start" +car.toString());
      //    int i = new Random().nextInt(100)+1000;

//          Car car = Car.builder()                  //const lombok
//                  .location("Tel Aviv, Israel")
//                  .manufacture("Opel")
//                  .model("sd")
//                  .year("1999")
//                  .fuel("Petrol")
//                  .seats(5)
//                  .carClass("D")
//                  .carRegNumber("252-2525"+i)
//                  .price(12)
//                  .about("good")
//                  .build();

          app.getHelperCar().openCarForm();
          app.getHelperCar().fillCarForm(car);
       //   app.getHelperCar().attachPhoto("");     //add foto link
          app.getHelperCar().submit();
          Assert.assertTrue(app.getHelperCar().getMessege().contains("added successful"));
          Assert.assertEquals(app.getHelperCar().getMessege(), car.getManufacture()+ " " +car.getModel()+ " added successful");
          logger.info("method add car Suc done");
      }
    @Test (dataProvider = "addCarSuccessCSV", dataProviderClass = DataProviderCars.class)
    public  void  AddNewCarSuccessCSV(Car car){
        logger.info("Method add car Success start" +car.toString());

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessege().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessege(), car.getManufacture()+ " " +car.getModel()+ " added successful");
        logger.info("method add car Suc done");
    }

    @Test
    public  void  AddNewCarSuccessReq(){

        int i = new Random().nextInt(100)+1000;

        Car car = Car.builder()                  //const lombok
                .location("Tel Aviv, Israel")
                .manufacture("Mercedes")
                .model("c-35")
                .year("2024")
                .fuel("Gas")
                .seats(7)
                .carClass("A")
                .carRegNumber("252-64659"+i)
                .price(70)
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessege().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessege(), car.getManufacture()+ " " +car.getModel()+ " added successful");

    }

      @AfterMethod
    public  void  postConditions(){
        app.getHelperCar().returnToHomePage();

      }
}
