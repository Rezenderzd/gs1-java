package br.com.fiap.dadosMissao;

import br.com.fiap.componentes.ComponenteEspacial;
import br.com.fiap.propulsao.SistemaPropulsao;

import java.util.List;
import java.util.Random;

public class DadosMissao {
    private String nome;
    private String codigoDeReconhecimento;
    private String componenteEspacialDestino;
    private int tempoEmDias;
    private List<ComponenteEspacial> listaAtualComponentes;
    private int numeroDeTripulantes;
    private SistemaPropulsao propulsaoUsada;
    private double combustivelRestante;

    public DadosMissao(String nome, String componenteEspacialDestino, int tempoEmDias, int numeroDeTripulantes, SistemaPropulsao propulsaoUsada) {
        this.nome = nome;
        this.componenteEspacialDestino = componenteEspacialDestino;
        this.tempoEmDias = tempoEmDias;
        this.numeroDeTripulantes = numeroDeTripulantes;
        this.propulsaoUsada = propulsaoUsada;
        this.codigoDeReconhecimento = String.format("%04d", new Random().nextInt(1, 9999));
        System.out.printf("Missao criada, o código é: %s\n", this.codigoDeReconhecimento);
        propulsaoUsada.ligarMotores();
        System.out.println("A nave chegou ao destino.");
        propulsaoUsada.desligarMotores();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoDeReconhecimento() {
        return codigoDeReconhecimento;
    }

    public int getTempoEmDias() {
        return tempoEmDias;
    }

    public String getComponenteEspacialDestino() {
        return componenteEspacialDestino;
    }

    public int getNumeroDeTripulantes() {
        return numeroDeTripulantes;
    }

    public SistemaPropulsao getPropulsaoUsada() {
        return propulsaoUsada;
    }

    public double getCombustivelRestante() {
        return combustivelRestante;
    }

    public void definirCombustivelRestante(double combustivelRestante){
        this.combustivelRestante = combustivelRestante;
    }

    public void exibirDadosMissao(){
        System.out.printf("""
                Nome: %s
                Componente Espacial de destino: %s
                Tempo em dias: %d
                Quantidade de tripulantes: %d
                Combustivel restante: %.2f%%
                Propulsão usada: %s
                """, this.getNome(), this.getComponenteEspacialDestino(),  this.getTempoEmDias(),this.getNumeroDeTripulantes(),this.getCombustivelRestante(), this.getPropulsaoUsada().nomePropulsao());
    }


}
