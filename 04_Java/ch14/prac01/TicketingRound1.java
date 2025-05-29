package ch14.prac01;

public class TicketingRound1 {
    public static void main(String[] args) {
        System.out.println("=== run() 직접 호출 테스트 ===");
        TicketRound1 fan1 = new TicketRound1();
        fan1.setName("팬1");
        fan1.run();

        Thread.currentThread().run();

        TicketRound1 fan2 = new TicketRound1();
        fan2.setName("팬2");
        fan2.run();


    }
}
