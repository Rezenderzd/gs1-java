package br.com.fiap.propulsao;

import java.util.Scanner;

public class PropulsaoQuimica extends SistemaPropulsao {
    private double nivelCombustivelEmPorcentagem;
    private double nivelCombustivelGasto;
    private double potenciaAtual;
    Scanner leitor = new Scanner(System.in);

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
    public double ligarMotores() {
        System.out.println("Motores ligados!");
        System.out.printf("Combustivel atual: %.2f%%\n", this.getNivelCombustivelEmPorcentagem());
        this.potenciaAtual = acelerar();
        calcularEmpuxo(this.potenciaAtual);
        return this.potenciaAtual;
    }

    @Override
    public double acelerar(){
        double potencia;
        System.out.println("Digite a potencia desejada");
        do{
            potencia = leitor.nextDouble();
            if(potencia>=100 || potencia<=0){
                System.out.println("Digite uma potência válida (entre 1 e 100)\n");
            }
        }while (potencia>100 || potencia<=0);
        System.out.printf("Acelerando com potencia atual de %.2f%%\n", potencia);
        return potencia;
    }

    @Override
    public void desligarMotores() {
        System.out.println("Motores desligados");
        setNivelCombustivelGasto(this.potenciaAtual);
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
    public void calcularEmpuxo(double potencia) {
        double empuxoGerado = getEmpuxoMaximo() * (potencia / 100.0);
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
