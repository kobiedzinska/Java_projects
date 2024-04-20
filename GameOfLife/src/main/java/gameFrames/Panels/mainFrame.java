package gameFrames.Panels;

import javax.swing.*;
import java.awt.*;

import static Serwer.Serwer.getCurrState;
import static Serwer.Serwer.main;
import static gameFrames.GUI.GUI.createPanel;

public class mainFrame extends JFrame {
    private JPanel content;
    private CardLayout cardLayout= new CardLayout();
    private ImageIcon logo= new ImageIcon("D:\\JP\\GameOfLife\\src\\main\\resources\\pobrany plik.png");
    private mainPanel mainPanel1;
    private boardPanel boardPanel1;
    public mainFrame()
    {
        this.setIconImage(logo.getImage());
        int x=500;
        int y=400;
        Color color= new Color(99,209,76);

        content=createPanel(Color.PINK,x,y);
        content.setLayout(cardLayout);


        mainPanel1=new mainPanel(color,x,y);
        boardPanel1=new boardPanel(color,x,y);

        content.add(mainPanel1,"mainPanel");
        content.add(boardPanel1, "boardPanel");

        cardLayout.show(content,"mainPanel");
        this.add(content);

        setTitle("GameOfLife");
        setSize(new Dimension(750,700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getContent() {
        return content;
    }

    public mainPanel getMainPanel1() {
        return mainPanel1;
    }

    public synchronized boardPanel getBoardPanel1() {
        return boardPanel1;
    }
}
