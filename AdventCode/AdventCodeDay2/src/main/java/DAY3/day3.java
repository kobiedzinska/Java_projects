package DAY3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> arrayList= new ArrayList<>();
        Scanner scanner= new Scanner(new File("D:\\JP\\AdventCode\\AdventCodeDay2\\textDAY3.txt"));
        while(scanner.hasNextLine())
        {
            String scan= scanner.nextLine();
            //System.out.println(scan);
            //System.out.println("");
            arrayList.add(scan);

        }

        int licznik=0;
        int index0=0;
        int index1=0;
        boolean start=false;
        boolean stop=true;

        int bloop=0;
        int BLOOP=0;
        for(int i=0; i<arrayList.size();i++)
        {
            for(int y=0; y<arrayList.get(0).length()-1;y++)
            {
               if(isNumber(String.valueOf(arrayList.get(i).charAt(y))))
                {

                        //sprawdzanie
                        if(isNumber(String.valueOf(arrayList.get(i).charAt(y))))
                        {
                            bloop++;

                            for(int x=-1;x<=1;x++)
                            {
                                for(int z=-1;z<=1;z++)
                                {
                                    if(i == 0 || y == 0 || i == arrayList.size()||i == arrayList.size()-1 || y == arrayList.get(i).length() - 1 || y == arrayList.get(i).length() - 2)
                                {
                                    System.out.println("row:"+(i+1)+" y:"+(y+1));
                                    System.out.println(arrayList.get(i).charAt(y));

                                } else if(String.valueOf(arrayList.get(i+x).charAt(y+z)).equals(".") )
                                    {
                                       // System.out.println("kropka");
                                        BLOOP++;
                                    }
                                }


                            }
                        }
                }
            }

        }System.out.println("bloop:"+bloop);
        System.out.println("kropka:"+BLOOP);
    }



   /* public static void lookForSign(ArrayList<String> arrayList,Integer row, Integer x0, Integer x1) {


       if(x1-x0+1==2)
       {
           System.out.println("x0:"+x0+"  x1:"+x1);
           System.out.println("2");
       }
        if(x1-x0+1==3)
        {
            System.out.println("3");

            System.out.println("x0:"+x0+"  x1:"+x1);
            if(arrayList.get(row).charAt(x1+1)=='.')
            {
                System.out.println("blop");
            }
        }
    }
*/
    public static boolean isNumber(String c)
    {
            if(c.equals("0"))
            {
                return true;
            }
            if(c.equals("1"))
            {
                return true;
            }
            if(c.equals("2"))
            {
                return true;
            }
        if(c.equals("3"))
        {
            return true;
        }
        if(c.equals("4"))
        {
            return true;
        }
        if(c.equals("5"))
        {
            return true;
        }
        if(c.equals("6"))
        {
            return true;
        }
        if(c.equals("7"))
        {
            return true;
        }
        if(c.equals("8"))
        {
            return true;
        }
        if(c.equals("9"))
        {
            return true;
        }

        return false;
    }
    public static String[] makeArrayOfNumbers()
    {
        String[] numbers=new String[10];

        numbers[0]="0";
        numbers[1]="1";
        numbers[2]="2";
        numbers[3]="3";
        numbers[4]="4";
        numbers[5]="5";
        numbers[6]="6";
        numbers[7]="7";
        numbers[8]="8";
        numbers[9]="9";

        return numbers;
    }
}
