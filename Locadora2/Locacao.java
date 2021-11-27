package Locadora2;

import java.util.Scanner;

public class Locacao {

    private String cpf;

    LocacaoVeiculos locacaoVeiculos = new LocacaoVeiculos();

    Scanner scan = new Scanner(System.in);

    public void locaVeiculo(){
        System.out.println("Digite seu cpf");
        cpf = scan.nextLine();

        System.out.println("Qual veiculo deseja locar? \n1 - Carro\n2 - Moto");
        int tipo = scan.nextInt();

        if (tipo == 1){
            locacaoVeiculos.calcularLocacaoCarro();
        }else if ( tipo == 2){
            locacaoVeiculos.calcularLocacaoMoto();
        } else {
            System.out.println("Escolha um veiculo");
        }

    }
}
