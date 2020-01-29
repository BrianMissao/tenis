package classes;

import java.util.Random;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorSorteado;
    private boolean empate;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public void turno() {
        this.jogadorSorteado.lancarBola();
    }

    public void sorteiaParaTurno() {
        this.jogadorSorteado = new Random().nextInt(3) == 1 ? jogador1 : jogador2;
    }

    public Jogador getJogadorSorteado() {
        return jogadorSorteado;
    }
}