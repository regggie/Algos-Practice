package com.omkar;

import com.omkar.HashMap.Node;

public class HashMapRevision<K extends Comparable<K>, V> {

	private class Node {
		K key;
		V value;
		Node next;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private static final float LOAD_FACTOR = 0.75f;
	private int size;
	private Node[] hashTable;

	public HashMapRevision() {
		this.size = 0;
		//this.hashTable = (Node[]) new Object[10];		
		this.hashTable = new HashMapRevision.Node[10];
	}

	public V put(K key, V value) {
		V result = null;
		//size++;
		int length = this.hashTable.length;
		Node newNode = new Node(key, value);
		int index = key.hashCode() % length;
	    Node head = this.hashTable[index];
		if (head != null) {
			while (!head.key.equals(key) && head.next != null) {
				head = head.next;
			}
			if (head.key.equals(key)) {
				result = head.value;
				head.value = value;
			} else {
				result = value;
				head.next = newNode;
				size++;
			}
		} else {
			result = value;
			this.hashTable[index] = newNode;
			size++;
		}
		if (size > LOAD_FACTOR * length) {
			this.resize();
		}
		return result;
	}

	private void resize() {
		this.size = 0;
		Node[] old = this.hashTable;
		//this.hashTable = (Node[]) new Object[old.length * 2];
		this.hashTable = new HashMapRevision.Node[old.length * 2];
		for (Node node : old) {
			Node head = node;
			while (head != null) {
				this.put(head.key, head.value);
			}
		}
	}
	
	Node get(int key) {
		//Node newNode =
	   int ind = key%this.hashTable.length;
	   Node head=  this.hashTable[ind];
	   while(!head.key.equals(key)){
		   head=head.next;
	   }
	   return head;
	}
	
	public static void main(String[] args) {
		//HashMapRevision<String, String> hashMap = new
		HashMapRevision<Integer,Integer> myMap = new HashMapRevision<Integer,Integer>();
		myMap.put(1, 2);
		myMap.put(3, 3);
		myMap.put(3, 3);
		myMap.put(3, 3);
		myMap.put(3, 3);
		myMap.put(3, 4);
		System.out.println(myMap.get(3).value);
		System.out.println(myMap.size);
	}
}
