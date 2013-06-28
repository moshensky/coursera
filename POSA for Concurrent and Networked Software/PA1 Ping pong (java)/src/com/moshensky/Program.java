/*
You are to design a simple Java program where you create two threads,
Ping and Pong, to alternately display “Ping” and “Pong” respectively 
on the console.  The program should create output that looks like this:

Ready… Set… Go!

Ping!
Pong!
Ping!
Pong!
Ping!
Pong!
Done!

It is up to you to determine how to ensure that the two threads 
alternate printing on the console, and how to ensure that the main 
thread waits until they are finished to print: “Done!”  The order 
does not matter (it could start with "Ping!" or "Pong!").
 */
package com.moshensky;

public class Program {

	public static void main(String args[]) {
		Printer printer = new Printer();
		Word ping = new Word("Ping!", printer);
		Word pong = new Word("Pong!", printer);
		
		System.out.println("Ready… Set… Go!\n");
		
		ping.start();
		pong.start();
		
		// wait threads to finish
		while (ping.isAlive() || pong.isAlive()) {
			try {
				Thread.sleep(777);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Done!");
	}
}

class Word extends Thread {
	private String word;
	private Printer printer;
	private int printCount = 5; // how many times to print word

	public Word(String word, Printer printer) {
		this.word = word;
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 0; i < printCount; i++) {
			printer.startPrinting(this.word);
			printer.finishPrinting();
		}
	}
}

class Printer {
	private String lastPrintedWord;

	public Printer() {
		this.lastPrintedWord = "";
	}

	synchronized void startPrinting(String word) {
		// if current thread word equals to last printed word
		// we put this thread to sleep
		while (lastPrintedWord.equals(word)) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		
		System.out.println(word);
		lastPrintedWord = word;
		
		// sleep block to pause a little printing in console of next word
		try {
			Thread.sleep(777);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void finishPrinting() {
		notifyAll();
	}
}
