/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */

public class NaiveAlgorithm {

	
	public NaiveAlgorithm(){}
	
//GAATTCGAGATGCGAATGAGCAGCAGCCATTTTGATGTTGTGAGCATCGGAACGTTTCTGCGTCCGTACACTGTCCTTTTGTTACTTAGATAATGGCTAAGGCAAGCAGTCCGGGCCACAGGAGTCAAAGGCTTTTCGCCAGCTCCTAAACGCTGGAAGTGTAATTTTTTTTCTTCTTATAAAATTAAACAAACCCTTTTAGAAAGGAACACTCGCTTTATCTCTTCGACCGAATTTACTATACATGGATATATATATATTATCTTCTGTTCACAGTTAAAACTAGGAATAGCATAGTCATAAGTTAACACCATCATGTTGAGAACGTCAACATTGTTCACCAAGCGTGTCCAACCAAGCCTATTTTCTAGAAACATTCTTAGATTGCAATCCACAGCTGCAATCCCTAAGACTCAAAAAGGTGTCATCTTTTATGAGAATAAGGGGAACCTGCATTACAAAGATATCCCTGTCCCCGAGCCTAAGCCAAATGAAATTTTAATCAACGTTAAATATTCTGGTGTATGTCACACCGATTTACATGCTTGGCACGGCGATTGGCCATTACCTGTTAAACTACCATTAGTAGGTGGTCATGAAGGTGCTGGTGTAGTTGTCAAACTAGGTTCCAATGTCAAGGGCTGGAAAGTCGGTGATTTAGCAGGTATCAAATGGCTGAACGGTTCTTGTATGACATGCGAATTCTGTGAATCAGGTCATGAATCAAATTGTCCAGATGCTGATTTATCTGGTTACACTCATGATGGTTCTTTCCAACAATTTGCGACCGCTGATGCTATTCAAGCCGCCAAAATTCAACAGGGTACCGACTTGGCCGAAGTAGCCCCAATATTATGTGCTGGTGTTACTGTATATAAAGCACTAAAAGAGGCAGACTTGAAAGCTGGTGACTGGGTTGCCATCTCTGGTGCTGCAGGTGGCTTGGGTTCCTTGGCCGTTCAATATGCAACTGCGATGGGTTACAGAGTTCTAGGTATTGATGCAGGTGAGGAAAAGGAAAAACTTTTCAAGAAATTGGGGGGTGAAGTATTCATCGACTTTACTAAAACAAAGAATATGGTTTCTGACATTCAAGAAGCTACCAAAGGTGGCCCTCATGGTGTCATTAACGTTTCCGTTTCTGAAGCCGCTATTTCTCTATCTACGGAATATGTTAGACCATGTGGTACCGTCGTTTTGGTTGGTTTGCCCGCTAACGCCTACGTTAAATCAGAGGTATTCTCTCATGTGGTGAAGTCCATCAATATCAAGGGTTCTTATGTTGGTAACAGAGCTGATACGAGAGAAGCCTTAGACTTCTTTAGCAGAGGTTTGATCAAATCACCAATCAAAATTGTTGGATTATCTGAATTACCAAAGGTTTATGACTTGATGGAAAAGGGCAAGATTTTGGGTAGATACGTCGTCGATACTAGTAAATAATAGCGTGTTACGCACCCAAACTTTTATGAAAGTCTTTGTTTATAATGATGAGGTTTATAAATATATAGTGGAGCAAAGATTAATCACTAAATCAAGAAGCAGTACCAGTATTTTTTCTATATCAAGTAGTGATAATGGAAATAGCCCAAATTTGGCTTCCGTCGAC

static String text = "GAATTCGAGATGCGAATGAGCAGCAGCCATTTTGATGTTGTGAGCATCGGAACGTTTCTGCG"
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
	
	static String pattern1 = "TGATGG";
	static String pattern2 = "TTTT";
	

	
	public static void main(String[] args) {

		int n = text.length();
		int m1 = pattern1.length();
		int m2 = pattern2.length();

		for (int i = 0 ; i<n-m1 ; i++)
		{
			if (pattern1.equals(text.subSequence(i, i+m1)))
					System.out.println("shift du pattern TGATGG à la position : "+(i+1));
			if (pattern2.equals(text.subSequence(i, i+m2)))
				System.out.println("shift du pattern TTTT à la position : "+(i+1));
			
		}
		
	}
}
