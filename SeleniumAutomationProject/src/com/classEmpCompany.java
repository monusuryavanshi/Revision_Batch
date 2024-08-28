package com;

public class classEmpCompany  extends programClassEmploye {

    String Comp = "Cybage" ;
    programClassEmploye e1 = new programClassEmploye();

    public void display()
    {
        e1.display();
        System.out.println("Company Name : " + Comp);
    }

}
