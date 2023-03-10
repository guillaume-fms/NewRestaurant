
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *@since Jeudi 24 et Vendredi 25 Février 2023
 *@params Exos Execption /  Gestion de fichiers / retour sur le Tp Resto
 *@return Exercice 3.1 : AdvEx3File. Le gérant du resto souhaite imprimer les menus pour les déposer
 *sur les tables des clients d’une part et les transmettre en cuisine d’autre part afin de simplifier
 *son organisation.
 * 
 */

public class Restaurant {
	public static final String [] STARTER = 	{"entrée", "salade","soupe","quiche","aucune"};
	public static final String [] DISHES = 		{"plats" , "poulet" , "boeuf" , "poisson" , "végétarien" , "vegan","aucun"};
	public static final String [] SIDE_DISH = 	{"accompagnements" , "riz" , "pates" , "frites" , "légumes","aucun"};
	public static final String [] DRINKS = 		{"boissons" , "eau plate" , "eau gazeuze" , "soda" , "vin","aucune"};
	public static final String [] DESSERTS = 	{"desserts" , "tarte maison" , "mousse au chocolat" , "tiramisu","aucun"};

	// Définir les couleurs
	 public static final String RED = "\033[0;31m";
	 public static final String GREEN = "\033[0;32m";
	 public static final String YELLOW = "\033[0;33m";
	 public static final String BLUE = "\033[0;34m"; 
	 public static final String CYAN = "\033[0;36m";
	 public static final String PURPLE = "\033[0;35m";  
	
	public static void main(String[] args)  {	


		System.out.println(PURPLE + "Bonjour,combien de menus souhaitez vous ?");
		Scanner scan = new Scanner(System.in);
		int nbMenu;
		while(scan.hasNextInt() == false)	scan.next();
		nbMenu = scan.nextInt();
		ArrayList<String>  order = new ArrayList<String>();
		for(int i = 0 ; i < nbMenu ; i ++) {
			System.out.println(RED + "Commande numéro " + (i+1));
			int result = getInfos(scan,STARTER[0]);
			if(STARTER.length-1 > result)	order.add(STARTER[result]);

			result = getInfos(scan,DISHES[0]);
			if(DISHES.length-1 > result)	order.add(DISHES[result]);	

			result = getInfos(scan,SIDE_DISH[0]);
			if(SIDE_DISH.length-1 > result)	order.add(SIDE_DISH[result]);	

			result = getInfos(scan,DRINKS[0]);
			if(DRINKS.length-1 > result)	order.add(DRINKS[result]);

			result = getInfos(scan,DESSERTS[0]);
			if(DESSERTS.length-1 > result)	order.add(DESSERTS[result]);	

			System.out.println( GREEN + "Résumé de la commande "+(i+1));
			System.out.println(order);		//ici on pourrait stocker la commande en base par exemple
			System.out.println();          //avant de passer à la suivante

			try {
				// Créer et Ecrire dans le fichier 
				BufferedWriter fw = new BufferedWriter(new FileWriter("resto.txt", true));
				// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("restoCommande.txt")));
				fw.write(" ************** Résumé de la commande numéro " + (i+1) + " **************" +("\n" + order));
				fw.newLine(); 
				fw.flush();  // sert à vider le buffer
				fw.close();
			}
			catch (Exception e) {
				//System.out.println();
				e.printStackTrace();
			}
			
			System.out.println();
		}
	}
	public static int getInfos(Scanner scan, String info) {
		System.out.println("Choix " + info + " : ");
		if(info.equalsIgnoreCase(STARTER[0])) displayTable(STARTER);
		else if(info.equalsIgnoreCase(DISHES[0])) displayTable(DISHES);
		else if(info.equalsIgnoreCase(SIDE_DISH[0])) displayTable(SIDE_DISH);
		else if(info.equalsIgnoreCase(DRINKS[0])) displayTable(DRINKS);
		else if(info.equalsIgnoreCase(DESSERTS[0])) displayTable(DESSERTS);		
		System.out.println("Que souhaitez vous comme "+ info + " ? [saisir le chiffre correspondant]");
		return scan.nextInt();
	}
	public static void displayTable(String [] table) {
		for(int i=1;i<table.length;i++) {			
			System.out.print( YELLOW +"[" + i + " - " + table[i].toUpperCase() + "]");
		}
		System.out.println();
	}
}
