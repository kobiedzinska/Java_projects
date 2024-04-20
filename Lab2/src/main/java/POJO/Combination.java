package POJO;

public class Combination {
    private String pID;
    private String task;
    private Employee employee;
    private int points;
    public Combination(String pID,String task, Employee employee){
        this.pID=pID;
        this.task=task;
        this.employee=employee;
    }

    public String getpID() {
        return pID;
    }

    public String getTask() {
        return task;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void getPoint(){
        points++;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getPoints() {
        return points;
    }
}
