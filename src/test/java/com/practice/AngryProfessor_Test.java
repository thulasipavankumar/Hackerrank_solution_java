package src.test.java.com.practice;


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
    	int[] arr = {4,3};
    	Assert.assertTrue(AngryProfessor.angryProfessor(3,Arrays.asList(arr)).equals("YES"));
    	int[] fail_arr= {0 ,-1, 2, 1};
    	Assert.assertTrue(AngryProfessor.angryProfessor(2,Arrays.asList(fail_arr)).equals("NO"));
    	
    }
    @After
    public void tearDown() {

    }
}
