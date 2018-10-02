
public class Complement {

	public static void main(String[] args) {
		Solution sol = new Complement().new Solution();
		
		int x = 5;
		System.out.println(sol.findComplement(x));
		
	}

 class Solution {
    public int findComplement(int x) 
    {
        int length = Integer.toBinaryString(x).length();
        for(int i=0; i<length; i++)
        {
            if((x & (1 << i)) == 0)
            {
                x |= (1 << i);
            }
            else
            {
                x &= ~(1 << i);
            }
        }
        return x;
    }
 }
 
}