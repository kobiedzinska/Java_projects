package gameFrames.GUI;

import Serwer.Serwer;
import javax.swing.*;
import java.awt.*;

public class GUI {
    public static JButton createButton1(String name, int x, int y) {
        Serwer serwerListener= new Serwer();
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(x, y));
        button.setSize(x,y);
        button.setFocusable(false);
        button.addActionListener(serwerListener);
        return button;
    }

    public static JPanel createPanel(Color color, int x, int y) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(x, y));
        panel.setBackground(color);
        panel.setOpaque(true);
        panel.setVisible(true);

        return panel;
    }

    public static JLabel setLabelFontStyle1(JLabel label) {
        label.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 75));
        label.setForeground(Color.BLACK);
        return label;
    }
}


