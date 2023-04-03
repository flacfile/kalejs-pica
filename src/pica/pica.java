package pica;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class pica {
    public static void main(String[] args) {
        ImageIcon img = new ImageIcon("image.png");
        JOptionPane.showMessageDialog(null, null, "Pizza Top", JOptionPane.INFORMATION_MESSAGE,img);


    }
}
