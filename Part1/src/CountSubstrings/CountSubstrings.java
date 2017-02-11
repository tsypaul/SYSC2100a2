package CountSubstrings;
import java.util.*;
import java.io.*;

public class CountSubstrings {

	private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        
        for (int i = 0; i <= n - m; i++) { // try every starting index
                                        // within text
        int k = 0; // k is index into pattern
        while (k < m && text.get(i + k) == pattern.get(k))
            // kth character of pattern matches
            k++;
        if (k == m) // if we reach the end of the pattern,
            return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }
	
	public static void readFileToAL(Scanner s1, String filename, ArrayList<Character> pattern, Long begin){
	    ArrayList<Character> list = new ArrayList<Character>();
	    int count = 0;
	    String s = null;
	    while (s1.hasNextLine()) {
	    	Scanner s2 = new Scanner(s1.nextLine());
	    	while (s2.hasNext()) {
	    		s = s2.next();
	    		for (int i = 0; i < s.length();i++){
	    			list.add(s.charAt(i));
	    		}
	    		if(findBrute(list,pattern) != -1){
	    			count += 1;
	    		}
	    		list.clear();
	    	}
	    	s2.close();
	    }
	    Long end = System.currentTimeMillis();
	    Long time = end - begin;
	    System.out.println("Using ArrayLists: " + count + " matches, derived in " + time + " milliseconds.");
	}
	
	public static void readFileToLL(Scanner s1, String filename, LinkedList<Character> pattern, Long begin){
	    LinkedList<Character> list = new LinkedList<Character>();
	    int count = 0;
	    String s = null;
	    while (s1.hasNextLine()) {
	    	Scanner s2 = new Scanner(s1.nextLine());
	    	while (s2.hasNext()) {
	    		s = s2.next();
	    		for (int i = 0; i < s.length();i++){
	    			list.add(s.charAt(i));
	    		}
	    		if(findBrute(list,pattern) != -1){
	    			count += 1;
	    		}
	    		list.clear();
	    	}
	    	s2.close();
	    }
	    Long end = System.currentTimeMillis();
	    Long time = end - begin;
	    System.out.println("Using LinkedLists: " + count + " matches, derived in " + time + " milliseconds.");
	}

	public static void main(String[] args) {
        ArrayList<Character> pattern = new ArrayList<>();
        LinkedList<Character> p2 = new LinkedList<>();
        String filename = null;
        Scanner s1 = null;
        boolean error = true;
        while(error){
        	System.out.println("Please enter the path for the input file: ");
        	filename = new Scanner (System.in).nextLine();
        	try {
        		s1 = new Scanner(new File(filename));
        		System.out.println("Enter the pattern to look for: ");
                Scanner s2 = new Scanner(System.in);
                String s = s2.next();
                for(int i=0; i < s.length(); i++){
                	pattern.add(s.charAt(i));
                	p2.add(s.charAt(i));
                }
                s2.close();
                long begin = System.currentTimeMillis();
                readFileToAL(s1, filename, pattern, begin);
                begin = System.currentTimeMillis();
                s1 = new Scanner(new File(filename));
                readFileToLL(s1, filename, p2, begin);
                s1.close();
                error = false;
        	}
        	catch (FileNotFoundException e) {
        		System.out.println("File not exist: " + e.getMessage());
        		error = true;
        	}
        }
        
    }
}