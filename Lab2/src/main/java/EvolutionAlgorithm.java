import POJO.Combination;
import POJO.Employee;
import POJO.Project;
import POJO.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EvolutionAlgorithm {
    private static int populationSize=10000;
    static ArrayList<Solution> population;
    public static void InitializePopulation(){

    population= new ArrayList<>();


    for(int i=0; i<populationSize; i++){
        ArrayList<Combination> list= new ArrayList<>();

        ArrayList<Project> listA= new ArrayList<Project>(Parser.getProjects());
        ArrayList<Employee> listB= new ArrayList<Employee>(Parser.getEmployees());

        Random random=new Random();
        for(Project item: listA){
            for(String element: item.getTasks()){
                if(listB.size()>0){
                    int a=random.nextInt(listB.size());
                    Employee emp=listB.get(a);
                    Combination comb= new Combination(item.getProjectID(),element,emp);
                    listB.remove(emp);
                    Collections.shuffle(listB);
                    list.add(comb);
                }
            }
        }
        Solution solution= new Solution(list);
        population.add(solution);
        }
    }
    public static void ocenPopulacje(){


        for(Solution item: population){
            int b=0;
            for(Combination element: item.getSolution()){

                for(String trait: element.getEmployee().getTraits()){
                    if(element.getTask().equals(trait)){
                        element.getPoint();
                    }
                }
                b+=element.getPoints();
            }
           item.setPoints(b);
        }
    }
    public static void selekcja(){
       ArrayList<Solution> newGeneration=new ArrayList<>();
        Random random=new Random();
        int size= population.size();

        for(int i=0; i<size; i++){
            if(population.size()>2){
                int a=random.nextInt(population.size());
                Solution X=population.get(a);
                population.remove(X);
                Collections.shuffle(population);
                a=random.nextInt(population.size());
                Solution Y=population.get(a);
                population.remove(Y);

                if(X.getPoints()>Y.getPoints()){
                    newGeneration.add(X);
                }else{
                    newGeneration.add(Y);
                }
            }else{
                Collections.shuffle(population);
                return;
            }
        }
        population=newGeneration;
    }
    public static void Crossover(){
        ArrayList<Solution> generation=new ArrayList<>();
        Random random=new Random();
        int size=populationSize;

        for(int i=0; i<size; i++){

            if(population.size()>2){
                int a=random.nextInt(population.size());
                Solution X=population.get(a);
                population.remove(X);
                Collections.shuffle(population);
                a=random.nextInt(population.size());
                Solution Y=population.get(a);
                population.remove(Y);

                for(Combination item1: X.getSolution()){
                    for(Combination item2: Y.getSolution()){
                        if(item1.getTask().equals(item2.getTask())){
                            if(checkEmpBusy(item2.getEmployee(),item1.getTask(),X.getSolution()) && checkEmpBusy(item1.getEmployee(), item1.getTask(), Y.getSolution())){
                                Employee emp= item1.getEmployee();
                                item1.setEmployee(item2.getEmployee());
                                item2.setEmployee(emp);
                            }

                        }
                    }

                }
                generation.add(X);
                generation.add(Y);
            }else{
                return;
            }
            population=generation;
        }
    }
    public static boolean checkEmpBusy(Employee emp, String taskNotToCheck, ArrayList<Combination> listToCheck){
        int i=0;
        for(Combination item: listToCheck){
            if(item.getEmployee().getId().equals(emp.getId())){
                if(!item.getTask().equals(taskNotToCheck)){
                    i++;
                }
            }
        }
        if(emp.getTraits().size()==1 && (emp.getTraits().get(0).equals("QA") || emp.getTraits().get(0).equals("PM"))){
            i--;
        }
        if (i>=1) {
            return true;
        }
        return false;
    }

}
