//This kind of search uses the Divide and Conquer methodology and requires the data set to be sorted beforehand.
// it is mandatory that array should be sorted.

//Time complexity: O(log(N))
//Space complexity: O(1)

public class BinarySearch {
	public static void main(String[] args) {
		int[] list = new int[] { 3, 22, 27, 47, 57, 67, 89, 91, 95, 99 };
		
		
		int index = binarySearch(list, 67);
		
		int indexByArraysMethod = java.util.Arrays.binarySearch(list, 67);
		
		System.out.println("indexByArraysMethod: " + indexByArraysMethod);
		if (index != 0) {
			System.out.println("Searched element is at index: " + index);
		}
	}

	public static int binarySearch(int arr[], int elementToSearch) {

		int firstIndex = 0;
		int lastIndex = arr.length - 1;

		// termination condition (element isn't present)
		while (firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;
			// if the middle element is our goal element, return its index
			if (arr[middleIndex] == elementToSearch) {
				return middleIndex;
			}

			// if the middle element is smaller
			// point our index to the middle+1, taking the first half out of consideration
			else if (arr[middleIndex] < elementToSearch)
				firstIndex = middleIndex + 1;

			// if the middle element is bigger
			// point our index to the middle-1, taking the second half out of consideration
			else if (arr[middleIndex] > elementToSearch)
				lastIndex = middleIndex - 1;

		}
		return -1;
	}
}
