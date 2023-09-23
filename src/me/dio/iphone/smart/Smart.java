package me.dio.iphone.smart;

import java.util.Scanner;

public class Smart {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Acessando funcionalidades");
                System.out.println("2. Navegador Internet");
                System.out.println("3. Sair");

                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("======= Funcionalidades do aplicativo =======");
                        phone.menu();
                        phone.pausar();
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Navegador Internet");

                        System.out.println("Digite a URL da página: ");
                        String url = sc.next();
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1. Exibir Página");
                        System.out.println("2. Adicionar Nova Aba");
                        System.out.println("3. Atualizar Página");
                        int navegar = sc.nextInt();

                        switch (navegar) {
                            case 1:
                                phone.exibirPagina(url);
                                break;
                            case 2:
                                phone.adicionarNovaAba(url);
                                break;
                            case 3:
                                phone.atualizarPagina();
                                break;
                            default:
                                System.out.println("Opção inválida! Por favor, tente novamente");
                        }
                        break;
                    case 3:
                        System.out.println("Fechando todos os aplicativos.");
                        return;
                    default:
                        System.out.println("Por favor, escolha uma opção válida.");
                }
            }
        } finally {
            sc.close();
        }
    }
}
