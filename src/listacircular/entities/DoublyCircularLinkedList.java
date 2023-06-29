package listacircular.entities;

public class DoublyCircularLinkedList<T> {
    private Node<T> head;
    private int size;

    public DoublyCircularLinkedList() {
        this.head = null;
        this.size = 0;
    }
    public Node<T> getFirst() {
        if (isEmpty()) return null;
        return head;
     }
  
     // Retorna o ultimo valor da lista (ou null se a lista for vazia)
     public Node<T> getLast() {
        if (isEmpty()) return null;
        return head.getPrev();
     }
  
    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if (isEmpty()) {
            head = node;
            head.setNext(head);
            head.setPrev(head);
        } else {
            Node<T> tail = head.getPrev();
            tail.setNext(node);
            node.setPrev(tail);
            node.setNext(head);
            head.setPrev(node);
        }
        size++;
    }
    public void addFirst(T value) {
        addLast(value);
        head = head.getPrev();
     }
    public void remove(T node) {
        if (isEmpty()) {
            return;
        }
        Node<T> current = head;
        do {
            if (current.getValue().equals(node)) {
                Node<T> prev = current.getPrev();
                Node<T> next = current.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                if (current == head) {
                    head = next;
                }
                size--;
                break;
            }
            current = current.getNext();
        } while (current != head);
    }
    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) head = null;
        else{
            Node<T> tail = head.getPrev();
            tail.setNext(head.getNext());
            head.getNext().setPrev(tail);
            head=head.getNext();
        }
        size--;
    }
   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
    if (isEmpty()) return;
    if (size == 1) {
       head = null;
    } else {
       Node<T> tail = head.getPrev();
       Node<T> cur = tail.getPrev();
        tail.setPrev(null);
        tail.setNext(null);
        cur.setNext(head);
        head.setPrev(cur);
    }
    size--;
 }
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
    
    public void clear(){
        head=null;
        size=0;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public void rotate() {
        if (!isEmpty()) // Se estiver vazia nao faz nada
           head = head.getNext();
     }
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String str = "{";      
      Node<T> cur = head;
      for (int i=0; i<size; i++) {
         str += cur.getValue();
         if (cur.getNext() != head)str += ",";
         cur = cur.getNext();
      }      
      str += "}";
      return str;
    }
    
}
