import java.util.Collections;
import java.util.Comparator;

public class Glouton {
	public static Comparator<Objet> ComparatorRapport = new Comparator<Objet>() {
        public int compare(Objet obj1, Objet obj2) {
            return (int) (obj2.getRelation() - obj1.getRelation());
        }
	};
	public void trieGlouton(SacAdos a) {
		Collections.sort(a.getSac(), Glouton.ComparatorRapport);
	}
	public static void trierSac(SacAdos a,SacAdos b)
	{

		double p=0;
		while (p!=b.getMaxWeight())
		{
			for(Objet o : a.getSac())
			{
				if (o.getWeight()+p<=b.getMaxWeight())
				{
					b.getbag().add(o);
					p=p+o.getWeight();
					System.out.println(o.getName());
				}
				else
					System.out.println(o.getName() + " est trop lourd");
				if (p==b.getMaxWeight())
					return;
			}
		}
			
	}	
	}


