/**
 * 
 */

/**
 * @author Sylemo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KMPAlgorithm kmp = new KMPAlgorithm("ABABABABCA", "vide");
		kmp.computeTab();
	}

}
