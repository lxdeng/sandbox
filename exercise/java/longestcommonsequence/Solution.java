package longestcommonsequence;

public class Solution {

	
	public static void main(String args[]) {
		Solution sol = new Solution();
		
		String s = "ABAZDC";
		String t = "BACBAD";
		
		System.out.println(sol.lcsLengthDP(s, t));
		
	}
	
	int lcsLength(String s, String t) {
		if (s.length() == 0 || t.length() == 0)
			return 0;
		
		if (s.charAt(s.length()-1) == t.charAt(t.length()-1)) {
			return lcsLength(s.substring(0, s.length()-1), 
							 t.substring(0, t.length()-1)) + 1;
		} else {
			return Math.max(lcsLength(s.substring(0, s.length()-1), t),
							lcsLength(s, t.substring(0, t.length()-1)));
		}
		
	}
	
	int lcsLengthDP(String s, String t) {
		
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		for (int i = 1; i <= s.length(); i++)
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					//System.out.println(s.charAt(i-1));
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		
		return dp[s.length()][t.length()];
	}
}
