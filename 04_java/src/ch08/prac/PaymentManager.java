package ch08.prac;

public class PaymentManager {

    private int creditCardCount = 0;
    private int KakaoPayCount = 0;
    private int creditCardAmount = 0;
    private int KakaoPayAmount = 0;

    public void process(Payment payment, int amount){
        if(payment instanceof CreditCard){
            creditCardCount++;
            creditCardAmount += amount;
        } else if(payment instanceof KakaoPay){
            KakaoPayCount++;
            KakaoPayAmount += amount;
        }

        if(payment.pay(amount)) {
            payment.approve();
            payment.cancel("테스트 취소");

            if(payment instanceof KakaoPay) {
                ((KakaoPay) payment).sendNotification();
            } else {
                System.out.println("[알림 서비스 없음]");
            }
        } else {
            System.out.println("[결제 실패 : 승인/취소 건너뜀");
        }
    }

    public void printSummary(){
        System.out.println("✅ 결제 통계 요약\n");
        System.out.println(" 총 결제 횟수: " + (creditCardCount + KakaoPayCount) + "회");
        System.out.println(" 총 결제 금액: " + (creditCardAmount + KakaoPayAmount) + "원\n");
        System.out.println(" [CreditCard] : " + creditCardCount + "건");
        System.out.println(" [KakaoPay] : " + KakaoPayCount + "건");

    }
}
