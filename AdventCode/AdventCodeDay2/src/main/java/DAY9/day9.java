package DAY9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day9 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\JP\\AdventCode\\AdventCodeDay2\\textDAY9.txt"));


        ArrayList<ArrayList<Integer>> LISTA=new ArrayList<>();
        while (scanner.hasNextLine()) {
            ArrayList<Integer> list=new ArrayList<>();
            String scan = scanner.nextLine();
            String[] split=scan.split(" ");
            for(String element:split)
            {
                list.add(Integer.parseInt(element));
            }
            LISTA.add(list);
        }

        int sum=0;

for(ArrayList<Integer> element: LISTA)
{
    Counting count= new Counting(element);
    count.policzA(element);
    System.out.println("LISTA Z: "+count.getListaZ().size());

    ArrayList<ArrayList<Integer>> lista=count.getListaZ();
    int size= lista.size();
    for(int i=size-1; i>0; i--)
    {
        int sizeList=lista.get(i).size();
        int a=lista.get(i).get(sizeList-1);
       // System.out.println(a);
        int b=lista.get(i-1).get(sizeList-1);
       // System.out.println(b);
        System.out.println(a+b);
        lista.get(i-1).add(a+b);
        System.out.println(lista.get(0).get(sizeList-1));
    }
    //System.out.println(count.getListaZ().get(0).get(count.getListaZ().get(0).size()-1));
    sum+=count.getListaZ().get(0).get(count.getListaZ().get(0).size()-1);
}
        System.out.println("SUMA: "+sum);
        System.out.println(1882396045-1882395907);
}




}