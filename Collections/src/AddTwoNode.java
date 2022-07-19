import java.util.LinkedList;

class ListNode {
	int val;

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

	ListNode next;

	ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNode {

	/**
	 * This list node uses for optimize memory usage
//	 */
//	private static final ListNode ZERO_NODE = new ListNode(0);
//
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		return recursiveSum(l1, l2, 0);
//	}
//
//	/**
//	 * Calculate sum of node values recursively
//	 *
//	 * @param a     first node
//	 * @param b     second node
//	 * @param carry the number from the last addition
//	 * @return calculated list node
//	 */
//	private ListNode recursiveSum(ListNode a, ListNode b, int carry) {
//		int sum = (a.val + b.val) + carry;
//		int newCarry = sum / 10;
//
//		ListNode r = new ListNode(sum % 10);
//		if (a.next == null && b.next == null) {
//			if (newCarry > 0) {
//				r.next = new ListNode(newCarry);
//			}
//		} else {
//			r.next = recursiveSum((a.next == null) ? ZERO_NODE : a.next, (b.next == null) ? ZERO_NODE : b.next,
//					newCarry);
//		}
//		System.out.println(r.val);
//		
//		return r;
//	}
	 ListNode nl= new ListNode();  
		      public int[] recuAdd(int v1,int  v2, int rem){
		        int[]a= new int[2];
		        a[0] = (v1+v2 + rem) % 10;
		        a[1]=Math.round(v1+v2)/10;  
		        return a;
		    }
		      public ListNode recu(ListNode l1, ListNode l2, int rem) {
		    	  int x= (l1 != null) ? l1.val : 0;
			       int y= (l2 != null) ? l1.val : 0;
			      
			        while(x !=0 && y !=0 ){
			            int[] newV= recuAdd(x, y , rem=0);
			           // nl.val=newV[0];
			            nl.next= new ListNode(newV[0]);
			            System.out.println(newV[0]+"****");
			            return recu(l1.next, l2.next, newV[1]);
			        }
					return nl;  
		      }
		    
		    public ListNode addTwoNumbers(ListNode l1, ListNode l2 ) {
		    	return recu(l1,l2,0);
		         
		        
		    }

	public static void main(String[] args) {
		AddTwoNode a = new AddTwoNode();
		ListNode l1= new ListNode(2);
		ListNode l2= new ListNode(4);
		l1.next= l2;
		ListNode l3= new ListNode(3);
		l2.next=l3;
		ListNode l4= new ListNode(5);

		ListNode l5= new ListNode(6);
		l4.next=l5;
		ListNode l6= new ListNode(4);
		l5.next=l6;
		
		
		Object r= a.addTwoNumbers(l1, l4);
		//System.out.println(r + "******");
	}
}
