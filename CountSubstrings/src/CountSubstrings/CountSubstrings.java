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


    public static void main(String[] args) {
        List<Character> l = new ArrayList();
        List<Character> pattern = new ArrayList<>();
        long begin = 0;
        boolean error = true;
        String filename = null;
        while(error){ 
	        System.out.println("Please enter the path for the input file: ");
	        filename = new Scanner (System.in).nextLine();
        	try{
	            BufferedReader br = new BufferedReader(new FileReader(filename));
	            String line;
	            try{
	            	begin = System.currentTimeMillis();
		            while((line = br.readLine()) != null){
		            	for (int i=0; i<line.length(); i++){
		            		l.add(new Character(line.charAt(i)));
		            	}
		            }
		            error = false;
	            }catch (IOException e){
	            	System.out.println("Reading error: " + e.getMessage());
	            	error = true;
	            }
	        }catch (FileNotFoundException e){
	            System.out.println("File not exist: " + e.getMessage());
	            error = true;
	        }
	    }
        System.out.println("Enter the pattern to look for: ");
        Scanner s1 = new Scanner(System.in);
        String s = s1.next();
        for(int i=0; i < s.length(); i++){
        	pattern.add(s.charAt(i));
        }
        s1.close();
        int count = 0;
        while (findBrute(l, pattern)!=-1){
        	count++;
        }
        System.out.println("Using ArrayLists: " + count + " matches, derived in " + " " + (System.currentTimeMillis() - begin) + " milliseconds.");
        long begin2 = System.currentTimeMillis();
        System.out.println("Using LinkedLists: " + count + " matches, derived in " + " " + (System.currentTimeMillis() - begin2) + " milliseconds");
    }
}
