package com.sorting.client;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {
	
	public JUnitTest() {
		
	
	}
	
	private SortMethod sortMethod = new SortMethod();
	private Utility tool;
	private List<Integer> testList;
	private static String fileName;
	
	@BeforeClass
	public static void setUp() throws IOException {
		fileName ="testFileUtility";
		File testFile1 = new File(fileName);
		testFile1.createNewFile();
		
		
		
	}

	@Test
	public void testUtility() throws FileNotFoundException {
		testList = Arrays.asList(1,9,2,4,123,321);
		
		Utility test = new Utility();
		test.WriteFile(testList, fileName);
		List<Integer> readList = test.ReadFile(fileName);
		assertEquals("The list being writen has to be the same list when it is read", testList, readList);
		//Assert Equal for the testList and information out of the read
		
	}
	
	@Test
	public void testSortQuick() throws FileNotFoundException {
		testList = Arrays.asList(1,9,2,4,123,321);
		List<Integer> resultList = Arrays.asList(1,2,4,9,123,321);
		
		//set the method to quick sort
		sortMethod.setMethod("QUICK");
		sortMethod.sortArray(testList);
		
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
		//Assert Equal for the testList and information out of the read
		
		//testList.clear();
		testList = Arrays.asList(19191,23,1,2345,209,399,12);
		//resultList.clear();
		resultList = Arrays.asList(1,12,23,209,399,2345,19191);
		
		sortMethod.sortArray(testList);
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
		
		//Test with the case where the list is almost sorted
		testList = Arrays.asList(1,2,3,4,9,6);
		resultList = Arrays.asList(1,2,3,4,6,9);
		
		sortMethod.sortArray(testList);
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
		
		
		//Test with the case where there are many duplicated elements
		testList = Arrays.asList(1,1,1,1,1,18,64,234,18,64,234);
		resultList = Arrays.asList(1,1,1,1,1,18,18,64,64,234,234);
		
		sortMethod.sortArray(testList);
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
	}
	
	@Test
	public void testSortMERGE() throws FileNotFoundException {
		testList = Arrays.asList(1,9,2,4,123,321);
		List<Integer> resultList = Arrays.asList(1,2,4,9,123,321);
		
		//set the method to quick sort
		sortMethod.setMethod("MERGE");
		sortMethod.sortArray(testList);
		
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
		//Assert Equal for the testList and information out of the read
		
		//testList.clear();
		testList = Arrays.asList(19191,23,1,2345,209,399,12);
		//resultList.clear();
		resultList = Arrays.asList(1,12,23,209,399,2345,19191);
		
		sortMethod.sortArray(testList);
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
		
		//Test with the case where the list is almost sorted
		testList = Arrays.asList(1,2,3,4,9,6);
		resultList = Arrays.asList(1,2,3,4,6,9);
		
		sortMethod.sortArray(testList);
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
		
		
		//Test with the case where there are many duplicated elements
		testList = Arrays.asList(1,1,1,1,1,18,64,234,18,64,234);
		resultList = Arrays.asList(1,1,1,1,1,18,18,64,64,234,234);
		
		sortMethod.sortArray(testList);
		assertEquals("The list after being sorted has to be the same as the resultList", resultList, testList);
	}
	
	
	
	

}
