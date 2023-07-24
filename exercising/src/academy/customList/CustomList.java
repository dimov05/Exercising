package academy.customList;

import java.util.Arrays;

public class CustomList<T> {
    private int size;
    private int CAPACITY = 10;
    private T[] elements;

    public CustomList() {
        this.size = 0;
        this.elements = (T[]) new Object[CAPACITY];
    }

    public CustomList(int capacity) {
        this.size = 0;
        this.elements = (T[]) new Object[capacity];
        this.CAPACITY = capacity;
    }

    public void add(T element) {
        resizeIfSizeReachCapacity();
        if (element == null) {
            throw new NullPointerException("Can't add element null");
        }
        this.elements[size] = element;
        size++;
    }

    public void addByIndex(int index, T element) {
        size++;
        resizeIfSizeReachCapacity();
        if (element == null) {
            throw new NullPointerException("Can't add element null");
        }
        T elementToMoveForward = this.elements[index];
        T tempElement;
        this.elements[index] = element;
        for (int i = index; i <= size; i++) {
            if (i == index) {
                this.elements[i] = element;
            } else {
                tempElement = this.elements[i];
                this.elements[i] = elementToMoveForward;
                elementToMoveForward = tempElement;
            }
        }
    }

    private void resizeIfSizeReachCapacity() {
        if (size == CAPACITY) {
            this.CAPACITY = CAPACITY * 3 / 2 + 1;
            T[] copyElements = (T[]) new Object[CAPACITY];
            if (size >= 0) System.arraycopy(this.elements, 0, copyElements, 0, size);
            this.elements = copyElements;
        }
    }

    public void remove(int indexToRemove) {
        if (indexToRemove < 0 || indexToRemove >= this.size) {
            throw new IndexOutOfBoundsException("The given index is out of bounds! - " + indexToRemove);
        }
        for (int i = indexToRemove; i < size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        if (size * 2 < CAPACITY) {
            CAPACITY = CAPACITY * 2 / 3;
            copyArrayOnCapacityChange();
        }
    }

    private void copyArrayOnCapacityChange() {
        T[] copyElements = (T[]) new Object[CAPACITY];
        System.arraycopy(this.elements, 0, copyElements, 0, size);
        this.elements = copyElements;
    }

    public void remove(T element) {
        if (element == null) {
            throw new NullPointerException("Can't remove element null");
        }
        int indexOfElement = indexOf(element);
        if (indexOfElement == -1) {
            throw new IllegalArgumentException("The element is not present in the List");
        }
        for (int i = 0; i < size; i++) {
            if (this.elements[i] == element) {
                remove(i);
            }
        }
    }

    public int indexOf(T element) {
        if (element == null) {
            throw new NullPointerException("Can't find index of element null");
        }
        int indexOfElement = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i] == element) {
                indexOfElement = i;
                break;
            }
        }
        return indexOfElement;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound for size " + this.size);
        }
        return elements[index];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int lastIndexOf(T element) {
        if (element == null) {
            throw new NullPointerException("Can't find index of element null");
        }
        int indexOfElement = -1;
        for (int i = size; i >= 0; i--) {
            if (this.elements[i] == element) {
                indexOfElement = i;
                break;
            }
        }
        if (indexOfElement == -1) {
            throw new IllegalArgumentException("The element is not present in the List");
        }
        return indexOfElement;
    }

    public void addAll(CustomList<T> elementsToAdd) {
        for (int i = 0; i < elementsToAdd.size; i++) {
            if (elementsToAdd.get(i) == null) {
                throw new NullPointerException("Can't add element null");
            }
            add(elementsToAdd.get(i));
        }
    }

    public boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException("Can't find element null");
        }
        return Arrays.stream(this.elements).filter(e -> e == element).toArray().length >= 1;
    }

    public boolean containsAll(CustomList<T> elementsToCheck) {
        for (int i = 0; i < elementsToCheck.size; i++) {
            if (elementsToCheck.get(i) == null) {
                throw new NullPointerException("Can't check 'containsAll' for null element");
            }
            if (!contains(elementsToCheck.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(elements[i])
                    .append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
