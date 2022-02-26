package test.java.com.practice.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.practice.datastructures.Custom_Dict;


import org.junit.Assert;
public class Custom_Dict_Test {
	@Before
    public void SetUp() {

    }
    @Test
    public void test_for_positive_test_cases() {
    	List<Long> list = new ArrayList<Long>();
    	int[] arr = {0,1,2};
    	List<Integer> one_list =  Arrays.stream(arr).boxed().collect(Collectors.toList());
    	list.add((long)1);list.add((long)1);list.add((long)1);
    	
    	list.add((long) 4);list.add((long)16);list.add((long)64);
    	Custom_Dict<Long> dict = new Custom_Dict<Long>(list);
    	
    	//assert length is equal
    	Assert.assertEquals(4, dict.keySet().size());
    	Assert.assertEquals(dict.get((long)1), one_list);
    }
    @After
    public void tearDown() {

    }
}
