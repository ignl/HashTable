package org.intelligentjava;

import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class HashTable {
	
	private static int SIZE = 1000;
	
	@SuppressWarnings("unchecked")
	private LinkedList<String>[] hashtable = (LinkedList<String>[])new LinkedList[SIZE];
	
	/**
	 * Calculate hash with hash function then use it to find right bucket and add value there. 
	 */
	public void add(String value) {
		int hash = hash(value);
		if (hashtable[hash] == null) {
			hashtable[hash] = new LinkedList<>();
		}
		LinkedList<String> bucket = hashtable[hash];
		bucket.add(value);
	}
	
	/**
	 * Calculate hash with hash function then use it to find right bucket check if value exists in that bucket.
	 */
	public boolean contains(String value) {
		int hash = hash(value);
		LinkedList<String> bucket = hashtable[hash];
		if (bucket != null) {
			Iterator<String> it = bucket.iterator();
			while (it.hasNext()) {
				if (it.next().equals(value)) {
					return true;
				}
			}
		}
		// value not found
		return false;
	}

	/**
	 * Calculate hash with hash function then use it to find right bucket check if value exists in that bucket and if so remove it.
	 */
	public boolean remove(String value) {
		int hash = hash(value);
		LinkedList<String> bucket = hashtable[hash];
		if (bucket != null) {
			Iterator<String> it = bucket.iterator();
			while (it.hasNext()) {
				if (it.next().equals(value)) {
					it.remove();
					return true;
				}
			}
		}
		// value not found
		return false;
	}
	
	
	/**
	 * Hash function from Guava library.
	 */
	private int hash(String value) {
		HashFunction hf = Hashing.murmur3_128(); // can choose any hash function
		return Math.abs(hf.newHasher()
	       .putString(value, Charsets.UTF_8)
	       .hash().asInt()) % SIZE;
	}
}