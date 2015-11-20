import java.util.ArrayList;


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
		computeTab();
	}
	
	public void computeTab(){
		int lengthPattern = pattern.length();
		int j = 0;
		
		tabComputePattern[0] = 0; // pour la première lettre du pattern
		
		for (int i = 1; i < lengthPattern; i++) {
			System.out.print("- Nouvelle boucle --->> i = " + i);
			while (j > 0 && pattern.charAt(j + 1) != pattern.charAt(i)){
				j = tabComputePattern[j];
				System.out.print(", j = " + j + ", pattern.chartAt(i) = " + pattern.charAt(i));
			}
			System.out.print(", IF pattern.charAt(j + 1) = " + pattern.charAt(j + 1) + ", pattern.charAt(i) = " + pattern.charAt(i));
			if (pattern.charAt(j + 1) == pattern.charAt(i)){
				j++;
				System.out.print(", j = " + j);
			}
			tabComputePattern[i] = j;
			System.out.println(", tabCoputePattern[i] = " + tabComputePattern[i]);
		}
	}
}
