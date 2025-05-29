package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Coin> coinStack = new Stack<>();

        coinStack.add(new Coin(100));
        coinStack.add(new Coin(50));
        coinStack.add(new Coin(500));
        coinStack.add(new Coin(10));

        System.out.println("꺼내온 동전: " + coinStack.pop().getValue());
        System.out.println("꺼내온 동전: " + coinStack.pop().getValue());
        System.out.println("꺼내온 동전: " + coinStack.pop().getValue());
        System.out.println("꺼내온 동전: " + coinStack.pop().getValue());

    }
}
