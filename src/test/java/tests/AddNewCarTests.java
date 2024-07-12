package tests;

import models.Car;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends  TestBase{


      @Test
    public  void  AddNewCarSuccess(){

          int i = new Random().nextInt(100)+1000;

          Car car = Car.builder()                  //const lombok
                  .location("Tel Aviv, Israel")
                  .manufacture("Opel")
                  .model("sd")
                  .year("1999")
                  .fuel("Petrol")
                  .seats(5)
                  .carClass("D")
                  .carRegNumber("252-2525"+i)
                  .price(12)
                  .about("good")
                  .build();

          app.getHelperCar().openCarForm();
          app.getHelperCar().fillCarForm();
          app.getHelperCar().submitCarForm();
      }
}