package arvore.entities;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Josh Newman
 */
public class Arvore {
    private Diretorio raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void criarDiretorio(String nomeDiretorio) {
        Diretorio novoDiretorio = new Diretorio(nomeDiretorio);
        if (raiz == null) {
            raiz = novoDiretorio;
            System.out.println("Diretório raiz criado: " + nomeDiretorio);
        } else {
            inserirDiretorio(raiz, novoDiretorio);
        }
    }

    private void inserirDiretorio(Diretorio raizAtual, Diretorio novoDiretorio) {
        Queue<Diretorio> fila = new LinkedList<>();
        fila.add(raizAtual);

        while (!fila.isEmpty()) {
            Diretorio diretorio = fila.poll();

            if (diretorio.esquerda == null) {
                diretorio.esquerda = novoDiretorio;
                System.out.println("Diretório criado: " + novoDiretorio.nome);
                return;
            } else if (diretorio.direita == null) {
                diretorio.direita = novoDiretorio;
                System.out.println("Diretório criado: " + novoDiretorio.nome);
                return;
            }

            fila.add(diretorio.esquerda);
            fila.add(diretorio.direita);
        }
    }

    public void excluirDiretorio(String nomeDiretorio) {
        if (raiz == null) {
            System.out.println("A árvore de diretórios está vazia.");
            return;
        }

        if (raiz.nome.equals(nomeDiretorio)) {
            if (raiz.esquerda == null && raiz.direita == null) {
                raiz = null;
                System.out.println("Diretório excluído: " + nomeDiretorio);
            } else {
                System.out.println("O diretório raiz possui subdiretórios e não pode ser excluído.");
            }
            return;
        }

        Queue<Diretorio> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Diretorio diretorio = fila.poll();

            if (diretorio.esquerda != null) {
                if (diretorio.esquerda.nome.equals(nomeDiretorio)) {
                    if (diretorio.esquerda.esquerda == null && diretorio.esquerda.direita == null) {
                        diretorio.esquerda = null;
                        System.out.println("Diretório excluído: " + nomeDiretorio);
                    } else {
                        System.out.println("O diretório possui subdiretórios e não pode ser excluído.");
                    }
                    return;
                }
                fila.add(diretorio.esquerda);
            }

            if (diretorio.direita != null) {
                if (diretorio.direita.nome.equals(nomeDiretorio)) {
                    if (diretorio.direita.esquerda == null && diretorio.direita.direita == null) {
                        diretorio.direita = null;
                        System.out.println("Diretório excluído: " + nomeDiretorio);
                    } else {
                        System.out.println("O diretório possui subdiretórios e não pode ser excluído.");
                    }
                    return;
                }
                fila.add(diretorio.direita);
            }
        }

        System.out.println("Diretório não encontrado: " + nomeDiretorio);
    }

    public void criarDiretorioFilho(String nomeDiretorioPai, String nomeDiretorioFilho) {
        Diretorio pai = encontrarDiretorio(raiz, nomeDiretorioPai);
        if (pai != null) {
            inserirDiretorio(pai, new Diretorio(nomeDiretorioFilho));
        } else {
            System.out.println("Diretório pai não encontrado: " + nomeDiretorioPai);
        }
    }

    private Diretorio encontrarDiretorio(Diretorio raizAtual, String nomeDiretorio) {
        if (raizAtual == null) {
            return null;
        }

        if (raizAtual.nome.equals(nomeDiretorio)) {
            return raizAtual;
        }

        Diretorio esquerda = encontrarDiretorio(raizAtual.esquerda, nomeDiretorio);
        if (esquerda != null) {
            return esquerda;
        }

        Diretorio direita = encontrarDiretorio(raizAtual.direita, nomeDiretorio);
        if (direita != null) {
            return direita;
        }

        return null;
    }

    public void pesquisaLargura() {
        if (raiz == null) {
            System.out.println("A árvore de diretórios está vazia.");
            return;
        }

        Queue<Diretorio> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Diretorio diretorio = fila.poll();
            System.out.println(diretorio.nome);

            if (diretorio.esquerda != null) {
                fila.add(diretorio.esquerda);
            }

            if (diretorio.direita != null) {
                fila.add(diretorio.direita);
            }
        }
    }

    public void pesquisaLarguraDiretorio(String nomeDiretorio) {
    Diretorio diretorio = encontrarDiretorio(raiz, nomeDiretorio);

    if (diretorio == null) {
        System.out.println("Diretório não encontrado: " + nomeDiretorio);
        return;
    }

    Queue<Diretorio> fila = new LinkedList<>();
    Queue<String> caminho = new LinkedList<>();
    fila.add(raiz);
    caminho.add(raiz.nome);

    while (!fila.isEmpty()) {
        Diretorio dir = fila.poll();
        String path = caminho.poll();

        if (dir.nome.equals(nomeDiretorio)) {
            System.out.println("Caminho do diretório " + nomeDiretorio + ": " + path);
            return;
        }

        if (dir.esquerda != null) {
            fila.add(dir.esquerda);
            caminho.add(path + "," + dir.esquerda.nome);
        }

        if (dir.direita != null) {
            fila.add(dir.direita);
            caminho.add(path + "," + dir.direita.nome);
        }
    }
}
    
}
