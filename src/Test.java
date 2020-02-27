import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {

		SacAdos backpack1 = new SacAdos();
		SacAdos backpack2 = new SacAdos("test", 16);
		
		backpack1.ReadFile("test");
		backpack1.getList();
		Glouton g= new Glouton();
		System.out.println();
		g.trieGlouton(backpack1);
		Glouton.trierSac(backpack1, backpack2);
		backpack2.getBag();
		
		
		
		
		
		
		
		

		
		

		
		
				

		}
}