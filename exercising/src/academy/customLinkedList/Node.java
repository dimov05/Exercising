package academy.customLinkedList;

public class Node<T> {
    public Node<T> next;
    public Node<T> prev;
    public T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
