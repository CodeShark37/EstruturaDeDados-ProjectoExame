/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvore.entities;

/**
 *
 * @author Josh Newman
 */
public class Diretorio {
    String nome;
    Diretorio esquerda;
    Diretorio direita;

    public Diretorio(String nome) {
        this.nome = nome;
        this.esquerda = null;
        this.direita = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Diretorio getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Diretorio esquerda) {
        this.esquerda = esquerda;
    }

    public Diretorio getDireita() {
        return direita;
    }

    public void setDireita(Diretorio direita) {
        this.direita = direita;
    }

}
