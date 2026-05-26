package br.com.fiap.dadosMissao;

import br.com.fiap.componentes.Asteroides;
import br.com.fiap.componentes.ComponenteEspacial;
import br.com.fiap.componentes.Planeta;
import br.com.fiap.propulsao.PropulsaoEletrica;
import br.com.fiap.propulsao.PropulsaoQuimica;
import br.com.fiap.propulsao.SistemaPropulsao;

import java.util.List;
import java.util.Scanner;

public class CadastroMissoes {
    Scanner leitor = new Scanner(System.in);

    public String cadastrarNomeMissao(){
        String nomeMissao;
        System.out.println("Digite o nome da missão:");
        do{
            nomeMissao = leitor.nextLine();
            if(nomeMissao.isEmpty()){
                System.out.println("Nome inválido, digite um nome");
            }
        }while(nomeMissao.isEmpty());
        return nomeMissao;
    }

    public String cadastrarDestino(List<ComponenteEspacial> listaComponentes){
        String nomeDestino;
        boolean isDestinoExploravel = false;
        boolean isDestinoExistente = false;
        System.out.println("Digite o nome do Componente Espacial de destino");
        do{
            nomeDestino = leitor.nextLine();
            if(nomeDestino.isEmpty()){
                System.out.println("Nome inválido, digite um nome de componente");
                continue;
            }
            for(ComponenteEspacial componente : listaComponentes){
                if(componente.getNome().equalsIgnoreCase(nomeDestino)){
                    isDestinoExistente = true;
                    ComponenteEspacial componenteDestino = componente;
                    if(componenteDestino instanceof Asteroides && ((Asteroides) componenteDestino).getVelocidadeEmKm()>1){
                        System.out.println("Impossível fazer a missão, pois o asteroide está muito rápido.");
                        continue;
                    }

                    if(componenteDestino instanceof Planeta){
                        Planeta planetaDestino = (Planeta) componenteDestino;

                        if (planetaDestino.verificarCondicoesParaSobrevivencia() == false) {
                            String motivo = planetaDestino.getIsHabitavel();
                            System.out.println("Impossível fazer a missão. " + motivo);
                            continue;
                        }
                        if (planetaDestino.getTipoPlaneta().equalsIgnoreCase("gasoso")){
                            System.out.println("Impossível realizar a missão pois o planeta é gasoso.");
                        }
                    }

                    isDestinoExploravel = true;
                    break;
                }
            }
            if(!isDestinoExistente){
                System.out.println("Destino não existente, retornando para o menu");
                return null;
            }
            if(!isDestinoExploravel){
                System.out.println("Retorandno para o menu");
                return null;
            }
        }while(nomeDestino.isEmpty() || !isDestinoExploravel);
        return nomeDestino;
    }

    public int cadastrarNumeroDeDias(){
        int numeroDeDiasExpedicao;
        System.out.println("Digite o número de dias da expedição:");
        do {
            numeroDeDiasExpedicao = leitor.nextInt();
            if(numeroDeDiasExpedicao<=0){
                System.out.println("Digite um número de dias válido.");
            }
        }while (numeroDeDiasExpedicao<=0);
        return numeroDeDiasExpedicao;
    }

    public int cadastrarNumeroTripulantes(){
        int numeroTripulantes;
        System.out.println("Digite o número de tripulantes:");
        do{
            numeroTripulantes = leitor.nextInt();
            if(numeroTripulantes<=0 || numeroTripulantes>10){
                System.out.println("Numero de tripulantes a cima ou abaixo do permitido (mínimo 1 máximo 10)");
            }
        }while (numeroTripulantes<=0 || numeroTripulantes>10);
        return numeroTripulantes;
    }

    public SistemaPropulsao cadastrandoPropulsaoDoFoguete(){
        SistemaPropulsao propulsao = null;
        String propulsaoDesejada;
        System.out.println("Digite a propulsao usada (quimica ou eletrica)");
        do {
            propulsaoDesejada = leitor.next();
            if(propulsaoDesejada.equalsIgnoreCase("quimica")){
                System.out.println("Digite a quantidade de empuxo exercida: ");
                int empuxo = leitor.nextInt();
                propulsao = new PropulsaoQuimica(empuxo);
                continue;
            }
            if(propulsaoDesejada.equalsIgnoreCase("eletrica")){
                System.out.println("Digite a quantidade de empuxo exercida: ");
                int empuxo = leitor.nextInt();
                propulsao = new PropulsaoEletrica(empuxo);
                continue;
            }
            System.out.println("A propulsão exigida não está na base de dados.");
        }while(propulsao == null);
        return propulsao;
    }

}
