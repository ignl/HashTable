package org.intelligentjava;

import org.junit.Assert;
import org.junit.Test;

public class OpenAddressingHashTableTest {

	  @Test
	    public void testAdd() {
	        OpenAddressingHashTable table = new OpenAddressingHashTable();
	        
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
	        
	    }
	  
}
