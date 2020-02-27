import java.io.IOException;
import java.util.Scanner;

public class Appli {
	public static void main(String[] args) throws IOException 
	{
		SacAdos a = new SacAdos(); 
		String chemin;
		double  poidsMax;
		String methode;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Entrez le nom du fichier à ouvrir");
		chemin = sc.nextLine();
		SacAdos.ReadFile(chemin);
		a.getList();
		System.out.println("Entrez le poids  maximum du sac ");
		poidsMax=sc.nextDouble();
		SacAdos  b = new SacAdos(chemin,poidsMax);
		System.out.println("Entrez la méthode de trie (glouton,dynamique,pse) ");
		methode= sc1.nextLine();
		System.out.println(chemin+" "+poidsMax+" "+methode);
		switch(methode)
		{
		case "pse":
			PSE p = new PSE();
			p.triPSE(a);
			a.getob();
			break;
		case "dynamique":
			Dynamique d = new Dynamique(b,a);
			d.DynamicAlgorithm(a);
			a.getob();
			break;
		case "glouton":
			Glouton g= new Glouton();
			
			g.trieGlouton(a);
			Glouton.trierSac(a, b);
			a.getbag();

		}

}
}
