package com.practice;
import java.io.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;


import com.practice.datastructures.Custom_Dict;
import com.practice.utils.FileWriter_Utils;

import static java.util.stream.Collectors.toList;

public class Count_Triplets {
	
	
	
	static public long countTriplets(List<Long> arr, long r) {
		
		if(arr.size()<3){
			return 0;
		}
		
		return countTriplets_with_center(arr,r);
		//return count_new_mothod(arr,r);
		
		//return countTriplets_with_dict(arr,r);
		//return countTriplets_old(arr,r);
	}
	
	static public long count_same_values(Custom_Dict<Long> dict) {
		long count = 0;
		Set<Long> keySet = dict.keySet();
		for(Long eachKey:keySet) {
			List<Integer> list = dict.get(eachKey);
		    int size=list.size();
		    count+=caluclate_combination(size,3);
		}
		return count;
	}
	static public long caluclate_combination(int n,int r) {
		long numerator =1;
		for(int i=0;i<3;i++) {
			numerator= numerator*(long)(n);
			n--;
		}
		return numerator/6;
	}
	
	static public long countTriplets_with_center(List<Long> arr, long r) {
		long count =0;
		
		List<Long> filtered = arr;
		if(filtered.size()<3){
			return 0;
		}
	   Custom_Dict<Long> dict = new Custom_Dict<Long>(filtered);
	   if(r==1)
	   {
		   return count_same_values(dict);
	   }
	   for (int i=1;i<filtered.size()-1;i++) {
		   Long mid = filtered.get(i);
		   Long first_value = mid/r,
				   second_value=mid*r;
		   if(mid==1||mid%r!=0) {
			  // System.out.println(mid+" breaking");
			   continue;
		   }
		   if(first_value<=0||second_value<=0)
		   {
			   System.out.println(first_value+" anamoly "+second_value);
		   }
		   long left = compare_and_count_in_dict(dict,first_value,i,false);
		   long right = compare_and_count_in_dict(dict,second_value,i,true);
		   if(left>0&&right>0) {
			   count+=(left*right);
			   //System.out.println(first_value+" "+mid+" "+second_value+" "+(left>right?left:right));
		   }
		  
	   }
	   
	
	   return count;
	}
	
	static public long compare_and_count_in_dict(Custom_Dict<Long> dict,Long value,int index,boolean plus) {
		if(!dict.containsKey(value))
			return 0;
		if(plus)
		return dict.get(value).stream().filter(val->val>index).count();
		else
		return dict.get(value).stream().filter(val->val<index).count();
		
	}
	static public long countTriplets_with_dict(List<Long> arr, long r) {
		long count =0;

		List<Long> filtered = arr;

	   Custom_Dict<Long> dict = new Custom_Dict<Long>(filtered);
	   for(int i=0;i<filtered.size()-2;i++) {
		   Long src = filtered.get(i);

		   long first_to_find = src*r;
		   if(dict.containsKey(first_to_find)) {
			   List<Integer> list = dict.get(first_to_find);
			   for(Integer index:list) {
				   long second_to_find = first_to_find*r;
				   if(dict.containsKey(second_to_find)) {
					   List<Integer> second_list = dict.get(second_to_find);
					  
					  long l = second_list.stream().filter(val->(val>index)).count();
					 // System.out.println(src+"["+i+"] "+first_to_find+"["+index+"] "+second_to_find+"["+"] "+l);
					  count+=l;
					  
				   }
			   }
		   }
		   
	   }
	   return count;
		
	}
	// Complete the countTriplets function below.
    
    
    public static void main(String[] args) throws IOException {
    	
    	//readInput("input_3.txt");
   	
//    	if(true)
//    		return;
    	List<Long> four = new ArrayList<Long>();
    	four.add((long)1);four.add((long) 4);four.add((long)16);four.add((long)64);
    	List<Long> two = new ArrayList<Long>();
    	two.add((long)1);two.add((long) 2);two.add((long)2);two.add((long)4);two.add((long)2);
    	
    	List<Long> five = new ArrayList<Long>();
    	five.add((long)1);five.add((long) 5);five.add((long) 5);five.add((long)25);five.add((long)125);
    	
    	List<Long> three = new ArrayList<Long>();
    	three.add((long)1);three.add((long) 3);three.add((long) 9);three.add((long) 9);three.add((long)27);three.add((long)81);

    	//System.out.println(countTriplets(five,5));
    	List<Long> misc = new ArrayList<Long>();
    	misc.add((long)1);misc.add((long) 3);misc.add((long) 1);misc.add((long) 3);misc.add((long) 9);
    	Count_Triplets.countTriplets(five,5);
    	
    }
    
    
    public static List<Long> readInput(String fileName) throws IOException{
    	File file = new File(fileName);
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
    
    
    public static long countTriplets_old(List<Long> arr, long r) {
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
			List<Long> progression_with_src = filtered.stream()
					.filter(val->(val%expected)==0)
					.collect(Collectors.toList());
		//	List<Long> progression_with_src = filtered;
		//	int index=i+1;
			
			
			int index=0;
			int to_start = -1;
			
			do{
				if(index>=filtered.size()-1) {
					to_start = -1;
				}
				else
				 to_start = findElement(progression_with_src,expected,index);
				
				if(to_start!=-1) {
					//System.out.print(i+"="+src+"-"+to_start+"="+progression_with_src.get(to_start)+"-");
					//Optional<Long> third_expected = filtered.stream().filter(val->(val==(expected*r))).findFirst();
					//if(third_expected.isPresent()) {
						count = third_loop(progression_with_src,expected*r,to_start+1,count);
						index=to_start+1;
					//}
				
					/*
					{
					long thrid_value = expected*r;
					long temp  = progression_with_src.stream()
							.filter(val->val==thrid_value)
							.count();
					count+=temp;
					index++;
					}
					*/
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
		if(fromIndex>=list.size()||fromIndex<0)
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
				//System.out.print(found+"="+progression_with_src.get(found)+"-");
				count++;
				found++;
			}
			
		}
		return count;
	}
static public long countTriplets_(List<Long> arr, long r) {

	long count =0;
	List<Long> filtered = arr.stream()
	.filter(num->(num==1||(num%r==0)))
	.collect(Collectors.toList());
	
	if(filtered.size()<3){
		return 0;
	}
	for(int i=0;i<filtered.size()-2;i++) {
	}
	return count;
}

public static List<Long> returnListFromIndex(List<Long> source,int index){
	
		if(index>source.size())
			return source;
		return source.subList(index,source.size());
	
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


private static long count_new_mothod(List<Long> arr, long r) {
	Map<Long, Long> potential = new HashMap<>();
    Map<Long, Long> counter = new HashMap<>();
    long count = 0;
    for (int i = 0; i < arr.size(); i++) {
        long a = arr.get(i);
        long key = a / r;
        
        if (counter.containsKey(key) && a % r == 0) {
            count += counter.get(key);
        }
        
        if (potential.containsKey(key) && a % r == 0) {
            long c = potential.get(key);
            counter.put(a, counter.getOrDefault(a, 0L) + c);
        }
        
        potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
    }
    return count;
}
 
}
