package DAY9;

import java.util.ArrayList;

public class Counting {
    ArrayList<ArrayList<Integer>> listaZ;
    public Counting(ArrayList<Integer> lista)
    {
        listaZ=new ArrayList<>();
        listaZ.add(lista);
    }

    public int policzA(ArrayList<Integer> lista) {
        ArrayList<Integer> lista2 = new ArrayList<>();
        int a=0;

        for (int i = 1; i < lista.size(); i++) {
            lista2.add(lista.get(i) - lista.get(i - 1));
            System.out.println(lista.get(i) - lista.get(i - 1));
        }
        listaZ.add(lista2);
        System.out.println("");
        if(sum(lista2)==0)
        {
            System.out.println("A element is:"+lista.get(0));

            a=lista.get(0);
            System.out.println(a);
            return a;
        }
        else{
            return policzA(lista2);
        }

    }
    public static int sum(ArrayList<Integer> lista0)
    {
        int sum=0;
        for(Integer element: lista0)
        {
            // System.out.println(element);
            sum+=element;
        }
        return sum;
    }

    public void setListaZ(ArrayList<ArrayList<Integer>> listaZ) {
        this.listaZ = listaZ;
    }

    public ArrayList<ArrayList<Integer>> getListaZ() {
        return listaZ;
    }
}
