import java.util.Arrays;
import java.util.Random;

import sorting.Sort;

/*
 * Assignment 2 
 * @author Jobanpreet Singh
 * Student Id: 110024321
 */

class Playground {

	/*
	 * Task 2 Generating 100000 random Long keys then sort them by Mergesort,
	 * Quicksort, Heapsort and dual-pivot Quicksort and Calculating average sorting
	 * time for each algorithm. Repeat the process for 100 times.
	 */
	void task2() {

		// Displaying Header

		System.out.println("\n\nTask 2:\n");
		System.out.println("\t\t\tAverage Sorting time of 100000 elements for 100 times");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println("\tMerge Sort\t\tQuick Sort\t\tHeap Sort\t\tDual Pivot Quick Sort");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");

		Long[] num = new Long[100000];

		long start = 0;
		long elapsed = 0;
		long average[] = new long[4];

		// Sorting an array of 100000 elements for 100 times
		for (int i = 0; i < 100; i++) {

			// Merge Sorting
			num = generateRandomLong();
			start = System.currentTimeMillis();
			Sort.mergeSort(num);
			elapsed = System.currentTimeMillis() - start;
			average[0] += elapsed;

			// Quick Sorting
			num = generateRandomLong();
			start = System.currentTimeMillis();
			Sort.quicksort(num);
			elapsed = System.currentTimeMillis() - start;
			average[1] += elapsed;

			// Heap Sorting
			num = generateRandomLong();
			start = System.currentTimeMillis();
			Sort.heapsort(num);
			elapsed = System.currentTimeMillis() - start;
			average[2] += elapsed;

			// Dual Pivot Quick Sorting
			num = generateRandomLong();
			start = System.currentTimeMillis();
			Arrays.sort(num);
			elapsed = System.currentTimeMillis() - start;
			average[3] += elapsed;
		}

		// Displaying average time results
		System.out.println("\t" + average[0] / 100 + "\t\t\t" + average[1] / 100 + "\t\t\t" + average[2] / 100 + "\t\t\t\t"
				+ average[3] / 100);
	}// end of task 2

	/*
	 * Task 3 Generating 100000 random strings of length 4,6,8,10 then sort them by
	 * Mergesort, Quicksort, Heapsort, dual-pivot Quicksortand Radix Sort and
	 * Calculating average sorting time for each algorithm. Repeat the process for
	 * 10 times.
	 */
	void task3() {

		// Displaying the Header
		System.out.println("\n\nTask 3:\n");
		System.out.println("\t\t\t\t\tAverage Sorting time of 100000 elements for 10 times");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"Lenght of String\tMerge Sort\t\tQuick Sort\t\tHeap Sort\t\tDual Pivot Quick Sort\t\tRadix Sort");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------");

		String randomStrings[];
		int num = 100000;

		// loop for sorting random strings of length 4,6,8,10
		for (int i = 4; i < 11; i += 2) {

			long start = 0;
			long elapsed = 0;
			long average[] = new long[5];

			// Repeating 10 times
			for (int j = 0; j < 10; j++) {
				// Merge Sorting
				randomStrings = generateRandomString(num, i);
				start = System.currentTimeMillis();
				Sort.mergeSort(randomStrings);
				elapsed = System.currentTimeMillis() - start;
				average[0] += elapsed;

				// Quick Sorting
				randomStrings = generateRandomString(num, i);
				start = System.currentTimeMillis();
				Sort.quicksort(randomStrings);
				elapsed = System.currentTimeMillis() - start;
				average[1] += elapsed;

				// Heap Sorting
				randomStrings = generateRandomString(num, i);
				start = System.currentTimeMillis();
				Sort.heapsort(randomStrings);
				elapsed = System.currentTimeMillis() - start;
				average[2] += elapsed;

				// Dual Pivot Quick Sorting
				randomStrings = generateRandomString(num, i);
				start = System.currentTimeMillis();
				Arrays.sort(randomStrings);
				elapsed = System.currentTimeMillis() - start;
				average[3] += elapsed;

				// Radix Sorting
				randomStrings = generateRandomString(num, i);
				start = System.currentTimeMillis();
				sorting.RadixSort.radixSortA(randomStrings, i);
				elapsed = System.currentTimeMillis() - start;
				average[4] += elapsed;

			}

			// Displaying the average sorting time results
			System.out.println("\t" + i + "\t\t" + average[0] / 10 + "\t\t\t" + average[1] / 10 + "\t\t\t" + average[2] / 10
					+ "\t\t\t\t" + average[3] / 10 + "\t\t\t\t" + average[4] / 10);
		}

	}// End of task 3

	/*
	 * Task 5 Generating 1000 pairs of random words of length 10,20,50 and 100 and
	 * then compute the edit distance for all words and find the average CPU time
	 * for each pair
	 */
	void task5() {

		// Displaying the Header
		System.out.println("\n\nTask 5:\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("String length\t\tAverage edit distance time");
		System.out.println("-----------------------------------------------------------------");

		long start = 0;
		long elapsed = 0;
		long average = 0;

		int len[] = new int[] { 10, 20, 50, 100 };

		// Repeating the loop for different length of String
		for (int i = 0; i < 4; i++) {
			// generating the pairs of Random Strings
			String str1[] = generateRandomString(1000, len[i]);
			String str2[] = generateRandomString(1000, len[i]);

			// Computing Edit distance for all pairs and calculate the average time
			for (int j = 0; j < 1000; j++) {
				start = System.nanoTime();
				algorithmDesign.Sequences.editDistance(str1[j], str2[j]);
				elapsed = System.nanoTime() - start;
				average += elapsed;
			}

			// Displaying the results
			System.out.println(len[i] + "\t\t\t\t" + average / 1000);

		}

	}

	public static void main(String args[]) {
		Playground playground = new Playground();
		playground.task2();
		playground.task3();
		playground.task5();
	}

	// Generating and popularizing 1,00,000 Long array with random Long elements
	Long[] generateRandomLong() {
		Long num[] = new Long[100000];
		Random random = new Random(System.currentTimeMillis());
		for (int j = 0; j < num.length; j++) {
			num[j] = random.nextLong();
		}
		return num;
	}

	/*
	 * @param num number of Strings to generate
	 * 
	 * @param len length of String
	 * 
	 * @return String[] an array of Strings Generating and popularizing num string
	 * array of length len with random strings
	 */
	String[] generateRandomString(int num, int len) {
		String randomStrings[] = new String[num];

		final String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer randomBuffer = new StringBuffer(len);

		// generating num random string
		for (int i = 0; i < num; i++) {

			// appending random char to StringBuffer
			for (int j = 0; j < len; j++) {
				randomBuffer.append(alphaNumeric.charAt(new Random().nextInt(alphaNumeric.length())));
			}

			randomStrings[i] = randomBuffer.toString();
			// clearing string buffer
			randomBuffer.delete(0, randomBuffer.length());
		}

		return randomStrings;
	}
}
