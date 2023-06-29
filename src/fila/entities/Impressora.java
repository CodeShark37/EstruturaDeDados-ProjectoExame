package fila.entities;

/**
 *
 * @author Josh Newman
 */
public class Impressora {
    private int id;
    private Queue<Documento> filaDocumentos;

    public Impressora() {
        this.filaDocumentos = new Queue<>();
    }

    public Impressora(int id, Queue<Documento> filaDocumentos) {
        this.id = id;
        this.filaDocumentos = filaDocumentos;
    }

    public Impressora(Queue<Documento> filaDocumentos) {
        this.filaDocumentos = filaDocumentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Documento> getFilaDocumentos() {
        return filaDocumentos;
    }

    public void setFilaDocumentos(Queue<Documento> filaDocumentos) {
        this.filaDocumentos = filaDocumentos;
    }

    public int getQtdDocs() {
        return this.filaDocumentos.Size();
    }

    private void setQtdDocs(int qtdDocs) {
        this.filaDocumentos.Size = qtdDocs;
    }
    /*Testa se a data do doc1 antecede a data do doc2*/
    private boolean isBeforeDoc(Documento doc1,Documento doc2){
        return(doc1.getData().isBefore(doc2.getData()));
    }
   
    public boolean hasDocs(){
        return (getQtdDocs() > 0);
    }
    
    public void addDoc(Documento doc) throws Exception{
        int i;
        
        for (i = 0; i <  this.filaDocumentos.Size(); i++) {
            if (isBeforeDoc(doc,(Documento)this.filaDocumentos.Element[i])) {
                break;
            }
        } 
        if(!this.filaDocumentos.Add(i, doc)){
            throw new Exception("Erro ao adicionar Documento!!");
        }
    }
    
    public void deleteDoc(int index) throws Exception{
        if(index < 0 || index >= this.filaDocumentos.Size()){
            throw new Exception("Erro ao eliminar Documento!!");
        }
        this.filaDocumentos.Remove(index);  
    }
    public void deleteAllDocs(){
        setQtdDocs(0);  
    }
    public void listDocs(){
        System.out.println(this.filaDocumentos.toString());
    }
    public void print(){
        System.out.println("Imprimindo "+getQtdDocs()+" Documentos...");
        Documento aux;
        
        while(hasDocs()){
            aux = this.filaDocumentos.UnQueue();
            System.out.println("    -> "+aux.getData()+" - "+aux.getTitulo()+".pdf [Done]");
        }
        System.out.println("Impressão Terminada!");
    }
    
}
