package br.com.fiap.propulsao;

import java.util.Random;
import java.util.Scanner;

public class PropulsaoEletrica extends SistemaPropulsao{
    private double potenciaConsumidaEmPorcentagem;
    private double potenciaTotalEmPorcentagem;
    private double potenciaAtualPorcentagem = 100;
    private double potenciaAtual;
    Scanner leitor = new Scanner(System.in);

    public PropulsaoEletrica(int empuxoTotal) {
        super(empuxoTotal);
        this.potenciaTotalEmPorcentagem = 100;
    }

    public double getPotenciaAtualPorcentagem() {
        return potenciaAtualPorcentagem;
    }

    public double getPotenciaTotalEmPorcentagem() {
        return potenciaTotalEmPorcentagem;
    }

    public double getPotenciaConsumidaEmPorcentagem() {
        return potenciaConsumidaEmPorcentagem;
    }

    private void setPotenciaConsumidaEmPorcentagem(double potenciaConsumidaEmPorcentagem) {
        this.potenciaConsumidaEmPorcentagem = potenciaConsumidaEmPorcentagem;
    }

    public void setPotenciaAtualPorcentagem(double potenciaAtualPorcentagem) {
        this.potenciaAtualPorcentagem = potenciaAtualPorcentagem;
    }

    @Override
    public double ligarMotores() {
        System.out.println("Motores ligados!");
        System.out.printf("Potencia total atual: %.2f%%\n", getPotenciaAtualPorcentagem());
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
        System.out.println("Motores desligados!");
        setPotenciaConsumidaEmPorcentagem(this.potenciaAtual);
        System.out.printf("Total gasto: %.2f\n", this.getPotenciaConsumidaEmPorcentagem());
        setPotenciaAtualPorcentagem(this.getPotenciaTotalEmPorcentagem()- this.getPotenciaConsumidaEmPorcentagem());
        System.out.printf("Total restante de energia: %.2f\n", getPotenciaAtualPorcentagem());
        if(getPotenciaAtualPorcentagem()<=50){
            System.out.println("Status de combustível: Atenção\n");
            return;
        }if (getPotenciaAtualPorcentagem()<=35){
            System.out.println("Status de combustível: Alerta\n");
            return;
        }
        if(getPotenciaAtualPorcentagem()<=20){
            System.out.println("Status de combustível: Crítico!\n");
            recarregar();
        }
    }

    @Override
    public void calcularEmpuxo(double potencia) {
        double empuxoGerado = getEmpuxoMaximo() * (potencia / 100.0);
        System.out.printf("O empuxo foi de %.2f\n", empuxoGerado);
    }

    @Override
    public String nomePropulsao() {
        return "elétrica";
    }

    public void recarregar(){
        setPotenciaAtualPorcentagem(100);
        System.out.println("Nave recarregada");
    }
}
