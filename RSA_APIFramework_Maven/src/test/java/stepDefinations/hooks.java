package stepDefinations;

import io.cucumber.java.Before;

import java.io.IOException;

public class hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        // execute this code only when place id is null
        // write code that will give you place id

        // create object of class "stepDefs"
        stepDefs m = new stepDefs();
        if (stepDefs.place_id==null)
        {
            m.add_place_payload_with("Monu", "Turkey", "StarWay");
            m.user_calls_with_http_request("addPlaceAPI", "POST");
            m.verify_place_id_created_maps_to_using("Monu", "getPlaceAPI");
        }
    }
}
