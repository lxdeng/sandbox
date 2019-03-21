import java.util.*;

public class PrettyJson {

	public static void main(String[] args) {
    	//String s1 = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
    	String s1 = "[\"foo\",    {\"bar\":  [\"baz\",null,1.0,2]}]";
    	
		PrettyJson pj = new PrettyJson();
    	ArrayList<String> r = pj.prettyJSON(s1);
    	for (String line : r)
    		System.out.println(line);
    	
	}
	
	
	public ArrayList<String> prettyJSON(String a) {
	    ArrayList<String> result = new ArrayList<String>();
	    int tabCounter = 0;
	    StringBuffer current = new StringBuffer();
	    
	    for(int i=0; i<a.length(); i++) {
	        char c = a.charAt(i);
	        switch(c) {
    	        case '{':
                case '[':
                    if(current.length() > 0) {
    	                result.add(current.toString());
    	                current = new StringBuffer();
    	            }
    	            for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
    	            current.append(c);
    	            result.add(current.toString());
    	            current = new StringBuffer();
    	            tabCounter++;
                    break;
                
                case ']':    
    	        case '}':
    	            if(current.length() > 0) {
    	                result.add(current.toString());
    	                current = new StringBuffer();
    	            }
    	            tabCounter--;
    	            for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
    	            current.append(c);
    	            break;
    	            
    	        case ',':
    	            current.append(c);
    	            result.add(current.toString());
    	            current = new StringBuffer();
                    break;
                    
                default:
                    if(current.length() == 0) {
                        for(int j=0; j<tabCounter; j++) {
                            current.append('\t');
                        }
                    }
                    current.append(c);
	        }
	    }
	    
	    if(current.length() > 0) {
	        result.add(current.toString());
	    }
	    
	    return result;
	}
}
