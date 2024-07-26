package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class SearchCarTests extends TestBase{
    @Test
    public void  searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Tel-Aviv, Israel", "7/27/2024","7/30/2024");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
}
