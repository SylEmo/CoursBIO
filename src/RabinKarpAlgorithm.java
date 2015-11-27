/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RabinKarpAlgorithm {
	private String pattern;
	private long patternHash;
	/** pattern length **/
	private int M;
	private long Q;
	private long RM;

	static final String text = "GAATTCGAGATGCGAATGAGCAGCAGCCATTTTGATGTTGTGAGCATCGGAACGTTTCTGCG\n"
			+ "TCCGTACACTGTCCTTTTGTTACTTAGATAATGGCTAAGGCAAGCAGTCCGGGCCACAGGAGTCAAAG"
			+ "GCTTTTCGCCAGCTCCTAAACGCTGGAAGTGTAATTTTTTTTCTTCTTATAAAATTAAACAAACCCTT\n"
			+ "TTAGAAAGGAACACTCGCTTTATCTCTTCGACCGAATTTACTATACATGGATATATATATATTATCTTC"
			+ "TGTTCACAGTTAAAACTAGGAATAGCATAGTCATAAGTTAACACCATCATGTTGAGAACGTCAACATTG\n"
			+ "TTCACCAAGCGTGTCCAACCAAGCCTATTTTCTAGAAACATTCTTAGATTGCAATCCACAGCTGCAATC"
			+ "CCTAAGACTCAAAAAGGTGTCATCTTTTATGAGAATAAGGGGAACCTGCATTACAAAGATATCCCTGTC\n"
			+ "CCCGAGCCTAAGCCAAATGAAATTTTAATCAACGTTAAATATTCTGGTGTATGTCACACCGATTTACAT"
			+ "GCTTGGCACGGCGATTGGCCATTACCTGTTAAACTACCATTAGTAGGTGGTCATGAAGGTGCTGGTGTA\n"
			+ "GTTGTCAAACTAGGTTCCAATGTCAAGGGCTGGAAAGTCGGTGATTTAGCAGGTATCAAATGGCTGAAC"
			+ "GGTTCTTGTATGACATGCGAATTCTGTGAATCAGGTCATGAATCAAATTGTCCAGATGCTGATTTATCT\n"
			+ "GGTTACACTCATGATGGTTCTTTCCAACAATTTGCGACCGCTGATGCTATTCAAGCCGCCAAAATTCAA"
			+ "CAGGGTACCGACTTGGCCGAAGTAGCCCCAATATTATGTGCTGGTGTTACTGTATATAAAGCACTAAAA\n"
			+ "GAGGCAGACTTGAAAGCTGGTGACTGGGTTGCCATCTCTGGTGCTGCAGGTGGCTTGGGTTCCTTGGCC"
			+ "GTTCAATATGCAACTGCGATGGGTTACAGAGTTCTAGGTATTGATGCAGGTGAGGAAAAGGAAAAACTTT\n"
			+ "TCAAGAAATTGGGGGGTGAAGTATTCATCGACTTTACTAAAACAAAGAATATGGTTTCTGACATTCAAGA"
			+ "AGCTACCAAAGGTGGCCCTCATGGTGTCATTAACGTTTCCGTTTCTGAAGCCGCTATTTCTCTATCTACG\n"
			+ "GAATATGTTAGACCATGTGGTACCGTCGTTTTGGTTGGTTTGCCCGCTAACGCCTACGTTAAATCAGAGG"
			+ "TATTCTCTCATGTGGTGAAGTCCATCAATATCAAGGGTTCTTATGTTGGTAACAGAGCTGATACGAGAGA\n"
			+ "AGCCTTAGACTTCTTTAGCAGAGGTTTGATCAAATCACCAATCAAAATTGTTGGATTATCTGAATTACCA"
			+ "AAGGTTTATGACTTGATGGAAAAGGGCAAGATTTTGGGTAGATACGTCGTCGATACTAGTAAATAATAGC\n"
			+ "GTGTTACGCACCCAAACTTTTATGAAAGTCTTTGTTTATAATGATGAGGTTTATAAATATATAGTGGAGC"
			+ "AAAGATTAATCACTAAATCAAGAAGCAGTACCAGTATTTTTTCTATATCAAGTAGTGATAATGGAAATAG\n" + "CCCAAATTTGGCTTCCGTCGAC";

	public RabinKarpAlgorithm(String text, String pattern) {
		this.pattern = pattern;
		M = pattern.length();
		Q = 11;
		RM = 1;

		for (int i = 1; i <= M - 1; i++)
			RM = (RM) % Q;

		patternHash = hash(pattern, M);
		search(text);
	}

	public long hash(String key, int M) {
		long i = 0;
		for (int j = 0; j < M; j++)
			i = (i + key.charAt(j)) % Q;
		return i;
	}

	public boolean check(String txt, int i) {
		for (int j = 0; j < M; j++)
			if (txt.charAt(i + j) !=pattern.charAt(j))
				return false;
		return true;
	}

	public void search(String text) {
		int N = text.length();
		if (N > M) {
			long textHash = hash(text, M);

			/** hash match, then exact match **/
			for (int i = M; i < N; i++) {
				textHash = (textHash + Q - RM * text.charAt(i - M) % Q) % Q;
				textHash = (textHash + text.charAt(i)) % Q;
				// match
				int offset = i - M + 1;
				if ((patternHash == textHash) && check(text, offset))
					System.out.println("Le pattern "+pattern + " trouvé à la position : " + i + ".");

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Rabin Karp Algorithme\n");
		System.out.println("\nText utilisé : \n\n" + text);
		
		/** If we want to enter a sequence, uncomment the following line**/
		// String text = br.readLine();
		System.out.println("\nEntrer un Pattern\n");
		String pattern = br.readLine();
		
		Date tempsAvantRKA = new Date();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("'le' dd/MM/yyyy 'à' hh:mm:ss:SS");
		System.out.println("Début de l'algorithme Rabin Karp "+formater.format(tempsAvantRKA));
		
		System.out.println("\nResultats : \n");
		@SuppressWarnings("unused")
		RabinKarpAlgorithm rk = new RabinKarpAlgorithm(text, pattern);

		Date tempsApresRKA = new Date();
		System.out.println("\nFin de l'algorithme Rabin Karp "+formater.format(tempsApresRKA));

		long chrono = tempsApresRKA.getTime() - tempsAvantRKA.getTime();
		System.out.println("Temps total de l'éxécution de l'algorithme Rabin Karp : " + chrono + " ms.");

	}
}