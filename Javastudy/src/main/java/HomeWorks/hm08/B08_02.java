package HomeWorks.hm08;

class B08_02<T> {
    private Node<T> top;

    public B08_02() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній");
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній");
        }
        return top.data;
    }

    public static boolean isValid(String s) {
        B08_02<Character> stack = new B08_02<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;

                char open = stack.pop();
                if (!isMatching(open, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println("'()[]{}' Expected: true -> " + isValid("()[]{}"));
        System.out.println("'({[]})' Expected: true -> " + isValid("({[]})"));
        System.out.println("'([)]'   Expected: false -> " + isValid("([)]"));
        System.out.println("'({}'    Expected: false -> " + isValid("({}"));
        System.out.println("'((()))' Expected: true -> " + isValid("((()))"));
    }
}
