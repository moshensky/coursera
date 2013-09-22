package com.moshensky;

import com.moshensky.interfaces.IStack;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class StackTestClient {
    public static void main(String[] args) throws Exception {
	//IStack<String> stack = new LinkedStack<String>();
	IStack<String> stack = new ResizingArrayStack<String>();
	In in = new In(args[0]);
	while (!in.isEmpty()) {
	    String s = in.readString();
	    if (s.equals("-")) {
		StdOut.print(stack.pop() + " ");
	    } else {
		stack.push(s);
	    }
	}
	
	System.out.println();
	System.out.println("to be not that or be");
    }
}
