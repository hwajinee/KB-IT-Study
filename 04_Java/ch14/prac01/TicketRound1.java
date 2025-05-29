package ch14.prac01;

public class TicketRound1 implements Runnable{

    public void setName(String name){
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 티켓 구매 시도 중!");
    }
}
