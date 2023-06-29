/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvore.entities;

/**
 *
 * @author Josh Newman
 */
public class Arvorev {
    private Nodev root;
    
    public void recursividadeAdcionar(int element) {
        
    if (isEmpty())
        this.root = new Nodev(element);
    else {
        recursividadeAdcionar(this.root, element);
    }
        
}

private void recursividadeAdcionar(Nodev node, int element) {
        
    if (element < node.value) {
        if (node.left == null) {
            Nodev newNode = new Nodev(element);
            node.left = newNode;
            newNode.parent = node;
            return;
        }
        recursividadeAdcionar(node.left, element);
    } else {
        if (node.right == null) {
            Nodev newNode = new Nodev(element);
            node.right = newNode;
            newNode.parent = node;
            return;
        }
        recursividadeAdcionar(node.right, element);
    }
        
}
public Nodev Procurar(int element) {
        
    Nodev aux = this.root;
        
    while (aux != null) {   
        if (aux.value == element) return aux;
        if (element < aux.value) aux = aux.left;
        if (element > aux.value) aux = aux.right;
    }
        
    return null;

}


public void add(int element) {
        
    if (isEmpty())
        this.root = new Nodev(element);
    else {
            
        Nodev aux = this.root;
            
        while (aux != null) {
                
            if (element < aux.value) {
                if (aux.left == null) { 
                    Nodev newNode = new Nodev(element);
                    aux.left = newNode;
                    newNode.parent = aux;
                    return;
                }
                    
                aux = aux.left;
            } else {
                if (aux.right == null) { 
                    Nodev newNode = new Nodev(element);
                    aux.right = newNode;
                    newNode.parent = aux;
                    return;
                }
                    
                aux = aux.right;
            }
        }
    }
        
}
public Nodev recursividadeProcura(int element) {
    return recursividadeProcura(this.root, element);
}
    
private Nodev recursividadeProcura(Nodev node, int element) {
    if (node == null) return null;
    if (element == node.value) return node;
    if (element < node.value) return recursividadeProcura(node.left, element);
    else return recursividadeProcura(node.right, element);
}

public Nodev min() {
    if (isEmpty()) return null;
    return min(this.root);
}
    
private Nodev min(Nodev node) {
    if (node.left == null) return node;
    else return min(node.left);
}

public Nodev max() {
    if (isEmpty()) return null;
        
    Nodev node = this.root;
    while(node.right != null)
        node = node.right;      

    return node;

}

public Nodev sucessor(Nodev node) {
    if (node == null) return null;
        
    if (node.right != null)
        return min(node.right);
    else {
        Nodev aux = node.parent;
            
        while (aux != null && aux.value < node.value)
            aux = aux.parent;
            
        return aux;
    }
}

public Nodev predecessor(Nodev node) {
    if (node == null) return null;
    
    if (node.left != null)
        return min(node.left);
    else {
        Nodev aux = node.parent;
        
        while (aux != null && aux.value > node.value)
            aux = aux.parent;
        
        return aux;
    }
}

 public int height() {
        return height(this.root);
    }
    
    private int height(Nodev node) {
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

public void preOrder() {
    preOrder(this.root);
}

private void preOrder(Nodev node) {
    if (node != null) {
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
}

public void inOrder() {
    inOrder(this.root);
}

private void inOrder(Nodev node) {
    if (node != null) {
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
}

public void posOrder() {
    posOrder(this.root);
}

private void posOrder(Nodev node) {
    if (node != null) {
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }
}

    
    public boolean isEmpty() {
        return this.root == null;
    }
}
