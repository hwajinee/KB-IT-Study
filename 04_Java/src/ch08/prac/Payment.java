package ch08.prac;

public interface Payment {
    default boolean beforePay() {
        System.out.println("[공통] 결제를 준비합니다...");
        return true;
    }
    boolean pay(int amount);
    void approve();
    void cancel(String reason);
    static void log(String message){
        System.out.println("[LOG] " + message);
    }
}