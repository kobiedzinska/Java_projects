package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CurrentState {
    int rozmiarX=-1;
    int rozmiarY=-1;
    int liczbaIteracji=-1;
    int count_before=-1;
    List<Cell> aliveC = Collections.synchronizedList(new ArrayList<>());
    private AtomicBoolean[][] map;
    public CurrentState()
    {
    }
    public static ArrayList readTableFromFile(File file) throws FileNotFoundException {

        ArrayList<String> filesContent= new ArrayList<>();
        Scanner scanner= new Scanner(file);
        while(scanner.hasNext())
        {
            filesContent.add(scanner.nextLine());
        }

        return filesContent;
    }
    public static CurrentState createCurrState(ArrayList<String> file){
        CurrentState currentState= new CurrentState();
        currentState.setRozmiarX(Integer.parseInt(file.get(0)));
        currentState.setRozmiarY(Integer.parseInt(file.get(1)));
        currentState.setLiczbaIteracji(Integer.parseInt(file.get(2)));
        currentState.setCount_before(Integer.parseInt(file.get(3)));

        List<Cell> list= new ArrayList<>();
        Cell[] table=new Cell[currentState.getCount_before()];
        for(int i=0; i<currentState.getCount_before(); i++)
        {
            String[] split=file.get(4+i).split(" ");
            Cell cell=new Cell();
            cell.setX(Integer.parseInt(split[0]));
            cell.setY(Integer.parseInt(split[1]));

            list.add(cell);
        }

        currentState.setAliveC(list);
        currentState.setMap(currentState.updateAtomicMap(list));
        return currentState;
    }



    //gettery i settery
    public int getRozmiarX() {
        return rozmiarX;
    }

    public int getRozmiarY() {
        return rozmiarY;
    }

    public void setRozmiarX(int rozmiarX) {
        this.rozmiarX = rozmiarX;
    }


    public int getLiczbaIteracji() {
        return liczbaIteracji;
    }


    public void setRozmiarY(int rozmiarY) {
        this.rozmiarY = rozmiarY;
    }


    public void setCount_before(int count_before) {
        this.count_before = count_before;
    }

    public void setLiczbaIteracji(int liczbaIteracji) {
        this.liczbaIteracji = liczbaIteracji;
    }

    public int getCount_before() {
        return count_before;
    }


    public synchronized List<Cell> getAliveC() {
        return aliveC;
    }

    public void setAliveC(List<Cell> aliveC) {
        this.aliveC = aliveC;
    }

    public void clearAliveC(){
        aliveC.clear();
    }

    synchronized public AtomicBoolean[][] updateAtomicMap( List<Cell> list){
        this.map= new AtomicBoolean[rozmiarX][rozmiarY];

        for(int i=0; i<rozmiarY; i++){
            for(int k=0; k<rozmiarX; k++){
                map[k][i] = new AtomicBoolean(false); // Inicjalizacja obiektu AtomicBoolean
                for (Cell item : list) {
                    if (item.getX() == i && item.getY() == k) {
                        map[k][i].set(true);
                    }
                }
            }
        }
        return map;
    }

    public AtomicBoolean[][] getMap() {
        return map;
    }

    public void setMap(AtomicBoolean[][] map) {
        this.map = map;
    }
}
