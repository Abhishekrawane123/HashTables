package com.bridgelabz.HashTables;

public class MyLinkedList<K> {

	private Inode<K> head;
	private Inode<K> tail;

	public Inode<K> search(K key) {
		Inode<K> temp = head;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	public void append(Inode<K> myNode) {

		if (this.head == null) {
			this.head = myNode;
		}
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	@Override
	public String toString() {
		return "MyLinkedList [head=" + head + "]";
	}
}
