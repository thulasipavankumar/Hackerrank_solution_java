package test.java.com.practice;

import java.util.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.practice.Count_Triplets;

public class Count_Triplets_Test {
	@Before
    public void SetUp() {

    }
    @Test
    public void test_for_positive_test_cases() {
    	List<Long> list = new ArrayList<Long>();
    	list.add((long)1);list.add((long) 4);list.add((long)16);list.add((long)64);
    	Assert.assertEquals(2,Count_Triplets.countTriplets(list,4));
    	
    	List<Long> two = new ArrayList<Long>();
    	two.add((long)1);two.add((long) 2);two.add((long)2);two.add((long)4);
    	Assert.assertEquals(2,Count_Triplets.countTriplets(two,2));
    	
    	
    	List<Long> five = new ArrayList<Long>();
    	five.add((long)1);five.add((long) 5);five.add((long) 5);five.add((long)25);five.add((long)125);
    	Assert.assertEquals(4,Count_Triplets.countTriplets(five,5));
    	
    	
    	List<Long> three = new ArrayList<Long>();
    	three.add((long)1);three.add((long) 3);three.add((long) 9);three.add((long) 9);three.add((long)27);three.add((long)81);
    	Assert.assertEquals(6,Count_Triplets.countTriplets(three,3));
    	
    	
    	
    	List<Long> misc = new ArrayList<Long>();
    	misc.add((long)1);misc.add((long) 3);misc.add((long) 1);misc.add((long) 3);misc.add((long) 9);
    	Assert.assertEquals(3,Count_Triplets.countTriplets(misc,3));
    }
    @Test
    public void test_for_negative_test_cases() {
    	List<Long> list = new ArrayList<Long>();
    	list.add((long)1);list.add((long) 1);list.add((long)1);list.add((long)4);
    	Assert.assertEquals(0,Count_Triplets.countTriplets(list,4));
    	
    
    }
    
    
    
    @After
    public void tearDown() {

    }
}
