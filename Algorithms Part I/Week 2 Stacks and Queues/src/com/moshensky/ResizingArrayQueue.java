package com.moshensky;

import java.util.Iterator;

import com.moshensky.interfaces.IQueue;

public class ResizingArrayQueue<T> implements IQueue<T> {
    private T[] arr;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
	this.arr = (T[]) new Object[1];
	this.head = 0;
	this.tail = -1;
	this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
	return new QueueIterator(this.arr, this.head, this.size);
    }
    
    private class QueueIterator implements Iterator<T>{
	private T[] arr;
	private int head;
	private int size;
	
	public QueueIterator(T[] arr, int head, int size) {
	    this.arr = arr;
	    this.head = head;
	    this.size = size;
	}

	@Override
	public boolean hasNext() {
	    return this.size > 0;
	}

	@Override
	public T next() {
	    int k = this.head % this.arr.length;
	    this.head += 1;
	    this.size -= 1;
	    return this.arr[k];
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }

    @Override
    public void enqueue(T item) {
	if (this.size == this.arr.length) {
	    this.arr = resize(this.arr.length * 2);
	}

	this.tail += 1;
	this.arr[this.tail % this.arr.length] = item;
	this.size += 1;
    }

    private T[] resize(int size) {
	@SuppressWarnings("unchecked")
	T[] newArr = (T[]) new Object[size];
	int arrLength = this.arr.length;
	for (int i = 0; i < size; i++) {
	    int k = (this.head + i) % arrLength;
	    newArr[i] = this.arr[k];
	}
	
	this.head = 0;
	this.tail = this.head + this.size - 1;
	return newArr;
    }

    @Override
    public T dequeue() throws Exception {
	if (this.size == 0) {
	    throw new Exception("Queue is empty");
	}
	
	this.size -= 1;
	return this.arr[this.head++];
	//this.head += 1;
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
