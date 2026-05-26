package br.com.fiap.componentes;

public class Asteroides extends ComponenteEspacial{
    private boolean hasRiscoColisao;
    private double velocidadeEmKm;

    public Asteroides(String nome, int distanciaDaTerra, double velocidade,boolean hasRiscoColisao) {
        super(nome, distanciaDaTerra);
        this.velocidadeEmKm = velocidade;
        this.hasRiscoColisao = hasRiscoColisao;
    }

    public double getVelocidadeEmKm() {
        return velocidadeEmKm;
    }

    public boolean getHasRiscoColisao() {
        return hasRiscoColisao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                Nome: %s
                Distância para a Terra: %d
                Há risco de colisão com a Terra? %b
                """, this.getNome(), this.getDistanciaDaTerra(), this.getHasRiscoColisao());
    }

    public void mudarStatus(){
        this.hasRiscoColisao = !this.hasRiscoColisao;
    }
}
