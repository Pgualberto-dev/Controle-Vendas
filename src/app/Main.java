package app;

import entities.Product;
import entities.Storage;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage();
        int opcao = 0;
        boolean continuar = false;
        while (opcao != 4) {

            System.out.println("____________________");
            System.out.println("      BEM VINDO     ");
            System.out.println("____________________");
            System.out.println("Cadastro de Produtos - [1]");
            System.out.println("   Listar Estoque - [2] ");
            System.out.println("      Venda - [3] ");
            System.out.println("     Finalizar - [4] ");
            opcao = sc.nextInt();
            sc.nextLine();

            continuar = switch (opcao) {
                case 1 -> {
                    storage.cadastrarProdutos(sc);
                    yield false;
                }
                case 2 -> {
                    System.out.println("--- RELATÓRIO DE ESTOQUE ---");
                    if (storage.getProducts().isEmpty()) {
                        System.out.println("O estoque está vazio!");
                    } else {
                        for (Product p : storage.getProducts()) {
                            System.out.println(p);
                        }
                    }
                    yield false;
                }
                case 3 -> {
                    storage.vendasProdutos(sc);
                    yield false;
                }

                default -> true;
            };
        }
    }
}