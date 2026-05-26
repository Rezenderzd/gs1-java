package br.com.fiap.sensor;

import br.com.fiap.componentes.Planeta;

import java.util.Random;

public class SensorTemperatura implements Sensor {
    Random random  = new Random();
    private boolean isSensorAtivo;

    @Override
    public void verificandoSensorAtivo(){
        if(random.nextInt(0,100)<5){
            setSensorAtivo(false);
            return;
        }
        setSensorAtivo(true);
    }

    private void setSensorAtivo(boolean sensorAtivo) {
        isSensorAtivo = sensorAtivo;
    }

    @Override
    public void coletarInformacoes(Planeta planeta) {
        verificandoSensorAtivo();
        if(isSensorAtivo){
            int temperatura = random.nextInt(-40,80);
            planeta.registrarTemperatura(temperatura);
            return;
        }
        System.out.printf("Sensor de %s não ativo no momento", retornarTipo());
    }

    @Override
    public String retornarTipo() {
        return "temperatura";
    }
}
