package grafo.entities;

import java.util.ArrayList;

/**
 *
 * @author Josh Newman
 */
public class Vertice<Tipo> {
    private int id;
    private Tipo dado;
    private ArrayList<Aresta<Tipo>> arestasEntrada;
    private ArrayList<Aresta<Tipo>> arestasSaida;
    
    public Vertice(Tipo valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Tipo>>();
        this.arestasSaida = new ArrayList<Aresta<Tipo>>();
    }

    public Vertice(int id, Tipo valor){
        this.id = id;
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Tipo>>();
        this.arestasSaida = new ArrayList<Aresta<Tipo>>();
    }
    
     public int getId() {
        return id;
    }
     
    public Tipo getDado() {
        return dado;
    }

    public void setDado(Tipo dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<Tipo> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<Tipo> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<Tipo>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Tipo>> getArestasSaida() {
        return arestasSaida;
    }
}
