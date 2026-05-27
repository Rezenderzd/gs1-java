package br.com.fiap.sensor;
import br.com.fiap.componentes.Planeta;

import java.util.Random;

public class SensorPressao implements Sensor {
    Random random = new Random();
    private boolean isSensorAtivo;

    private void setSensorAtivo(boolean sensorAtivo) {
        isSensorAtivo = sensorAtivo;
    }


    @Override
    public void verificandoSensorAtivo(){
        if(random.nextInt(0,100)<5){
            setSensorAtivo(false);
            return;
        }
        setSensorAtivo(true);
    }

    @Override
    public void coletarInformacoes(Planeta planeta) {
        verificandoSensorAtivo();

        if(isSensorAtivo){
            int pressaoEmATM = random.nextInt(0,15);
            planeta.registrarPressaoAbsoluta(pressaoEmATM);
            return;
        }
        System.out.printf("Sensor de %s não ativo no momento\n", retornarTipo());
    }

    @Override
    public String retornarTipo() {
        return "Pressão";
    }
}
