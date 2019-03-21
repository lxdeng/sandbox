package removecomment;

import java.util.*;

class Solution {
	
	
	public static void main(String args[]) {
		//String prog[] = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
		
		String prog[] = {"a//*b/*/c","blank","d/*/e/*/f"};
		
		Solution sol = new Solution();
		List<String> list = sol.removeComments(prog);
		for (String s : list) {
			System.out.println(s);
		}
		
		
	}

	public List<String> removeComments(String[] source) {
        ArrayList<String> list = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        
        for (String s : source) {
            char[] line = s.toCharArray();
            int i = 0;
            if (!inBlock) sb = new StringBuilder();
            
            while (i < line.length) {
                if (i+1 < line.length && line[i] == '/' && line[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length && line[i] == '*' && line[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length && line[i] == '/' && line[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    sb.append(line[i]);
                }
                i++;
            } // end of while loop
            
            if (!inBlock && sb.length() > 0)
                list.add(sb.toString());
        } // end of for loop
        
        return list;
    }
	    
    
}