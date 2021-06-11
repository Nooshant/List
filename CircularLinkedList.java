package com.duke.circularlist;

public class CircularLinkedList {
	private CLLNode head;
	private CLLNode tail;
	
	
	// add the CLL node
	public void add(int data)
	{
		CLLNode node = new CLLNode(data);
		
		if (head==null) {
			head=node;
			tail=node;
			node.setNext(tail);
		}
		else {
			CLLNode cur = head;
			while (cur!=tail) {
				cur = cur.getNext();
			}
			tail.setNext(node);
			tail=node;
			tail.setNext(cur);
		}
	}
	
	// print the CLL
	public void show()
	{
		if(head==null)
		{
			System.out.println("No Element");
			return;
		}
		System.out.print("Circular linked list:");
		CLLNode cur = head;
		while(cur!=tail) {
			System.out.print(cur.getData()+" ");
			cur=cur.getNext();
		}
		System.out.print(tail.getData()+"\n");
	}
	
	// delete the node
	public void remove()
	{
		if(head==null)
		{
			System.out.println("No Element");
			return;
		}
		CLLNode cur = head;
		if (cur == tail) {
			System.out.print("removed :"+tail.getData()+"\n");
			head = null;
			return;
		}
		CLLNode prevCllNode = null;
		while (cur!=tail) {
			prevCllNode = cur;
			cur = cur.getNext();
		}
		System.out.print("removed :"+tail.getData()+"\n");
		prevCllNode.setNext(head);
		tail=prevCllNode;
		
	}

}
