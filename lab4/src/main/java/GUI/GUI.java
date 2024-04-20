package GUI;

import logic.FoodLogic.Dish;
import logic.FoodLogic.foodProducts;
import logic.serwer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import static logic.Tools.Update.updateProductsListFromFile;
import static logic.Tools.Update.updatedishListFromFile;


public class GUI {
private static serwer serwerListener= new serwer();
    public static JButton createButton(String name, int x, int y, ActionListener actionListener)
    {

        JButton button= new JButton(name);
        button.setPreferredSize(new Dimension(x,y));
        button.setFocusable(false);
        button.addActionListener(actionListener);
        return button;
    }
    public static JLabel createLabel(String text, int x, int y)
    {
        JLabel label= new JLabel(text);
        label.setPreferredSize(new Dimension(x,y));
        return label;
    }
    public static JPanel createPanel(Color color, int x, int y)
    {
        JPanel panel= new JPanel();
        panel.setPreferredSize(new Dimension(x, y));
        panel.setBackground(color);
        panel.setOpaque(true);
        panel.setVisible(true);

        return panel;
    }
    public static void createLayoutFrame(JFrame frame,String title, int x, int y)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setBackground(Color.GRAY);
        frame.setSize(x,y);
        //frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(9,84,162));
    }
    public static JLabel setLabelFontStyle1(JLabel label)
    {
        label.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 45));
        label.setForeground(new Color(243,151,0));
        return label;
    }
    public static JLabel setLabelFontStyle2(JLabel label)
    {
        label.setFont(new Font("Cascadia Mono", Font.PLAIN, 20));
        label.setForeground(new Color(248,183,0));
        return label;
    }
    public static JMenuItem createMenuItem(String text){
        JMenuItem item= new JMenuItem(text);
        item.addActionListener(serwerListener);
        return item;
    }
    public static JMenu createMenu(String text)
    {
        JMenu menu= new JMenu(text);
        return menu;
    }
    public static JPanel createFieldBox(String name)
    {
        JPanel panelc=createPanel(Color.lightGray,200,25);
        panelc.setLayout(new GridLayout(1,2));
        JLabel labelname=new JLabel(name+":");
        JTextArea textfield= new JTextArea();
        panelc.add(labelname);
        panelc.add(textfield);
        return panelc;
    }
    public static class FoodTableModel extends DefaultTableModel {
        private ArrayList<foodProducts> foodProductsArrayList;
        private int rowCount;
        public FoodTableModel(ArrayList<foodProducts> foodProducts) {
            this.foodProductsArrayList =updateProductsListFromFile();
            this.rowCount = (foodProductsArrayList != null) ? foodProductsArrayList.size() : 0;
        }
        public void setFoodProductsArrayList(ArrayList<foodProducts> foodProducts)
        {
            this.foodProductsArrayList=foodProducts;
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public int getRowCount() {
         return rowCount;

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            foodProductsArrayList=updateProductsListFromFile();
            foodProducts foodProduct =foodProductsArrayList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return foodProduct.getFoodName();
                case 1:
                    return foodProduct.getCarbohydrate();
                case 2:
                    return foodProduct.getProtein();
                case 3:
                    return foodProduct.getFat();
                case 4:
                    return foodProduct.getCategory();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Food Name";
                case 1:
                    return "Carbs";
                case 2:
                    return "Protein";
                case 3:
                    return "Fat";
                case 4:
                    return "Category";
                default:
                    return null;
            }
        }
}
    public static class DishTableModel extends DefaultTableModel {
        private ArrayList<Dish> foodProductsArrayList;
        private int rowCount;
        public DishTableModel(ArrayList<Dish> foodProducts) throws IOException, ClassNotFoundException {
            this.foodProductsArrayList =updatedishListFromFile();
            this.rowCount = (foodProductsArrayList != null) ? foodProductsArrayList.size() : 0;
        }
        public void setFoodProductsArrayList(ArrayList<Dish> foodProducts)
        {
            this.foodProductsArrayList=foodProducts;
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public int getRowCount() {
            return rowCount;

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                foodProductsArrayList=updatedishListFromFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Dish foodProduct =foodProductsArrayList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return foodProduct.getDishName();
                case 1:
                    String a = "";
                    for (foodProducts product : foodProduct.getFoodList()) {
                        a += product.getFoodName() + ", ";
                    }
                    return a.substring(0, a.length() - 2);

                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Food Name";
                case 1:
                    return "Carbs";
                case 2:
                    return "Protein";
                case 3:
                    return "Fat";
                case 4:
                    return "Category";
                default:
                    return null;
            }
        }}}
