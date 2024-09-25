package br.com.biblioteca;

class No {
    Livro livro;
    No esquerda, direita;

    No(Livro livro) {
        this.livro = livro;
        esquerda = direita = null;
    }
}

public class Arvore {
    private No raiz;

    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    private No inserirRecursivo(No raiz, Livro livro) {
        if (raiz == null) {
            return new No(livro);
        }
        if (livro.getTitulo().compareToIgnoreCase(raiz.livro.getTitulo()) < 0) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, livro);
        } else {
            raiz.direita = inserirRecursivo(raiz.direita, livro);
        }
        return raiz;
    }

    public void buscarPorTitulo(String titulo) {
        System.out.println("Buscando livros com título: " + titulo);
        buscarTituloRecursivo(raiz, titulo);
    }

    private void buscarTituloRecursivo(No raiz, String titulo) {
        if (raiz != null) {
            buscarTituloRecursivo(raiz.esquerda, titulo);
            if (raiz.livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println(raiz.livro);
            }
            buscarTituloRecursivo(raiz.direita, titulo);
        }
    }

    public void buscarPorAno(int ano) {
        System.out.println("Buscando livros do ano: " + ano);
        buscarAnoRecursivo(raiz, ano);
    }

    private void buscarAnoRecursivo(No raiz, int ano) {
        if (raiz != null) {
            buscarAnoRecursivo(raiz.esquerda, ano);
            if (raiz.livro.getAno() == ano) {
                System.out.println(raiz.livro);
            }
            buscarAnoRecursivo(raiz.direita, ano);
        }
    }

    public void buscarPorAutor(String autor) {
        System.out.println("Buscando livros do autor: " + autor);
        buscarAutorRecursivo(raiz, autor);
    }

    private void buscarAutorRecursivo(No raiz, String autor) {
        if (raiz != null) {
            buscarAutorRecursivo(raiz.esquerda, autor);
            if (raiz.livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(raiz.livro);
            }
            buscarAutorRecursivo(raiz.direita, autor);
        }
    }
}
