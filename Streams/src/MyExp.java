import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;



// 

public class MyExp {
	
	public void recurr(int[] a, int i) {
       while(a.length -1 == i) {
		if(a[i]> a[i+1]) {
			a[a.length -1] = a[i];
		}else {
			
		}
       }
		
	}
		public static void main(String[] args) {
			int[] a= {1,3,35,3,5};
			int temp=0;
			for(int i=0;i < a.length -1; i++) {
				
				if(a[i] > a[i+1]) {
					temp=a[i];
					a[i] = a[i+1];
					a[i+1]= temp;
					System.out.print(a[i]+"\n");
					 i = -1;
					 
				}else {
					System.out.print(a[i]+"\n");
				}
				
				

			}


		}
}
