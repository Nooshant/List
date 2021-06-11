package com.duke.linkedlist;

public class MainClass {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(10);
		//list.display();
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(100);
		list.add(110);
		//list.add(120);
		//list.add(60);
//		list.display();
//		list.remove(40);
//		list.display();
//		list.remove(20);
		//list.display();
//		list.reverse();
//		list.display();
		//list.rotateRight(1);
		//list.swapInPair();
		list.reverseListByKNode(3);
		list.display();
//		LinkedList list2 = new LinkedList();
//		list2.add(25);
//		list2.add(40);
//		list2.add(50);
		//list2.display();
		//list.intersectionPoint(list, list2);
	}

}
