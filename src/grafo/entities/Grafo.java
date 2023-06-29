package grafo.entities;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Josh Newman
 */
public class Grafo <T>{
   
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }
    
    public void adicionarVertice(T dado){
        Vertice<T> novoVertice = new Vertice<>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarVertice(int id, T dado) {
        Vertice<T> novoVertice = new Vertice<>(id, dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public void adicionarAresta(Double peso, int idInicio, int idFim) {
        Vertice<T> inicio = this.getVertice(idInicio);
        Vertice<T> fim = this.getVertice(idFim);
        Aresta<T> aresta = new Aresta<>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<T> getVertice(T dados){
        Vertice<T> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dados)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public Vertice<T> getVertice(int id) {
        Vertice<T> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getId() == id) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public void buscarLargura(){
        ArrayList<Vertice<T>> marcar = new ArrayList<>();
        ArrayList<Vertice<T>> fila = new ArrayList<>();
        Vertice<T> atual = this.vertices.get(0);
        marcar.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(!fila.isEmpty()){
            Vertice<T> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcar.contains(proximo)){ 
                    marcar.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }
    
    public void buscarLargura(int id) {
        Vertice<T> verticeInicial = this.getVertice(id);
        if (verticeInicial != null) {
            ArrayList<Vertice<T>> visitados = new ArrayList<>();
            ArrayList<Vertice<T>> fila = new ArrayList<>();
            LinkedList<String> t = new LinkedList<>();
            

            visitados.add(verticeInicial);
            fila.add(verticeInicial);

            while (!fila.isEmpty()) {
                Vertice<T> vertice = fila.get(0);
                System.out.println(vertice.getDado());
                fila.remove(0);
                for (Aresta<T> aresta : vertice.getArestasSaida()) {
                    Vertice<T> vizinho = aresta.getFim();
                    if (!visitados.contains(vizinho)) {
                        visitados.add(vizinho);
                        fila.add(vizinho);
                    }
                }
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    
    public void listarAmigos(int id) {
        Vertice<T> vertice = this.getVertice(id);
        if (vertice != null) {
            System.out.println("Amigos do Usuário " + id + ":");
            for (Aresta<T> aresta : vertice.getArestasSaida()) {
                Vertice<T> amigo = aresta.getFim();
                System.out.println(amigo.getId() + ": " + amigo.getDado());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void listarAmigosEmComum(int idUsuario1, int idUsuario2) {
        Vertice<T> vertice1 = this.getVertice(idUsuario1);
        Vertice<T> vertice2 = this.getVertice(idUsuario2);
    
        if (vertice1 != null && vertice2 != null) {
            ArrayList<Vertice<T>> amigos1 = new ArrayList<>();
            ArrayList<Vertice<T>> amigos2 = new ArrayList<>();
    
            for (Aresta<T> aresta : vertice1.getArestasSaida()) {
                amigos1.add(aresta.getFim());
            }
    
            for (Aresta<T> aresta : vertice2.getArestasSaida()) {
                amigos2.add(aresta.getFim());
            }
    
            ArrayList<Vertice<T>> amigosEmComum = new ArrayList<>(amigos1);
            amigosEmComum.retainAll(amigos2);
    
            System.out.println("Amigos em comum entre os usuários " + ((Usuario)getVertice(idUsuario1).getDado()).getNome() + " e " + ((Usuario)getVertice(idUsuario2).getDado()).getNome() + ":");
            for (Vertice<T> amigo : amigosEmComum) {
                System.out.println(amigo.getId() + ": " + ((Usuario) amigo.getDado()).getNome());
            }
            System.out.println("Quantidade de amigos em comum: " + amigosEmComum.size());
        } else {
            System.out.println("Usuário(s) não encontrado(s).");
        }
    }
    
    public ArrayList<Vertice<T>> getVertices() {
        return this.vertices;
    }
    

    public void eliminarTodosVertices() {
        this.vertices.clear();
        this.arestas.clear();
    }
    
}
