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

    @Test
    public  void searcCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Rehovot", "1/5/2024", "2/7/2024" );
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }

    //avery period
    @Test
    public void searchAnyPeriodSuccess(){
        app.getHelperCar().searchAnyPeriod("Rehovot", "8/11/2024", "7/8/2025");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }
}
