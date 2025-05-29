package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.add(new Message("sendMail", "홍길동"));
        messageQueue.add(new Message("sendSMS", "신용권"));
        messageQueue.add(new Message("sendKakaotalk", "김자바"));

        while(!messageQueue.isEmpty()){
            Message message = messageQueue.poll();
            String command = message.command;
            String to = message.to;
            switch(command) {
                case "sendMail":
                    System.out.println(to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(to + "님에게 SMS를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }

    }
}
