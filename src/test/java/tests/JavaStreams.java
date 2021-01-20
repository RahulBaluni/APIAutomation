package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {
        streamConcept();
    }

    public static void streamConcept(){
        List<String> nameList = new ArrayList<>();
        nameList.add("ntiin");
        nameList.add("anmol");
        nameList.add("aman");
        nameList.add("rahul");
        System.out.println(nameList.toString());

        /*List<String> namesStartingWithA = nameList
                .stream()
                .filter(name -> name.startsWith("a")).collect(Collectors.toList());*/
        //System.out.println(namesStartingWithA.toString());

        nameList
                .stream()
                .filter(name -> name.startsWith("a")).findAny();
    }


}
