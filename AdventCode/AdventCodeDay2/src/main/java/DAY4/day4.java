package DAY4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) throws FileNotFoundException {


        ArrayList<Cards> lista5=new ArrayList<>();

        Scanner scanner = new Scanner(new File("D:\\JP\\AdventCode\\AdventCodeDay2\\adventcode.txt"));
        while (scanner.hasNextLine()) {
            String scan = scanner.nextLine();
            Cards object= new Cards();
                    String[] cardANDnumber=scan.split(":");
                    object.setNameOFlottery(cardANDnumber[0]);

                    String[] splited=cardANDnumber[1].split("\\|");

                    object.getNumbers().add(splited[0]);
                    object.getMyNumbers().add(splited[1]);
                    lista5.add(object);

        }

        for(Cards element:lista5)
        {
            element.setSOLOnumbers(makeAnArray(element.getNumbers()));
            element.setSOLOmyNumbers(makeAnArray(element.getMyNumbers()));
        }
        ArrayList<Cards> lista7=new ArrayList<>(przeszukajListe(lista5));


        //PUNKTY i DOPASOWANIA

        for(Cards element: lista5)
        {
            for(Cards item: lista7)
            {
                if(item.getNameOFlottery().equals(element.getNameOFlottery()))
                {
                    element.setDopasowanie(look2(item.getSOLOnumbers(),item.getSOLOmyNumbers()));
                }
            }

          /*  ///PUNTKY
          System.out.println(item.getNameOFlottery());
            a=look2(item.getSOLOnumbers(),item.getSOLOmyNumbers());
            if(a>1){
               // System.out.println(Math.pow(2,a-1));
                sum+=Math.pow(2,a-1);
            }
            else{
              //  System.out.println(a);
                sum+=a;
            }*/

        }
      //  System.out.println(sum);

        //MAKE COPIES
        System.out.println(lista7.size());
        System.out.println(lista5.size());
       // processCards(lista5);
        //showResult(lista5);
    }

    public static void showResult(ArrayList<Cards> lista5)
    {
        int sumA=0;
        int sumB=0;
        int sumC=0;

        for(Cards ele:lista5)
        {
            System.out.println("Name of lottery:"+ele.getNameOFlottery());
            System.out.println("Dopasowania: "+ele.getDopasowanie());
            System.out.println("Copies: "+ ele.getCopies());
            System.out.println("Original: "+ele.getOriginal());

            sumA+= ele.getCopies();
            sumB+= ele.getOriginal();
            System.out.println("A "+sumA);
            System.out.println("B "+sumB);
            //sum+= ele.getCopies()+ ele.getOriginal();
            //System.out.println(sum);

            System.out.println("");
        }
        sumC=sumA+sumB+23;
        System.out.println();
        System.out.println("C: "+sumC);
    }
    public static void processCards(ArrayList<Cards> lista5){

        for(int y=0; y<lista5.size(); y++){ //iteruje po liście kart
            int dopasowanie=lista5.get(y).getDopasowanie();
            int copies=lista5.get(y).getCopies();

            if (dopasowanie > 0) { //jeśli karta będzie miała dopasowanie tzn., że tworzymy kopie
                lista5.get(y).setOriginal(1); //ustawiamy, że tej karty orginal=1

                //iterujemy, dodajemy kopie i robimy to (copies+1) times
                //np jeśli copies=0, zrobimy to tylko raz, ale jeśli
                //copies=2, zrobimy to 3 razy, czyli dodamy 3 kopie po x dopasowań
                System.out.println(lista5.get(y).getNameOFlottery());
                for (int i = 1; i <=dopasowanie ; i++) {
                    int index = y + i;

                    if (index < lista5.size()) {
                        if(copies==0)
                        {
                            lista5.get(index).setCopies(lista5.get(index).getCopies() + 1);
                            System.out.println("I make copy");
                        }
                        else{
                            int p=copies+1;
                            lista5.get(index).setCopies(lista5.get(index).getCopies() +p );
                            System.out.println("I make copy");
                        }

                    }
                }

            }
        }

    }

    public static ArrayList<String> makeAnArray(ArrayList<String> lista1)
    {
        ArrayList<String> osobnoLiczby= new ArrayList<>();
        for(String element: lista1)
        {
            String[] split=element.split(" ");
            for(int i=0; i< split.length;i++)
            {
                if(!split[i].equals(""))
                {
                    osobnoLiczby.add(split[i]);
                }
            }
        }

        return osobnoLiczby;
    }
    public static ArrayList<Cards> przeszukajListe(ArrayList<Cards> lista)
    {
        ArrayList<Cards> listaB= new ArrayList<>();

        for(Cards element: lista)
        {
           ArrayList<String> lista1= new ArrayList<>(element.getSOLOnumbers());
           ArrayList<String> lista2=new ArrayList<>(element.getSOLOmyNumbers());

           if(look(lista1, lista2))
           {
            Cards object= new Cards();
            object.setSOLOnumbers(lista1);
            object.setSOLOmyNumbers(lista2);
            object.setNameOFlottery(element.getNameOFlottery());
            listaB.add(object);
           }
        }
        return listaB;
    }
    public static boolean look(ArrayList<String> A, ArrayList<String> B)
    {
        for(String item: A)
        {
            for(String item2: B)
            {
                if(item.equals(item2))
                {
                   return true;
                }
            }
        }
        return false;
    }
    public static int look2(ArrayList<String> A, ArrayList<String> B)
    {
        int licznik=0;
        for(String item: A)
        {
            for(String item2: B)
            {
                if(item.equals(item2))
                {
                    licznik++;
                }
            }
        }

       // System.out.println(licznik);
        return licznik;
    }

}
