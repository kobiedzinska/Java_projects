package DAY6;

import DAY4.Cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\JP\\AdventCode\\AdventCodeDay2\\textDAY6.txt"));
        ArrayList<String> lista=new ArrayList<>();
        while (scanner.hasNextLine()) {
            String scan = scanner.nextLine();
            String[] split=scan.split(":");
            split[1]=split[1].trim();

            String[] split2= split[1].split("   ");
            for(String element: split2)
            {
                lista.add(element.trim());
                System.out.println(element.trim());
            }
        }
        ArrayList<String> lista1=new ArrayList<>();
        for(int i=0; i<4; i++)
        {
            lista1.add(lista.get(i));
        }
        ArrayList<String> lista2= new ArrayList<>();
        for(int i=4; i<lista.size(); i++)
        {
            lista2.add(lista.get(i));
        }
        System.out.println("lista1:");
        wyswietlliste(lista1);
        System.out.println("lista2:");
        wyswietlliste((lista2));

        ArrayList<Race> RaceList= new ArrayList<>();
        for(int i=0; i<4; i++)
        {
            Race race0=new Race();
            race0.setTime(Integer.parseInt(lista1.get(i)));
            race0.setDistance(Integer.parseInt(lista2.get(i)));
            RaceList.add(race0);
        }

        for(Race element: RaceList)
        {
            System.out.println("Distance:"+element.getDistance()+"  time:"+ element.getTime());
        }

        //Próba
      /*  Race race=new Race();
        race.setDistance(9);
        race.setTime(7);
        System.out.println(obliczdroge(1,7));;
        obliczsposoby(race);
        Próba zakończona sukcesem
*/
        //sprawdzListe(RaceList);
        Race race=new Race();
        race.setDistance(478223210191071l);
        race.setTime(58996469);
        obliczsposoby(race);

    }
    public static void sprawdzListe(ArrayList<Race> raceList)
    {
       long iloczyn=1l;
        for(Race element: raceList)
        {
            long itemek= obliczsposoby(element);
            iloczyn*=itemek;
        }
        System.out.println(iloczyn);

    }


    public static void wyswietlliste(ArrayList<String> lista)
    {
        for(int i=0; i<lista.size(); i++)
        {
            System.out.println(lista.get(i));
        }
    }
    public static long obliczdroge(long v, long t)
    {
        long s=v*(t-v);
        return s;
    }
    public static long obliczsposoby(Race race)
    {
       long time=race.getTime();
       long distance=race.getDistance();
       long counter=0l;
            //dla każdego elementu sprawdzamy sposoby
        for(long i=0l; i<=time; i++)
        {
            if(obliczdroge(time-i,time)>distance)
            {
                counter++;
            }
        }
        System.out.println("Liczba sposobow:" +counter);
        return counter;

    }
}
