import classes.Jogador;
import classes.Jogo;

import java.util.Scanner;

public class Main {
    private static Jogador jogador1;
    private static Jogador jogador2;
    private static Jogo jogo;

    public static void main(String[] args) {
        jogador1 = new Jogador("Computador");
        jogador2 = new Jogador(args[0]);
        jogo = new Jogo(jogador1, jogador2);
        System.out.println("Jogo básico de tênis\nPressione enter para lançar a bola");
        Scanner teclado = new Scanner(System.in);
        jogo.sorteiaQuemComeca();
        System.out.println(jogo.getJogadorSorteado().getNome() + " ganhou a bola.\n");
        while (true) {
            if (jogo.getJogadorSorteado() == jogador1) {
                jogo.turno();
                jogo.sorteiaProximoJogador();
                System.out.println(jogo.getJogadorSorteado().getNome()+" ganhou a bola.");
                continue;
            }
            else {
                switch (teclado.nextLine()) {
                    case "":
                        jogo.turno();
                        break;
                    case "s":
                        System.out.println("Pontuações atuais:\n" + jogador1.getNome() + ": " + jogador1.getPontos() + ";\n" + jogador2.getNome() + ": " + jogador2.getPontos() + ".");
                        System.out.println(jogo.getJogadorSorteado().getNome() + " vai lançar a bola.\n");
                        continue;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                    case "q":
                        sair();
                        break;
                }
                jogo.sorteiaProximoJogador();
                System.out.println(jogo.getJogadorSorteado().getNome() + " ganhou a bola.");
            }
            if (jogador1.getPontos() == 40 || jogador2.getPontos() == 40) {
                break;
            }
        }
        jogaUltimoTurno();
        sair();
    }

    private static void jogaUltimoTurno() {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            if (jogo.getJogadorSorteado() == jogador1) {
                jogo.turno();
                jogo.sorteiaProximoJogador();
                System.out.println(jogo.getJogadorSorteado().getNome()+" ganhou a bola.");
                break;
            }
            switch (teclado.nextLine()) {
                case "":
                    jogo.turno();
                    break;
                case "s":
                    System.out.println("Pontuações atuais:\n" + jogador1.getNome() + ": " + jogador1.getPontos() + ";\n" + jogador2.getNome() + ": " + jogador2.getPontos() + ".");
                    System.out.println(jogo.getJogadorSorteado().getNome() + " vai lançar a bola.\n");
                    continue;
                default:
                    System.out.println("Opção inválida.");
                    continue;
                case "q":
                    sair();
                    break;
            }
            break;
        }
        if (jogador1.getPontos() == 40 && jogador2.getPontos() == 40) {
            jogo.transformarEsteTurnoEmDesempate();
            turnoDesempate();
        }
        jogo.definirGanhador();
        System.out.println(jogo.getJogadorGanhador().getNome() + " Ganhou este game!\nParabéns!");
    }

    private static void turnoDesempate() {
        System.out.println("Vamos desempatar esta partida.");
        System.out.println(jogo.getJogadorSorteado().getNome() + " Está em vantagem!");
        Scanner teclado = new Scanner(System.in);
        while (true) {
            if (jogo.getJogadorSorteado() == jogador1) {
                jogo.turno();
                jogo.sorteiaProximoJogador();
                System.out.println(jogo.getJogadorSorteado().getNome()+" Está em vantagem!");
                continue;
            }
else {
                switch (teclado.nextLine()) {
                    case "":
                        jogo.turno();
                        break;
                    case "s":
                        System.out.println("Pontuações atuais:\n" + jogador1.getNome() + ": " + jogador1.getPontos() + ";\n" + jogador2.getNome() + ": " + jogador2.getPontos() + ".");
                        System.out.println(jogo.getJogadorSorteado().getNome() + " está em vantagem!");
                        continue;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                    case "q":
                        sair();
                        break;
                }
            }
            if (jogo.getJogadorSorteado().getPontosParaEmpate() > 0) {
                break;
            }
            jogo.sorteiaProximoJogador();
            System.out.println(jogo.getJogadorSorteado().getNome()+" está em vantagem!");
        }
    }

    private static void sair() {
        System.out.println("Saindo...");
        System.exit(0);
    }
}
