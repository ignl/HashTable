package org.intelligentjava;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class OpenAddressingHashTable {

	private static int SIZE = 1000;

	private String[] hashtable = new String[SIZE];

	/**
	 * Run loop incrementing probe index until an empty spot is found to insert
	 * an element.
	 * 
	 * @param value
	 *            String value to add to hashtable
	 */
	public void add(String value) {

		int probe = 0;

		do {
			int hash = hash(value, probe);
			if (hashtable[hash] == null) {
				hashtable[hash] = value;
				return;
			}
			probe++;
		} while (probe < SIZE);

		// hash table is full
		throw new RuntimeException("Hash table overflow");
	}

	/**
	 * Run loop incrementing probe index until element is found in one of the
	 * hash addresses or null is found which indicates that hashtable does not
	 * have an element..
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(String value) {
		int probe = 0;

		do {
			int hash = hash(value, probe);
			if (hashtable[hash] == null) {
				return false;
			} else {
				if (hashtable[hash].equals(value)) {
					return true;
				}
				probe++;
			}

		} while (probe < SIZE);

		return false;
	}

	/**
	 * Hash function with linear probing.
	 */
	private int hash(String value, int probe) {
		HashFunction hf = Hashing.murmur3_128(); // can choose any hash function
		int hash = Math.abs(hf.newHasher().putString(value, Charsets.UTF_8).hash().asInt()) % SIZE;

		return (hash + probe) % SIZE;
	}

}
