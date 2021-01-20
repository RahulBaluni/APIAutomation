package tests;

import enums.Days;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

/**
 * Created by ngoyal on 15/01/21.
 */
public class JunitAnnotationsOverView {


    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"nitin", "nitish", "aman"})
    public void parameterizedTestWithStringValueSource(String name){
        System.out.println("I am inside the test");
        System.out.println(name);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7})
    public void parameterizedTestWithIntValueSource(int id){
        System.out.println("I am inside the test");
        System.out.println(id);
    }

    @ParameterizedTest
    @EnumSource(Days.class)
    public void parameterizedTestWithEnumSource(Days day){
        System.out.println("I am inside the test");
        System.out.println(String.valueOf(day));
    }

}
