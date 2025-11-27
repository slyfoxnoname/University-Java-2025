package HomeWorks.hm08;


class Node<T> {
    T data;           // Значення будь-якого типу
    Node<T> next;     // Посилання на наступний елемент

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
