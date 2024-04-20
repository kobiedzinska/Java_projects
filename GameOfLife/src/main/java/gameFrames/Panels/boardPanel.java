package gameFrames.Panels;

import Logic.Cell;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import static gameFrames.GUI.GUI.createButton1;
import static gameFrames.GUI.GUI.createPanel;


public class boardPanel extends JPanel {
    private final JButton playButton;
    private JButton stopButton;
    private  JPanel panel1;
    public boardPanel(Color color, int width, int height)
    {
        setBackground(color);
        setSize(width, height);
        setLayout(new BorderLayout());

        panel1= createPanel(Color.white, 200,200);
        JPanel panel2= createPanel(color, 100,50);
        JPanel panel3= createPanel(color, 100,100);
        JPanel panel4= createPanel(color, 25,50);
        JPanel panel5= createPanel(color, 150,50);

            //PANEL5- EAST - PLAY I STOP BUTTON
            playButton=createButton1("PLAY", 100,25);
            stopButton=createButton1("STOP",100,25);

            panel5.add(playButton);
            panel5.add(stopButton);

        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.SOUTH);
        this.add(panel4, BorderLayout.WEST);
        this.add(panel5, BorderLayout.EAST);
    }

    public synchronized void paintPanel(List<Cell> table, int rozmiar_x, int rozmiar_y, Color color)
    {
        panel1.removeAll();
        panel1.setLayout(new GridLayout(rozmiar_x,rozmiar_y,2,2));
        for (int i = 0; i < rozmiar_x; i++) {
            for (int z = 0; z < rozmiar_y; z++) {
                JPanel panel=createPanel(Color.black,10,10);
                for(Cell item: table)
                {
                   if(item.getX()==i && item.getY()==z)
                   {
                       panel.setBackground(Color.blue);
                   }
                }
                panel1.add(panel);
            }
        }
    }
    public synchronized void updatePanel(List<Cell> table, int rozmiar_x, int rozmiar_y, Color color)
    {
        panel1.revalidate();
        panel1.repaint();
        paintPanel(table,rozmiar_x,rozmiar_y,color);

    }

    public synchronized JPanel getPanel1() {
        return panel1;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }
}
