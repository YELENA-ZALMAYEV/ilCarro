package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

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

    @DataProvider
    public Iterator <Object []> addCarSuccessCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/cars.csv")));
        String line =reader.readLine();
        while (line!=null){
            String [] all = line.split(",");
        list.add(new Object[]{Car.builder()
                .location(all[0])
                .manufacture(all[1])
                .model(all[2])
                .year(all[3])
                .fuel(all[4])
                .seats(parseInt(all[5]))
                .carClass(all[5])
                .carRegNumber(all[7])
                .price(Double.parseDouble(all[8]))
                .about(all[9])
                .build()});
         line = reader.readLine();
        }
        return list.iterator();
    }
}
