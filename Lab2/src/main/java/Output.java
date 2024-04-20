import POJO.Combination;
import POJO.Employee;
import POJO.Project;
import POJO.Solution;

import java.util.ArrayList;
import java.util.Collections;

public class Output {
    public static void showStaff(ArrayList<Employee> list){
        System.out.println("STAFF list:");
        for(Employee item:list){
            System.out.println(item.getId()+ ": ");
            for(String element:item.getTraits()){
                System.out.print(element+" ");
            }
            System.out.println("");
        }
    }
    public static void showProjects(ArrayList<Project> list){
        System.out.println("PROJECT list");
        for(Project item:list){
            System.out.println(item.getProjectID()+ ": ");
            for(String element:item.getTasks()){
                System.out.print(element+" ");
            }
            System.out.println("");
        }
    }
    public static void showSolution(Solution sol){
        System.out.println("The best found solution");
        System.out.println(sol.getPoints()+"/15 points\n");

        for(Combination item: sol.getSolution()){
            System.out.println(item.getpID());
            System.out.println(item.getTask());
            System.out.println(item.getEmployee().getId());
            System.out.println("");
        }
    }
}
