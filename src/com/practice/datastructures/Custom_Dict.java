package com.practice.datastructures;


import java.util.*;

public class Custom_Dict<T> extends HashMap<T,List<Integer>>{
   
    public Custom_Dict(List<T> list){
    	for(int i=0;i<list.size();i++) {
    		T key =  list.get(i);
    		if(this.containsKey(key)) {
    			this.get(key).add(i);
    		}else {
    			List<Integer> l = new ArrayList<Integer>();
    			l.add(i);
    			this.put( key, l);
    			
    		}
    	}
    	
    }
    
    
    
}
