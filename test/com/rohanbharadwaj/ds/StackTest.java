package com.rohanbharadwaj.ds;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Rohan Bharadwaj
 * @created Dec 24, 2016
 *
 */
public class StackTest {

	@Test
	public void basicPushPopTest() {
		Stack s = new Stack();
		s.push(2);
		s.push(5);
		s.push(8);
		assertEquals(3, s.size());
		s.pop();
		s.pop();
		assertEquals(1, s.size());
		assertEquals(s.pop(), 2);
	}
}
