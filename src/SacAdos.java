import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SacAdos {
	private static double maxWeight;
	private static ArrayList<Objet> objects;
	private static ArrayList<Objet> Bag;
	private String path;
	private List<Objet> ob;
	private static double p;
	
	/**
	 * Constructeur d'un sac à dos
	 */
	public SacAdos() {
		objects = new ArrayList<Objet>();
		Bag = new ArrayList<Objet>();
		ob=new ArrayList<Objet>();
	}
	
	/**
	 * Constructeur d'un sac à dos prenant en paramètre le chemin du fichier 
	 * ayant la liste des objets du sac à dos et son poids maximal
	 */
	public SacAdos(String path, double maxWeight) {
		this.path = path;
		this.maxWeight = maxWeight;
		Bag = new ArrayList<Objet>();
		ob=new ArrayList<Objet>();

	}
	
	/**
	 * Fonction permettant d'ajouter un objet dans le sac
	 */
	public void ajouter(Objet obj) {
		ob.add(obj);
	}
	
	/**
	 * Fonction permettant d'obtenir la liste des objets disponibles
	 */
	public  void getList() {
		
		int compteur = 1;
		
		for (Objet o : objects) {
			System.out.println(compteur + " - " +  o.getName());
			++compteur;
		}
		
		
	}
	
	/**
	 * Ajoute un objet dans la liste des objets disponibles
	 * Prend en paramètre le nom, le poids et la valeur de l'objet
	 */
	public static void addObject(String name, double weight, double value) {
		Objet obj = new Objet(name, weight, value);
		objects.add(obj);
	}
	
	/**
	 * Fonction permettant de lire tout le contenu d'un fichier
	 * Prend en paramètre le nom du fichier (incluant son chemin)
	 */
	public static void ReadFile(String path) throws FileNotFoundException {
		try {
			File f = new File (path + ".txt");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(f).useDelimiter(" ; |\n");
			
			while (scanner.hasNext()) {
				addObject(scanner.next(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
			}
			
			scanner.close();
		}
		catch (FileNotFoundException NotFounded) {
			System.out.println("Fichier non trouvé");
		}
	}
	
	/**
	 * ?
	 */
	
	
	/**
	 * Fonction permettant d'obtenir le poids maximal du sac
	 */
	public double getMaxWeight() {
		return maxWeight;
	}

	
	public ArrayList<Objet> getSac() 
	{
		return objects;
	}
	public void getBag()
	{
		int compteur = 0;
		
		for (Objet o : Bag) {
			System.out.println(compteur + " - " +  o.getName());
			++compteur;
		}
	}
	public void getob() 
	{
		int compteur = 1;
		
		for (Objet o : ob) {
			System.out.println(compteur + " - " +  o.getName());
			++compteur;
		}
	}
	
	public static void trierSac()
	{
		while (p!=maxWeight)
		{
			for(Objet o : objects)
			{
				if (o.getWeight()<maxWeight)
				{
					Bag.add(o);
					p=p+o.getWeight();
				}
				else
					System.out.println(o.getName() + " est trop lourd");
				if (p==maxWeight)
					return;
			}
		}
			
		
	}
	public ArrayList<Objet> getbag()
	{
		return Bag;
	}
	
	
	
	
}
