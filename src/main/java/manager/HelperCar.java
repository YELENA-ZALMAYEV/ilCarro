package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void searchCurrentYear(String city, String dateFrom, String dateTo) {
        //"Rehovot", "10/15/2024", "12/10/2024"
        typeCity(city);
        click(By.id("dates"));

       LocalDate now = LocalDate.now(); //today
        System.out.println(now); //2024-07-30 - not string (object local date)

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
      //day today (now) ++++ equils of month
                                                 //patern of date
      LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
      LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));

        System.out.println(from);
      //  LocalDate from1 = LocalDate.parse("2013:23/05", DateTimeFormatter.ofPattern("yyyy:dd/MM"));
      //  System.out.println("from1");

        int diffMonth = from.getMonthValue()-month;
        if(diffMonth > 0){
            clickNextMonthBtn(diffMonth);
        }

        click(By.xpath("//div[text()= ' " + from.getDayOfMonth() + " ']"));

        //1
        diffMonth = to.getMonthValue()-from.getMonthValue();
        if(diffMonth > 0){
            clickNextMonthBtn(diffMonth);
        }
        //2
        ////div[text()= ' " +to[1] + ' ']"
        String locator = String.format("//div[text() = ' %s ']", to.getDayOfMonth());
        click(By.xpath("//button[@aria-label='Next month']"));

    }

    private void clickNextMonthBtn(int diffMonth) {
        for (int i = 0; i< diffMonth; i++){
            click(By.cssSelector("button[aria-label='Next month']"));
        }

    }

    public void searchAnyPeriod(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));

        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        int diffYear;
        int diffMonth;

        diffYear = from.getYear()-now.getYear();
        if (diffYear == 0){
            diffMonth = from.getMonthValue()-now.getMonthValue();
        } else{
            diffMonth = 12- now.getMonthValue()+ from.getMonthValue();
      } clickNextMonthBtn(diffMonth);
        String locator = String.format("//div[text() = ' %s ']", from.getDayOfMonth());
        click(By.xpath("locator"));
    }
   //dateTo home work
}