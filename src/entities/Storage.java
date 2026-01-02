package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {return products;}



    public void vendasProdutos(Scanner sc) {
        List<Product> produtosVendidos = new ArrayList<>();
        boolean venda = true;
        Product produtoEncontrado = null;
        double totalVenda = 0.0;
        while (venda) {
            for(Product p : products) {
                System.out.println(p);
            }
            System.out.println("ID do produto: ");
            int id = sc.nextInt();
            System.out.println("Quantidade de produtos: ");
            int quantidade = sc.nextInt();

            for(int i = 0; i < products.size(); i++) {

                if(id == products.get(i).getId()) {
                    produtoEncontrado = products.get(i);

                    if(quantidade > products.get(i).getQtd()) {
                        System.out.println("Quantidade de estoque insuficiente " + produtoEncontrado);
                    } else {
                        int newqtd = products.get(i).getQtd() -  quantidade;
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

    public void cadastrarProdutos(Scanner sc) {
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
            products.add(new Product(id, name, price, qtd));
        }
        System.out.println("Produto Cadastrado!");
        for (Product p : products){
            System.out.println(p);
        }
    }
}


