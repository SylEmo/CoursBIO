public class KMPAlgorithm {
	
	private String pattern, sequence;
	private int tabComputePattern[];
	
	public KMPAlgorithm(String pattern, String sequence){
		this.pattern = pattern;
		System.out.println("Pattern utilisé : " + pattern);
		this.sequence = sequence;
		tabComputePattern = new int[pattern.length()];
	}
	
	public void doYourJob(){
		System.out.println("Lancement du pre-process...");
		
		computeTab();
		System.out.print("Tableau après pre-process : ");
		for (int i = 0; i < pattern.length() ; i++) {
			System.out.print(tabComputePattern[i] + " ");
		}
		
		
	}
	
	public void computeTab(){
		int index = 0, v = 0;
		
		tabComputePattern[0] = 0; // pour la première lettre du pattern
		
		while (index < pattern.length() - 1) {
			System.out.print(" -- Nouvelle boucle : index = " + index);
			System.out.print(", ");
			index++;
			System.out.print("incrément index = " + index);
			System.out.print(", ");
			System.out.print("pattern.charAt(v) = " + pattern.charAt(v) + ", pattern.charAt(index) = " + pattern.charAt(index));
			System.out.print(", ");
			if (pattern.charAt(v) == pattern.charAt(index)) {
				System.out.print("rentre IF");
				System.out.print(", ");
				v++;
				System.out.print("v = " + v);
				System.out.print(", ");
			}
			else {
				System.out.print("rentre ELSE");
				System.out.print(", ");
				v = 0;
				System.out.print("v = " + v);
				System.out.print(", ");
			}
			tabComputePattern[index] = v;
			System.out.print("tabComputePattern[index] = " + tabComputePattern[index]);
			System.out.println(" -- ");
		}
	}
	
	public void search(){
		
	}
}
