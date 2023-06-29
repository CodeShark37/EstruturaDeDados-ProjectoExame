package pilha.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Medicamento {
    private int id;
    private String nome;
    private String ref;
    private LocalDate dataProd;
    private LocalDate dataExp;

    
    public Medicamento() {
        this.nome = "";
        this.ref="";
        this.dataProd = null;
        this.dataExp = null;
    }
    
    public Medicamento(String nome, String ref, LocalDate dataProd, LocalDate dataExp) {
        this.nome = nome;
        this.ref = ref;
        this.dataProd = dataProd;
        this.dataExp = dataExp;
    }
    
    public Medicamento(int id, String nome, String ref, LocalDate dataProd, LocalDate dataExp) {
        this.id = id;
        this.nome = nome;
        this.ref = ref;
        this.dataProd = dataProd;
        this.dataExp = dataExp;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getRef() {
        return ref;
    }


    public void setRef(String ref) {
        this.ref = ref;
    }


    public LocalDate getDataProd() {
        return dataProd;
    }


    public void setDataProd(LocalDate dataProd) {
        this.dataProd = dataProd;
    }


    public LocalDate getDataExp() {
        return dataExp;
    }


    public void setDataExp(LocalDate dataExp) {
        this.dataExp = dataExp;
    }

    /* Conta os dias que faltam para o medicamento expirar */
    public long getDaysToExpire(){
        long diferencaEmDias = ChronoUnit.DAYS.between(LocalDate.now(), getDataExp());
        return diferencaEmDias;
    }


    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Medicamento\n ID: "+id+"\n NOME: " + nome +"\n REF: "+ ref+"\n DATA_PROD: " + dataProd.format(dtf) + "\n DATA_EXP: " + dataExp.format(dtf) +"\n";
    }
    
}