package ch08.prac;

import java.util.Scanner;

public class Main {
//    practice 4번 main 함수
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        Payment[] payments = {
//                new CreditCard(),
//                new KakaoPay(),
//                new KakaoPay(),
//                new CreditCard()
//        };
//
//        for(int i=0; i<payments.length; i++) {
//            System.out.println("[" + (i+1) + "번 결제수단] 결제 금액을 입력하세요: ");
//            System.out.print(">> ");
//
//            int input = sc.nextInt();
//            if(payments[i].pay(input)){
//                payments[i].approve();
//                payments[i].cancel("테스트 취소");
//            }
//            System.out.println();
//        }
//
//    }
    public static void main(String[] args) {
        Payment payment = null;
        PaymentManager pm = new PaymentManager();

        while(true){
            System.out.println("== 화진페이 결제 시스템 ==");
            System.out.println(" [1] 신용카드");
            System.out.println(" [2] 카카오페이");
            System.out.println(" [0] 종료");
            System.out.println();

            // (1). 결제 수단 선택
            Scanner sc = new Scanner(System.in);
            System.out.print("결제 수단을 선택하세요: ");
            int method = sc.nextInt();
            if( method == 0 ) break;

            // (1)-1. 결제 수단에 따른 Payment 객체 생성
            if(method == 1) {
                payment = new CreditCard();
            } else if(method == 2) {
                payment = new KakaoPay();
            } else {
                System.out.println("결제 수단을 잘못 입력하셨습니다.");
                System.out.println("결제 수단을 선택하세요 : ");
                method = sc.nextInt();
            }

            // (1)-2. 카카오페이의 경우 사용자 인증절차 실행
            if(payment instanceof KakaoPay){
                System.out.print("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
                String input = sc.next();
                if(input.trim().equals("y")){
                    ((KakaoPay) payment).authenticate();
                } else if(input.trim().equals("n")){
                    //
                }
            }

            // (2) 결제 준비 단계
            if (!payment.beforePay()){
                System.out.println("[결제 실패: 준비 단계에서 중단]");
                System.out.println();
                continue;
            }

            // (3) 결제 실행 -> 금액 받고 PaymentManager에게 넘김.
            System.out.print("결제 금액을 입력하세요 : ");
            int amount = sc.nextInt();

            pm.process(payment, amount);
            System.out.println();
        }
        pm.printSummary();
    }
}
