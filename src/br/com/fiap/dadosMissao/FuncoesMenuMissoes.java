package br.com.fiap.dadosMissao;

import br.com.fiap.componentes.ComponenteEspacial;
import br.com.fiap.propulsao.SistemaPropulsao;

import java.util.List;
import java.util.Scanner;

public class FuncoesMenuMissoes {
    Scanner leitor = new Scanner(System.in);
    CadastroMissoes cadastros = new CadastroMissoes();

    public void visualizarMissao(List<DadosMissao> listaMissoes){
        DadosMissao missaoAlvo = null;
        String codigoMissao;

        if(listaMissoes.isEmpty()){
            System.out.println("Não há nenhuma missão no momento!");
            return;
        }
        System.out.println("Escreva o nome da missão que está procurando");
        String missaoBuscada = leitor.nextLine();
        for(DadosMissao missao: listaMissoes){
            if(missaoBuscada.equalsIgnoreCase(missao.getNome())){
                missaoAlvo = missao;
            }
        }
        if(missaoAlvo == null){
            System.out.println("Missão não encontrada, retornando para o menu.");
            return;
        }
        System.out.println("Digite o código de acesso da missão");
        codigoMissao = leitor.nextLine();
        if(codigoMissao.equalsIgnoreCase(missaoAlvo.getCodigoDeReconhecimento())){
            System.out.println("Exibindo informações:");
            missaoAlvo.exibirDadosMissao();
            return;
        }
        System.out.println("Código inválido, retornando para o menu.");
    }

    public void adicionarMissao(List<DadosMissao> listaMissoes, List<ComponenteEspacial> listaComponentes){
        if(listaComponentes.isEmpty()){
            System.out.println("Impossível cadastrar missão pois não há nenhum componente espacial como destino conhecido.");
            return;
        }
        String nomeMissao = cadastros.cadastrarNomeMissao();
        String componenteEspacialDestino = cadastros.cadastrarDestino(listaComponentes);
        if(componenteEspacialDestino == null){
            return;
        }
        int numeroDeDiasExpedicao = cadastros.cadastrarNumeroDeDias();
        int numeroDeTripulantes = cadastros.cadastrarNumeroTripulantes();
        SistemaPropulsao propulsaoUsada = cadastros.cadastrandoPropulsaoDoFoguete();
        DadosMissao novaMissao = new DadosMissao(nomeMissao, componenteEspacialDestino, numeroDeDiasExpedicao, numeroDeTripulantes, propulsaoUsada);
        listaMissoes.add(novaMissao);
    }
}
