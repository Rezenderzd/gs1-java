package br.com.fiap.main;

import br.com.fiap.componentes.ComponenteEspacial;
import br.com.fiap.componentes.FuncoesMenuComponentesEspaciais;
import br.com.fiap.dadosMissao.DadosMissao;
import br.com.fiap.dadosMissao.FuncoesMenuMissoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu(){
        int escolha;
        Scanner leitor = new Scanner(System.in);
        List<ComponenteEspacial> listaComponentesEspaciais = new ArrayList<>();
        List<DadosMissao> listaMissoes = new ArrayList<>();
        FuncoesMenuMissoes funcoesMenuMissoes = new FuncoesMenuMissoes();
        FuncoesMenuComponentesEspaciais funcoesMenuComponentesEspaciais  = new FuncoesMenuComponentesEspaciais();

        do{
            System.out.printf("""
                    Bem vindo ao sistema de exploração espacial, escolha a opção que deseja acessar:
                    1- Visualizar informações de missão
                    2- Adicionar uma missão
                    3- Adicionar um Componente Espacial
                    4- Mudar status de colisão do asteroide
                    5- Exibir Asteroides com risco de colisão
                    6- Exibir informações de planetas/asteroides
                    7- Exibir informações dos sensores
                    0- Sair do programa
                    """);
            escolha = leitor.nextInt();
            switch (escolha){
                case 1:
                    funcoesMenuMissoes.visualizarMissao(listaMissoes);
                    break;
                case 2:
                    funcoesMenuMissoes.adicionarMissao(listaMissoes,listaComponentesEspaciais);
                    break;
                case 3:
                    funcoesMenuComponentesEspaciais.adicionarComponenteEspacial(listaComponentesEspaciais);
                    break;
                case 4:
                    funcoesMenuComponentesEspaciais.mudarStatusAsteroide(listaComponentesEspaciais);
                    break;
                case 5:
                    funcoesMenuComponentesEspaciais.mostrarAsteroidesColisao(listaComponentesEspaciais);
                    break;
                case 6:
                    funcoesMenuComponentesEspaciais.mostrarInformacoes(listaComponentesEspaciais);
                    break;
                case 7:
                    funcoesMenuComponentesEspaciais.visualizarStatusSensores(listaComponentesEspaciais);
                    break;
                case 0:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }while (escolha!=0);
        leitor.close();
    }
}
