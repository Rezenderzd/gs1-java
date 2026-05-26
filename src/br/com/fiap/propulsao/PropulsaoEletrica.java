package br.com.fiap.propulsao;

import java.util.Random;

public class PropulsaoEletrica extends SistemaPropulsao{
    private double potenciaConsumidaEmPorcentagem;
    private double potenciaTotalEmPorcentagem;
    private double potenciaAtualPorcentagem = 100;
    Random random = new Random();

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
    public void ligarMotores() {
        System.out.println("Motores ligados!");
        System.out.printf("Potencia atual com %.2f%%\n", getPotenciaTotalEmPorcentagem());
        calcularEmpuxo();
    }

    @Override
    public void desligarMotores() {
        System.out.println("Motores desligados!");
        setPotenciaConsumidaEmPorcentagem(random.nextDouble(10, getPotenciaAtualPorcentagem()-15));
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
    public void calcularEmpuxo() {
        double empuxoGerado = getEmpuxoMaximo() * (this.getPotenciaAtualPorcentagem() / 100.0);
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
