package manager;

import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

//generate
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
}
