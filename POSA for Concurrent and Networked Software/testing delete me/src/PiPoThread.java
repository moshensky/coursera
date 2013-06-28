/*
 * PiPoThread represents the Runnable that would
 * be used to spawn the two threads that alternate
 * outputting Ping! Pong!
 */
public class PiPoThread implements Runnable {

        private int turnNumber;

        private static class PipoTask {
                private int turn = 0;
                public synchronized void doWork(int turnNumber) {
                        for (int i = 0; i < 3; ++i) {
                                while (turnNumber != turn) {
                                        try {
                                                wait();
                                        } catch (InterruptedException e) {
                                                e.printStackTrace();
                                        }
                                }
                                // It is my turn
                                if (turnNumber == 0)
                                        System.out.println("Ping!");
                                else
                                        System.out.println("Pong!");
                                // Now notify the other thread
                                turn = 1 - turnNumber;
                                notify();
                        }
                }
        }

        private static PipoTask task = new PipoTask();

        PiPoThread(int turn) {
                turnNumber = turn;
        }

        @Override
        public void run() {
                // The thread has to call a synchronized function
                // on an object
                task.doWork(turnNumber);
        }

        public static void main(String[] args) throws InterruptedException {

                System.out.println("Ready... Set... Go!");
                Thread p1 = new Thread(new PiPoThread(1));
                Thread p2 = new Thread(new PiPoThread(0));
                p1.start();
                p2.start();

                // Join with the threads
                p1.join();
                p2.join();

                System.out.println("Done!");
        }
}