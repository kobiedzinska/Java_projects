package Multithreading;

import Logic.Cell;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import static Serwer.Serwer.getCurrState;
import static Serwer.Serwer.getMainFrame1;

public class MultithreadManager {

   private THREAD thread1;
   private THREAD thread2;
   private THREAD thread3;
    private CyclicBarrier cyclicBarrier;
    private int x;
    private int y;
    private List<Cell> list;
    private List<List<Cell>> nestedCellList = Collections.synchronizedList(new ArrayList<>());


    public MultithreadManager(int x, int y, List<Cell> list) {
        this.x=x;
        this.y=y;
        this.list=list;

    }
    public void runSimulation()
    {

            ArrayList<Cell> tab=new ArrayList<>(divideIntoParts(x));

            cyclicBarrier= new CyclicBarrier(3, ()->{
                taks1();

            });
            thread1= new THREAD("1",tab.get(0), getCurrState().getMap(), cyclicBarrier, nestedCellList);
            thread2= new THREAD("2",tab.get(1), getCurrState().getMap(), cyclicBarrier, nestedCellList);
            thread3= new THREAD("3", tab.get(2), getCurrState().getMap(), cyclicBarrier, nestedCellList);

            thread1.start();
            thread2.start();
            thread3.start();

        }

     ArrayList<Cell> divideIntoParts(int x){
        ArrayList<Cell> divisions=new ArrayList<>();
        int numberOfThreads=3;
        int result=0;
        int reszta=0;

        if(x>=numberOfThreads){
            result= x / numberOfThreads;
            reszta= x % numberOfThreads;
        }

        int a=0;
        for(int i=0; i<numberOfThreads; i++) {

            Cell cell1= new Cell();
            if(reszta>0){
                cell1.setX(a);
                cell1.setY(a+result);
                a=cell1.getY()+1;
            }
            else {
                cell1.setX(a);
                cell1.setY(a+result-1);
                a=cell1.getY()+1;
            }
            reszta--;
            divisions.add(cell1);
        }
        return divisions;
    }

    public synchronized void stopEverything()
    {
        System.out.println("STOP");
        if(thread1.isAlive()){
            System.out.println("t1 is dead");
            thread1.interrupt();
        }
        if(thread2.isAlive()){
            System.out.println("t2 is dead");
            thread2.interrupt();
        }
        if(thread3.isAlive()){
            System.out.println("t3 is dead");
            thread3.interrupt();
        }

    }

    public synchronized void updateAliveCells(List<List<Cell>> list){

        List<Cell> lista= Collections.synchronizedList(new ArrayList<>());

            for(List<Cell> l: list){
                for(Cell item: l){
                    lista.add(item);
                }
            }
            getCurrState().clearAliveC();
            getCurrState().setAliveC(lista);

    }
    public synchronized void wyswietlMape(AtomicBoolean[][] mapx){

        for(int i=0; i< mapx.length; i++){
            for(int y=0; y<mapx[0].length; y++){
                if(mapx[y][i].get()){
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public THREAD getThread1() {
        return thread1;
    }

    public THREAD getThread2() {
        return thread2;
    }

    public THREAD getThread3() {
        return thread3;
    }
    public synchronized void taks1() {

        wyswietlMape(getCurrState().getMap());
        getMainFrame1().getBoardPanel1().updatePanel(getCurrState().getAliveC(),getCurrState().getRozmiarX(),getCurrState().getRozmiarY(), Color.blue);
        getMainFrame1().getBoardPanel1().getPanel1().revalidate();
        getMainFrame1().getBoardPanel1().getPanel1().repaint();

        updateAliveCells(nestedCellList);
        nestedCellList.clear();
        getCurrState().updateAtomicMap(getCurrState().getAliveC());

    }
}
