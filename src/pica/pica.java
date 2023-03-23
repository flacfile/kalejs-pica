package pica;

public class pica {

	public static void main(String[] args) {
		//Idejas, kadas funkcijas bus programma
		//1. Sanemt visu par pirceju pirceju (telefona numurs, vards, uzvards, adrese)
		//2. Iesp�jams konstruet picu (lielums, piedevas, m�rces)
		//3. Cena mainas atkarigi no picas lieluma, piedavam utt.
		//ja klients picu izv�las iz�emt uz vietas ceptuv�, tad pieg�des cena nav j�iek�auj
		//4.Kadas ir akcijas (Piemeram perc 1 picu ar extra sieru, davana bus 1 maza pica)
		//5.Picerijas likumi(Privacy Policy)
		//6.Pas�t�juma izseko�ana
		//7. Picerijas adresi + kontakti
		//8. Pasutijumu vesture
		//Features: piedavat klientam dzerienu

		
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
		    public PizzaOrder(ArrayList<String> kadapica, String vards, String adrese, String telefonaNumurs, String size, ArrayList<String> toppings,
		            ArrayList<String> merces, boolean delivery) {
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
		    
		    
		}
		
	}
}
