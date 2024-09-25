package br.com.biblioteca;

public class Ordenacao {

    public static void bubbleSort(Livro[] array, int count, boolean byTitle) {
        boolean swapped;
        for (int i = 0; i < count - 1; i++) {
            swapped = false;
            for (int j = 0; j < count - i - 1; j++) {
                Livro l1 = array[j];
                Livro l2 = array[j + 1];
                boolean shouldSwap = byTitle 
                    ? l1.getTitulo().compareToIgnoreCase(l2.getTitulo()) > 0
                    : l1.getAutor().compareToIgnoreCase(l2.getAutor()) > 0;
                
                if (shouldSwap) {
                    Livro temp = l1;
                    array[j] = l2;
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void buscaPorTitulo(Livro[] array, int count, String titulo) {
        boolean encontrado = false;
        System.out.println("Buscando por título contendo: " + titulo);
        for (int i = 0; i < count; i++) {
            if (array[i].getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                if (!encontrado) {
                    System.out.println("Livros encontrados:");
                    encontrado = true;
                }
                System.out.println(array[i]);
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o título contendo: " + titulo);
        }
    }

    public static void buscaPorAutor(Livro[] array, int count, String autor) {
        boolean encontrado = false;
        System.out.println("Buscando por autor contendo: " + autor);
        for (int i = 0; i < count; i++) {
            if (array[i].getAutor().toLowerCase().contains(autor.toLowerCase())) {
                if (!encontrado) {
                    System.out.println("Livros encontrados:");
                    encontrado = true;
                }
                System.out.println(array[i]);
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o autor contendo: " + autor);
        }
    }
    
    public static void buscaPorId(Livro[] array, int count, int id) {
        boolean encontrado = false;
        System.out.println("Buscando por ID: " + id);
        for (int i = 0; i < count; i++) {
            if (array[i].getId() == id) {
                System.out.println("Livro encontrado:");
                System.out.println(array[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o ID: " + id);
        }
    }
}
