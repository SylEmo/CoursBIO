import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */

/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
public class Main {

	private static final String sequence = "GAATTCGAGATGCGAATGAGCAGCAGCCATTTTGATGTTGTGAGCATCGGAACGTTTCTGCG"
			+ "TCCGTACACTGTCCTTTTGTTACTTAGATAATGGCTAAGGCAAGCAGTCCGGGCCACAGGAGTCAAAG"
			+ "GCTTTTCGCCAGCTCCTAAACGCTGGAAGTGTAATTTTTTTTCTTCTTATAAAATTAAACAAACCCTT"
			+ "TTAGAAAGGAACACTCGCTTTATCTCTTCGACCGAATTTACTATACATGGATATATATATATTATCTTC"
			+ "TGTTCACAGTTAAAACTAGGAATAGCATAGTCATAAGTTAACACCATCATGTTGAGAACGTCAACATTG"
			+ "TTCACCAAGCGTGTCCAACCAAGCCTATTTTCTAGAAACATTCTTAGATTGCAATCCACAGCTGCAATC"
			+ "CCTAAGACTCAAAAAGGTGTCATCTTTTATGAGAATAAGGGGAACCTGCATTACAAAGATATCCCTGTC"
			+ "CCCGAGCCTAAGCCAAATGAAATTTTAATCAACGTTAAATATTCTGGTGTATGTCACACCGATTTACAT"
			+ "GCTTGGCACGGCGATTGGCCATTACCTGTTAAACTACCATTAGTAGGTGGTCATGAAGGTGCTGGTGTA"
			+ "GTTGTCAAACTAGGTTCCAATGTCAAGGGCTGGAAAGTCGGTGATTTAGCAGGTATCAAATGGCTGAAC"
			+ "GGTTCTTGTATGACATGCGAATTCTGTGAATCAGGTCATGAATCAAATTGTCCAGATGCTGATTTATCT"
			+ "GGTTACACTCATGATGGTTCTTTCCAACAATTTGCGACCGCTGATGCTATTCAAGCCGCCAAAATTCAA"
			+ "CAGGGTACCGACTTGGCCGAAGTAGCCCCAATATTATGTGCTGGTGTTACTGTATATAAAGCACTAAAA"
			+ "GAGGCAGACTTGAAAGCTGGTGACTGGGTTGCCATCTCTGGTGCTGCAGGTGGCTTGGGTTCCTTGGCC"
			+ "GTTCAATATGCAACTGCGATGGGTTACAGAGTTCTAGGTATTGATGCAGGTGAGGAAAAGGAAAAACTTT"
			+ "TCAAGAAATTGGGGGGTGAAGTATTCATCGACTTTACTAAAACAAAGAATATGGTTTCTGACATTCAAGA"
			+ "AGCTACCAAAGGTGGCCCTCATGGTGTCATTAACGTTTCCGTTTCTGAAGCCGCTATTTCTCTATCTACG"
			+ "GAATATGTTAGACCATGTGGTACCGTCGTTTTGGTTGGTTTGCCCGCTAACGCCTACGTTAAATCAGAGG"
			+ "TATTCTCTCATGTGGTGAAGTCCATCAATATCAAGGGTTCTTATGTTGGTAACAGAGCTGATACGAGAGA"
			+ "AGCCTTAGACTTCTTTAGCAGAGGTTTGATCAAATCACCAATCAAAATTGTTGGATTATCTGAATTACCA"
			+ "AAGGTTTATGACTTGATGGAAAAGGGCAAGATTTTGGGTAGATACGTCGTCGATACTAGTAAATAATAGC"
			+ "GTGTTACGCACCCAAACTTTTATGAAAGTCTTTGTTTATAATGATGAGGTTTATAAATATATAGTGGAGC"
			+ "AAAGATTAATCACTAAATCAAGAAGCAGTACCAGTATTTTTTCTATATCAAGTAGTGATAATGGAAATAG" 
			+ "CCCAAATTTGGCTTCCGTCGAC";
	private static final String pattern = "TGATGG";
	//private static final String pattern = "TTTT";
	private static final String sequenceSuffixTree = "ABAB";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd/MM/yyyy 'à' hh:mm:ss:SSS");

		
		/***** Algo 3 *****/
		System.out.println("*********** ALGO KMP ***********");
		Date debutKMP = new Date();
		System.out.println("!!! Lancement de KMP le " + formater.format(debutKMP) + " !!!");
		
		KMPAlgorithm kmp = new KMPAlgorithm(pattern, sequence);
		kmp.doYourJob();
		
		Date finKMP = new Date();
		System.out.println("\n!!! Fin de KMP le " + formater.format(finKMP) + " !!!");
		System.out.println("!!! Temps total de KMP : " + (finKMP.getTime() - debutKMP.getTime()) + "msec !!!");
		
		
		/***** Algo 4 *****/
		//SuffixTree st = new SuffixTree(sequenceSuffixTree);
		//st.showMeThings();		
		
		System.out.println("\n\n*********** ALGO BWT ***********");
		Date debutBWT = new Date();
		System.out.println("!!! Lancement de BWT le " + formater.format(debutBWT) + " !!!");
		
		BWTAlgorithm bwt = new BWTAlgorithm(pattern);
		bwt.makeMeDream();
		
		Date finBWT = new Date();
		System.out.println("\n\n!!! Fin de BWT le " + formater.format(finBWT) + " !!!");
		System.out.println("!!! Temps total de BWT : " + (finBWT.getTime() - debutBWT.getTime()) + "msec !!!");
	}
}
