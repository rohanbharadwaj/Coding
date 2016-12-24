package com.rohanbharadwaj.util;

/**
 * @author Rohan Bharadwaj
 * @created Dec 24, 2016
 *
 */
public class Stack {

	private int MAX_CAPACITY = 32;
	private int[] arr;
	private int size;

	public Stack() {
		arr = new int[MAX_CAPACITY];
		size = 0;
	}

	public boolean empty() {
		return size == 0;
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalArgumentException("Stack is empty");
		}
		return arr[size - 1];
	}

	public int pop() {
		if (size == 0) {
			throw new IllegalArgumentException("Stack is empty");
		}
		int val = arr[size - 1];
		size--;
		return val;
	}

	public int push(int data) {
		if (size == MAX_CAPACITY) {
			throw new IllegalArgumentException("Stack is full");
		}
		arr[size++] = data;
		return arr[size - 1];
	}

	public int search(int data) {
		for (int i = 0; i < size; i++) {
			if (data == arr[i]) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public int size(){
		return size;
	}
}
