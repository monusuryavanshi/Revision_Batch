package resources;

import pojo.D15AddPlaces;
import pojo.D16Locations;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public D15AddPlaces addPlacePayload(String name, String language, String address)
    {

        // create object of pojo class addplace
        D15AddPlaces p = new D15AddPlaces();
        p.setAccuracy(50);
        //p.setAddress("29, side layout, cohen 09");
        p.setAddress(address);
        //p.setLanguage("French-IN");
        p.setLanguage(language);
        //p.setName("Frontline house");
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("http://google.com");
        //setting data through list
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        // setting data through class's object
        D16Locations l = new D16Locations();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayload(String place_id)
    {
        return "{\r\n    \"place_id\": \""+place_id+"\"\r\n}";
    }
}