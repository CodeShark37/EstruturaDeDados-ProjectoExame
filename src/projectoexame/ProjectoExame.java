package projectoexame;


import arvore.app.ArvoreApp;
import fila.app.FilaApp;
import grafo.app.GrafoApp;
import java.util.InputMismatchException;
import java.util.Scanner;
import listacircular.app.ListaCircularApp;
import pilha.app.PilhaApp;

/**
 *
 * @author Josh Newman
 */
public class ProjectoExame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
		int op =0;
		while(true){
			System.out.println("------------------------------");
			System.out.println("PROJECTO EXAME DE ALGORITMOS");
			System.out.println("-------------------------------");
			System.out.println("1 - Fila");
			System.out.println("2 - Pilha");
			System.out.println("3 - Lista Circular");
			System.out.println("4 - Arvore");
			System.out.println("5 - Grafo");
			System.out.println("6 - Sair");
			System.out.print("\nEscolha uma opcão: ");
			try {
                
				op = scan.nextInt();
				scan.nextLine();
				switch(op){
					case 1:  FilaApp.execute(); break;
					case 2:  PilhaApp.execute();break;
					case 3:  ListaCircularApp.execute();break;
					case 4:  ArvoreApp.execute();break;
					case 5:  GrafoApp.execute();break;
					case 6: System.exit(0);
					default: System.out.println("Opcao Invalida");
				}	
			} catch(InputMismatchException e){
				System.out.println("\n Valor Invalido Digitado!!");
			}catch(Exception e){
				System.out.println("Algum Erro :"+ e);
                e.printStackTrace();
			}	
		}	

    }
    
}
