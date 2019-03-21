import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {

  public static void main(String args[]) {
	  //List<List<Integer>> list = generate(5);
	
	  //strStr("aaa", "aaaa");

  }
  
  
  public static int strStr(String haystack, String needle) {
      int ndLen = needle.length();
      if (ndLen == 0) return 0;
  
      char first = needle.charAt(0);
      int hsLen = haystack.length();
      
      int start = 0;
      while (start < hsLen)  {
          while (haystack.charAt(start) != first) {
              start++;
              if (hsLen - start < ndLen)
                  return -1;
          }    
           
          for (int j = 0; j < ndLen; j++) {
              if (needle.charAt(j) != haystack.charAt(start + j))
                  break;
              
              if (j == ndLen - 1)
                  return start;
          }
      }
      
      return -1;
  }
  
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if (numRows == 0) return list;
        
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        list.add(row);
        
        for (int i = 2; i <= numRows; i++) {
            row = new ArrayList<>();
            row.add(1);
            
            for (int j = 1; j < i-1; j++) {
            	List<Integer> above = list.get(i-1-1);
            	
                int x = above.get(j-1) + above.get(j);
                row.add(x);
            }
            row.add(1); // i - 1 column
            list.add(row);
        }
        
        return list;
    }
}