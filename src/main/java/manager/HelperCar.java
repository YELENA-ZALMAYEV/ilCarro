package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),String.valueOf(car.getSeats()));
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice()+"");
        type(By.id("about"), car.getAbout());

    }

    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);

        //Gas
//        select.selectByIndex(5);
//        select.selectByValue("Gas");
//        select.selectByVisibleText(" Gas ");
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"),location);
        click(By.cssSelector("div.pac-item"));
    }

    public void returnToHomePage() {
        click(By.xpath("//button[text()='Search cars']"));
    }


    public void attachPhoto(String link) {
        wd.findElement(By.cssSelector("")).sendKeys(link);
    }

    public void searchCurrentMonth(String city, String dateForm, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"7/27/2024","7/30/2024"            27 -30 - find by locator
        String[] from = dateForm.split("/"); //["7"]["27"]["2024"]
        String locatorFrom = "//div[text()= ' "+27+" ']";
        click(By.xpath(locatorFrom));                              //split = cut
        String[] to = dateTo.split("/");
        click(By.xpath("//div[text()= ' 30 ']"));
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isListOfCarAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }
}