package HomeWorks.hm08;
public class B08_01 <T> {
    private Node<T> top; // Верхівка стеку

    public B08_01() {
        top = null;
    }

    // Перевірка, чи стек порожній
    public boolean isEmpty() {
        return top == null;
    }

    // Додати елемент (push) — рекурсивно
    public void push(T item) {
        top = new Node<>(item, top);
    }

    // Видалити і повернути верхній елемент (pop) — рекурсивно
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній!");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    //  
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній!");
        }
        return top.data;
    }

    
    public int size() {
        return sizeRecursive(top);
    }

    private int sizeRecursive(Node<T> node) {
        if (node == null) return 0;
        return 1 + sizeRecursive(node.next);
    }

    public static void main(String[] args) {
        B08_01<Object> stack = new B08_01<>();

        stack.push(10);
        stack.push("Hello");
        stack.push(3.14);

        System.out.println(stack.peek()); // 3.14
        System.out.println(stack.pop());  // 3.14
        System.out.println(stack.size()); // 2
    }
}
