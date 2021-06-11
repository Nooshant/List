package com.duke.linkedlist;

public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;;
	}
	
	// Add the node to linkedlist
	public void add(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}
		Node prev = head;
		while (prev.getNext() != null) {
			prev = prev.getNext();
		}
		prev.setNext(node);
	}
	
	//Print the linkedlist
	public void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

	//Remove the node
	public void remove(int data)
	{
		Node node = head;
		Node prev = null;
		if (node.getData() == data) {
			Node next = node.getNext();
			if (next == null) {
				head = null;
			} else {
				head = next;
			}
		} else {
			while (node != null && node.getData() != data) {
				prev = node;
				node = node.getNext();
			}
			if (node != null) {
				if (node.getNext() == null) {
					prev.setNext(null);
				} else {
					prev.setNext(node.getNext());
				}
			}
		}
	}
	
	
	//Reverse the linklist  1->2->3->4->5    5->4->3->2->1->null
	public void reverse()
	{
		Node reverse = null;
		Node cur = head;
		Node nextNode = null;
		while (cur != null) {
			nextNode = cur.getNext();
			cur.setNext(reverse);
			reverse = cur;
			cur = nextNode;
		}
		head = reverse;
	}
	
	//Rotate right to the linkedlist 4->5->1->2->3->null
	public void rotateRight(int k) // 1->2->3->4->5
	{
		Node node = head;
		Node root = null;
		int len = 0;
		while (node != null) {
			len++;
			node = node.getNext();
		}
		if (k > len) {
			return;
		}
		node = head;
		Node prev = null;
		int r = 1;
		while (r != len - k) {
			node = node.getNext();
			prev = node;// 3
			r++;
		}
		root = node.getNext();// 4
		while (node.getNext() != null) {
			node = node.getNext();// 5
		}
		prev.setNext(null); // 3->null
		node.setNext(head);
		head = root;
	}
	
	//Swap node in pair
	public void swapInPair()  // 1 2 3 4 5
	{
		Node node1 = head; // 1
		Node node2 = node1.getNext(); // 2
		Node node3 = node2.getNext(); // 3
		Node cur = node2; // 3

		node1.setNext(node3); // 1 3 4 5
		node2.setNext(node1); // 2 1 3 4 5
		head = node2;// set the head node
		Node root = node1;//start now reversing from third node

		while (cur != null && cur.getNext() != null) {
			node1 = cur;// 3
			node2 = node1.getNext();// 4
			node3 = node2.getNext();// 5
			cur = node2;// 5
			node1.setNext(node3); // 3 5
			node2.setNext(node1); // 4 3
			root.setNext(node2);
			root = node1;
		}
		node1.setNext(cur);
	}
	
	//Intersection of two linkedlist
	public void intersectionPoint(LinkedList list1, LinkedList list2) {
		Node node1 = list1.head;
		Node node2 = list2.head;
		int len1 = 0;
		while (node1 != null) {
			len1++;
			node1 = node1.getNext();
		}

		int len2 = 0;
		while (node2 != null) {
			len2++;
			node2 = node2.getNext();
		}
		System.out.println("Len1:" + len1 + " Len2:" + len2);
		node1 = list1.head;
		node2 = list2.head;
		int diff = 0;
		if (len1 > len2) {
			diff = len1 - len2;
			for (int i = 0; i < diff; i++) {
				node1 = node1.getNext();
			}
		} else if (len1 < len2) {
			diff = len2 - len1;
			for (int i = 0; i < diff; i++) {
				node2 = node2.getNext();
			}
		}
		while (diff >= 0) {
			if (node1.getData() == node2.getData()) {
				System.out.println("Intersection Point: " + node1.getData());
				return;
			}
			node1 = node1.getNext();
			node2 = node2.getNext();
			diff--;
		}
	}
	
	
	// reverse k node block of linkedlist
	public void reverseListByKNode(int k)// 1 2 3 4 5 6 7 8 9 10 11 and k=3											
	{ 									 // 30 20 10 40 50 60 70 80 90 100 110
		// start with head node
		Node cur = head;
		// next block first node
		Node prevCurrent = head;
		// first node after reverse
		Node prevTail = null;

		while (cur != null) {
			int block = k;
			Node tail = null;
			while (cur != null && block > 0) {
				Node next = cur.getNext(); // 1
				cur.setNext(tail); // 1->null
				tail = cur;
				cur = next;
				block--;
			}
			if (prevTail != null) {
				prevTail.setNext(tail);
			} else {
				head = tail;
			}
			prevTail = prevCurrent;

			prevCurrent = cur;
		}
	}
}
