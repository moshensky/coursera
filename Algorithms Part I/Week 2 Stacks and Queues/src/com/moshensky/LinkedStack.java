package com.moshensky;

import com.moshensky.interfaces.IStack;

public class LinkedStack<T> implements IStack<T> {

    private class Node {
	T item;
	Node next;
	
	Node(T item, Node next) {
	    this.item = item;
	    this.next = next;
	}
    }

    private Node first = null;
    private int size = 0;

    @Override
    public void push(T item) {
	Node newNode = new Node(item, this.first);
	this.first = newNode;
	this.size += 1;
    }

    @Override
    public T pop() throws Exception {
	if (this.size == 0) {
	    throw new Exception("Stack is empty!");
	}
	T item = this.first.item;
	this.first = this.first.next;
	this.size -= 1;

	return item;
    }

    @Override
    public boolean isEmpty() {
	return this.size == 0;
    }

    @Override
    public int size() {
	return this.size;
    }

}
