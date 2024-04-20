package Serwer;

import Logic.Cell;
import Logic.CurrentState;
import Multithreading.MultithreadManager;
import gameFrames.Panels.mainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static Logic.CurrentState.createCurrState;
import static Logic.CurrentState.readTableFromFile;
import static Logic.Validation.Validate.*;

public class Serwer implements ActionListener {
    private static mainFrame mainFrame1;
    private static CurrentState currState;
    private static MultithreadManager manager;
    private boolean running=false;
    public static void main(String[] args){

    mainFrame1 = new mainFrame();

    }

    public static mainFrame getMainFrame1() {
        return mainFrame1;
    }

    public static CurrentState getCurrState() {
        return currState;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mainFrame1.getMainPanel1().getStartButton())
        {
            JFileChooser chooser=mainFrame1.getMainPanel1().getChooser();
           int response=chooser.showOpenDialog(null);

            if(response==JFileChooser.APPROVE_OPTION)
            {
                String path= chooser.getSelectedFile().getAbsolutePath();
                File file= new File(path);
                if(isFileTxt(file)){
                    try {
                        ArrayList<String> filex=readTableFromFile(file);
                            currState=createCurrState(filex);

                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(isCurrStateGood()){
                        mainFrame1.getBoardPanel1().paintPanel(currState.getAliveC(),currState.getRozmiarX(),currState.getRozmiarY(), Color.blue);
                        getMainFrame1().getCardLayout().show(getMainFrame1().getContent(),"boardPanel");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Wrong file or wrong data. Choose different file.", "Problem", JOptionPane.WARNING_MESSAGE);
                    }
                     }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong extenstion file","Problem",JOptionPane.WARNING_MESSAGE);
                }

            }
            else{
                JOptionPane.showMessageDialog(null,"You didn't choose the file. Click 'start', if you want to try again.", "Problem",JOptionPane.WARNING_MESSAGE
                );
            }
        }
        if(e.getSource()==mainFrame1.getBoardPanel1().getPlayButton())
        {
            manager= new MultithreadManager(getCurrState().getRozmiarX(), getCurrState().getRozmiarY(), getCurrState().getAliveC());
            System.out.println("Play");

            if(manager!=null)
            {
                System.out.println("run Simulation");

                for(int i=0; i<getCurrState().getLiczbaIteracji(); i++) {
                    System.out.println("Iteracaja: "+(i+1));
                    manager.runSimulation();
                    try {
                        manager.getThread1().sleep(1000);
                        manager.getThread2().sleep(1000);
                        manager.getThread3().sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        }
        if(e.getSource()==mainFrame1.getBoardPanel1().getStopButton())
        {
            if(running){
                if(manager!=null)
                {
                    manager.stopEverything();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"The game isn't started, click 'play'","Problem",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}