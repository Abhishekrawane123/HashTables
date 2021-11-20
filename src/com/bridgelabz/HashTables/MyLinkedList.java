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
	
	public boolean remove(K key) {
		
		Inode<K> temp =head;
		Inode<K> prev = null;
		while(temp != null) {
			if(temp.getKey()==key) {
				prev.setNext(temp.getNext());
				return true;
			} 
			prev = temp;
			temp = temp.getNext();
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "MyLinkedList [head=" + head + "]";
	}
}