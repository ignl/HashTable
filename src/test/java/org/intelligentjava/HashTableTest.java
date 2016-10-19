package org.intelligentjava;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

	  @Test
	    public void testAdd() {
	        HashTable table = new HashTable();
	        
	        table.add("aaa");
	        table.add("aaa1");
	        table.add("aaa2");
	        table.add("aaa3");
	        table.add("aaa4");
	        
	        Assert.assertTrue(table.contains("aaa"));
	        Assert.assertTrue(table.contains("aaa1"));
	        Assert.assertTrue(table.contains("aaa2"));
	        Assert.assertTrue(table.contains("aaa3"));
	        Assert.assertTrue(table.contains("aaa4"));
	        
	        Assert.assertFalse(table.contains("bbb"));
	        Assert.assertFalse(table.contains("bbb1"));
	        
	        table.remove("aaa");
	        table.remove("aaa1");
	        table.add("bbb");

	        Assert.assertFalse(table.contains("aaa"));
	        Assert.assertFalse(table.contains("aaa1"));
	        Assert.assertTrue(table.contains("bbb"));
	        Assert.assertFalse(table.contains("bbb1"));
	    }
	  
}
