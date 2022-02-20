
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Sherlock_anagrams {

    static int count;
	public static int sherlockAndAnagrams(String s) {
		count =0;
		List<String> allStrings=returnListOfSubStrings(s);
		for(int i=0;i<allStrings.size()-1;i++) {
			String src = allStrings.get(i);
			int j = i+1;
			//for(int j=i+1;j<allStrings.size();j++) {
				List<String> subList = returnListFromIndex(allStrings,j);
				subList.stream()
				.filter(val->(val.length()==src.length()))
   			 	.filter(equalLength->areStringEqual(equalLength,src))
   			 	.forEach(dup->{
   				 
   				 count++;
   				 });
				
			//}
		}
		return count;
	}
	
	public static List<String> returnListFromIndex(List<String> source,int index){
		ArrayList<String> list = new ArrayList<String>();
		if(index>source.size())
			return source;
		return source.subList(index,source.size());
	
	}
	public static List<String> returnListOfSubStrings(String src){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<src.length();i++) {
			for(int j=i+1;j<=src.length();j++) {
				list.add(src.substring(i, j));
			}
		}
		return list;
	}
	
	public static boolean areStringEqual(String src,String des) {
		if(src.length()!=des.length())
			return false;
		char[] srcArray=src.toCharArray(),
				desArray = des.toCharArray();

		  Arrays.sort(srcArray);  
          Arrays.sort(desArray);  
		
         return Arrays.equals(srcArray, desArray);
		
		
	}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
