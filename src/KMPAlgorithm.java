public class KMPAlgorithm {
	
	private String pattern, sequence;
	private int tabComputePattern[];
	
	public KMPAlgorithm(String pattern, String sequence){
		this.pattern = pattern;
		System.out.println("Pattern utilisé : " + pattern + " de taille " + pattern.length());
		this.sequence = sequence;
		System.out.println("Séquence utilisée : " + sequence + " de taille " + sequence.length());
		tabComputePattern = new int[pattern.length()];
	}
	
	public void doYourJob(){
		System.out.println("\nLancement du pre-process...");
		computeTab();
		
		System.out.print("\nTableau après pre-process : ");
		for (int i = 0; i < pattern.length() ; i++)
			System.out.print(tabComputePattern[i] + " ");
		
		System.out.println("\n\nLancement de la recherche...");
		search();
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
			System.out.print("pattern.charAt(v) = " + pattern.charAt(v) +
					", pattern.charAt(index) = " + pattern.charAt(index));
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
		int similarChars = 0, patternsFound = 0, indexPat = 0;
		
		for (int indexSeq = 0; indexSeq < sequence.length() - 1; indexSeq++) {
			System.out.print(" -- Nouvelle boucle : indexSeq = " + indexSeq);
			System.out.print(", ");
			
			System.out.print("? " + pattern.charAt(indexPat) +	" == " + 
					sequence.charAt(indexSeq + indexPat));
			System.out.print(" ? ");
			while (indexPat < pattern.length() && indexPat + indexSeq < sequence.length() 
					&& pattern.charAt(indexPat) == sequence.charAt(indexSeq + indexPat)) {	
				similarChars++;
				System.out.print("incrément similarChars = " + similarChars);
				System.out.print(", ");
				indexPat++;
				System.out.print("incrément indexPat = " + indexPat);
				System.out.print(", ");
				
				if (indexPat == pattern.length()) {
					System.out.print("\n -- !!!!!!! Pattern trouvé à la position " + indexSeq);
					System.out.print(" !!!!!!! ");
					patternsFound++;
					indexSeq += pattern.length() - 1;
					System.out.print("modif indexSeq = " + indexSeq);
					System.out.print(", ");
				}
				else {
					try {
						System.out.print("? " + pattern.charAt(indexPat) +	" == " + 
								sequence.charAt(indexSeq + indexPat));
						System.out.print(" ? ");
					}catch(Exception e){}
				}
			}
			if (similarChars != 0) {
				indexSeq += ((similarChars - tabComputePattern[similarChars - 1]) - 1);
				System.out.print("modif indexSeq = " + indexSeq + " avec tabComputePattern[similarChars - 1] = " + 
						tabComputePattern[similarChars - 1] + " - 1");
				System.out.print(", ");
				similarChars = 0;
				System.out.print("réinit similarChars = " + similarChars);
				System.out.print(", ");
				indexPat = 0;
				System.out.print("réinit indexPat = " + indexPat);
				System.out.print(" -- ");
			}
			System.out.println();
		}
	}
}
