package com.practice;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Count_Triplets {
	
	public static long countTriplets(List<Long> arr, long r) {
		long count =0;
		List<Long> filtered = arr.stream()
				.filter(num->(num==1||(num%r==0)))
				.collect(Collectors.toList());
		if(filtered.size()<3){
			return 0;
		}
		for(int i=0;i<filtered.size()-2;i++) {
			
			Long src = filtered.get(i);
			long expected = src*r;
//			List<Long> progression_with_src = filtered.stream()
//					.filter(val->(val>=(expected)))
//					.collect(Collectors.toList());
			List<Long> progression_with_src = arr;
			int index=i+1;
			int to_start = -1;
			do{
				 to_start = findElement(progression_with_src,expected,index);
				if(to_start!=-1) {
					//System.out.print(src+"-"+progression_with_src.get(to_start)+"-");
					//Optional<Long> third_expected = filtered.stream().filter(val->(val==(expected*r))).findFirst();
					//if(third_expected.isPresent()) {
						count = third_loop(progression_with_src,expected*r,to_start+1,count);
					//}
					index++;
					//System.out.println();
				}
				
				
		}while(to_start!=-1);
		}	
		return count;
    }
	private static int findElement_recursively(List<Long> list,long expected,int fromIndex) {
		if(fromIndex>=list.size())
			return -1;
		if(list.get(fromIndex)==expected)
			return fromIndex;
		return findElement_recursively(list, expected, ++fromIndex);
	}
	
	private static int findElement(List<Long> list,long expected,int fromIndex) {
		if(fromIndex>=list.size())
			return -1;
		for(int i=fromIndex;i<list.size();i++) {
			if((list.get(i)).equals(expected))
				return i;
		}
		return -1;
	}
	
	public static  long third_loop(List<Long> progression_with_src,long expected,int found,long count) {
		
		if(found!=-1&&found<progression_with_src.size()) {

			while((found<=progression_with_src.size())&&(found =findElement(progression_with_src,expected,found))!=-1) {
				//System.out.print(progression_with_src.get(found)+"-");
				count++;
				found++;
			}
			
		}
		return count;
	}
	
	
	// Complete the countTriplets function below.
    static public long countTriplets_(List<Long> arr, long r) {
    	long count =0;
    	List<Long> filtered = arr.stream()
    	.filter(num->(num==1||(num%r==0)))
    	.collect(Collectors.toList());
    	
    	if(filtered.size()<3){
    		return 0;
    	}
    	for(int i=0;i<filtered.size()-2;i++) {
    		
    		Long src = filtered.get(i);
    		List<Long> progression_with_src = filtered.stream()
    				.filter(val->(val>=(src*r)))
    				.collect(Collectors.toList());
    		for(int j=0;j<progression_with_src.size();j++) {
    		List<Long> filtered1 = returnListFromIndex(progression_with_src,j).stream()
    				.filter(val->(val>=(src*r)))
    				.collect(Collectors.toList());
    		if(filtered1.size()<2) {
    			break;
    		}
    		 filtered1.stream().forEach(val->System.out.print(val+" "));
    		 System.out.println();
    		 System.out.print(src+"-");
    		int index=  recursiveFind(filtered1,r,src,0,j,false);
    		if(index>0) {
    			
    			
    			System.out.println(index+" => found");
    			//j=index;
    			count++;
    		}
    		//filtered1.stream().forEach(System.out::print);
    		System.out.println();
    	}
    	}
    	return count;
    }
    
    public static int recursiveFind(List<Long> list,long r,long num,int count,int index,boolean isFound) {
    	
    	if(list.size()==0) {
    		return 0;
    	}
    	Long src = list.get(0);
    	
    	if(src==num*r) {
    		isFound=true;
    		count++;
    		num=src;
    		System.out.print(num+"-");
    	}
    	
    	if(!isFound)
 		   index++;
    		
    	if(count==2) {
    		return 1;
    	}
    	return recursiveFind(returnListFromIndex(list,1),r,num,count,index,isFound);
    	
    }
    public static List<Long> returnListFromIndex(List<Long> source,int index){
		
		if(index>source.size())
			return source;
		return source.subList(index,source.size());
	
	}	

    public static List<Long> readInput() throws IOException{
    	File file = new File(
                "input.txt");
    	 BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
         //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

         String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

         int n = Integer.parseInt(nr[0]);

         long r = Long.parseLong(nr[1]);

         List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
             .map(Long::parseLong)
             .collect(toList());
         long millis= System.currentTimeMillis();
         long ans = countTriplets(arr, r);
     	System.out.println((System.currentTimeMillis())-millis);
         System.out.println("answer is "+ans);
        // bufferedWriter.write(String.valueOf(ans));
         //bufferedWriter.newLine();

         bufferedReader.close();
         //bufferedWriter.close();
         return arr;
    }
    
    
    public static void main(String[] args) throws IOException {
    	long millis= System.currentTimeMillis();
   	readInput();
   	System.out.println(millis-(System.currentTimeMillis()));
//    	if(true)
//    		return;
    	List<Long> four = new ArrayList<Long>();
    	four.add((long)1);four.add((long) 4);four.add((long)16);four.add((long)64);
    	List<Long> two = new ArrayList<Long>();
    	two.add((long)1);two.add((long) 2);two.add((long)2);two.add((long)4);
    	
    	List<Long> five = new ArrayList<Long>();
    	five.add((long)1);five.add((long) 5);five.add((long) 5);five.add((long)25);five.add((long)125);
    	
    	List<Long> three = new ArrayList<Long>();
    	three.add((long)1);three.add((long) 3);three.add((long) 9);three.add((long) 9);three.add((long)27);three.add((long)81);

    	System.out.println(countTriplets(two,2));
    }
}
