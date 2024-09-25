package br.com.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar Livros");
            System.out.println("4. Buscar Livro");
            System.out.println("5. Remover Livro por ID");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    int ano = 0;
                    boolean anoValido = false;

                    while (!anoValido) {
                        System.out.print("Ano de Publicação: ");
                        try {
                            ano = scanner.nextInt();
                            scanner.nextLine();
                            if (ano > 0) {
                                anoValido = true;
                            } else {
                                System.out.println("Ano de publicação deve ser um número positivo. Tente novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    biblioteca.adicionarLivro(new Livro(titulo, autor, ano));
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.println("1. Ordenar por Título");
                    System.out.println("2. Ordenar por Autor");
                    System.out.print("Escolha uma opção de ordenação: ");
                    
                    int ordenacaoOpcao = 0;
                    boolean ordenacaoOpcaoValida = false;

                    while (!ordenacaoOpcaoValida) {
                        try {
                            ordenacaoOpcao = scanner.nextInt();
                            scanner.nextLine();
                            if (ordenacaoOpcao == 1 || ordenacaoOpcao == 2) {
                                ordenacaoOpcaoValida = true;
                            } else {
                                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    if (ordenacaoOpcao == 1) {
                        Ordenacao.bubbleSort(biblioteca.getAcervo(), biblioteca.getCount(), true);
                        System.out.println("Livros ordenados por título.");
                    } else if (ordenacaoOpcao == 2) {
                        Ordenacao.bubbleSort(biblioteca.getAcervo(), biblioteca.getCount(), false);
                        System.out.println("Livros ordenados por autor.");
                    }
                    break;

                case 4:
                    System.out.println("1. Buscar por Título");
                    System.out.println("2. Buscar por Autor");
                    System.out.println("3. Buscar por ID");
                    System.out.print("Escolha uma opção de busca: ");
                    
                    int buscaOpcao = 0;
                    boolean buscaOpcaoValida = false;

                    while (!buscaOpcaoValida) {
                        try {
                            buscaOpcao = scanner.nextInt();
                            scanner.nextLine();
                            if (buscaOpcao >= 1 && buscaOpcao <= 4) {
                                buscaOpcaoValida = true;
                            } else {
                                System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    switch (buscaOpcao) {
                        case 1:
                            System.out.print("Digite o título do livro: ");
                            String tituloBusca = scanner.nextLine();
                            Ordenacao.buscaPorTitulo(biblioteca.getAcervo(), biblioteca.getCount(), tituloBusca);
                            break;
                        case 2:
                            System.out.print("Digite o autor do livro: ");
                            String autorBusca = scanner.nextLine();
                            Ordenacao.buscaPorAutor(biblioteca.getAcervo(), biblioteca.getCount(), autorBusca);
                            break;
                        case 3:
                            System.out.print("Digite o ID do livro: ");
                            int idBusca = scanner.nextInt();
                            scanner.nextLine();
                            Ordenacao.buscaPorId(biblioteca.getAcervo(), biblioteca.getCount(), idBusca);
                            break;
                        default:
                            System.out.println("Opção de busca inválida.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o ID do livro a ser removido: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.removerLivroPorId(id);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
