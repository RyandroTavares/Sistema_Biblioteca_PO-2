package br.com.biblioteca;

public class Biblioteca {
    private Livro[] acervo;
    private int count;
    private Arvore arvore;
    private Grafo grafo;

    public Biblioteca() {
        acervo = new Livro[100];
        count = 0;
        arvore = new Arvore();
        grafo = new Grafo(100);
    }

    public void adicionarLivro(Livro livro) {
        if (count < acervo.length) {
            acervo[count++] = livro;
            arvore.inserir(livro);
            grafo.adicionarRelacao(livro.getId() - 1, livro.getAutor());
        } else {
            System.out.println("Acervo cheio! Não é possível adicionar mais livros.");
        }
    }

    public void listarLivros() {
        if (count == 0) {
            System.out.println("Nenhum livro disponível.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(acervo[i]);
            }
        }
    }

    public void removerLivroPorId(int id) {
        int i;
        for (i = 0; i < count; i++) {
            if (acervo[i].getId() == id) {
                break;
            }
        }

        if (i < count) {
            for (int j = i; j < count - 1; j++) {
                acervo[j] = acervo[j + 1];
            }
            acervo[--count] = null;
            System.out.println("Livro com ID " + id + " removido.");
        } else {
            System.out.println("Livro com ID " + id + " não encontrado.");
        }
    }

    public Livro[] getAcervo() {
        return acervo;
    }

    public int getCount() {
        return count;
    }

    public void mostrarRelacoes(int id) {
        if (id > 0 && id <= count) {
            grafo.mostrarRelacoes(id - 1);
        } else {
            System.out.println("ID inválido.");
        }
    }
}
