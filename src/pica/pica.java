package pica;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class pica {
    public static void main(String[] args) {
        JMenu menu = new JMenu("Options");


        ImageIcon imageIcon = new ImageIcon("png");


        JMenuItem menuItem = new JMenuItem("Menu item", imageIcon);
        menu.add(menuItem);


    }
}
