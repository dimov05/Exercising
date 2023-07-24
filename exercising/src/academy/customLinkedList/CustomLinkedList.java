package academy.customLinkedList;

public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T nodeValue) {
        Node<T> nodeToAdd = new Node<>(nodeValue);

        if (this.head == null) {
            this.head = nodeToAdd;
            this.tail = nodeToAdd;
        } else if (this.head.next == null) {
            nodeToAdd.prev = head;
            this.head.next = nodeToAdd;
            this.tail = nodeToAdd;
            this.tail.next = null;

        } else {
            this.tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            this.tail = nodeToAdd;
            this.tail.next = null;
        }
        size++;
    }

    public void add(int position, T nodeValue) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> newNode = new Node<>(nodeValue);
        if (position == 0) {
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        } else if (position == size) {
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        } else {
            Node<T> current = get(position);
            Node<T> prevNode = current.prev;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;

            size++;
        }
    }

    public Node<T> get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    public void remove(T value) {
        if (this.head == null) {
            throw new NullPointerException("The list is already empty");
        }
        Node<T> temp = head;
        while (temp.value != value) {
            temp = temp.next;
        }
        if (temp != head) {
            unLinkNode(temp);
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeAtIndex(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (position == 0) {
            if (isEmpty()) {
                return;
            }
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        } else if (position == size - 1) {
            if (isEmpty()) {
                return;
            }
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        } else {
            Node<T> nodeToRemove = get(position);
            remove(nodeToRemove.value);
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return "Custom Linked List is empty";
        }
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value)
                    .append(", ");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private void unLinkNode(Node<T> temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public int indexOf(T nodeValue) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == nodeValue) {
                return i;
            }
            temp = temp.next;
        }
        throw new NullPointerException("No such element is present in list");

    }

    public int lastIndexOf(T nodeValue) {
        Node<T> temp = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (temp.value == nodeValue) {
                return i;
            }
            temp = temp.prev;
        }
        throw new NullPointerException("No such element is present in list");
    }

    public boolean contains(T nodeValue) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.value == nodeValue) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean containsAll(CustomLinkedList<T> nodesToCheck) {
        for (int i = 0; i < nodesToCheck.size; i++) {
            if (nodesToCheck.get(i) == null) {
                throw new NullPointerException("Can't check 'containsAll' for null element");
            }
            if (!contains(nodesToCheck.get(i).value)) {
                return false;
            }
        }
        return true;
    }

    public void addAll(CustomLinkedList<T> elementsToAdd) {
        for (int i = 0; i < elementsToAdd.size; i++) {
            if (elementsToAdd.get(i) == null) {
                throw new NullPointerException("Can't add element null");
            }
            add(elementsToAdd.get(i).value);
        }
    }
}
