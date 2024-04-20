package POJO;

import java.util.ArrayList;

public class Employee {
    private String employeeID;
    private ArrayList<String> traits;
    private int points;
    public Employee(String name, ArrayList<String> list){
        this.employeeID=name;
        traits= new ArrayList<>(list);

    }

    public String getId() {
        return employeeID;
    }

    public ArrayList<String> getTraits() {
        return traits;
    }



}
