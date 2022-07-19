

class Nodes<E>{
	protected E value;
	protected Nodes next;
	
	
}
class SinglyLinked {
	
	public Nodes head;
	public Nodes tail;
	
	public int size;
	
	public Nodes createSinglyLinkedList(int nodeValue) {
		head = new Nodes();
		
		Nodes Nodes = new Nodes();
		Nodes.next = null;
		Nodes.value = nodeValue;
		
		head= Nodes;
		tail = Nodes;
		
		size = 1;
		return head;
	}
	
	public void traverseSinglyLinkedList() {
		if (head == null) {
			System.out.println("SLLL doest not exist");
		}else {
			Nodes tempNode= head;
			for (int i = 0 ; i < size ; i++) {
				System.out.print(tempNode.value);
				
				if ( i != size -1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("\n");
	}
	
	public void insertInLinekedList(int nodeValue,int location) {
		Nodes Nodes = new Nodes();
		Nodes.value = nodeValue;
		
		if ( head  == null) {
			createSinglyLinkedList(nodeValue);
			return;
		}else if ( location == 0) {
			//System.out.println("insert start of singly linked list");
			Nodes.next = head;
			head = Nodes;
		}else if ( location >= size) {
//			System.out.println("insert end of singly linked list");
			Nodes.next = null;
			tail.next = Nodes;
			tail = Nodes;
		}else {
//			System.out.println("middle");
			Nodes tempNode = head;
			int index = 0;
			while ( index < location -1) {
				tempNode = tempNode.next;
				index++;
			}
			
			Nodes nextNode = tempNode.next;
			tempNode.next = Nodes;
			Nodes.next = nextNode;
		}
		size ++;
		return;
	}

}








public class Exp {
	public static void main(String[] args) {
		 SinglyLinkedList sll = new SinglyLinkedList();
			sll.insertInLinekedList(5);
			sll.traverseSinglyLinkedList();
			//System.out.println(sll.head.value);
			
			sll.insertInLinekedList(6);
			sll.traverseSinglyLinkedList();
		    sll.insertInLinekedList(7);
			sll.traverseSinglyLinkedList();
	}

}
