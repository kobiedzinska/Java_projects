import POJO.Employee;
import POJO.Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    private File file;
    private static ArrayList<Employee> employees;
    private static ArrayList<Project> projects;
    private static List<String> readLines;
    public Parser(File file){
        this.file=file;
        employees=new ArrayList<>();
        projects=new ArrayList<>();
        readLines=new ArrayList<>();
        readFromFile();
        filtr();
    }
    public void readFromFile(){
        boolean projectsSection=false;
        try{
            Scanner scanner= new Scanner(file);
            while(scanner.hasNext()){
                readLines.add(scanner.nextLine());
            }

        }catch(IOException e){
            System.out.println("Błąd z odczytem pliku Parser");
        }
    }
    public void filtr(){
        boolean projectSection=false;
        boolean staffSection=false;

        for(String line: readLines){
            if(line.equals("PROJECTS")){
                projectSection=true;
                staffSection=false;
            }
            if(line.equals("STAFF")){
                projectSection=false;
                staffSection=true;
            }

            if(projectSection && !line.isEmpty() && !line.equals("PROJECTS")){
                String[] splited= line.split(": ");
                String[] splited2=splited[1].split(" ");

                ArrayList<String> list= new ArrayList<>();
                for(String item: splited2){
                    list.add(item);
                }

                Project project= new Project(splited[0],list);
                projects.add(project);

            }
            if(staffSection && !line.isEmpty() && !line.equals("STAFF")){
                String[] splited= line.split(": ");
                String[] splited2=splited[1].split(" ");

              ArrayList<String> list= new ArrayList<>();
                for(String item: splited2){
                    list.add(item);
                }
                Employee employee= new Employee(splited[0],list);
                employees.add(employee);

                if(list.size()==1){
                    if(list.get(0).equals("QA")||list.get(0).equals("PM")){
                        employees.add(employee);
                    }
                }


            }
        }
        //System.out.println("Listy zostały przypisane. Parser");
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }

    public static List<String> getReadLines() {
        return readLines;
    }
}
