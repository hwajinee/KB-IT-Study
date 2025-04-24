package ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        MusicRunnable musicRunnable = new MusicRunnable();
        Thread thread1 = new Thread(musicRunnable);
        thread1.start();

        MovieThread movieThread = new MovieThread();
        Thread thread2 = new Thread(movieThread);
        thread2.start();
    }
}
