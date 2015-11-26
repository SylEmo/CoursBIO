/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
public class RabinKarpAlgorithm {

	
	public final static int q = 11;
	
	public RabinKarpAlgorithm(String T, String M){
		
		int n = T.length();
		int m = M.length();
		
		int hn = hash(T.substring(1,m));
		int hm = hash(M.substring(1, m));
		
		for (int i = 0; i < n-m+1; i++) {
			if (hn == hm)
			{
				if ( T.substring(i, i+m-1) == M.substring(1,m)){
					System.out.println("résultat trouvé en position : "+i);
				}
			}
			hn = hash(T.substring(i+1, i+m));
		}
	}
	
	public int hash (String T){
		int res = Integer.parseInt(T);
		return res % q;
	}
	
}