package test.java.com.practice;

import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.practice.Sherlock_anagrams;

public class Sherlock_anagrams_Test {
	@Before
    public void SetUp() {

    }
    @Test
    public void test_for_positive_test_cases() {
    	Assert.assertEquals(4,Sherlock_anagrams.sherlockAndAnagrams("abba"));
    	Assert.assertEquals(0,Sherlock_anagrams.sherlockAndAnagrams("abcd"));
    	Assert.assertEquals(3,Sherlock_anagrams.sherlockAndAnagrams("ifailuhkqq"));
    	Assert.assertEquals(10,Sherlock_anagrams.sherlockAndAnagrams("kkkk"));
    	Assert.assertEquals(5,Sherlock_anagrams.sherlockAndAnagrams("cdcd"));
    	
    }
    @After
    public void tearDown() {

    }
}
