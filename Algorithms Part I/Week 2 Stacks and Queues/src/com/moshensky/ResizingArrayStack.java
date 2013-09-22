package com.moshensky;

import com.moshensky.interfaces.IStack;

public class ResizingArrayStack<T> implements IStack<T> {
    private T[] stack;
    private int size;
    
    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
	this.stack = (T[]) new Object[4];
	this.size = 0;
    }

    @Override
    public void push(T item) {
	this.stack[this.size] = item;
	this.size += 1;
	if (this.size == this.stack.length) {
	    this.stack = this.resizeArray(this.stack.length * 2);
	}
    }

    @Override
    public T pop() throws Exception {
	if (this.size == 0) {
	    throw new Exception("Stack is empty!");
	}
	this.size -= 1;
	T result = this.stack[this.size];
	if (this.size > 4 && this.size == this.stack.length / 4) {
	    this.stack = this.resizeArray(this.stack.length / 2);
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

    private T[] resizeArray(int size) {
	@SuppressWarnings("unchecked")
	T[] result = (T[]) new Object[size];
	for (int i = 0; i < this.size; i++) {
	    result[i] = this.stack[i];
	}
	
	return result;
    }

}
