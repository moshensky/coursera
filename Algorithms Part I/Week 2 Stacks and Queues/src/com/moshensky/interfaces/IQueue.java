package com.moshensky.interfaces;

public interface IQueue<T> extends Iterable<T>{
    void enqueue(T item);

    T dequeue() throws Exception;

    boolean isEmpty();

    int size();
}
