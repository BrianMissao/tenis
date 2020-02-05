package classes;

import java.util.Random;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorSorteado;
    private Jogador jogadorGanhador;
    private boolean empate;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        empate = false;
    }

    public void transformarEsteTurnoEmDesempate() {
        empate = !empate;
    }

    public void turno() {
        if (eEmpate()) {
            jogadorSorteado.lanceDeEmpate();
        }
        else {
            jogadorSorteado.lancarBola();
        }
    }

    public void sorteiaQuemComeca() {
        this.jogadorSorteado = new Random().nextInt(3) == 1 ? jogador1 : jogador2;
    }

    public void definirGanhador() {
        jogadorGanhador = jogador1.getPontos() > jogador2.getPontos() ? jogador1 : jogador2;
    }
    public Jogador getJogadorGanhador() {
        return jogadorGanhador;
    }

    public Jogador getJogadorSorteado() {
        return jogadorSorteado;
    }

    public void sorteiaProximoJogador() {
        jogadorSorteado = jogadorSorteado == jogador1 ? jogador2 : jogador1;
    }

    public boolean eEmpate() {
        return empate;
    }

    public void imprimirPontosDoJogador() {
        System.out.println("Pontuações atuais:\n" + jogador1.getNome() + ": " + jogador1.getPontos() + ";\n" + jogador2.getNome() + ": " + jogador2.getPontos() + ".");
        System.out.println(getJogadorSorteado().getNome() + " está em vantagem!");
    }
}