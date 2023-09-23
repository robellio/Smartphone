package me.dio.iphone.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phone implements Smartphone, ReprodutorMusical, NavegadorInternet {

    private List<String> abasAbertas = new ArrayList<>();
    private boolean reproduzindoMusica = false;
    private String musicaAtual = "";
    private String paginaAtual = "";

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Para Reproduzir.");
            System.out.println("2. Para Pausar.");
            System.out.println("3. Para Selecionar Música.");
            System.out.println("4. Para Exibir Página.");
            System.out.println("5. Para Adicionar Nova Aba.");
            System.out.println("6. Para Atualizar Página.");
            System.out.println("7. Para Ligar.");
            System.out.println("8. Para Atender Chamada.");
            System.out.println("9. Para Iniciar Correio de Voz.");
            System.out.println("10. Para Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    if (!reproduzindoMusica) {
                        System.out.println("Reproduzindo música: " + musicaAtual);
                        reproduzindoMusica = true;
                    } else {
                        System.out.println("Já existe música em reprodução.");
                    }
                    break;
                case 2:
                    pausar();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite o nome da música: ");
                    String nomeMusica = scanner.nextLine();
                    selecionarMusica(nomeMusica);
                    System.out.println("Para Reproduzir Digite 1.");
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Digite a URL da página: ");
                    String urlPagina = scanner.nextLine();
                    exibirPagina(urlPagina);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Digite a URL da nova aba: ");
                    String novaAba = scanner.nextLine();
                    adicionarNovaAba(novaAba);
                    break;
                case 6:
                    atualizarPagina();
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("Digite o número para ligar: ");
                    String numero = scanner.nextLine();
                    ligar(numero);
                    break;
                case 8:
                    atender();
                    break;
                case 9:
                    iniciarCorreioVoz();
                    break;
                case 10:
                    System.out.println("Saindo.");
                    return;
                default:
                    System.out.println("Por favor, escolha uma opção válida.");
            }
        }
    }

    @Override
    public void pausar() {
        if (reproduzindoMusica) {
            System.out.println("Música pausada.");
            reproduzindoMusica = false;
        } else {
            System.out.println("Não há música em reprodução.");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        musicaAtual = musica;
        System.out.println("Selecionando Música: " + musica);
    }

    @Override
    public void exibirPagina(String url) {
        paginaAtual = url;
        System.out.println("Exibindo página da web: " + url);
    }

    @Override
    public void adicionarNovaAba(String url) {
        if (!url.isEmpty()) {
            abasAbertas.add(url);
            System.out.println("Abrindo nova aba: " + url);
        } else {
            System.out.println("URL inválida. A nova aba não pode ser aberta.");
        }
    }

    @Override
    public void atualizarPagina() {
        if (!paginaAtual.isEmpty()) {
            System.out.println("Atualizando página da web: " + paginaAtual);
        } else {
            System.out.println("Nenhuma página da web carregada para atualizar.");
        }
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o número: " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo a chamada.");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz.");
    }
}
