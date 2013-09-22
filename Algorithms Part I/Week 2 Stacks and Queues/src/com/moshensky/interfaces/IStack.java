package com.moshensky.interfaces;

public interface IStack<T> {
    void push(T item);

    T pop() throws Exception;

    boolean isEmpty();

    int size();
}
