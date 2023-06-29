/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fila.entities;

import java.time.LocalDate;

/**
 *
 * @author Josh Newman
 */
public class Documento{
    private int id;
    private String titulo;
    private LocalDate data;
    private int qtdPag;

    public Documento() {
    }

    public Documento(String titulo, LocalDate data, int qtdPag) {
        this.titulo = titulo;
        this.data = data;
        this.qtdPag = qtdPag;
    }

    public Documento(int id, String titulo, LocalDate data, int qtdPag) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.qtdPag = qtdPag;
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }

    @Override
    public String toString() {
        return "Documento{" + "id=" + id + ", titulo=" + titulo + ", data=" + data + ", qtdPag=" + qtdPag + "}";
    }
    
}
