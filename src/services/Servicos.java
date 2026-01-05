package services;
import entities.Product;
import entities.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servicos {
    public void vendasProdutos(Scanner sc, Storage storage) {
        List<Product> produtosVendidos = new ArrayList<>();
        boolean venda = true;
        Product produtoEncontrado;
        double totalVenda = 0.0;
        while (venda) {
            for(Product p : storage.getProducts()) {
                System.out.println(p);
            }
            System.out.println("ID do produto: ");
            int id = sc.nextInt();
            System.out.println("Quantidade de produtos: ");
            int quantidade = sc.nextInt();

            for(int i = 0; i < storage.getProducts().size(); i++) {

                if(id == storage.getProducts().get(i).getId()) {
                    produtoEncontrado = storage.getProducts().get(i);

                    if(quantidade > storage.getProducts().get(i).getQtd()) {
                        System.out.println("Quantidade de estoque insuficiente " + produtoEncontrado);
                    } else {
                        int newqtd = storage.getProducts().get(i).getQtd() -  quantidade;
                        produtoEncontrado.setQtd(newqtd);
                        produtosVendidos.add(produtoEncontrado);
                        totalVenda += produtoEncontrado.getPrice() * quantidade;
                    }
                    break;
                }
            }

            System.out.println("Finalizar venda: [1] - Sim || [2] - Não");
            int opcao = sc.nextInt();

            if (opcao == 1) {

                System.out.println("       RECIBO       ");

                for(Product p : produtosVendidos) {
                    System.out.println("ITEM: " + p.getName() + " - R$ " + p.getPrice());
                }
                System.out.println("TOTAL A PAGAR: R$ " + totalVenda);
                venda = false;
                System.out.println("|Venda realizada com sucesso|");
            }

        }

    }

    public void cadastrarProdutos(Scanner sc, Storage storage) {
        int quatd;
        System.out.println("Quantos produtos a cadastrar?");
        quatd = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < quatd; i++){
            int id = i + 1;
            System.out.println("Nome do produto: ");
            String name = sc.nextLine();
            System.out.println("Preço do produto: " );
            double price = sc.nextDouble();
            System.out.println("Quantidade do produto: " );
            int qtd = sc.nextInt();
            sc.nextLine();
            storage.getProducts().add(new Product(id, name, price, qtd));
        }
        System.out.println("Produto Cadastrado!");
        for (Product p : storage.getProducts()){
            System.out.println(p);
        }
    }
}
