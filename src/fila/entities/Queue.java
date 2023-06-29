package fila.entities;

public class Queue<T> extends StaticStructure<T> {
    public Queue() {
        super();
    }

    public Queue(int capacity) {
        super(capacity);
    }

    public boolean ToQueue(T element) {
        return this.Add(element);
    }

    public T Spy() {
        if (this.IsEmpty()) {
            return null;
        }

        return (T)this.Element[0];

    }

    public T UnQueue() {

        final int pos = 0;

        if (this.IsEmpty()) {
            return null;
        }

        T removeElement = (T)this.Element[pos];

        this.Remove(pos);

        return removeElement;

    }

}
