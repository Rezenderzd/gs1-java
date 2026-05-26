package br.com.fiap.componentes;

import br.com.fiap.sensor.SensorPressao;
import br.com.fiap.sensor.SensorRadiacao;
import br.com.fiap.sensor.SensorTemperatura;

import java.util.List;
import java.util.Scanner;

public class FuncoesMenuComponentesEspaciais {
    Scanner leitor = new Scanner(System.in);
    private SensorPressao sensorPressao = new SensorPressao();
    private SensorRadiacao sensorRadiacao = new SensorRadiacao();
    private SensorTemperatura sensorTemperatura = new SensorTemperatura();

    public void adicionarComponenteEspacial(List<ComponenteEspacial> listaComponentes){
        String tipoComponente;
        boolean componenteValido;
        System.out.println("Escreva o tipo do componente espacial (planeta ou asteroide)");
        do {
            tipoComponente  = leitor.nextLine();
            if(tipoComponente.equalsIgnoreCase("asteroide")){
                componenteValido = true;
                continue;
            }
            if(tipoComponente.equalsIgnoreCase("planeta")){
                componenteValido=true;
                continue;
            }
            componenteValido = false;
            if(!componenteValido){
                System.out.println("Este componente espacial não está na base de dados.");
            }
        }while (!componenteValido);

        CadastrarComponenteEspacial cadastroComponente = new CadastrarComponenteEspacial();
        CadastrarPlaneta cadastroPlaneta = new CadastrarPlaneta();
        CadastrarAsteroide cadastroAsteroide = new CadastrarAsteroide();

        String nomeComponente = cadastroComponente.cadastrarNomeComponente();
        int distanciaDaTerra = cadastroComponente.cadastrarDistanciaEmKm();
        if (tipoComponente.equalsIgnoreCase("planeta")){
            String tipoPlaneta = cadastroPlaneta.cadastrarTipoPlaneta();
            Planeta planetaNovo = new Planeta(nomeComponente, distanciaDaTerra, tipoPlaneta);
            sensorPressao.coletarInformacoes(planetaNovo);
            sensorRadiacao.coletarInformacoes(planetaNovo);
            sensorTemperatura.coletarInformacoes(planetaNovo);
            planetaNovo.verificarCondicoesParaSobrevivencia();
            listaComponentes.add(planetaNovo);
            return;
        }
        if(tipoComponente.equalsIgnoreCase("asteroide")){
            double velocidade = cadastroAsteroide.velocidadeAsteroide();
            Asteroides asteroideNovo =  new Asteroides(nomeComponente, distanciaDaTerra, velocidade, false);
            listaComponentes.add(asteroideNovo);
        }
    }

    public void mudarStatusAsteroide(List<ComponenteEspacial> listaComponentes){
        System.out.println("Digite o nome do asteroide");
        boolean achou = false;
        String nome;
        nome = leitor.nextLine();
        for(ComponenteEspacial componente: listaComponentes){
            if(componente instanceof Asteroides && componente.getNome().equalsIgnoreCase(nome)){
                achou = true;
                ((Asteroides) componente).mudarStatus();
                break;
            }
        }
        if(!achou){
            System.out.println("Asteroide não localizado!");
            return;
        }
    }

    public void mostrarAsteroidesColisao(List<ComponenteEspacial> listaComponentes){
        System.out.println("Asteroides com risco de colisão: ");
        boolean hasComponente = false;
        for(ComponenteEspacial componente: listaComponentes){
            if(componente instanceof Asteroides && ((Asteroides) componente).getHasRiscoColisao()){
                componente.exibirInformacoes();
                hasComponente = true;
            }
        }
        if(!hasComponente){
            System.out.println("Nenhum asteroide com perigo de atingir a Terra no momento.");
        }
    }

    public void mostrarInformacoes(List<ComponenteEspacial> listaComponentes){
        if(listaComponentes.isEmpty()){
            System.out.println("Lista vazia, cadastre as informações de um asteroide ou planeta.");
            return;
        }
        System.out.println("Digite o nome do componente");
        String nome = leitor.nextLine();
        boolean achou = false;
        for(ComponenteEspacial componente: listaComponentes){
            if(nome.equalsIgnoreCase(componente.getNome())){
                componente.exibirInformacoes();
                achou = true;
                break;
            }
        }
        if(!achou){
            System.out.println("Não existe nenhum componente com esse nome");
        }
    }

    public void visualizarStatusSensores(List<ComponenteEspacial> listaComponentes){
        String nome;
        System.out.println("Digite o planeta que quer visualizar");
        nome = leitor.nextLine();
        for(ComponenteEspacial componente: listaComponentes){
            if(nome.equalsIgnoreCase(componente.getNome()) && componente instanceof Planeta){
                ((Planeta) componente).verificarSensores();
                return;
            }
        }
        System.out.println("Nenhum planeta encontrado com esse nome");
    }
}
