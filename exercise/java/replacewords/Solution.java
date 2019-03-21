package replacewords;

import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		/*
		list.add("cat");
		list.add("bat");
		list.add("rat");
		
		String s = "the cattle was rattled by the battery";
		*/
		list.add("a");
		list.add("aa");
		list.add("aaa");
		list.add("aaaa");
		
		String s = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
				
		System.out.println(new Solution().replaceWords(list, s));
		
	}
	
	public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                if (p.children == null || !p.children.containsKey(c)) 
                    break;
                
                p = p.children.get(c);
            }
            
            if (sb.length() > 0) sb.append(' ');
            
            if (p.word != null)
                sb.append(p.word);
            else
                sb.append(w);
        }
        
        return sb.toString();
    }
    
    TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        
        for (String w : dict) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                if (p.children == null) 
                    p.children = new HashMap<>();
                if (!p.children.containsKey(c))
                    p.children.put(c, new TrieNode());
                
                p = p.children.get(c);
            }
            
            p.word = w;
        } 
        return root;
    }
	
	/*
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        
        for (String root: roots) {
            TrieNode cur = trie;
            
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }*/
}

/*
class TrieNode {
    TrieNode[] children;
    String word;
    
    TrieNode() {
        children = new TrieNode[26];
    }
}*/

class TrieNode {
    HashMap<Character, TrieNode> children;
    String word;
}