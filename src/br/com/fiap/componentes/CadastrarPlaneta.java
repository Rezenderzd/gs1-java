package br.com.fiap.componentes;

import java.util.Scanner;

public class CadastrarPlaneta {

    Scanner leitor = new Scanner(System.in);

    public String cadastrarTipoPlaneta(){
        String tipoPlaneta;
        boolean planetaValido;
        System.out.println("Digite o tipo do planeta (gasoso ou rochoso)");
        do {
            tipoPlaneta = leitor.nextLine();
            if(tipoPlaneta.equalsIgnoreCase("gasoso")){
                planetaValido = true;
                continue;
            }
            if(tipoPlaneta.equalsIgnoreCase("rochoso")){
                planetaValido = true;
                continue;
            }
            System.out.println("Digite um tipo de planeta válido (gasoso ou rochoso)");
            planetaValido = false;
        }while(!planetaValido);
        return tipoPlaneta;
    }
}
