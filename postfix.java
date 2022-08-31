package stack;

import java.util.Stack;

class StackImpl {

    public int postfixToEvaluation(String s) {//girdiğimiz stringin hesaplamasını yapıyor
        Stack<Integer> st = new Stack<Integer>();
        int x = 0, y = 0;
        char ch[] = s.toCharArray();//stringi char dizisine dönüştürüyoruz
        for (char c : ch) {// dizi içindeki herbir eleman için döngüde işlem yapıcaz bu şekilde sadece rakamlar ile işlem yapabiliyoruz
            if (c >= '0' && c <= '9') {
                st.push((int) (c - '0'));//eğer string içinde sayi görürse burada inte dönüştürüyor
            } else {
                y = st.pop();
                x = st.pop();//2 kere pop işlemi gerçekleştiriyoruz ki hesaplamayı yapabilelim
                switch (c) {
                    case '+':
                        st.push(x + y);
                        break;
                    case '-':
                        st.push(x - y);
                        break;
                    case '*':
                        st.push(x * y);
                        break;
                    case '/':
                        st.push(x / y);
                        break;
                }
            }
        }
        return st.pop();
    }

    public String infixToPostfix(String s) {//infixi dönüştürüyoruz
        Stack<Character> st = new Stack<Character>();
        String postfix = "";
        char ch[] = s.toCharArray();

        for (char c : ch) {
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                postfix = postfix + c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty()) {
                    char t = st.pop();
                    if (t != '(') {
                        postfix = postfix + t;
                    } else {
                        break;
                    }
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (st.isEmpty()) {
                    st.push(c);
                } else {
                    while (!st.isEmpty()) {
                        char t = st.pop();
                        if (t == '(') {
                            st.push(t);
                            break;
                        } else if (t == '+' || t == '-' || t == '*' || t == '/') {
                            if (getPriority(t) < getPriority(c)) {
                                st.push(t);
                                break;
                            } else {
                                postfix = postfix + t;
                            }
                        }
                    }
                    st.push(c);
                }
            }
        }
        while (!st.isEmpty()) {
            postfix = postfix + st.pop();
        }
        return postfix;
    }

    public int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }

}

public class StackApp {

    public static void main(String[] args) {
        StackImpl a = new StackImpl();

        String s1 = a.infixToPostfix("2+3-1");
        System.out.println(a.postfixToEvaluation(s1));

        String s2 = a.infixToPostfix("2+3*4");
        System.out.println(a.postfixToEvaluation(s2));

        String s3 = a.infixToPostfix("3*(4+54)-6/(1+2)");
        System.out.println(a.postfixToEvaluation(s3));
    }

}
