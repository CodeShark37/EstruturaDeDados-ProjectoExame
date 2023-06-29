package pilha.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entities.Management;
import Entities.Medicamento;

public class PilhaApp {

	public static void execute() 
	{
		Scanner scan = new Scanner(System.in);
		Management mng = new Management();
		int op =0,countId=0;
		while(true){
			System.out.println("-------------------");
			System.out.println("Ango Farm Logistic");
			System.out.println("-------------------");
			System.out.println("1 - Armazenar Medicamento");
			System.out.println("2 - Desalojar Medicamentos");
			System.out.println("3 - Listar Medicamentos com caducidade proxima");
			System.out.println("4 - Listar Medicamentos em validade");
			System.out.println("5 - Listar Todos os Medicamentos");
			System.out.println("6 - Sair");
			System.out.print("\nEscolha uma opcão: ");
			try {
				op = scan.nextInt();
				scan.nextLine();
				switch(op){
					case 1:
						System.out.print("\nDigite o nome: ");
						String nome = scan.nextLine();
						System.out.print("\nDigite a referencia: ");
						String ref = scan.nextLine();
						System.out.print("\nDigite a data de Producao(DD/MM/AAAA): ");
						String dataP = scan.nextLine();
						System.out.print("\nDigite a data de Expiracao(DD/MM/AAAA): ");
						String dataE = scan.nextLine();
						mng.armazenar(new Medicamento(++countId,nome, ref, LocalDate.parse(dataP,DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse(dataE,DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
						System.out.println("Medicamento armazenado com sucesso!!");
						break;
					case 2: 
						if(mng.desalojarTodos()){
							countId=0;
							System.out.println("\n Todos os medicamentos foram desalojados com sucesso");
						}else{
							System.out.println("Armazem Vazio!!");
						}
						break;
					case 3: mng.listarCaducados(); break;
					case 4: mng.listarEmValidade(); break;
					case 5: mng.listarTodos(); break;
					case 6: return;
					default: System.out.println("Opcao Invalida");
				}	
			} catch (DateTimeParseException e) {
				System.out.println("Data invalida");
			}catch(InputMismatchException e){
				System.out.println("\n Valor invalido digitado ");
			}catch(Exception e){
				System.out.println("Algum erro :"+ e);
			}	
		}	
	}

}
