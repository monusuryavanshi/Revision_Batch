package RSA_RestDemos.POJO;

public class D08GetCourse {

    // define variables as private
    private  String url;
    private  String services;
    private  String expertise;
    private D09GetNestedCoureses courses; // return is object of nested course
    private String instructor;
    private String linkedIn;


    // define functions as public for private variables

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public D09GetNestedCoureses getCourses() { // return type is class
        return courses;
    }

    public void setCourses(D09GetNestedCoureses courses) { // sending class object as argument
        this.courses = courses;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }



}
