package org.example.DAY2;

import org.example.DAY2.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner= new Scanner(new File("D:\\JP\\AdventCode\\AdventCodeDay2\\textDAY2.txt"));
        ArrayList<String> nova=new ArrayList<>();
        ArrayList<Game> gameLists = new ArrayList<>(MakeAnArray(scanner));

        Integer suma=0;
        for (Game element:gameLists) {
            suma=countRGB(element.getRounds(),element.getRGB(), element.getGameNumber(), suma);

        }
        System.out.println(suma);
       // System.out.println(nova);
        //System.out.println(countGames(nova));

    }
    public static ArrayList<Game> MakeAnArray(Scanner scanner)
    {
        ArrayList<Game> gameLists=new ArrayList<>();
        String line=null;

        while(scanner.hasNextLine())
        {
            ArrayList<String> rounds=new ArrayList<>();
            Game gameObject= new Game();

            //ROZDZIELA NA GAME I RUNDY
            line= scanner.nextLine();

            String[] splitedLine = line.split(":");
            gameObject.setGameNumber(splitedLine[0]);

            //ROZDZIELA NA POSZCZEGÓLNE RUNDY
            String[] roundsSplited=splitedLine[1].split(";");

            for(int i=0; i< roundsSplited.length; i++)
            {
                rounds.add(roundsSplited[i]);
            }
            gameObject.setRounds(rounds);

        gameLists.add(gameObject);
        }

        return gameLists;
    }

    public static Integer countRGB(ArrayList<String> roundsList, ArrayList<ArrayList<Integer>> RGB, String name, Integer suma)
    {
      //  System.out.println(name);
        ArrayList<String> pierwszalista=new ArrayList<>();

        for (String element: roundsList) {
           String[] elementsplit= element.split(",");
           for(int i=0;i<elementsplit.length;i++)
           {
               String line=elementsplit[i].strip();
               pierwszalista.add(line);
              // System.out.println(line);
           }
         //   System.out.println(" ");
        }

        ArrayList<Integer> green=new ArrayList<>();
        ArrayList<Integer> red=new ArrayList<>();
        ArrayList<Integer> blue=new ArrayList<>();
        int a=0;

        int redmax=0;
        int greenmax=0;
        int bluemax=0;

      for (String element: pierwszalista) {

            String[] elementsplited=element.split(" ");

                if(elementsplited[1].equals("green"))
                {
                   if(greenmax<Integer.valueOf(elementsplited[0]))
                   {
                       greenmax=Integer.valueOf(elementsplited[0]);
                   }
                }

            if(elementsplited[1].equals("blue"))
            {
                if(bluemax<Integer.valueOf(elementsplited[0]))
                {
                    bluemax=Integer.valueOf(elementsplited[0]);
                }
            }

            if(elementsplited[1].equals("red"))
            {
                if(redmax<Integer.valueOf(elementsplited[0]))
                {
                    redmax=Integer.valueOf(elementsplited[0]);
                }
            }

        }
      //  System.out.println(redmax);
      //  System.out.println(greenmax);
      //  System.out.println(bluemax);
      //  System.out.println(redmax*greenmax*bluemax);


    return suma+=(redmax*greenmax*bluemax);
    }
    public static boolean isPossible(Integer red, Integer green, Integer blue)
    {
        if(red>12)
        {
            return false;
        }
        if(green>13)
        {
            return false;
        }
        if(blue>14)
        {
            return false;
        }
        return true;
    }
    public static Integer countGames(ArrayList<String> gameList)
    {
        int sum=0;
        for (String element:gameList) {
            String[] split=element.split(" ");
            sum+=Integer.valueOf(split[1]);
        }
        return sum;
    }
}