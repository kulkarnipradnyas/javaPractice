// Space complexity O(1) as single unit being use to store element
// Time complexity O(n)
public class LiniearSearch {
	
	public static void main(String[] args) {
		int index = linearSearch(new int[]{89, 57, 91, 47, 95, 3, 27, 22, 67, 99}, 67);
		if(index !=0) {
			System.out.println("Searched element is at index: " + index);
		}
		
	}

	private static int linearSearch(int[] listOFElement, int elementToSearch) {
		for(int i =0; i< listOFElement.length; i++) {
			if(listOFElement[i] == elementToSearch) {
				return i;
			}
		}
		return 0;
	}

}
