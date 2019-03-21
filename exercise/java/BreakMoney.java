

// 37 cents, 
//unlimited 25 cents, 10 cents, 5 cents, and pennies
// how many ways to break the money

public class BreakMoney {

	public static void main(String[] args) {
		System.out.println(breakMoney(500));
	}
	
	static int breakMoney(int money) {

		int count = 0;

		for (int i = 0; i <= money/25; i++) {
			int sum1 = i * 25;
			
			for (int j = 0; j<= money; j++) {
				int sum2 = sum1 + j * 10;
				if (sum2 > money) break;
				
				for (int k = 0; k <= money; k++) {
					int sum3 = sum2 + k * 5;
					
					int p = money - sum3;
					
					if (p>=0) {
						//System.out.println(i + " quarter, " + j + " dime, " + k + " nickle, " + p + " pennies" );
						++count;
					} else {
						break;
					}
				}
		
			}
		}
		
		return count;
	}
}
