package com.bridgelabz.HashTables;

import java.util.ArrayList;

public class LinkedHashMap<K, V> {

	private final int numberOfBucket;
	ArrayList<MyLinkedList<K>> arrayList;

	public LinkedHashMap() {

		numberOfBucket = 10;
		arrayList = new ArrayList<>();
		for (int i = 0; i < numberOfBucket; i++) {
			arrayList.add(null);
		}
	}

	public V get(K key) {

		int indexNumber = this.getBucketNumber(key);
		MyLinkedList<K> linkedList = arrayList.get(indexNumber);

		if (linkedList == null) {
			return null;
		}
		MyMapNode<K, V> mapNode = (MyMapNode<K, V>) linkedList.search(key);
		return mapNode == null ? null : mapNode.getValue();
	}

	private int getBucketNumber(K key) {

		int hashCode = Math.abs(key.hashCode());
		return hashCode % this.numberOfBucket;
	}

	public void put(K key, V value) {

		int index = this.getBucketNumber(key);
		MyLinkedList<K> linkedList = this.arrayList.get(index);
		if (linkedList == null) {
			linkedList = new MyLinkedList<>();
			this.arrayList.set(index, linkedList);
		}

		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			linkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}
	
public boolean remove(K key) {
		
		int index = this.getBucketNumber(key);
		MyLinkedList<K> linkedList = this.arrayList.get(index);

		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);

		linkedList.remove(key);
		arrayList.remove(index);
		return true;	
	}

	@Override
	public String toString() {
		return "LinkedHashMap [arrayList=" + arrayList + "]";
	}
}