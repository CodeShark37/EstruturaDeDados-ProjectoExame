package grafo.app;

import grafo.entities.Grafo;
import grafo.entities.Usuario;
import grafo.entities.Vertice;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GrafoApp {
    public static void execute() throws Exception {
       Grafo<Usuario> grafo= new Grafo<>();
       int proximoId = 1;
       int opcao=0;
       Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        do{
            System.out.println("-------- Menu --------");
            System.out.println("1. Adicionar Usuario");
            System.out.println("2. Adicionar amizade");
            System.out.println("3. Buscar amigos de um Usuario");
            System.out.println("4. Buscar amigos em comum");
            System.out.println("5. Listar todos os Usuarios");
            System.out.println("6. Eliminar todos os Usuarios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do Usuario: ");
                        String nome = scanner.nextLine();
                        adicionarUsuario(proximoId,nome,grafo);
                        proximoId++;
                        break;
                    case 2:
                        listarUsuarios(grafo);
                        System.out.print("Digite o ID do primeiro Usuario: ");
                        int idUsuario1 = scanner.nextInt();
                        System.out.print("Digite o ID do segundo Usuario: ");
                        int idUsuario2 = scanner.nextInt();
                        adicionarAmizade(idUsuario1, idUsuario2,grafo);
                        break;
                    case 3:
                        System.out.print("Digite o ID do Usuario: ");
                        int idAmigos = scanner.nextInt();
                        buscarAmigos(idAmigos,grafo);
                        break;
                    case 4:
                        listarUsuarios(grafo);
                        System.out.print("Digite o ID do primeiro Usuario: ");
                        int idUsuarioA = scanner.nextInt();
                        System.out.print("Digite o ID do segundo Usuario: ");
                        int idUsuarioB = scanner.nextInt();
                        buscarAmigosEmComum(idUsuarioA, idUsuarioB,grafo);
                        break;
                    case 5:
                        listarUsuarios(grafo);
                        break;
                    case 6:
                        eliminarTodosUsuarios(grafo);
                        proximoId = 1;
                        break;
                    case 0:
                        executando = false;
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número inteiro correspondente à opção desejada.");
                scanner.nextLine(); // Limpar o buffer
            }
        }while (executando);
    }


    public static void adicionarUsuario(int proximoId,String nome,Grafo<Usuario> grafo) {
        Usuario usuario = new Usuario(proximoId, nome);
        grafo.adicionarVertice(proximoId, usuario);
        System.out.println("Usuario adicionado com sucesso.");
    }

    public static void adicionarAmizade(int idUsuario1, int idUsuario2,Grafo<Usuario> grafo) {
        if (idUsuario1 == idUsuario2) {
            System.out.println("Os IDs dos Usuarios devem ser diferentes.");
            return;
        }

        Usuario usuario1 = encontrarUsuario(idUsuario1,grafo);
        Usuario usuario2 = encontrarUsuario(idUsuario2,grafo);

        if (usuario1 == null || usuario2 == null) {
            System.out.println("Usuario(s) não encontrado(s).");
            return;
        }

        grafo.adicionarAresta(1.0, idUsuario1, idUsuario2);
        grafo.adicionarAresta(1.0, idUsuario2, idUsuario1);
        System.out.println("Amizade adicionada com sucesso.");
    }

    public static void buscarAmigos(int idUsuario,Grafo<Usuario> grafo) {
        grafo.listarAmigos(idUsuario);
    }

    public static void buscarAmigosEmComum(int idUsuario1, int idUsuario2,Grafo<Usuario> grafo) {
        grafo.listarAmigosEmComum(idUsuario1, idUsuario2);
    }

    public static void listarUsuarios(Grafo<Usuario> grafo) {
        for (Vertice<Usuario> vertice : grafo.getVertices()) {
            System.out.println(vertice.getId() + ": " + vertice.getDado().getNome());
        }
        System.out.println("Quantidade total de Usuarios: " + grafo.getVertices().size());
    }

    public static void eliminarTodosUsuarios(Grafo<Usuario> grafo) {
        grafo.eliminarTodosVertices();
        
        System.out.println("Todos os Usuarios foram eliminados.");
    }

    private static Usuario encontrarUsuario(int idUsuario,Grafo<Usuario> grafo) {
        for (Vertice<Usuario> vertice : grafo.getVertices()) {
            if (vertice.getId() == idUsuario) {
                return vertice.getDado();
            }
        }
        return null;
    }

   
}
