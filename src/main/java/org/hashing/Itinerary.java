package org.hashing;

import java.util.*;

public class Itinerary {
    Map<String, String> fwd = new HashMap<>();
    Map<String, String> rev = new HashMap<>();

    public static void main(String[] args) {
        List<List<String>> ite = List.of(List.of("Chennai", "Banglore"), List.of("Bombay","Delhi"),List.of("Goa","Chennai"),List.of("Delhi","Goa"));
        Itinerary i = new Itinerary();
        i.initialize(ite);
        i.findItinerary().forEach(System.out::println);
    }
    void initialize(List<List<String>> ite){
        for(List<String> s: ite){
            fwd.put(s.get(0), s.get(1));
            rev.put(s.get(1), s.get(0));
        }
    }
    String findStart(){
        for(String s: fwd.keySet()){
            if(!rev.containsKey(s))
                return s;
        }
        return null;
    }

    List<String> findItinerary(){
        String curr = findStart();
        List<String> journey = new LinkedList<>();
        while(fwd.get(curr) != null){
            journey.add(curr);
            curr = fwd.get(curr);
        }
        journey.add(curr);
        return journey;
    }
}
