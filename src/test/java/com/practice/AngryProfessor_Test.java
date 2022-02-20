package test.java.com.practice;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.practice.AngryProfessor;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class AngryProfessor_Test {

	@Before
    public void SetUp() {

    }
    @Test
    public void test_for_positive_test_cases() {
    	List<Integer> list =  new ArrayList<Integer>();
    	list.add(4);
    	list.add(3);
    	Assert.assertTrue(AngryProfessor.angryProfessor(3,list).equals("YES"));
    	list =  new ArrayList<Integer>();
    	list.add(0);list.add(-1);list.add(2);list.add(1);
    	int[] fail_arr= {0 ,-1, 2, 1};
    	Assert.assertTrue(AngryProfessor.angryProfessor(2,list).equals("NO"));
    	
    }
    @Test
    public void test_for_failed_scenario() {
    	List<Integer> list =  new ArrayList<Integer>();
    	list.add(0);list.add(-1);list.add(2);list.add(1);
    	int[] fail_arr= {0 ,-1, 2, 1};
    	Assert.assertTrue(AngryProfessor.angryProfessor(2,list).equals("NO"));
    	
    }
    @After
    public void tearDown() {

    }
}
