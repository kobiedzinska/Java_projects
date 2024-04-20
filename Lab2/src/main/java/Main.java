import java.io.File;

public class Main {
    public static void main(String[] args){
        int liczbaGeneracji=500;
        try{
            File file= new File("D:\\JP\\Lab2\\src\\main\\resources\\EXAMPLE.txt");
            Parser parser= new Parser(file);

        }catch(Exception e){
            System.out.println("Błąd z odczytem pliku");
            System.out.println(e);
        }

        EvolutionAlgorithm.InitializePopulation();
        for(int k=0; k<liczbaGeneracji; k++){
            if(EvolutionAlgorithm.population.size()==1){
                break;
            }
            EvolutionAlgorithm.ocenPopulacje();
            EvolutionAlgorithm.selekcja();
            EvolutionAlgorithm.Crossover();
        }
        Output.showSolution(EvolutionAlgorithm.population.get(0));

    }
}
