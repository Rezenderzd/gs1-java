package br.com.fiap.propulsao;

abstract public class SistemaPropulsao {
    private double empuxoMaximo;

    public double getEmpuxoMaximo() {
        return empuxoMaximo;
    }

    public SistemaPropulsao(double empuxoMaximo) {
        this.empuxoMaximo = empuxoMaximo;
    }

    public abstract void ligarMotores();
    public abstract void desligarMotores();
    public abstract void calcularEmpuxo();
    public abstract String nomePropulsao();
}
