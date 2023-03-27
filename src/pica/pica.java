package pica;
import javax.swing.JOptionPane;
import java.util.ArrayList;

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
            ArrayList<String> toppings, ArrayList<String> merces, boolean delivery) {
        this.vards = vards;
        this.adrese = adrese;
        this.telefonaNumurs = telefonaNumurs;
        this.kadapica = kadapica;
        this.size = size;
        this.toppings = toppings;
        this.merces = merces;
        this.delivery = delivery;
        this.delivered = false;
        this.price = calculatePrice();
    }

    public double calculatePrice() {
        double basePrice = 0.0;
        if (this.size.equals("Small")) {
            basePrice = 6.99;
        } else if (this.size.equals("Medium")) {
            basePrice = 9.99;
        } else if (this.size.equals("Large")) {
            basePrice = 12.99;
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
                String vards = JOptionPane.showInputDialog("Ievadi vards:");
                String adrese = JOptionPane.showInputDialog("Ievadi adrese:");
                String telefonaNumurs = JOptionPane.showInputDialog("Ievadi telefona numuru:");
                Object[] sizeOptions = { "Small", "Medium", "Large" };
                String size = (String) JOptionPane.showInputDialog(null, "Izvelies izmeru:", "Pizza Orders",
                        JOptionPane.PLAIN_MESSAGE, null, sizeOptions, sizeOptions[0]);
                ArrayList<String> toppings = new ArrayList<String>();
                while (true) {
                    Object[] toppingOptions = { "Pepperoni", "Senes", "Sipols", "Ananas", "Siera kubiki", "Olīvas", "Sēnes" };
                    Object selectedTopping = JOptionPane.showInputDialog(null, "Izvēlies pildījumu:",
                            "Pizza Orders", JOptionPane.PLAIN_MESSAGE, null, toppingOptions, toppingOptions[0]);
                    if (selectedTopping == null) {
                        break;
                    }
                    toppings.add(selectedTopping.toString());
                }

                ArrayList<String> merces = new ArrayList<String>();
                while (true) {
                    Object[] merchandiseOptions = { "Mērce", "Ķiploku mērce", "BBQ mērce", "Siera mērce",
                            "Tomātu mērce" };
                    Object selectedMerchandise = JOptionPane.showInputDialog(null, "Izvēlies mērci:", "Pizza Orders",
                            JOptionPane.PLAIN_MESSAGE, null, merchandiseOptions, merchandiseOptions[0]);
                    if (selectedMerchandise == null) {
                        break;
                    }
                    merces.add(selectedMerchandise.toString());
                }

                Object[] deliveryOptions = { "Yes", "No" };
                String delivery = (String) JOptionPane.showInputDialog(null, "Vai pasūtījums ir ar piegādi?",
                        "Pizza Orders", JOptionPane.PLAIN_MESSAGE, null, deliveryOptions, deliveryOptions[0]);

                ArrayList<String> kadapica = new ArrayList<String>();
                Object[] pizzaOptions = { "Margarīta", "Pepperoni", "Veģetārijas", "Havaju" };
                Object selectedPizza = JOptionPane.showInputDialog(null, "Izvēlies picu:", "Pizza Orders",
                        JOptionPane.PLAIN_MESSAGE, null, pizzaOptions, pizzaOptions[0]);
                kadapica.add(selectedPizza.toString());

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


