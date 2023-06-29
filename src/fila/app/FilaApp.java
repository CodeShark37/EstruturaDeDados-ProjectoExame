package fila.app;

import fila.entities.Documento;
import fila.entities.Impressora;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FilaApp {

    public static void execute() throws Exception {
        Scanner scan = new Scanner(System.in);
        Impressora printer = new Impressora();
        int op = 0, countId = 0, index = 0, pag = 0;
        String titulo, data;

    printer.addDoc(new Documento(1,"Doc1",LocalDate.of(2023, Month.MARCH, 8),6));
    printer.addDoc(new Documento(2,"Doc2",LocalDate.of(2021, Month.AUGUST, 5),6));
    printer.addDoc(new Documento(3,"Doc3",LocalDate.of(2023, Month.AUGUST, 5),6));
    printer.addDoc(new Documento(4,"Doc4",LocalDate.of(2022, Month.FEBRUARY, 8),6));
    printer.addDoc(new Documento(5,"Doc5",LocalDate.of(2020, Month.JANUARY, 5),6));
    printer.addDoc(new Documento(6,"Doc6",LocalDate.of(2023, Month.MARCH, 8),6));
    printer.addDoc(new Documento(7,"Doc7",LocalDate.of(2022, Month.AUGUST, 5),6));
    printer.addDoc(new Documento(8,"Doc8",LocalDate.of(2022, Month.SEPTEMBER, 5),6));
    printer.addDoc(new Documento(9,"Doc9",LocalDate.of(2023, Month.FEBRUARY, 8),6));
    printer.addDoc(new Documento(10,"Doc10",LocalDate.of(2020, Month.JULY, 5),6));
    printer.addDoc(new Documento(11,"Doc11",LocalDate.of(2023, Month.APRIL, 8),6));
    printer.addDoc(new Documento(12,"Doc12",LocalDate.of(2023, Month.JANUARY, 5),6));
    
      
      
        do {

            System.out.println("---------------------------------");
            System.out.println("     IMPRESSAO DE DOCUMENTOS");
            System.out.println("---------------------------------");
            System.out.println("1 - Adicionar Documento");

            if (printer.hasDocs()) {
                System.out.println("2 - Remover Documento na posicao");
                System.out.println("3 - Remover Todos Documentos");
                System.out.println("4 - Listar Documentos");
                System.out.println("5 - Imprimir Documentos");
                System.out.println("6 - Total de Documentos");
            }
            System.out.println("7 - Sair");

            try {
                System.out.print("\nEscolha uma opcão: ");
                op = scan.nextInt();
                scan.nextLine();
                if (op == 1) {
                    System.out.print("\nDigite o Titulo do Documento: ");
                    titulo = scan.nextLine();
                    System.out.print("Digite a Data de Emissao(dd/mm/aaaa): ");
                    data = scan.nextLine();
                    System.out.print("Digite a Quantidade de Paginas: ");
                    pag = scan.nextInt();
                    Documento doc = new Documento(++countId, titulo, LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")), pag);
                    printer.addDoc(doc);
                    System.out.println("\n Documento Adicionado com Sucesso!!");
                } else if (op == 7) {
                    return;
                } else if (printer.hasDocs()) {

                    switch (op) {
                        case 2:
                            printer.listDocs();
                            System.out.print("\nDigite o Indice: ");
                            index = scan.nextInt();
                            printer.deleteDoc(index);
                            System.out.println("\nDocumento Removido com Sucesso!!");
                            break;
                        case 3:
                            printer.deleteAllDocs();
                            System.out.println("\nDocumentos Removidos com Sucesso!!");
                            break;
                        case 4:
                            printer.listDocs();
                            break;
                        case 5:
                            printer.print();
                            break;
                        case 6:
                            System.out.println("\nTotal de Documentos: " + printer.getQtdDocs());
                            break;
                        default:
                            System.out.println("\nOpcao Invalida");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("\n Valor Inválido Digitado ");
            } catch (Exception e) {
                System.out.println("\nAlgum erro :" + e);
            }
        } while (true);
    }
}
