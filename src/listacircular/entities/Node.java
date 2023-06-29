package listacircular.entities;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node(T n) {
        this.value = n;
        this.next = null;
        this.prev = null;
    }

    public T getValue() {
        return value;
    }

    public void setNode(T n) {
        this.value = n;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node [prev=" + prev.getValue() + ", value=" + value + ", next=" + next.getValue() + "]";
    }
    
}
