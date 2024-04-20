package gameFrames.Panels;

import javax.swing.*;
import java.awt.*;
import static gameFrames.GUI.GUI.*;


public class mainPanel extends JPanel {
    private ImageIcon logo = new ImageIcon("D:\\JP\\GameOfLife\\src\\main\\resources\\plik.png");
    private JLabel photo = new JLabel();
    private JLabel title;
    private JButton startButton;
    private JFileChooser chooser = new JFileChooser();


    public mainPanel(Color color, int width, int height) {
        setBackground(Color.pink);
        setSize(width, height);
        setLayout(new BorderLayout());

        JPanel panel1 = createPanel(color, 100, 200);
        JPanel panel2 = createPanel(color, 100, 200);
        JPanel panel3 = createPanel(color, 100, 100);
        JPanel panel4 = createPanel(color, 100, 100);
        JPanel panel5 = createPanel(color, 100, 100);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.WEST);
        this.add(panel5, BorderLayout.CENTER);


        startButton = createButton1("START", 200, 50);
        panel2.add(startButton);

        title = new JLabel("GAME of LIFE");
        setLabelFontStyle1(title);
        title.setAlignmentY(50);
        panel5.add(title);

        photo.setIcon(logo);
        panel5.add(photo);

    }

    public JFileChooser getChooser() {
        return chooser;
    }


    public JButton getStartButton() {
        return startButton;
    }

}
