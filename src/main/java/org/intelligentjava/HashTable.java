package org.intelligentjava;

import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * Simple chaining hashtable implementation for strings.
 * 
 * @author Ignas
 *
 */
public class HashTable {
	
	private static int SIZE = 1000;
	
	@SuppressWarnings("unchecked")
	private LinkedList<String>[] hashtable = (LinkedList<String>[])new LinkedList[SIZE];
	
	/**
	 * Calculate hash with hash function then use it to find right bucket and add value there. 
	 * 
	 * @param value String value to add to hashtable
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
	 * @param value
	 * @return
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
	 * @param value
	 * @return
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
	
	
	private int hash(String value) {
		HashFunction hf = Hashing.murmur3_128(); // can choose any hash function
		return Math.abs(hf.newHasher()
	       .putString(value, Charsets.UTF_8)
	       .hash().asInt()) % SIZE;
	}
}