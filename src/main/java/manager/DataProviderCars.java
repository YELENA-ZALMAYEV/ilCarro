package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCars {

    @DataProvider
    public Iterator<Object []> addCarSuccess(){
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Opel")
                .model("sd")
                .year("1999")
                .fuel("Petrol")
                .seats(5)
                .carClass("D")
                .carRegNumber("252-2525")
                .price(12)
                .about("good")
                .build()

        });
        list.add(new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mercedes")
                .model("sd")
                .year("1999")
                .fuel("Petrol")
                .seats(5)
                .carClass("D")
                .carRegNumber("252-2125")
                .price(12)
                .about("good")
                .build()

        });
        list.add(new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("BMW")
                .model("sd")
                .year("1999")
                .fuel("Petrol")
                .seats(5)
                .carClass("D")
                .carRegNumber("252-2335")
                .price(12)
                .about("good")
                .build()

        });

        return list.iterator();
    }
}
