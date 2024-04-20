package DAY7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day7 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("D:\\JP\\AdventCode\\AdventCodeDay2\\textDAY7.txt"));

        while (scanner.hasNextLine()) {
            String scan = scanner.nextLine();
            String[] split=scan.split(" ");
           // System.out.println(split[0]);
        }
        String a="99998";
        checkIf5Kind(a);
        checkIf4Kind(a);
        checkIffullhouse(a);
        checkIf3Kind(a);

    }
    public static boolean checkIf5Kind(String karta) {
        //where all five cards have the same label: AAAAA
        boolean is5kind=false;
        int counter=0;
        for (int i = 0; i < karta.length(); i++)
        {
            for(int y=0; y<karta.length(); y++)
            {
                if(karta.charAt(i)==karta.charAt(y))
                {
                    counter++;
                }
            }
        }
        if(counter==karta.length()*karta.length())
        {
            System.out.println("It's 5 kind");
            is5kind=true;
        }
        else{
            System.out.println("It's not 5 kind");
        }
        //System.out.println(counter);
        return is5kind;
    }
    public static boolean checkIf4Kind(String karta)
    {
        //where four cards have the same label and one card has a different label: AA8AA
        boolean is4Kind=false;
        int counter=0;
        int size=karta.length();
        for (int i = 0; i <size; i++)
        {
            for(int y=0; y<size; y++)
            {
                if(karta.charAt(i)==karta.charAt(y))
                {
                    counter++;
                }
            }
        }
        //System.out.println("counter:" +counter);
        if(counter==(size-1)*(size-1)+1)
        {
            System.out.println("It's 4 Kind");
            is4Kind=true;
        }
        else {
            System.out.println("It's not 4 Kind");
        }

        return is4Kind;
    }
    public static boolean checkIffullhouse(String karta)
    {
        //where three cards have the same label, and the remaining two cards share a different label: 23332
        boolean isFullhouse=false;
        int counter0=0;
        int counter1=0;
        int size=karta.length();
        char x0=karta.charAt(0);
        Map<Character, Integer> list=new HashMap<>();
        for (int i = 0; i <size; i++)
        {
            if(karta.charAt(i)==x0)
            {
                counter0++;
            }
          if(karta.charAt(i)!=x0)
          {
              counter1++;
              list.put(karta.charAt(i),i);
          }
        }

        if(list.size()==1 && ( counter1==3 || counter1==2 ))
        {
            System.out.println("It's fullhouse");
        }
        else {
            System.out.println("It's not fullhouse");
        }

        return isFullhouse;
    }
    public static boolean checkIf3Kind(String karta)
    {
        //where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
        boolean is3Kind=false;
        int counter1=0;
        int counter2=0;
        int counter3=0;

        int size=karta.length();
        Map<String, Integer> list=new HashMap<>();

        for (int i = 0; i <size; i++)
        {
                list.put(karta.charAt(i),);
        }
        if(list.size()==3)
        {
            System.out.println("It's 3 Kind");
            is3Kind=true;
        }
        else{
            System.out.println("It's not 3 Kind");
        }
       // System.out.println("Size of map: "+list.size());

        return is3Kind;
    }
    public static boolean checkIf2Pairs(String karta)
    {
        //where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
        boolean is2Pairs=false;
        int size=karta.length();
        Map<Character, Integer> list=new HashMap<>();
        int counter1=0;
        int counter2=0;
        int counter3=0;

        for (int i = 0; i <size; i++)
        {
            list.put(karta.charAt(i),i);
        }
        if(list.size()==3)
        {
            for(int i=0; i<size; i++)
            {
                for(Map.Entry<Character, Integer> entry: list.entrySet())
                {
                   if(entry.getKey()==karta.charAt(i))
                   {

                   }

            }}
            System.out.println("It's 2 Pairs");
            is2Pairs=true;
        }

        return is2Pairs;
    }
    public static boolean checkIf1Pair(String karta)
    {
        //where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
        boolean is1Pair=false;
        return is1Pair;
    }
    public static boolean checkIfHighCard(String karta)
    {
        //where all cards' labels are distinct: 23456
        boolean isHighCard=false;
        return isHighCard;
    }

}