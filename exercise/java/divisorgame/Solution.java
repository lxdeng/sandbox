package divisorgame;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		sol.divisorGame(3);
	}
	
    int[] dp; // 0 unkown, 1 false, 2 true
    public boolean divisorGame(int N) {
        
        dp = new int[N+1];
        
        dp[1] = 1;
        dp[2] = 2;
        return game(N);
    }
    
    private boolean game(int N) {
        
        if (dp[N] > 0)
            return dp[N] == 2;
        
        for (int i = 1; i < N; i++) {
            if (N % i == 0 && 
            	!divisorGame(N-i)) {
                dp[N] = 2;
                return true;
            }
        }
        
        dp[N] = 1;
        return false;
    }
}