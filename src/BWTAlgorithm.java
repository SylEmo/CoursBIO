import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */

/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
public class BWTAlgorithm {

	private String sequence;
	/**
	 * 
	 */
	public BWTAlgorithm(String sequence) {
		this.sequence = sequence;
	}
	
	public void makeMeDream() {
		int sequenceLength = sequence.length();
		char listChars[] = new char[sequenceLength + 1];
		ArrayList<String> arraySequencesBeforeSort = new ArrayList<String>();
		char listeCharsAfterBWT[] = new char[sequenceLength + 1];
		HashMap<Integer, String> test = new HashMap<>();
		
		System.out.println("Récupération des lettres qui composent la chaîne :");
		for (int i = 0; i < sequenceLength; i++) {
			listChars[i] = sequence.charAt(i);
			System.out.print("-" + listChars[i]);
		}
		System.out.println("-\n");
		
		System.out.println("Récupération des combinaisons de la chaîne :");
		
		arraySequencesBeforeSort.add(sequence);
		System.out.println("- " + sequence);
		String currentNewSequence = "";
		for (int i = 1; i < sequenceLength - 1; i++) {
			currentNewSequence = arraySequencesBeforeSort.get(i - 1);
			currentNewSequence = currentNewSequence.charAt(sequenceLength - 1) + 
					currentNewSequence.substring(0, sequenceLength - 1);
			System.out.println("- " + currentNewSequence);
			arraySequencesBeforeSort.add(currentNewSequence);
		}
		
		System.out.println("\nTri des combinaisons par ordre alphabétique :");
		Collections.sort(arraySequencesBeforeSort);
		for (String string : arraySequencesBeforeSort) {
			System.out.println("- " + string);
		}
		
		System.out.println("\nRécupération de la dernière lettre de chaque combinaison :");
		int i = 0;
		for (String string : arraySequencesBeforeSort) {
			listeCharsAfterBWT[i] = string.charAt(string.length() - 1);
			System.out.print("-" + listeCharsAfterBWT[i]);
			i++;
		}
		System.out.print("-");
	}
}
