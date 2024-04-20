package GUI.PANELS;

import logic.FoodLogic.Dish;
import logic.FoodLogic.foodProducts;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import static GUI.GUI.*;
import static logic.FoodLogic.CalculateCalories.calculateCaloriesInDish;
import static logic.Serialization.Deserialization.writeToFile;
import static logic.Serialization.Serialization.loadFromFile;
import static logic.Serialization.Serialization.readFromFile;
import static logic.Tools.Convertion.convertModelListToArray;
import static logic.serwer.getMenuFrame;

public class dishCreatePanel extends JPanel  implements ActionListener, MouseListener {
    private JPanel paneltlo1;
    private JPanel paneltlo2;
    private JPanel paneltlo3;
    private JPanel paneltlo4;
    private JPanel paneltlo5;
    private JLabel labelname;
    private JButton returnButton;
    private JButton saveButton;
    private JButton clearButton;
    private JButton addButton;
    private JButton deleteButton;
    private DefaultListModel<String> model = new DefaultListModel<>();
    private DefaultListModel<String> model2 = new DefaultListModel<>();
    private JList<String> list;
    private JList<String> dishList;
    private ArrayList<foodProducts> foodProductsList;
    private JTextArea dishtextfield;
    private ArrayList<Dish> dishList0;
    private JTextField kcalfield;
    private JLabel sumkcal;

    public dishCreatePanel() {
        this.setBackground(new Color(9, 84, 162));
        this.setSize(500, 500);
        this.setLayout(new BorderLayout(10, 10));


        returnButton = createButton("return", 80, 25, this);
        saveButton = createButton("save", 70, 25, this);
        clearButton = createButton("clear all", 100, 25, this);
        addButton = createButton("add to the Dish", 150, 25, this);
        deleteButton = createButton("delete from the dish", 170, 25, this);

        paneltlo1 = createPanel(new Color(9, 84, 162), 100, 50);
        paneltlo2 = createPanel(new Color(9, 84, 162), 100, 50);
        paneltlo3 = createPanel(new Color(9, 84, 162), 25, 400);
        paneltlo4 = createPanel(new Color(9, 84, 162), 25, 400);
        paneltlo5 = createPanel(Color.WHITE, 300, 300);

        JPanel paneltlo51 = createPanel(Color.lightGray, 250, 250);
        paneltlo51.setLayout(new BorderLayout());
        JPanel paneltlo52 = createPanel(Color.PINK, 250, 200);
        paneltlo52.setLayout(new GridLayout(1, 2));
        JPanel paneltlo53 = createPanel(Color.ORANGE, 100, 200);
        paneltlo51.add(paneltlo53, BorderLayout.EAST);

        //panel 51.NORTH
        JPanel paneld = createPanel(Color.PINK, 300, 300);
        paneld.setLayout(new BorderLayout());

        JPanel panelc = createPanel(Color.lightGray, 200, 25);
        panelc.setLayout(new GridLayout(1, 2));
        labelname = new JLabel("Dish name: ");
        sumkcal=new JLabel("Total sum (kcal):");
        dishtextfield = new JTextArea();
        panelc.add(labelname);
        panelc.add(dishtextfield);
        kcalfield=new JTextField();

        paneld.add(sumkcal,BorderLayout.CENTER);
        paneld.add(kcalfield,BorderLayout.SOUTH);
        paneld.add(panelc, BorderLayout.NORTH);
        paneltlo51.add(paneld, BorderLayout.CENTER);

        this.add(paneltlo1, BorderLayout.NORTH);
        this.add(paneltlo2, BorderLayout.SOUTH);
        this.add(paneltlo3, BorderLayout.WEST);
        this.add(paneltlo4, BorderLayout.EAST);
        this.add(paneltlo5, BorderLayout.CENTER);

        paneltlo2.setLayout(new FlowLayout());
        paneltlo1.add(returnButton);
        paneltlo53.add(saveButton);
        paneltlo2.add(clearButton);
        paneltlo2.add(addButton);
        paneltlo2.add(deleteButton);

        paneltlo5.setLayout(new GridLayout(2, 1, 0, 10));
        paneltlo5.add(paneltlo51);
        paneltlo5.add(paneltlo52);

//EXAMPLE foodProductList

        foodProductsList = loadFromFile();

        //DEFAULT LIST MODEL

        list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(this);

        for (foodProducts product : foodProductsList) {
            model.addElement(product.getFoodName());
        }

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(250, 200));

        //DISH LIST
        dishList = new JList<String>(model2);
        dishList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        dishList.addMouseListener(this);

        JScrollPane scrollPane2 = new JScrollPane(dishList);
        scrollPane.setPreferredSize(new Dimension(250, 200));

        paneltlo52.add(scrollPane);
        paneltlo52.add(scrollPane2);

        JLabel title = new JLabel("Create your own dish!");
        title = setLabelFontStyle1(title);
        paneltlo1.add(title);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {

            System.out.println("Return");
            dishtextfield.setText("");
            getMenuFrame().getCardLayout().show(getMenuFrame().getContentPanel(), "mainPanel");
            try {
                dishList0 = readFromFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                writeToFile(dishList0);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == addButton) {
            if (!list.isSelectionEmpty()) {
                model2.addElement(model.elementAt(list.getSelectedIndex()));
                list.clearSelection();

                kcalfield.setText(String.valueOf(calculateCaloriesInDish(convertModelListToArray(model2))));
            } else {
                JOptionPane.showMessageDialog(this, "Select an item.");
            }
        }
        if (e.getSource() == deleteButton) {
            if (!dishList.isSelectionEmpty()) {
                if (model2.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "List is empty!");
                } else {
                    model2.removeElement(model2.elementAt(dishList.getSelectedIndex()));
                    kcalfield.setText(String.valueOf(calculateCaloriesInDish(convertModelListToArray(model2))));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select an item to delete.");
            }
        }
        if (e.getSource() == clearButton) {
            model2.clear();
            dishtextfield.setText("");
        }
        if (e.getSource() == saveButton) {
            if (dishtextfield.equals("") || model2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "There's missing some information");
            } else {
                Dish dish = new Dish();
                dish.setDishName(dishtextfield.getText());
                dish.setFoodList(convertModelListToArray(model2));

                try {
                    dishList0 = readFromFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


                dishList0.add(dish);
                try {
                    writeToFile(dishList0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"You have successfully saved your dish!");
                model2.clear();
                dishtextfield.setText("");
            }
        }
    }

        @Override
        public void mouseClicked (MouseEvent e){
            System.out.println(list.getSelectedIndex());
        }

        @Override
        public void mousePressed (MouseEvent e){

        }

        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseEntered (MouseEvent e){

        }

        @Override
        public void mouseExited (MouseEvent e){

        }

}