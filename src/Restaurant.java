
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*@author PastorGuillaume
 *@since Jeudi 24 et Vendredi 25 Février 2023
 *@params Exos Execption
 *@return Exercice 3 : AdvEx3File. Le gérant du resto souhaite imprimer les menus pour les déposer
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

	public static void main(String[] args) {	
		
		try {
			  
            // Recevoir le fichier 
			BufferedWriter fw = new BufferedWriter(new FileWriter("resto.txt"));
           //FileWriter fw = new FileWriter("resto.txt");
           fw.write("*********** Voici les commandes ***********");
           fw.newLine();
           fw.close();
           System.out.println("Le texte a été écrit avec succès");
            // Créer un nouveau fichier
           // Vérifier s'il n'existe pas
            //if (f.createNewFile())
            //    System.out.println("Fichier crée");
            //else
             //   System.out.println("Fichier existe déjà");
        }
        catch (Exception e) {
        	System.out.println("toto");
            e.printStackTrace();
        }
		System.out.println("bonjour,combien de menus souhaitez vous ?");
		Scanner scan = new Scanner(System.in);
		int nbMenu;
		while(scan.hasNextInt() == false)	scan.next();
		nbMenu = scan.nextInt();
		ArrayList<String>  order = new ArrayList<String>();
		for(int i = 0 ; i < nbMenu ; i ++) {
			System.out.println("Commande numéro " + (i+1));
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

			System.out.println("Résumé de la commande "+(i+1));
			System.out.println(order);		//ici on pourrait stocker la commande en base par exemple
			System.out.println();			//avant de passer à la suivante
			order.clear();
		}
		
	}
	public static int getInfos(Scanner scan, String info) {
		System.out.println("choix " + info + " : ");
		if(info.equalsIgnoreCase(STARTER[0])) displayTable(STARTER);
		else if(info.equalsIgnoreCase(DISHES[0])) displayTable(DISHES);
		else if(info.equalsIgnoreCase(SIDE_DISH[0])) displayTable(SIDE_DISH);
		else if(info.equalsIgnoreCase(DRINKS[0])) displayTable(DRINKS);
		else if(info.equalsIgnoreCase(DESSERTS[0])) displayTable(DESSERTS);		
		System.out.println("que souhaitez vous comme "+ info + " ? [saisir le chiffre correspondant]");
		return scan.nextInt();
	}	
	public static void displayTable(String [] table) {
		for(int i=1;i<table.length;i++) {			
			System.out.print("[" + i + " - " + table[i].toUpperCase() + "]");
		}
		System.out.println();	
	}	
}
