import java.util.ArrayList;
import java.util.List;

public class TestStreamMain {

    static List<String> places = new ArrayList<>();
    public static List getPlaces(){


        places.add("MadhyaPradesh, Bhopal");
        places.add("UttarPradesh, Lacknao");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");

        return places;
    }

    public static void main( String[] args ) {

        List<String> myPlaces = getPlaces();
        System.out.println("Places from MadhyaPradesh:");
        myPlaces.stream()
                .filter((p) -> p.startsWith("MadhyaPradesh"))
                .map((p) -> p.toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));

             System.out.println("Places from India:");
              myPlaces.stream()
             .filter((a) -> a.startsWith("India"))
                      .map((a) -> a.toLowerCase())
                      .sorted()
                      .forEach((a) -> System.out.println(a));

    }

}
