package lru;

// Java program to implement LRU cache
// using LinkedHashSet

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

// The idea is to use a LinkedHashSet that maintains insertion order of elements.
// This way implementation becomes short and easy.

public class LRUCacheNEW {

	Set<Integer> cache;
	int capacity;

	public LRUCacheNEW(int capacity) {
		this.cache = new LinkedHashSet<Integer>(capacity);
		this.capacity = capacity;
	}

	// This function returns false if key is not
	// present in cache. Else it moves the key to
	// front by first removing it and then adding
	// it, and returns true.

	/* Refers key x with in the LRU cache */
	public void refer(int key) {
		if (!cache.contains(key)) {
			put(key);
		} else {
			cache.remove(key); //remove and add at last so order is maintained
			cache.add(key);
		}
	}

	public void put(int key) {
		//size full?
		if (cache.size() == capacity) {
			int firstKey = cache.iterator().next();
			cache.remove(firstKey); //always remove from front
		}

		cache.add(key);
	}

	// displays contents of cache in Reverse Order
	public void display() {
		LinkedList<Integer> list = new LinkedList<>(cache);

		// The descendingIterator() method of java.util.LinkedList
		// class is used to return an iterator over the elements
		// in this LinkedList in reverse sequential order
		Iterator<Integer> itr = list.descendingIterator();

		while (itr.hasNext())
			System.out.print(itr.next() + " ");
	}

	public static void main(String[] args) {
		LRUCacheNEW ca = new LRUCacheNEW(4);// [3,1,4,5]
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();

//		Properties  properties = new Properties();
	}
}
