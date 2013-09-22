package com.moshensky;

import java.util.Iterator;

import com.moshensky.interfaces.IQueue;

public class LinkedQueue<T> implements IQueue<T> {
    private class Node {
	T item;
	Node next;
	
	Node(T item) {
	    this.item = item;
	}
    }
    
    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public void enqueue(T item) {
	Node newNode = new Node(item);
	this.size += 1;
	if (this.size == 1) {
	    this.first = this.last = newNode;
	} else {
	    this.last.next = newNode;
	    this.last = newNode;
	}
    }

    @Override
    public T dequeue() throws Exception {
	if (this.size == 0) {
	    throw new Exception("Queue is empty!");
	}
	
	T result = this.first.item;
	this.size -= 1;
	if (this.first.next == null) {
	    this.first = this.last = null;
	} else {
	    this.first = this.first.next;
	}
	
	return result;
    }

    @Override
    public boolean isEmpty() {
	return this.size == 0;
    }

    @Override
    public int size() {
	return this.size;
    }

    @Override
    public Iterator<T> iterator() {
	return new QueueIterator(this.first);
    }
    
    private class QueueIterator implements Iterator<T> {
	private Node first;

	public QueueIterator(Node first) {
	    this.first = first;
	}

	@Override
	public boolean hasNext() {
	    return first != null;
	}

	@Override
	public T next() {
	    T result = this.first.item;
	    this.first = this.first.next;
	    return result;
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }

}
