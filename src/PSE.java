import java.util.ArrayList;

public class PSE {
	public static void triPSE(SacAdos a) {
		Arbre racine = new Arbre();
		PSE.ajouterBranche(a, racine, 0);
		ArrayList<Arbre> valeur = new ArrayList<Arbre>();
		PSE.getArbre(valeur, racine, 0, a.getSac().size());
		Double tmp = (double) 0;
		int indice = 0;
		for (int i = 0; i < valeur.size(); i++) { //on recherche le meilleur arbe dans valeur et on prends  l'indice
			if (tmp.compareTo(valeur.get(i).getValue()) < 0) {
				indice = i;
				tmp = (double) valeur.get(i).getValue();	
			}
		}
		for (int i = 0; i < valeur.get(indice).getObjet().size(); i++) {  
			a.ajouter(valeur.get(indice).getObjet().get(i));
		}
	}
	
	//on ajoute des branche à l'arbre (c'est récursif)
	public static void ajouterBranche(SacAdos a, Arbre arbre, int tailleABR) {
		if (a.getSac().size() > tailleABR) {
			Arbre gauche = new Arbre(arbre.getObjet());
			Double tmp;
			tmp = (Double) (gauche.getWeight() + a.getSac().get(tailleABR).getWeight());
			if (tmp.compareTo(a.getMaxWeight()) <= 0) {
				gauche.getObjet().add(a.getSac().get(tailleABR));
				arbre.ajouterG(gauche);
				PSE.ajouterBranche(a, arbre.getGauche(), tailleABR + 1);
			}
			Arbre droite = new Arbre(arbre.getObjet());
			arbre.ajouterD(droite);
			PSE.ajouterBranche(a, arbre.getDroite(), tailleABR + 1);
				
		}
		
	}
	
	// met dans tab toutes les branches d'indice max
	public static void getArbre(ArrayList<Arbre> tab, Arbre a, int tailleABR, int max) {
		if (tailleABR == max) {
			tab.add(a);
		}
		else {
			if (a.getDroite() != null)
				PSE.getArbre(tab, a.getDroite(), tailleABR + 1, max);
			if (a.getGauche() != null)
				PSE.getArbre(tab, a.getGauche(), tailleABR + 1, max);
		}
	}
}
