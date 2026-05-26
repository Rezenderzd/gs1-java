package br.com.fiap.componentes;

import java.util.ArrayList;
import java.util.List;

public class Planeta extends ComponenteEspacial{
    private String tipoPlaneta;
    private String isHabitavel;
    private Integer temperaturaEmGrausCelcius;
    private Integer radiacaoEmSvPorAno;
    private Integer pressaoAbsolutaEmATM;

    public Planeta(String nome, int distanciaDaTerra, String tipoPlaneta) {
        super(nome, distanciaDaTerra);
        this.tipoPlaneta = tipoPlaneta;

    }

    public String getTipoPlaneta() {
        return tipoPlaneta;
    }

    public String getIsHabitavel() {
        return isHabitavel;
    }

    protected void setPressaoAbsolutaEmATM(int pressao) {
        this.pressaoAbsolutaEmATM = pressao;
    }

    protected void setTemperaturaEmGrausCelcius(int temperatura) {
        this.temperaturaEmGrausCelcius = temperatura;
    }

    protected void setRadiacaoEmSvPorAno(int radiacao) {
        this.radiacaoEmSvPorAno = radiacao;
    }

    public void setIsHabitavel(String isHabitavel) {
        this.isHabitavel = isHabitavel;
    }

    public void registrarPressaoAbsoluta(int pressao){
        setPressaoAbsolutaEmATM(pressao);
    }

    public void registrarTemperatura(int temperatura){
        setTemperaturaEmGrausCelcius(temperatura);
    }

    public void registrarRadiacao(int radiacao){
        setRadiacaoEmSvPorAno(radiacao);
    }

    public boolean verificarCondicoesParaSobrevivencia(){
        List<String> motivos = new ArrayList<>();

        if(this.pressaoAbsolutaEmATM == null || this.temperaturaEmGrausCelcius == null || this.radiacaoEmSvPorAno == null){
            setIsHabitavel("Não há dados suficientes para análise");
            return false;
        }
        if (this.pressaoAbsolutaEmATM > 10 || this.pressaoAbsolutaEmATM < 1) {
            motivos.add("pressão fora dos limites (" + this.pressaoAbsolutaEmATM + " ATM)");
        }
        if (this.temperaturaEmGrausCelcius < -25 || this.temperaturaEmGrausCelcius > 60) {
            motivos.add("temperatura extrema (" + this.temperaturaEmGrausCelcius + "°C)");
        }
        if (this.radiacaoEmSvPorAno > 50) {
            motivos.add("radiação crítica (" + this.radiacaoEmSvPorAno + " Sv/ano)");
        }

        if (!motivos.isEmpty()) {
            setIsHabitavel("Não é habitável pois: " + String.join(", ", motivos));
            return false;
        }
        setIsHabitavel("É habitável");
        return true;
    }

    @Override
    public void exibirInformacoes() {
        this.verificarCondicoesParaSobrevivencia();
        System.out.printf("""
                Nome: %s
                Tipo do planeta: %s
                Distância para a Terra: %d km
                É Habitável? %s
                """, this.getNome(), this.getTipoPlaneta(), this.getDistanciaDaTerra(), this.getIsHabitavel());
    }

    public void verificarSensores(){
        if (this.pressaoAbsolutaEmATM != null) {
            System.out.printf("Sensor de pressão: %d ATM\n", this.pressaoAbsolutaEmATM);
        } else {
            System.out.println("Sensor de pressão não ativo.");
        }

        if (this.temperaturaEmGrausCelcius != null) {
            System.out.printf("Sensor de temperatura: %d°C\n", this.temperaturaEmGrausCelcius);
        } else {
            System.out.println("Sensor de temperatura não ativo.]");
        }

        if (this.radiacaoEmSvPorAno != null) {
            System.out.printf("Sensor de radiação: %d Sv/ano\n", this.radiacaoEmSvPorAno);
        } else {
            System.out.println("Sensor de radiação não ativo.");
        }
    }
}
