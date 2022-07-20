
public class DoublyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public Node createDLL(int nodeValue) {
		head = new Node();

		Node newNode = new Node();
		newNode.data = nodeValue;
		newNode.next = null;
		newNode.prev = null;

		head = newNode;
		tail = newNode;
		size = 1;
		return head;
	}

	class Node {
		public int data;
		public Node prev;
		public Node next;

		public void displayNodeData() {
			System.out.println("{ " + data + " } ");
		}
	}

	public void insertDLL(int nodeValue, int location) {
		Node newNode = new Node();
		newNode.data = nodeValue;
		if (head == null) {
			// if in case user doesnt create before adding
			createDLL(nodeValue);
			return;
		} else if (location == 0) {
			// if user already created and added value using createDLL
			System.out.println("head 0");
			newNode.next = head; // null
			newNode.prev = null;
			head.prev = newNode;
			head = newNode; // first next index
		} else if (location >= size) {
			System.out.println("head location" + location + " " + nodeValue);
			newNode.next = null;
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		} else {
			System.out.println("head else" + location + " " + nodeValue);
			Node tempNode = head;
			int index = 0;
			// inserted at random location like 1, as location is less than size
			while (index < location - 1) {
				System.out.println("location: " + (location -1)+ " index: " + index);
				tempNode = tempNode.next;
				index++;
			}
			newNode.prev = tempNode;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			newNode.next.prev = newNode;
		}
		size++;
	}

	public void traverseDLL() {
		if (head != null) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.data);
				if (i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
			}
		} else {
			System.out.println("The DLL does not exist!");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		doublyLinkedList.createDLL(5);

		doublyLinkedList.insertDLL(10, 0);
		doublyLinkedList.insertDLL(20, 2);
		doublyLinkedList.insertDLL(30, 1);
		doublyLinkedList.insertDLL(30, 10);

		doublyLinkedList.traverseDLL();
//			doublyLinkedList.reverseTraverseDLL();
//			
//			doublyLinkedList.searchNode(20);
//			
//			
//			doublyLinkedList.deleteNodeDLL(2);
//			doublyLinkedList.traverseDLL();
//			
//			doublyLinkedList.deleteDLL();
//			doublyLinkedList.traverseDLL();

	}
}
