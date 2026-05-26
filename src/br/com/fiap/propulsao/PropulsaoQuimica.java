package br.com.fiap.propulsao;

import java.util.Random;

public class PropulsaoQuimica extends SistemaPropulsao {
    private double nivelCombustivelEmPorcentagem;
    Random random = new Random();
    private double nivelCombustivelGasto;

    public PropulsaoQuimica(int empuxoTotal) {
        super(empuxoTotal);
        this.nivelCombustivelEmPorcentagem = 100;
    }

    public double getNivelCombustivelGasto() {
        return nivelCombustivelGasto;
    }

    public double getNivelCombustivelEmPorcentagem() {
        return nivelCombustivelEmPorcentagem;
    }

    public void setNivelCombustivelEmPorcentagem(double nivelCombustivelEmPorcentagem) {
        this.nivelCombustivelEmPorcentagem = nivelCombustivelEmPorcentagem;
    }

    public void setNivelCombustivelGasto(double nivelCombustivelGasto) {
        this.nivelCombustivelGasto = nivelCombustivelGasto;
    }

    @Override
    public void ligarMotores() {
        System.out.println("Motores acionados.");
        System.out.printf("Combustivel atual: %.2f%%\n", this.getNivelCombustivelEmPorcentagem());
        calcularEmpuxo();
    }

    @Override
    public void desligarMotores() {
        System.out.println("Motores desligados");
        setNivelCombustivelGasto(random.nextDouble(0, getNivelCombustivelEmPorcentagem()-15));
        System.out.printf("Total gasto: %.2f\n", this.getNivelCombustivelGasto());
        setNivelCombustivelEmPorcentagem(this.getNivelCombustivelEmPorcentagem()- this.getNivelCombustivelGasto());
        System.out.printf("Total restante de combustível: %.2f\n", this.getNivelCombustivelEmPorcentagem());
        if(getNivelCombustivelEmPorcentagem()<=50){
            System.out.println("Status de combustível: atenção\n");
            return;
        }if (getNivelCombustivelEmPorcentagem()<=35){
            System.out.println("Status de combustível: alerta\n");
            return;
        }
        if(getNivelCombustivelEmPorcentagem()<=20){
            System.out.println("Status crítico!\n");
            reabester();
        }
    }

    @Override
    public void calcularEmpuxo() {
        double empuxoGerado = getEmpuxoMaximo() * (this.getNivelCombustivelEmPorcentagem() / 100.0);
        System.out.printf("O empuxo foi de %.2f\n", empuxoGerado);
    }

    @Override
    public String nomePropulsao() {
        return "quimica";
    }

    public void reabester(){
        setNivelCombustivelEmPorcentagem(100);
        System.out.println("Nave reabastecida");
    }
}
