package com.sorting.client;

import java.util.List;

public class SortMethod {
	String method = "";
	
	//If there is no parameter for the constructor, the default sorting method is quick sort
	public SortMethod() {
		method = "QUICK";
		
	}
	
	public SortMethod(String name) {
		name = name.toUpperCase();
		if (!name.equals("QUICK") || !name.equals("MERGE")) {
			name = "QUICK";
		}
		method = name;
		
	}
	
	public void setMethod(String name) {
		method = name;
	}
	
	public void sortArray(List<Integer> unsortedArray) {
		
		if (method.equals("QUICK")) {
			quickSort(unsortedArray);
		} else if (method.equals("MERGE")) {
			mergeSort(unsortedArray);
		} 
		
	}
		
	//quick Sort functions and helper functions
	private void quickSort(List<Integer> unsortedArray) {
		int low = 0;
		int high = unsortedArray.size() -1;
		quickSortRecur(unsortedArray, low, high);
	}
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	private int partition(List<Integer> arr, int low, int high) 
	{ 
		int pivot = arr.get(high); 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr.get(j) <= pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr.get(i); 
				arr.set(i, arr.get(j)); 
				arr.set(j, temp); 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr.get(i+1); 
		arr.set(i+1, arr.get(high)); 
		arr.set(high, temp); 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr --> List to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	private void quickSortRecur(List<Integer> arr, int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr is 
			now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			quickSortRecur(arr, low, pi-1); 
			quickSortRecur(arr, pi+1, high); 
		} 
	} 


	
	

	
	//Merge Sort functions and helper functions 
		private void mergeSort(List<Integer> unsortedArray) {
			int l = 0;
			int r = unsortedArray.size() -1;
			
			mergeSortRecur(unsortedArray, l, r);
			
		}
	
	/////////////////////////////////////////////////////////
	// Merges two subarrays of arr. 
    // First subarray is arr 
    // Second subarray is arr 
    void merge(List<Integer> arr, int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr.get(l+i); 
        for (int j=0; j<n2; ++j) 
            R[j] = arr.get(m + 1 + j); 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr.set(k, L[i]); 
                i++; 
            } 
            else
            { 
            	arr.set(k, R[j]); 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
        	arr.set(k, L[i]);  
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
        	arr.set(k, R[j]); 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void mergeSortRecur(List<Integer> arr, int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSortRecur(arr, l, m); 
            mergeSortRecur(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
	
	

}
