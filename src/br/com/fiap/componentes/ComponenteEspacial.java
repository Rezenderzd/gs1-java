package br.com.fiap.componentes;

abstract public class ComponenteEspacial {
    private String nome;
    private int distanciaDaTerra;

    public ComponenteEspacial(String nome, int distanciaDaTerra){
        this.nome = nome;
        this.distanciaDaTerra =  distanciaDaTerra;
    }

    public String getNome() {
        return nome;
    }

    public int getDistanciaDaTerra() {
        return distanciaDaTerra;
    }

    abstract public void exibirInformacoes();

}
