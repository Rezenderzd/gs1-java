package br.com.fiap.propulsao;

abstract public class SistemaPropulsao {
    private double empuxoMaximo;

    public double getEmpuxoMaximo() {
        return empuxoMaximo;
    }

    public SistemaPropulsao(double empuxoMaximo) {
        this.empuxoMaximo = empuxoMaximo;
    }

    public abstract double ligarMotores();
    public abstract double acelerar();
    public abstract void desligarMotores();
    public abstract void calcularEmpuxo(double potencia);
    public abstract String nomePropulsao();
}
