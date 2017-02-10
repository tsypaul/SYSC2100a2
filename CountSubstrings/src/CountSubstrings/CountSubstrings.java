package CountSubstrings;
import java.util.*;
import java.io.*;

public class CountSubstrings {

    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n-m; i++ ){
            int k = 0;
            while (k<m && text.get(i+k) == pattern.get(k)){
                k++;
            }
            if (k == m){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        List<Character> l = null;
        List<Character> pattern = new ArrayList<>();
        boolean error = true;
        String filename = null;
        int size = 0;
        while(error){ 
	        System.out.println("Please enter the path for the input file: ");
	        filename = new Scanner (System.in) .nextLine();
        	try{
	            Scanner s = new Scanner(new File(filename));
	            while (s.hasNext()){
	                l.add(s.next().toCharArray()[size]);
	                size++;
	            }
	            error = false;
	            s.close();
	        }catch (FileNotFoundException e){
	            System.out.println("File not exist: " + e.getMessage());
	            error = true;
	        }
	    }
        System.out.println("Enter the pattern to look for: ");
        char[] c = new Scanner(System.in).nextLine().toCharArray();
        size = 0;
        while (size < c.length) {
            pattern.add(c[size]);
            size ++;
        }
        long begin = System.currentTimeMillis();
        l = new ArrayList<>();
        System.out.println("Using ArrayLists: " + findBrute(l, pattern) + " matches, derived in " + filename + " " + (System.currentTimeMillis() - begin) + " milliseconds.");
        long begin2 = System.currentTimeMillis();
        l = new LinkedList<>();
        System.out.println("Using LinkedLists: " + findBrute(l, pattern) + " matches, derived in " + filename + " " + (System.currentTimeMillis() - begin2) + " milliseconds");
    }
}
