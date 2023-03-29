package pica;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
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
    boolean delivered;
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
        this.delivered = false;
        this.price = calculatePrice();
    }

    public double calculatePrice() {
        double basePrice = 0.0;
        if (this.kadapica.contains("Margarīta")) {
            if (this.size.equals("Small")) {
                basePrice = 5.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 6.99;
            } else if (this.size.equals("Large")) {
                basePrice = 7.99;
            }
        } else if (this.kadapica.contains("Pepperoni")) {
            if (this.size.equals("Small")) {
                basePrice = 6.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 8.99;
            } else if (this.size.equals("Large")) {
                basePrice = 9.99;
            }
        } else if (this.kadapica.contains("Veģetārijas")) {
            if (this.size.equals("Small")) {
                basePrice = 7.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 8.99;
            } else if (this.size.equals("Large")) {
                basePrice = 9.99;
            }
        } else if (this.kadapica.contains("Havaju")) {
            if (this.size.equals("Small")) {
                basePrice = 8.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 10.99;
            } else if (this.size.equals("Large")) {
                basePrice = 12.99;
            }
        } else if (this.kadapica.contains("Bombastik")) {
            if (this.size.equals("Small")) {
                basePrice = 9.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 10.99;
            } else if (this.size.equals("Large")) {
                basePrice = 13.99;
            }
        } else if (this.kadapica.contains("Vulkanu")) {
            if (this.size.equals("Small")) {
                basePrice = 11.99;
            } else if (this.size.equals("Medium")) {
                basePrice = 13.99;
            } else if (this.size.equals("Large")) {
                basePrice = 15.99;
            }
        }
        double toppingsPrice = this.toppings.size() * 0.5;
        double mercesPrice = this.merces.size() * 0.25;
        double deliveryPrice = this.delivery ? 2.0 : 0.0;
        return basePrice + toppingsPrice + mercesPrice + deliveryPrice;
    }


    public String toString() {
        return "Pica veids: " + this.kadapica + "\nVards: " + this.vards + "\nAdrese: " + this.adrese
                + "\nTelefonaNumurs: " + this.telefonaNumurs + "\nSize: " + this.size + "\nToppings: "
                + this.toppings.toString() + "\nMerces: " + this.merces.toString() + "\nDelivery: " + this.delivery
                + "\nDelivered: " + this.delivered + "\nPrice: " + this.price +"$";
    }
    


    
}



public class pica {
	


    
    public static void main(String[] args) {
        ArrayList<PizzaOrder> activeOrders = new ArrayList<PizzaOrder>();
        ArrayList<PizzaOrder> deliveredOrders = new ArrayList<PizzaOrder>();

        while (true) {
            String[] options = { "Jauns pasutijums", "Paradit aktivus pasutijumus", "Paradit delievered pasutijumus", "Exit" };
            int choice = JOptionPane.showOptionDialog(null, "Izveleties opciju:", "Pizza Orders", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                ArrayList<String> kadapica = new ArrayList<String>();
                Object[] pizzaOptions = { "Margarīta", "Pepperoni", "Veģetārijas", "Havaju", "Bombastik", "Vulkanu" };
                Object selectedPizza = JOptionPane.showInputDialog(null, "Izvēlies picu:", "Pizza Orders",
                        JOptionPane.PLAIN_MESSAGE, null, pizzaOptions, pizzaOptions[0]);
                kadapica.add(selectedPizza.toString());
                
                Object[] sizeOptions = { "Small", "Medium", "Large" };
                String size = (String) JOptionPane.showInputDialog(null, "Izvelies izmeru:", "Pizza Orders",
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
                int result = JOptionPane.showConfirmDialog(null, panel, "Izvēlies pildījumu:", JOptionPane.OK_OPTION);
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
                int result1 = JOptionPane.showConfirmDialog(null, panel1, "Izvēlies merces:", JOptionPane.OK_OPTION);
                if (result1 == JOptionPane.OK_OPTION) {
                    for (JCheckBox checkBox : checkBoxes1) {
                        if (checkBox.isSelected()) {
                            merces.add(checkBox.getText());
                        }
                    }
                }

  
                Object[] deliveryOptions = { "Yes", "No" };
                String delivery = (String) JOptionPane.showInputDialog(null, "Vai pasūtījums ir ar piegādi?",
                        "Pizza Orders", JOptionPane.PLAIN_MESSAGE, null, deliveryOptions, deliveryOptions[0]);


                String vards = JOptionPane.showInputDialog("Ievadi vards:");
                String adrese = JOptionPane.showInputDialog("Ievadi adrese:");
                String telefonaNumurs = JOptionPane.showInputDialog("Ievadi telefona numuru:");
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
                        ordersList.append(i + 1).append(". ").append(activeOrders.get(i).toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, ordersList.toString(), "Active orders",
                            JOptionPane.PLAIN_MESSAGE);
                }
            } else if (choice == 2) {
              //saveOrdersToFile(deliveredOrders);
            	if (deliveredOrders.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nav piegādātu pasūtījumu!");
                } else {
                    StringBuilder ordersList = new StringBuilder();
                    for (int i = 0; i < deliveredOrders.size(); i++) {
                        ordersList.append(i + 1).append(". ").append(deliveredOrders.get(i).toString())
                                .append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, ordersList.toString(), "Delivered orders",
                            JOptionPane.PLAIN_MESSAGE);

                }
            } else {
            	break;
            }
        }
        
    }
}


