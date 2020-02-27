import java.util.List;

public class Dynamique {
	private double[][] table;
	private double maxWeight;
	private List<Objet> objects;
	
	public Dynamique(SacAdos a, SacAdos b) {
		this.maxWeight = a.getMaxWeight() * 100;
		this.table = new double[b.getSac().size()][(int) maxWeight + 1];
		objects = b.getSac();
	}

	public void DynamicAlgorithm(SacAdos backpack) {
		int m = 0;
		int z = 0;
		
		for (m =0; m < objects.size(); m++) {
			for (z = 0; z <= maxWeight; z++) { // le sac laisse 1 kg si inférieur
				if (m == 0){
					if (objects.get(0).getWeight() * 100 > z)
						table[0][z] = 0;
					else
						table[0][z] = objects.get(0).getValue();
				}
				
				else if (m != 0) {
					if (objects.get(m).getWeight() * 100 > z)
						table[m][z] = table[m - 1][z];
					else
						table[m][z] = Math.max(table[m - 1][z], table[m - 1][(z - (int) (objects.get(m).getWeight() * 100))] + (int) objects.get(m).getValue());
}
			}
			
		}
		
		
		m--;
		z--;
		

		while (table[m][z] == table[m][z - 1]) {
			z--;

		}

		while (z > 0) {
			
			while ((m > 0) && (table[m][z] == table[m - 1][z])) {
				--m;

			}
			
			z =(int) (z - (objects.get(m).getWeight() * 100));
			
			
				if (z >= 0) {
				backpack.ajouter(objects.get(m));

				--m;


			}
			
		}
			
	
		
	}
	
	
	
}


