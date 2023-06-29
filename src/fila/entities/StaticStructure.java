package fila.entities;

public class StaticStructure<T> {
    protected Object[] Element;
    protected int Size;

    public StaticStructure(int capacity) {
        this.Element = new Object[capacity];
        this.Size = 0;

    }

    public StaticStructure() {
        this(12);
    }

    public int Size() {
        return Size;
    }

    public boolean Add(T element) {
        this.AddCapacity();
        if (this.Size < this.Element.length) {
            this.Element[Size] = element;
            Size++;
            return true;
        }
        return false;
    }

    public boolean IsEmpty() {
        return this.Size == 0;
    }

    public boolean Add(int pos, T element) {
        if (pos < 0 || pos > Size) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.AddCapacity();
        for (int i = this.Size - 1; i >= pos; i--) {
            this.Element[i + 1] = this.Element[i];
        }
        this.Element[pos] = element;
        this.Size++;

        return true;
    }

    public void AddCapacity() {
        if (this.Size == this.Element.length) {
            Object[] newElement = new Object[this.Element.length * 2];
            for (int i = 0; i < this.Element.length; i++) {
                newElement[i] = this.Element[i];
            }
            this.Element = newElement;
        }

    }

    public void Remove(int pos) {
        if (!(pos >= 0 && pos < Size)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        for (int i = pos; i < (Size-1); i++) {
            Element[i] = Element[i + 1];
        }
        Size--;
    }
    
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[\n");

        for (int i = 0; i < this.Size; i++) {
            s.append(i).append(" - ").append(this.Element[i]);
            if(i != this.Size-1)s.append(",");
            s.append("\n");
        }
        
        s.append("]");

        return s.toString();
    }
}
