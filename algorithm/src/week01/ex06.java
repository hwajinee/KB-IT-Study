package week01;
/*
    스택을 이용하여, 괄호의 짝을 검사한다.
    여는 괄호의 경우 push하고,
    닫는 괄호의 경우 스택의 top에 있는 여는 괄호와 짝이 맞으면 pop,
                                            짝이 맞지 않으면 result를 false로.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class ex06 {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean result = true;

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char popped = ' ';
                if(!stack.isEmpty()) popped = stack.pop();
                switch (c) {
                    case ')':
                        if(popped != '(') result = false;
                        break;
                    case '}':
                        if(popped != '{') result = false;
                        break;
                    case ']':
                        if(popped != '[') result = false;
                        break;
                }
            }
        }
        if( !stack.isEmpty()) result = false;
        System.out.println(result);
    }
}
