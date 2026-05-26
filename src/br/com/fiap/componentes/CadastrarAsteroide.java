package br.com.fiap.componentes;

import java.util.Locale;
import java.util.Scanner;

public class CadastrarAsteroide {
    Scanner leitor = new Scanner(System.in).useLocale(Locale.US);
    public double velocidadeAsteroide(){
        double velocidade;
        System.out.println("Digite a velocidade do asteroide.");
        do {
            velocidade = leitor.nextDouble();
            if(velocidade<0){
                System.out.println("Digite uma velocidade válida");
            }
        }while (velocidade<0);
        return velocidade;
    }
}
