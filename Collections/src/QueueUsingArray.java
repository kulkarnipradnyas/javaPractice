
//FIFO - first in first out
public class QueueUsingArray {
	int front;
	int rear;
	int[] queueArry;
	int capacity = 0;
	int currentSize = 0;

	QueueUsingArray(int size) {
		capacity = size;
		queueArry = new int[size];
		front = 0;
		rear = -1;

	}

	public boolean isFull() {
		// rear is end is equal to capacity mentioned in constructor
		return rear == capacity;
	}

	public boolean isEmpty() {
		// currentSize for front, capacity for rear, when both are same
		return currentSize == capacity;
	}

	public void enqueue(int data) {
		if (!isFull()) {
			rear++;
			if (rear == capacity - 1) {
				rear = 0;
			}
			queueArry[rear] = data;
			currentSize++;
			System.out.println(data + " is added");

		} else {
			System.out.println("Queue is Full");
		}
	}

	public void dequeue() {
		if (!isEmpty()) {
			front++;
			if (front == capacity - 1) {
				System.out.println(queueArry[front - 1] + "removed from the queue");
				front = 0;
			} else {
				System.out.println(queueArry[front - 1] + "removed from the queue");
			}

		} else {
			System.out.println("Queue is Full");
		}
		currentSize--;
	}

	public static void main(String[] args) {
		QueueUsingArray myQueue = new QueueUsingArray(6);
		myQueue.enqueue(1);
		myQueue.dequeue();
		myQueue.enqueue(30);
		myQueue.enqueue(44);
		myQueue.enqueue(32);
		myQueue.dequeue();
		myQueue.enqueue(98);
		myQueue.dequeue();
		myQueue.enqueue(70);
		myQueue.enqueue(22);
		myQueue.dequeue();
		myQueue.enqueue(67);
		myQueue.enqueue(23);
	}

}
