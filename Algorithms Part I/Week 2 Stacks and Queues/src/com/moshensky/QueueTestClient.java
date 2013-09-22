package com.moshensky;

import com.moshensky.interfaces.IQueue;

public class QueueTestClient {

    public static void main(String[] args) throws Exception {
	Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	//IQueue<Integer> queue = new LinkedQueue<Integer>();
	IQueue<Integer> queue = new ResizingArrayQueue<Integer>();
	for (Integer integer : arr) {
	    queue.enqueue(integer);
	}	

	for (int i = 0; i < arr.length; i++) {
	    System.out.print(queue.dequeue() + " ");
	}	
	
	System.out.println();
	
	for (Integer integer : arr) {
	    queue.enqueue(integer);
	}	
	
	for (Integer number: queue) {
	    System.out.print(number + " ");
	}
    }

}
