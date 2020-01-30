import classes.Jogador;
    import classes.Jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Computador");
        Jogador jogador2 = new Jogador(args[0]);
        Jogo jogo = new Jogo(jogador1, jogador2);
        System.out.println("Jogo básico de tênis\nPressione enter para lançar a bola");
        Scanner teclado = new Scanner(System.in);
        jogo.sorteiaParaTurno();
        System.out.println(jogo.getJogadorSorteado().getNome() + " ganhou a bola.\n");
        while (teclado.hasNextLine()) {
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
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
            }
            jogo.sorteiaParaTurno();
            System.out.println(jogo.getJogadorSorteado().getNome() + " ganhou a bola.");
        }
    }
}
