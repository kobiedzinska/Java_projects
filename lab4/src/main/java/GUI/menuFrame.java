package GUI;

import GUI.PANELS.dishCreatePanel;
import GUI.PANELS.mainPanel;
import GUI.PANELS.menuPanel;
import GUI.PANELS.productListPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static GUI.GUI.*;

public class menuFrame extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu checkMyMenu;
    private JMenu checkProducts;
    private JMenuItem showMyMenuItem;
    private JMenuItem showMyProductsItem;
    private ImageIcon logo= new ImageIcon("D:\\JP\\lab4\\src\\main\\resources\\bobthebuilder.png");
    private JPanel contentPanel;
    private CardLayout cardLayout= new CardLayout();

    public menuFrame() throws IOException, ClassNotFoundException {
        createLayoutFrame(this,"DietBuilder",550,550);
        this.setIconImage(logo.getImage());

        //MENUBAR
        menuBar=new JMenuBar();
        checkMyMenu=createMenu("My menu");
        checkProducts=createMenu("My products");

        showMyMenuItem=createMenuItem("Show my menu");
        showMyProductsItem=createMenuItem("Show my list of products");

        checkProducts.add(showMyProductsItem);
        checkMyMenu.add(showMyMenuItem);

        menuBar.add(checkMyMenu);
        menuBar.add(checkProducts);
        this.setJMenuBar(menuBar);

//CONTENT PANEL
    contentPanel=createPanel(Color.GRAY,500,500);
    contentPanel.setLayout(cardLayout);

       dishCreatePanel dishCreatePanel1=new dishCreatePanel();
       mainPanel mainPanel1=new mainPanel(new Color(9,84,162),500,500);
       menuPanel menuPanel1=new menuPanel(new Color(9,84,162),500,500);
       productListPanel productListPanel=new productListPanel();

        contentPanel.add(mainPanel1, "mainPanel");
        contentPanel.add(menuPanel1,"menuPanel");
        contentPanel.add(productListPanel,"productsPanel");
        contentPanel.add(dishCreatePanel1, "createPanel");

        cardLayout.show(contentPanel, "mainPanel");
        this.add(contentPanel);

        setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public JMenuItem getShowMyMenuItem(){
        return showMyMenuItem;
    }

    public JMenuItem getShowMyProductsItem() {
        return showMyProductsItem;
    }

    public CardLayout getCardLayout(){
        return cardLayout;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
