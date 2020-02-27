public class Objet {
	private double weight;
	private double value;
	private double relation;
	private String name;
	
	/**
	 * Constructeur d'un objet prenant en param鑤re son nom, son poids et sa valeur
	 */
	public Objet(String name, double weight, double value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.relation = value / weight; // rapport
	}
	
	/**
	 * Fonction retournant l'objet courant (?)
	 */
	public Objet getObj() {
		return this;
	}
	
	/**
	 * Fonction retournant le nom d'un objet
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Fonction retournant le poids d'un objet
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Fonction retournant la valeur d'un objet
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Fonction retournant le rapport entre la valeur et le poids d'un objet
	 */
	public double getRelation() {
		return relation;
	}
	
	/**
	 * Fonction retournant une cha頽e de caract鑢es contenant le nom, le poids et la valeur d'un objet
	 */
//	public String toString(){
//		return name + " " + weight + "kg " + value + "�\n"; 
//	}
	public String str() {
		return name + " [value = " + value + ", weight = " + weight + "]";
	}
	
}
