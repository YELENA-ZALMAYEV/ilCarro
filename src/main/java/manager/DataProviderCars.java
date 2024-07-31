package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderCars {

    @DataProvider
    public Iterator<Object []> addCarSuccess(){
        List<Object []> list = new ArrayList<>();
        int i = new Random().nextInt(100)+1000;
        list.add(new Object[]{Car.builder()
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
                .carRegNumber("252-2125"+i)
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
                .carRegNumber("252-2335"+i)
                .price(12)
                .about("good")
                .build()

        });

        return list.iterator();
    }
}
