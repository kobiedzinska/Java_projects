package DAY4;

import java.util.ArrayList;

public class Cards {
    String nameOFlottery;
    ArrayList<String> numbers;
    ArrayList<String> myNumbers;
    ArrayList<String> SOLOnumbers;
    ArrayList<String> SOLOmyNumbers;
    int dopasowanie=0;
    int original=0;
    int copies=0;
    private int totalScratchcards;
    public Cards()
    {
        myNumbers=new ArrayList<>();
        numbers=new ArrayList<>();
        SOLOnumbers=new ArrayList<>();
        SOLOmyNumbers=new ArrayList<>();
        dopasowanie=0;
        original=0;
        copies=0;
        totalScratchcards = 0;

    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public String getNameOFlottery() {
        return nameOFlottery;
    }

    public void setNameOFlottery(String nameOFlottery) {
        this.nameOFlottery = nameOFlottery;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<String> getMyNumbers() {
        return myNumbers;
    }

    public void setMyNumbers(ArrayList<String> myNumbers) {
        this.myNumbers = myNumbers;
    }

    public ArrayList<String> getSOLOmyNumbers() {
        return SOLOmyNumbers;
    }

    public ArrayList<String> getSOLOnumbers() {
        return SOLOnumbers;
    }

    public void setSOLOmyNumbers(ArrayList<String> SOLOmyNumbers) {
        this.SOLOmyNumbers = SOLOmyNumbers;
    }

    public void setSOLOnumbers(ArrayList<String> SOLOnumbers) {
        this.SOLOnumbers = SOLOnumbers;
    }

    public int getCopies() {
        return copies;
    }

    public int getDopasowanie() {
        return dopasowanie;
    }

    public void setDopasowanie(int dopasowanie) {
        this.dopasowanie = dopasowanie;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
    }
    public int getTotalScratchcards() {
        return totalScratchcards;
    }

    public void addTotalScratchcards(int count) {
        this.totalScratchcards += count;
    }
}
