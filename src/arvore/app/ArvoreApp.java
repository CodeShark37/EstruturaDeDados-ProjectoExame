package arvore.app;


import arvore.entities.Arvore;
import java.util.Scanner;


public class ArvoreApp {
     public static void execute() {
        Arvore arvore = new Arvore();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----------------------------------");
			System.out.println("    GERENCIADOR DE DIRECTORIOS");
			System.out.println("-----------------------------------");
            System.out.println("1. Criar diretório");
            System.out.println("2. Excluir diretório");
            System.out.println("3. Criar diretório filho");
            System.out.println("4. Pesquisar largura da árvore");
            System.out.println("5. Pesquisar largura de um diretório");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do diretório: ");
                    String nomeDiretorio = scanner.next();
                    arvore.criarDiretorio(nomeDiretorio);
                    break;
                case 2:
                    System.out.print("Digite o nome do diretório a ser excluído: ");
                    String dirExcluir = scanner.next();
                    arvore.excluirDiretorio(dirExcluir);
                    break;
                case 3:
                    System.out.print("Digite o nome do diretório pai: ");
                    String dirPai = scanner.next();
                    System.out.print("Digite o nome do diretório filho: ");
                    String dirFilho = scanner.next();
                    arvore.criarDiretorioFilho(dirPai, dirFilho);
                    break;
                case 4:
                    arvore.pesquisaLargura();
                    break;
                case 5:
                    System.out.print("Digite o nome do diretório: ");
                    String dirPesquisa = scanner.next();
                    arvore.pesquisaLarguraDiretorio(dirPesquisa);
                    break;
                case 0:
                    System.out.println("Encerrando o Programa!! ");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        System.exit(0);
    }
}
