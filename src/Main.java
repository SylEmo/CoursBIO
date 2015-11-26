/**
 * 
 */

/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KMPAlgorithm kmp = new KMPAlgorithm("ABCDABD", "ABCABCDABABCDABCDABDE");
		kmp.doYourJob();
	}

}
