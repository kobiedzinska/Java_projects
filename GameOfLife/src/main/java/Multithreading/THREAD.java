package Multithreading;

import Logic.Cell;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.List;

import static Serwer.Serwer.getCurrState;
import static Serwer.Serwer.getMainFrame1;

public class THREAD extends Thread{
    private final String name;
    private final int startColumn;
    private final int endColumn;
    private AtomicBoolean[][] map;
    private CyclicBarrier barrier;
    private List<Cell> myresult;
    private List<List<Cell>> list;
    public THREAD(String name, Cell cell, AtomicBoolean[][] originalmap, CyclicBarrier barrier, List<List<Cell>> list)
    {
        this.name= name;
        this.startColumn= cell.getX();
        this.endColumn=cell.getY();
        this.map=originalmap;

        this.barrier=barrier;
        this.list=list;
        myresult= Collections.synchronizedList(new ArrayList<>());
    }
    public void run() {
        //System.out.println("start column: "+startColumn+" end column: "+endColumn+" thread "+name);
        System.out.println(name+" starts working");
      /*  for (int y = 0; y < map.length; y++) {
            for (int i = startColumn; i <= endColumn; i++) {
            int count=0;
            //narożniki
                //GÓRNY LEWY
                if(i==0 && y==0){
                    for (int a = 0; a <= 1; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if(a==0 && b==0)
                            {

                            }
                            else if (map[i + a][y + b].get()) {
                                count++;
                            }

                            if(map[map.length-1][0].get()){
                                count++;
                            }
                            if(map[map.length-1][1].get()){
                                count++;
                            }
                            if(map[0][map[0].length-1].get()){
                                count++;
                            }
                            if(map[1][map[0].length-1].get()){
                                count++;
                            }
                            if(map[map.length - 1][map[0].length - 1].get()){
                                count++;
                            }
                            if (count == 3) {
                                Cell cell = new Cell();
                                cell.setX(i);
                                cell.setY(y);
                                myresult.add(cell);
                            }
                        }
                    }

                }
                //DOLNY LEWY
                if(i==0 && y== map.length-1){
                    for (int a = 0; a < 1; a++) {
                        for (int b = -1; b < 1; b++) {
                            if(a==0 && b==0)
                            {

                            }
                            else if (map[i + a][y + b].get()) {
                                count++;
                            }

                            if(map[0][0].get()){
                                count++;
                            }
                            if(map[0][1].get()){
                                count++;
                            }
                            if(map[0][map[0].length - 1].get()){
                                count++;
                            }
                            if(map[map.length - 1][map[0].length - 1].get()){
                                count++;
                            }
                            if(map[map.length - 1][map[0].length - 2].get()){
                                count++;
                            }
                            if (count == 3) {
                                Cell cell = new Cell();
                                cell.setX(i);
                                cell.setY(y);
                                myresult.add(cell);
                            }
                        }
                    }

                }
                //GÓRNY PRAWY
                if(i==map[0].length-1 && y==0){
                    for (int a = -1; a < 1; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if(a==0 && b==0)
                            {

                            }
                            else if (map[i + a][y + b].get()) {
                                count++;
                            }

                            if(map[map.length-1][0].get()){
                                count++;
                            }
                            if(map[0][0].get()){
                                count++;
                            }
                            if(map[1][0].get()){
                                count++;
                            }
                            if(map[map.length-1][map[0].length-1].get()){
                                count++;
                            }
                            if(map[map.length-1][map[0].length-2].get()){
                                count++;
                            }
                            if (count == 3) {
                                Cell cell = new Cell();
                                cell.setX(i);
                                cell.setY(y);
                                myresult.add(cell);
                            }
                        }
                    }
                }
                //DOLNY PRAWY
                if(i==map[0].length-1 && y== map.length-1){
                    for (int a = -1; a < 1; a++) {
                        for (int b = -1; b < 1; b++) {
                            if(a==0 && b==0)
                            {

                            }
                            else if (map[i + a][y + b].get()) {
                                count++;
                            }

                            if(map[map.length-1][0].get()){
                                count++;
                            }
                            if(map[map.length-2][0].get()){
                                count++;
                            }
                            if(map[0][map[0].length-1].get()){
                                count++;
                            }
                            if(map[0][map[0].length-2].get()){
                                count++;
                            }
                            if(map[0][0].get()){
                                count++;
                            }
                            if (count == 3) {
                                Cell cell = new Cell();
                                cell.setX(i);
                                cell.setY(y);
                                myresult.add(cell);
                            }
                        }
                    }
                }

                //liczenie poza krawędziami
                if(i!=0 && y!=0 && i!=map[0].length-1 && y!=map.length-1) {

                    for (int a = -1; a <= 1; a++) {
                        for (int b = -1; b <= 1; b++) {
                            if(a==0 && b==0){

                            }
                            else if (map[i + a][y + b].get()) {
                                count++;
                            }
                        }
                    }
                    if (count == 3) {
                        Cell cell = new Cell();
                        cell.setX(i);
                        cell.setY(y);
                        System.out.println("Dodaję komórkę: x:"+cell.getX()+" y:"+cell.getY()+" t"+name);
                        myresult.add(cell);
                    }

                } else{
                    if(i==0 && y!=0 && y!=map.length-1){
                        //lewa kolumna
                        for (int a = 0; a <= 1; a++) {
                            for (int b = -1; b <= 1; b++) {
                                if(a==0 && b==0)
                                {

                                }
                                else if (map[i + a][y + b].get()) {
                                    count++;
                                }

                                if(map[y][map[0].length-1].get()){
                                    count++;
                                }
                                if(map[y-1][map[0].length-1].get()){
                                    count++;
                                }
                                if(map[y+1][map[0].length-1].get()){
                                    count++;
                                }

                            }
                        }

                    }

                    if(i==map[0].length-1 && y!=0 && y!=map.length-1){
                        // prawa kolumna
                        for (int a = -1; a < 1; a++) {
                            for (int b = -1; b <= 1; b++) {
                                if(a==0 && b==0)
                                {

                                }
                                else if (map[i + a][y + b].get()) {
                                    count++;
                                }

                                if(map[y][0].get()){
                                    count++;
                                }
                                if(map[y-1][0].get()){
                                    count++;
                                }
                                if(map[y+1][0].get()){
                                    count++;
                                }
                                if (count == 3) {
                                    Cell cell = new Cell();
                                    cell.setX(i);
                                    cell.setY(y);
                                    myresult.add(cell);
                                }

                            }
                        }

                    }

                    if(y==0 && i!=0 && i!=map[0].length-1){
                        //górny wiersz
                        for (int a = -1; a <= 1; a++) {
                            for (int b = 0; b <= 1; b++) {
                                if(a==0 && b==0)
                                {

                                }
                                else if (map[i + a][y + b].get()) {
                                    count++;
                                }

                                if(map[map.length-1][i].get()){
                                    count++;
                                }
                                if(map[map.length-1][i+1].get()){
                                    count++;
                                }
                                if(map[map.length-1][i-1].get()){
                                    count++;
                                }
                                if (count == 3) {
                                    Cell cell = new Cell();
                                    cell.setX(i);
                                    cell.setY(y);
                                    myresult.add(cell);
                                }

                            }
                        }
                    }

                    if(y==map.length-1 && i!=0 && i!=map[0].length-1){
                        //dolny wiersz
                        for (int a = -1; a <= 1; a++) {
                            for (int b = -1; b < 1; b++) {
                                if(a==0 && b==0)
                                {

                                }
                                else if (map[i + a][y + b].get()) {
                                    count++;
                                }

                                if(map[0][i].get()){
                                    count++;
                                }
                                if(map[0][i+1].get()){
                                    count++;
                                }
                                if(map[0][i-1].get()){
                                    count++;
                                }

                                if (count == 3) {
                                    Cell cell = new Cell();
                                    cell.setX(i);
                                    cell.setY(y);
                                    myresult.add(cell);
                                }
                            }
                        }
                    }
                }
            }
        }*/
        for (int y = 0; y < map.length; y++) {
            for (int i = startColumn; i <= endColumn; i++) {
                int count=0;
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                int xNeighbor = (i + a + map.length) % map.length;
                int yNeighbor = (y + b + map[0].length) % map[0].length;

                if (a == 0 && b == 0) {
                } else if (map[xNeighbor][yNeighbor].get()) {
                    count++;
                }
            }
        }

        if (count == 3) {
            Cell cell = new Cell();
            cell.setX(y);
            cell.setY(i);
            myresult.add(cell);
        }}}
        list.add(myresult);

        try {
            System.out.println( "thread"+name+" is waiting");
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
