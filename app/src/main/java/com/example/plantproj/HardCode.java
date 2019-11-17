package com.example.plantproj;

import java.util.HashMap;

public class HardCode {
    public static void main(String[] args) {
        //Make a user

        User aUser = new User("Ross", "Jubber", "rossjubber@gmail.com", "password123");


        //Make 2 new plants

        Plants plant1 = new Plants("Tree", 7);
        Plants plant2 = new Plants("Dracaena", 6);

        //Put plants in hashmap and set location

        HashMap<LatLng, Plants> plantLocations = new HashMap<LatLng, Plants>();

        plantLocations.put(aValue1, plant1);
        plantLocations.put(aValue2, plant2);

    }
}
