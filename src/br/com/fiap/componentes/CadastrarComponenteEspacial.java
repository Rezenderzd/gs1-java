package br.com.fiap.componentes;

import java.util.Scanner;

public class CadastrarComponenteEspacial {
    Scanner leitor = new Scanner(System.in);

    public String cadastrarNomeComponente(){
        String nome;
        System.out.println("Digite o nome do componente");
        do{
            nome = leitor.nextLine();
            if(nome.isEmpty()){
                System.out.println("Nome inválido");
            }
        }while (nome.isEmpty());
        return nome;
    }

    public int cadastrarDistanciaEmKm(){
        int distanciaEmKm;
        System.out.println("Digite a distancia do componente em relação a Terra em km");
        do {
            distanciaEmKm = leitor.nextInt();
            if(distanciaEmKm<10000){
                System.out.println("Digite uma distância válida (maior que 10.000 km)");
            }
        }while(distanciaEmKm<10000);
        return distanciaEmKm;
    }
}
