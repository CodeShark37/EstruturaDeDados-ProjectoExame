package pilha.entities;

import Pilha.Pilha;

public class Management {
    private Pilha<Medicamento> pilhaCaducados = new Pilha<>();
    private Pilha<Medicamento> pilhaNormais = new Pilha<>();
    
    /* Verifica a existencia de medicamentos com data de caducidade proxima 
    e retira-os da pilha de medicamentos ainda em validade e coloca-os
    na pilha de medicamentos caducados
    */
    private void actualizaStock(){
        if(!pilhaNormais.estaVazia()){
            Medicamento medAux;
            Pilha<Medicamento> pilhaAux = new Pilha<>();
            
            while(!pilhaNormais.estaVazia()) {
                medAux = pilhaNormais.Topo();
                /* retira os medicamentos com data de validade proxima da pilha dos
            medicamentos ainda em validade */
                if(medAux.getDaysToExpire() <=30){
                    pilhaCaducados.Empilhar(pilhaNormais.Desempilhar());
                }else{
                    /* Empilha os medicamentos ainda em validade numa pilha auxiliar*/
                    pilhaAux.Empilhar(pilhaNormais.Desempilhar());
                }
            }
            /* Devolve os medicamentos da pilha normais */
           pilhaNormais = pilhaAux;
        }
    }
    public boolean armazenar(Medicamento med){
        if(med != null){
            if(med.getDaysToExpire() <= 30){
                pilhaCaducados.Empilhar(med);
            }else{
                pilhaNormais.Empilhar(med);
            }
            return true;
        }
        return false;
    }
    
    private Medicamento desalojar(){
        actualizaStock();
        /* Se a pilha dos medicamentos caducados estiver não estiver vazia
         * então ela será desempilhada, Senão a pilha dos não caducados será desempilhada, e 
         * se também esta pilha estiver vazia retorna null
         */
        Medicamento rem = pilhaCaducados.Desempilhar();;
        if(rem == null){
            rem = pilhaNormais.Desempilhar();
        }
        return rem;    
    }
    public boolean desalojarTodos(){
        if(!pilhaNormais.estaVazia() || !pilhaCaducados.estaVazia()){
            while(!pilhaNormais.estaVazia() || !pilhaCaducados.estaVazia()){
            System.out.println("A desalojar o " + desalojar());
            }
            return true;
        }return false;
    }
    public void listarCaducados(){
        if(!pilhaCaducados.estaVazia()){
            System.out.println(pilhaCaducados);
        }else{
            System.out.println("Nao existem Medicamentos com caducidade proxima no Armazem");
        }
    }
    public void listarEmValidade(){
        if(!pilhaNormais.estaVazia()){
            System.out.println(pilhaNormais);
        }else{
            System.out.println("Nao existem Medicamentos com tempo de validade aceitavel");
        }
    }
    public void listarTodos(){
        listarCaducados();
        listarEmValidade();
    }
}