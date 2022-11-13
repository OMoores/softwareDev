package game;
public class CardGame implements Runnable {
    
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CardGame());
        Thread thread2 = new Thread(new CardGame());

        thread.start();
        thread2.start();
    }

    
}