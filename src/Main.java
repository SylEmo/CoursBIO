import java.util.Date;

/**
 * 
 */

/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
public class Main {

	private static final String sequence = "ABCABCDABABCDABCDABDE";
	private static final String pattern = " AB.CD AB.D";
	private static final String sequenceSuffixTree = "ABAB";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/***** Algo 3 *****/
		KMPAlgorithm kmp = new KMPAlgorithm(pattern, sequence);
		kmp.doYourJob();
		
		/***** Algo 4 *****/
		SuffixTree st = new SuffixTree(sequenceSuffixTree);
		st.showMeThings();		
		
		BWTAlgorithm bwt = new BWTAlgorithm(pattern);
		bwt.makeMeDream();
	}

}
