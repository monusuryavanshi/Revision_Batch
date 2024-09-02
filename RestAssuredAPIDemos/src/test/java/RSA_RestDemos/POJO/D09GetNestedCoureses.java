package RSA_RestDemos.POJO;

import java.util.List;

public class D09GetNestedCoureses {


    // define variables as private
    private List<D10NestedCoursesWebAutomation> webAutomation;
    private List<D11NestedCoursesAPI> api;
    private List<D12NestedCoursesMobile> mobile;

    // Getter setter
    public List<D10NestedCoursesWebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<D10NestedCoursesWebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<D11NestedCoursesAPI> getApi() {
        return api;
    }

    public void setApi(List<D11NestedCoursesAPI> api) {
        this.api = api;
    }

    public List<D12NestedCoursesMobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<D12NestedCoursesMobile> mobile) {
        this.mobile = mobile;
    }
}
