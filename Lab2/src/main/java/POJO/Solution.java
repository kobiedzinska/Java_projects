package POJO;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Combination> solution;
    private int points;
    public Solution(ArrayList<Combination> population){
        this.solution = population;
    }

    public ArrayList<Combination> getSolution() {
        return solution;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
