public class Sorting {
	/**
	 * Swaps two elements in an integer array.
	 *
	 * This method swaps the elements at the specified positions (i and j) within
	 * the given integer array (A). It exchanges the values at A[i] and A[j] by
	 * temporarily storing the value of A[i] in a temporary variable, then assigning
	 * the value of A[j] to A[i], and finally assigning the temporary value to A[j].
	 *
	 * @param A The integer array in which elements are to be swapped.
	 * @param i The index of the first element to be swapped.
	 * @param j The index of the second element to be swapped.
	 */
	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	/**
	 * Prints the elements of an integer array.
	 *
	 * This method prints the elements of the given integer array (A) to the
	 * standard output stream, separated by spaces, followed by a newline character
	 * to create a visually formatted list of the array's contents.
	 *
	 * @param A The integer array to be printed.
	 */
	static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Finds the index of the smallest element within a specified range of an
	 * integer array.
	 *
	 * This method searches for the index of the smallest element within the
	 * subarray defined by the given start and end indices in the provided integer
	 * array (A). It iterates through the elements within the specified range and
	 * maintains the index of the smallest element encountered. The index of the
	 * smallest element is returned as the result.
	 *
	 * @param A     The integer array in which the smallest element is to be found.
	 * @param start The starting index of the subarray to search.
	 * @param end   The ending index of the subarray to search.
	 * @return The index of the smallest element within the specified subarray
	 *         range.
	 */
	static int findIndexSmallest(int[] A, int start, int end) {
		int minIndex = start; // Index of smallest remaining value.
		for (int j = start; j < end; j++) {
			if (A[minIndex] > A[j])
				minIndex = j; // Remember index of new minimum
		}
		return minIndex;
	}

	/**
	 * Sorts an integer array using the Selection Sort algorithm.
	 *
	 * This method sorts the given integer array (A) in ascending order using the
	 * Selection Sort algorithm. It iteratively selects the smallest element from
	 * the unsorted part of the array and swaps it with the element at the beginning
	 * of the unsorted part, effectively partitioning the array into sorted and
	 * unsorted sections.
	 *
	 * @param A The integer array to be sorted.
	 */
	static void SelectionSort(int[] A) { // Ex 1a Complete the method SelectionSort
		for (int i = 0; i < A.length - 1; i++) {
			int minIndex = i; // Index of smallest remaining value.
			minIndex = findIndexSmallest(A, i, A.length);
			// Complete this method. Note that the method swap is provided.
			if (i != minIndex) {
				swap(A, i, minIndex);
				printArray(A);
			}
		}
	}

	/**
	 * Sorts an integer array using the Insertion Sort algorithm.
	 *
	 * This method sorts the given integer array (A) in ascending order using the
	 * Insertion Sort algorithm. It iteratively builds a sorted subarray by shifting
	 * elements one at a time and inserting them into their correct positions within
	 * the sorted part of the array.
	 *
	 * @param A The integer array to be sorted.
	 */
	static void InsertionSort(int[] A) { // Ex 1b Complete the method InsertionSort
		for (int i = 1; i < A.length; i++) {
			int temp = A[i];
			for (int j = i - 1; j >= 0 && A[j] > temp; j--) {
				// Complete this method. Note the method swap is provided.
				swap(A, j, j+1);
				printArray(A);
			}
		}
	}

	/**
	 * Sorts an integer array using the Merge Sort algorithm recursively.
	 *
	 * This method sorts the given integer array (A) in ascending order using the
	 * Merge Sort algorithm. It recursively divides the array into smaller
	 * subarrays, sorts them individually, and then merges them back together.
	 *
	 * @param A The integer array to be sorted.
	 */
	private static void RecursiveMergeSort(int[] A) { // Ex3 Complete method RecursiveMergeSort
		int inputLength = A.length;
		if (inputLength < 2)
			return;

		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = A[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = A[i];
		}
		// Complete this method.
		// Call RecursiveMergeSort for leftHalf, rightHalf, and merge them. Note the
		// method merge is provided.
		RecursiveMergeSort(leftHalf);
		RecursiveMergeSort(rightHalf);
		merge(A, leftHalf, rightHalf);
	}

	/**
	 * Merges two sorted integer arrays into one sorted array.
	 *
	 * This method merges two sorted integer arrays, `leftHalf` and `rightHalf`,
	 * into a single sorted array `A`. It iterates through both input arrays,
	 * comparing elements and placing them in ascending order in the resulting
	 * merged array.
	 *
	 * @param A         The target integer array where the sorted elements will be
	 *                  stored.
	 * @param leftHalf  The first sorted integer array to be merged.
	 * @param rightHalf The second sorted integer array to be merged.
	 */
	private static void merge(int[] A, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] < rightHalf[j]) {
				A[k] = leftHalf[i];
				i++;
				k++;
			} else {
				A[k] = rightHalf[j];
				j++;
				k++;
			}
		}
		// Copy any remaining elements from the leftHalf array, if any.
		while (i < leftSize) {
			A[k] = leftHalf[i];
			i++;
			k++;
		}
		// Copy any remaining elements from the leftHalf array, if any.
		while (j < rightSize) {
			A[k] = rightHalf[j];
			j++;
			k++;
		}
	}

	/**
	 * Sorts an integer subarray using the Quick Sort algorithm recursively.
	 *
	 * This method sorts a subarray of the given integer array (A) in ascending
	 * order using the Quick Sort algorithm. It recursively partitions the array
	 * into smaller subarrays, and then sorts them individually.
	 *
	 * @param A     The integer array containing the subarray to be sorted.
	 * @param start The starting index of the subarray to be sorted.
	 * @param end   The ending index of the subarray to be sorted.
	 */
	static void RecursiveQuickSort(int[] A, int start, int end) { // Ex4. Complete the method RecursiveQuickSort
		if (start < end) { //recursive case
			int pivot = A[end];
			int[] L = new int[A.length];
			int[] R = new int[A.length];
			int l_count = 0;
			int r_count = 0;
			for (int i = start; i < end; i++) {
				if (A[i] < pivot) {
					L[l_count] = A[i];
					l_count++;
				} else {
					R[r_count] = A[i];
					r_count++;
				}
                                                                                                                                            			}

			for (int i = 0; i < l_count; i++) {
				A[start + i] = L[i];
			}
			A[l_count + start] = pivot;
			for (int i = 0; i < r_count; i++) {
				A[l_count + start + i + 1] = R[i];
			}
			// Complete this method.
//			// Call itself for sorting the leftHalf and the rightHalf
			RecursiveQuickSort(A, start, start+l_count - 1);
			RecursiveQuickSort(A, start+l_count+1, end);
		}

	}

	public static void main(String[] args) {

//		/**
//		 * The correct answer for a Selection Sort is
//		 * 
//		 * 9 12 89 36 64 22 75 51 45	
//		 * 9 12 22 36 64 89 75 51 45	
//		 * 9 12 22 36 45 89 75 51 64	
//		 * 9 12 22 36 45 51 75 89 64	
//		 * 9 12 22 36 45 51 64 89 75	
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("Selection Sort");
		int[] A = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(A);
		System.out.println("Your Solution is ");
		SelectionSort(A);

//		/**
//		 * The correct answer for an Insertion Sort is
//		 * 
//		 * 12 45 89 36 64 22 75 51 9	
//		 * 12 45 36 89 64 22 75 51 9 	
//		 * 12 36 45 89 64 22 75 51 9 	
//		 * 12 36 45 64 89 22 75 51 9 	
//		 * 12 36 45 64 22 89 75 51 9 	
//		 * 12 36 45 22 64 89 75 51 9 	
//		 * 12 36 22 45 64 89 75 51 9 	
//		 * 12 22 36 45 64 89 75 51 9 	
//		 * 12 22 36 45 64 75 89 51 9 	
//		 * 12 22 36 45 64 75 51 89 9 	
//		 * 12 22 36 45 64 51 75 89 9 	
//		 * 12 22 36 45 51 64 75 89 9 	
//		 * 12 22 36 45 51 64 75 9 89 	
//		 * 12 22 36 45 51 64 9 75 89 	
//		 * 12 22 36 45 51 9 64 75 89 	
//		 * 12 22 36 45 9 51 64 75 89 	
//		 * 12 22 36 9 45 51 64 75 89 	
//		 * 12 22 9 36 45 51 64 75 89 	
//		 * 12 9 22 36 45 51 64 75 89 	
//		 * 9 12 22 36 45 51 64 75 89 		
//		 */
		System.out.println("\nInsertion Sort");
		int[] B = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(B);
		System.out.println("Your Solution is ");
		InsertionSort(B);

//		/**
//		 * The correct answer for a Merge Sort is
//		 *
//		 * 9 12 22 36 45 51 64 75 89
//		 */
		System.out.println("\nMerge Sort");
		int[] C = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(C);
		System.out.println("Your Solution is ");
		RecursiveMergeSort(C);
		printArray(C);

		/**
		 * The correct answer for a Quick Sort is
		 *
		 * 9 12 22 36 45 51 64 75 89
		 */
		System.out.println("\nQuick Sort");
		int[] D = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(D);
		System.out.println("Your Solution is ");
		RecursiveQuickSort(D, 0, D.length - 1);
		printArray(D);
	}

}