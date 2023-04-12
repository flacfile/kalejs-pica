package pica;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
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
