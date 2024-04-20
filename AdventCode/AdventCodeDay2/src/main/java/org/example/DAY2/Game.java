package org.example.DAY2;

import java.security.PublicKey;
import java.util.ArrayList;

public class Game {
    int numberOfGame;
    String gameNumber;
    ArrayList<String> Rounds;
    ArrayList<ArrayList<Integer>> RGB;
    boolean possible=true;

    public Game()
    {
        gameNumber=null;
        Rounds=new ArrayList<>();
        RGB=new ArrayList<>();
        ArrayList<Integer> green=new ArrayList<>();
        ArrayList<Integer> red=new ArrayList<>();
        ArrayList<Integer> blue=new ArrayList<>();
        RGB.add(red);
        RGB.add(green);
        RGB.add(blue);

    }
    public void setGameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void setRounds(ArrayList<String> rounds) {
        Rounds = rounds;
    }

    public ArrayList<ArrayList<Integer>> getRGB() {
        return RGB;
    }

    public void setRGB(ArrayList<ArrayList<Integer>> RGB) {

        this.RGB = RGB;
    }
    public void setR(ArrayList<Integer> redList)
    {
        this.RGB.add(redList);
    }
    public void setG(ArrayList<Integer> greenList)
    {
        this.RGB.add(greenList);
    }
    public void setB(ArrayList<Integer> blueList)
    {
        this.RGB.add(blueList);
    }

    public void setNumberOfGame(int numberOfGame) {
        this.numberOfGame = numberOfGame;
    }

    public int getNumberOfGame() {
        return numberOfGame;
    }

    public String getGameNumber() {
        return gameNumber;
    }

    public ArrayList<String> getRounds() {
        return Rounds;
    }

    public boolean isPossible() {
        return possible;
    }

    public void setPossible(boolean possible) {
        this.possible = possible;
    }
}
