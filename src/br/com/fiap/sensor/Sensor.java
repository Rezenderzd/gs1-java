package br.com.fiap.sensor;
import br.com.fiap.componentes.Planeta;

public interface Sensor {
    void coletarInformacoes(Planeta planeta);
    void verificandoSensorAtivo();
    String retornarTipo();
}
