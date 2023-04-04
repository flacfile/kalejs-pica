package pica;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class PizzaOrder {
    String vards;
    String adrese;
    String telefonaNumurs;
    String size;
    ArrayList<String> toppings;
    ArrayList<String> merces;
    ArrayList<String> kadapica;
    boolean delivery;
    double price; 

    
    
    public PizzaOrder(ArrayList<String> kadapica, String vards, String adrese, String telefonaNumurs, String size,
            List<String> toppings2, List<String> merces2, boolean delivery) {
        this.vards = vards;
        this.adrese = adrese;
        this.telefonaNumurs = telefonaNumurs;
        this.kadapica = kadapica;
        this.size = size;
        this.toppings = (ArrayList<String>) toppings2;
        this.merces =  (ArrayList<String>) merces2;
        this.delivery = delivery;
        this.price = calculatePrice();
    }

    public double calculatePrice() {
        double basePrice = 0.0;
        if (this.kadapica.contains("Margarīta")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 7.99;
            } else if (this.size.equals("Large")) {
                basePrice = 10.99;
            }
        } else if (this.kadapica.contains("Pepperoni")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 7.99;
            } else if (this.size.equals("Large")) {
                basePrice = 10.99;
            }
        } else if (this.kadapica.contains("Veģetārijas")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 7.99;
            } else if (this.size.equals("Large")) {
                basePrice = 10.99;
            }
        } else if (this.kadapica.contains("Havaju")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 7.99;
            } else if (this.size.equals("Large")) {
                basePrice = 10.99;
            }
        } else if (this.kadapica.contains("Bombastik")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 7.99;
            } else if (this.size.equals("Large")) {
                basePrice = 10.99;
            }
        } else if (this.kadapica.contains("Vulkanu")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 7.99;
            } else if (this.size.equals("Large")) {
                basePrice = 10.99;
            }
        }
        double toppingsPrice = this.toppings.size() * 0.5;
        double mercesPrice = this.merces.size() * 0.25;
        double deliveryPrice = this.delivery ? 2.0 : 0.0;
        return basePrice + toppingsPrice + mercesPrice + deliveryPrice;
    }


    public String picainfo() {
        return "Pica veids: " + kadapica + "\nVards: " + vards + "\nAdrese: " + adrese
                + "\nTelefonaNumurs: " + telefonaNumurs + "\nSize: " + size + "\nToppings: "
                + toppings + "\nMerces: " + merces + "\nDelivery: " + delivery
                + "\nPrice: " + price +"$";
    }
    


    
}



public class pica {
	
	

    
    public static void main(String[] args) {
    	
        ArrayList<PizzaOrder> activeOrders = new ArrayList<PizzaOrder>();
        ImageIcon img = new ImageIcon("image.png");
        JOptionPane.showMessageDialog(null, null, "Welcome to Pizza Top", JOptionPane.INFORMATION_MESSAGE,img);

        while (true) {
            String[] options = { "Jauns pasutijums", "Paradit aktivus pasutijumus", "Exit" };
            int choice = JOptionPane.showOptionDialog(null, "Izveleties opciju:", "Pizza Orders", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                ArrayList<String> kadapica = new ArrayList<String>();
                Object[] pizzaOptions = { "Margarīta", "Pepperoni", "Veģetārijas", "Havaju", "Bombastik", "Vulkanu" };
                Object selectedPizza = JOptionPane.showInputDialog(null, "Izvēlies picu:", "Pizza Orders",
                        JOptionPane.PLAIN_MESSAGE, null, pizzaOptions, pizzaOptions[0]);
                kadapica.add(selectedPizza.toString());
                
                Object[] sizeOptions = { "Small", "Medium", "Large" };
                String size = (String) JOptionPane.showInputDialog(null, "Small:5,99$ | Medium:7,99$ | Large:10,99$ | Izvelies izmeru:", "Pizza Orders",
                        JOptionPane.PLAIN_MESSAGE, null, sizeOptions, sizeOptions[0]);
                
                
                List<String> toppings = new ArrayList<>();
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                String[] toppingOptions = {"Pepperoni", "Sēnes", "Sīpols", "Ananas", "Siera kubiki", "Olīvas"};
                JCheckBox[] checkBoxes = new JCheckBox[toppingOptions.length];
                for (int i = 0; i < toppingOptions.length; i++) {
                    checkBoxes[i] = new JCheckBox(toppingOptions[i]);
                    panel.add(checkBoxes[i]);
                }
                int result = JOptionPane.showConfirmDialog(null, panel, "Izvēlies pildījumu (katrs pildijums 0,5$):", JOptionPane.OK_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    for (JCheckBox checkBox : checkBoxes) {
                        if (checkBox.isSelected()) {
                            toppings.add(checkBox.getText());
                        }
                    }
                }

                
                List<String> merces = new ArrayList<>();
                JPanel panel1 = new JPanel();
                panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
                String[] mercesOptions = {"Ķiploku", "BBQ", "Ketcups", "Majonese"};
                JCheckBox[] checkBoxes1 = new JCheckBox[mercesOptions.length];
                for (int i = 0; i < mercesOptions.length; i++) {
                    checkBoxes1[i] = new JCheckBox(mercesOptions[i]);
                    panel1.add(checkBoxes1[i]);
                }
                int result1 = JOptionPane.showConfirmDialog(null, panel1, "Izvēlies merces (katra merce 0,25$):", JOptionPane.OK_OPTION);
                if (result1 == JOptionPane.OK_OPTION) {
                    for (JCheckBox checkBox : checkBoxes1) {
                        if (checkBox.isSelected()) {
                            merces.add(checkBox.getText());
                        }
                    }
                }
                
                
                String vards;
                do {
                    vards = JOptionPane.showInputDialog("Ievadi vardu:");
                    if (vards.length() < 2) {
                        JOptionPane.showMessageDialog(null, "Kluda! (Min 2 simboli vardā)");
                    }
                } while (vards.length() < 2);
                
                
                String telefonaNumurs;
                do {
                    telefonaNumurs = JOptionPane.showInputDialog("Ievadi telefona numuru:");
                    if (telefonaNumurs.length() < 8 || telefonaNumurs.length() > 8) {
                        JOptionPane.showMessageDialog(null, "Kluda! (8 cipari numurā)");
                    }
                } while (telefonaNumurs.length() < 8 || telefonaNumurs.length() > 8);
                
                
                Object[] deliveryOptions = { "Yes", "No" };
                String delivery = (String) JOptionPane.showInputDialog(null, "Vai pasūtījums ir ar piegādi (piegāde 2$)? ",
                        "Pizza Orders", JOptionPane.PLAIN_MESSAGE, null, deliveryOptions, deliveryOptions[0]);
                String adrese = "";
                if (delivery.equals("Yes")) {
                    adrese = JOptionPane.showInputDialog("Ievadi adresi:");
                }

                PizzaOrder newOrder = new PizzaOrder(kadapica, vards, adrese, telefonaNumurs, size, toppings, merces,
                        delivery.equals("Yes"));
                activeOrders.add(newOrder);

                JOptionPane.showMessageDialog(null, "Pasūtījums pievienots!");

            } else if (choice == 1) {
                if (activeOrders.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nav aktīvu pasūtījumu!");
                } else {
                    StringBuilder ordersList = new StringBuilder();
                    for (int i = 0; i < activeOrders.size(); i++) {
                        ordersList.append(i + 1).append(". ").append(activeOrders.get(i).picainfo()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, ordersList, "Aktivi pasutijumi",
                            JOptionPane.PLAIN_MESSAGE);
                }
      
            } else {
            	break;
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"))) {
            for (PizzaOrder order : activeOrders) {
                writer.write(order.picainfo()+"\n");
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kluda!");

        }
    }
}


