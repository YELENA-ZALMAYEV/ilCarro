package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCar {

    @DataProvider
    public Iterator<Object []> example(){
        List<Object []> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object []> loginData(){
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{"pap@gmail.com","@1234567Qq@"});
        list.add(new Object[]{"pap@gmail.com","@1234567Qq@"});
        list.add(new Object[]{"pap@gmail.com","@1234567Qq@"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object []> loginModels(){
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object []> attcarSuccess(){
        List<Object []> list = new ArrayList<>();


        return list.iterator();
    }

}
