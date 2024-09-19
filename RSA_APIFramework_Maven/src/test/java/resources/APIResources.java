package resources;

//enum is special class in java which has collection of constants and methods
public enum APIResources {

    addPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private String resour;

    APIResources(String resource)
    {
        this.resour = resource;
    }

    public String getResource()
    {
        return resour;
    }

}
