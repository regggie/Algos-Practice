package com.omkar;



public class HashMap<K extends Comparable<K>,V> {
		
	class Node {
		K key;
		V value;
		int hashcode;
		Node next;
		
		public Node(K k,V v){
			this.key= k;
			this.value=v;
			this.hashcode=this.key.hashCode();//actually should call k.hachCode()
			this.next=null;
		}
		
		@Override
		public boolean equals(Object other) {
			
			if(other instanceof HashMap.Node) {
				Node test= (Node)other;
				if(test.key.equals(this.key))
					return true;				
			}

			return false;
		}
	}
	
	int capacity;
    int size;
    final static float LOAD_FACTOR=0.75f;
	Node[] hashTable;
	public HashMap() {
		this.capacity=10;
	}
	
	
	public void put(K key,V value) {
		//check if hashtable has key with current capacity
		Node newNode= new Node(key, value);
		if(this.hashTable!=null) {
		   int oldind = key.hashCode()%this.hashTable.length;
		   if(this.checkIfBucketHasNode(this.hashTable[oldind], newNode))
			   return;
		}
		size++;		
		if(hashTable==null){
			this.hashTable = new HashMap.Node[16];			
		}
		else {
			if(size > hashTable.length*LOAD_FACTOR) {
			  //resize
				this.resize();	
			}			
		}		 
		int ind = newNode.hashcode%this.hashTable.length;
		this.putIntheBucket(this.hashTable[ind], newNode, ind);		
	}
	
	private boolean checkIfBucketHasNode(Node head, Node newNode) {
		while(head!=null) {	
			if(head.equals(newNode)) {
				head.value= newNode.value;
				return true;
			}
			head=head.next;
		}
		return false;
	}
	
	private void putIntheBucket(Node head, Node newNode,int ind) {		
		this.hashTable[ind]=newNode;		
        newNode.next=head;
	}
	
	
	private void resize() {
		// will do resizing
		System.out.println("Resize has been called");
		Node[] oldHashTable  = this.hashTable;
		this.hashTable = new HashMap.Node[oldHashTable.length*2];
		for(int i=0;i<oldHashTable.length;i++) {
			Node head = this.hashTable[i];
			while(head!=null) {
				int newInd = head.hashcode%this.hashTable.length;
				putIntheBucket(this.hashTable[newInd], head, newInd);
				head = head.next;
			}
		}
	}
	
	Node get(int key) {
		//Node newNode =
	   int ind = key%this.hashTable.length;
	   return this.hashTable[ind];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub										
		HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
		myMap.put(1, 2);
		myMap.put(3, 3);
		myMap.put(3, 3);
		myMap.put(3, 3);
		myMap.put(3, 3);
		myMap.put(3, 4);
		System.out.println(myMap.get(3).value);
		System.out.println(myMap.size);
		//System.out.println(1<<4);		
	}
}
