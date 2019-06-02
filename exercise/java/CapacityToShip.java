
public class CapacityToShip {

	public static void main(String[] args) {
		int[] w = {1,2,3,4,5,6,7,8,9,10};
		int d = 5;
		CapacityToShip test = new CapacityToShip();
		System.out.println(test.shipWithinDays(w, d));
	}
	
	public int shipWithinDays(int[] weights, int D) {
        int maxW = weights[0];
        int sum = 0;
        
        for (int w : weights) {
            maxW = Math.max(maxW, w);
            sum += w;
        }
        
        int minShipWeight = Math.max(sum/D, maxW);
        
        int lo = minShipWeight, hi = sum;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if (possible(weights, D, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;   
            }
        }
        
        return lo;
    }
    
    boolean possible(int[] weights, int D, int shipWeight) {
        
        int idx = 0;
        for (int i = 0; i < D; i++) {
            int w = 0;
            while (idx < weights.length && w + weights[idx] <= shipWeight) {
                w += weights[idx++];
            }
        }
        
        return idx >= weights.length;
    }
}
