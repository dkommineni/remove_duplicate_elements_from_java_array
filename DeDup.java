package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DeDup {

	public static final String ERROR_MSG = "Input array is null or empty.";
	
	public static void main(String[] args) {
		int[] randomIntegers = new int[200000];

	    for (int i = 0; i < randomIntegers.length; i++) {
	        Random random = new Random();
	        randomIntegers[i] = random.nextInt(200000);
	    }
		DeDup deDup = new DeDup();
		//With List implementation, elements are added in the order we receive the input, no overhead
		deDup.removeDupliacteArrayElementsWithList(randomIntegers);
		//With Set implementation, elements hash is used and little overhead, and order is not maintained
		deDup.removeDuplicateArrayElementsWithSet(randomIntegers);
		//With LinkedHashSet implementation we can maintain the order of elements inserted. More overhead compared to HashSet
		deDup.removeDuplicateArrayElementsWithSetAndKeepOrder(randomIntegers);
		
		//While LinkedList can be used, it has overhead of retrieving back elements from the linkedlist.		
		//My recommendation is, use List approach for removing duplicate elements and keeping the order of elements
	}

	/**
	 * This method uses list implementation to maintain the order of elements.
	 * This is useful where one wants to keep the order of elements
	 * 
	 * @param randomIntegers
	 */
	public void removeDupliacteArrayElementsWithList(int[] randomIntegers) {
		if (randomIntegers != null && randomIntegers.length > 0) {
			System.out.println("With List:\t");
			List<Integer> uniqueList = new ArrayList<Integer>();
			for (int i = 0; i < randomIntegers.length; i++) {
				if (!uniqueList.contains(randomIntegers[i])) {
					uniqueList.add(randomIntegers[i]);
					//System.out.print(randomIntegers[i] + "\t");
				}
			}
			for(Integer uniqueInt: uniqueList) {
				System.out.print(uniqueInt + "\t");
			}
		} else {
			System.err.println(ERROR_MSG);
		}
	}

	/**
	 * Removes duplicate elements using by adding elements to Set, as Set
	 * maintains unique elements. 
	 * 
	 * @param randomIntegers
	 */
	public void removeDuplicateArrayElementsWithSet(int[] randomIntegers) {
		if (randomIntegers != null && randomIntegers.length > 0) {
			System.out.println("\nWith Set:\t");
			Set<Integer> uniqueIntSet = new HashSet<Integer>();
			for (int i = 0; i < randomIntegers.length; i++) {
				uniqueIntSet.add(randomIntegers[i]);
			}
			for (Integer uniqueInt : uniqueIntSet) {
				System.out.print(uniqueInt + "\t");
			}
		} else {
			System.err.println(ERROR_MSG);
		}
	}

	/**
	 * Removes duplicate elements using by adding elements to Set, as Set
	 * maintains unique elements.
	 * 
	 * This method can be used to return elements after deleting duplicates.
	 * 
	 * @param randomIntegers
	 */
	public void removeDuplicateArrayElementsWithSetAndKeepOrder(int[] randomIntegers) {
		if (randomIntegers != null && randomIntegers.length > 0) {
			System.out.println("\nWith Set Order:\t");
			Set<Integer> uniqueIntSet = new LinkedHashSet<Integer>();
			for (int i = 0; i < randomIntegers.length; i++) {
				uniqueIntSet.add(randomIntegers[i]);
			}
			for (Integer uniqueInt : uniqueIntSet) {
				System.out.print(uniqueInt + "\t");
			}
		} else {
			System.err.println(ERROR_MSG);
		}
	}
}
