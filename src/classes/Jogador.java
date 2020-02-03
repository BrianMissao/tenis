package classes;

import java.util.Random;

public class Jogador {
    private String nome;
    private int pontos;
    private int pontosParaEmpate;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void lancarBola() {
        Random lancar = new Random();
        int lancamento = lancar.nextInt(9);
        if (lancamento > 4 && lancamento < 8) {
            pontuar();
        } else {
            System.out.println(this.getNome() + " não marcou pontos.\nTente novamente.");
        }
    }

    private void pontuar() {
        this.pontos += this.pontos < 30 ? 15 : 10;
        if (this.pontos >= 40) {
            this.pontos = 40;
        }
        System.out.println("Jogador " + this.getNome() + " marcou pontos.\nPontuação atual: " + this.getPontos());
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void lanceDeEmpate() {
        Random area = new Random();
        int tentativa = area.nextInt(9);
        if (tentativa > 4 && tentativa < 9) {
            pontuaParaEmpate();
        } else {
            System.out.println("Não foi desta vez.");
        }
    }

    public int getPontosParaEmpate() {
        return pontosParaEmpate;
    }

    private void pontuaParaEmpate() {
        pontosParaEmpate++;
    }
}