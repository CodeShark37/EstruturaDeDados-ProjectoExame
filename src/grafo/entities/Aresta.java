
package grafo.entities;

import java.util.ArrayList;

/**
 *
 * @author Josh Newman
 */
public class Aresta<Tipo>  {
   
    private Double peso;
    private Vertice<Tipo> inicio;
    private Vertice<Tipo> fim;
    private ArrayList<Aresta<Tipo>> arestasEntrada;
    private ArrayList<Aresta<Tipo>> arestasSaida;
    
    public Aresta(Double peso, Vertice<Tipo> inicio, Vertice<Tipo> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<Tipo> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<Tipo> inicio) {
        this.inicio = inicio;
    }

    public Vertice<Tipo> getFim() {
        return fim;
    }

    public void setFim(Vertice<Tipo> fim) {
        this.fim = fim;
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
