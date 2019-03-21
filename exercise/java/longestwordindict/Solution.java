package longestwordindict;

import java.util.*;

public class Solution {
	
	

	public static void main(String args[]) {
		String s = "wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi";
		String w = "jpthiudqzzeugzwwsngebdeai";
		
		System.out.println(valid(s, w));
		System.out.println(isSubsequence(w,s));
		
		//w = "nbmxgkduynigvzuyblwjepn";
		//System.out.println(valid(s, w));
		
		
		List<Number> list = new ArrayList<>();
		list.add(new Integer(1));
		list.add(new Float(1.1));
		test1(new ArrayList<Integer>());
		
		List<Integer> listInts = new ArrayList<>();
		List<? extends Number> listNums = listInts;
		
		
	}
	
	static void test1(List<? extends Number> list) {
		System.out.println(list.size());
		//list.add(0, new Integer(0));
	}
	
	static void test2(List<? super Integer> list) {
		System.out.println(list.size());
		//list.add(0, new Integer(0));
	}
	
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s2.compareTo(s1);  // so that lexi-lower string is at the high end
                } else {
                    return s1.length() - s2.length();
                }
            }
        });
        
        for (int i = d.size() - 1; i >= 0; i--) {
            String w = d.get(i);
            if (valid(s, w)) return w;
        }
        
        return "";
    }
                    
    private static boolean valid(String s, String w) {
        if (s.length() < w.length()) return false;
        
        int i = 0;
        char[] str = s.toCharArray();
        for (char c : w.toCharArray()) {
            while (i < str.length && str[i] != c) i++;
            if (i == str.length) return false;
        }
        return true;
    }         
    
    static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
}