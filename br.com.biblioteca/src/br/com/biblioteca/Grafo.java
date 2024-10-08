package br.com.biblioteca;

class Vertice {
    String autor;
    Vertice proximo;

    Vertice(String autor) {
        this.autor = autor;
        this.proximo = null;
    }
}

public class Grafo {
    private Vertice[] listaAdj;

    public Grafo(int tamanho) {
        listaAdj = new Vertice[tamanho];
    }

    public void adicionarRelacao(int index, String autor) {
        Vertice novoVertice = new Vertice(autor);
        novoVertice.proximo = listaAdj[index];
        listaAdj[index] = novoVertice;
    }

    public void mostrarRelacoes(int index) {
        if (index < 0 || index >= listaAdj.length || listaAdj[index] == null) {
            System.out.println("Nenhum autor relacionado encontrado.");
            return;
        }
        
        System.out.println("\nAutores relacionados:");
        Vertice atual = listaAdj[index];
        while (atual != null) {
            System.out.println("- " + atual.autor);
            atual = atual.proximo;
        }
    }
}
