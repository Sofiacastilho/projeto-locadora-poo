package Locadora2;

import java.util.ArrayList;
import java.util.Scanner;

public class LocacaoVeiculos {

    private Cliente cliente;
    private Veiculos veiculos;
    private Integer numeroDiasLocacao;
    private String dataLocacao;
    private boolean seguro;
    private double valorLocacao = 0;
    private String placa;
    private String cpf;


    @Override
    public String toString() { //lista a locação
        StringBuffer buffer = new StringBuffer();
        buffer.append("Locação [Cliente=" + this.cliente.getNome() +
                ", veiculo=" + this.veiculos.getPlacaVeiculo() + "," +
                " data=" + this.dataLocacao + ", dias locados=" + this.numeroDiasLocacao + "]");
        return buffer.toString();
    }


        //-----carro--------

    public double calcularLocacaoCarro() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a placa: ");
        String placa = scan.nextLine();
        System.out.println("Digite o valor de locação: ");
        double valorLocacao = scan.nextDouble();
        System.out.println("Digite quantos dias será locado: ");
        int numeroDiasLocacao = scan.nextInt();
        System.out.println("Deseja seguro?\n1 - SIM\n2 - não ");
        int opcao = scan.nextInt();
        
        //boolean seguro;
        switch (opcao){
            case 1:{
                seguro = true;

                System.out.println("Digite a quantidade de passageiros: ");
                int qtdPassageiros = scan.nextInt();
                double calcularSeguroCarro = (0.05f * valorLocacao * (1 + qtdPassageiros / 20));
                System.out.println("Digite a porcentagem de desconto: (menor que 12)");
                double desconto = scan.nextDouble();

                if (desconto < 0 || desconto > 12){
                    System.out.println("Valor invalido");
                }else if ( desconto == 0){
                    valorLocacao = ((valorLocacao * numeroDiasLocacao) + (calcularSeguroCarro * numeroDiasLocacao));
                    System.out.println(valorLocacao);

                }else if (desconto > 0 && desconto <= 12){
                    valorLocacao = ((valorLocacao * numeroDiasLocacao) + (calcularSeguroCarro * numeroDiasLocacao));
                    double calculoDesconto = (desconto/100);
                    double calculo1 = valorLocacao * calculoDesconto;
                    double calculoFinal = valorLocacao - calculo1;

                    System.out.println(calculoFinal);

                }

                break;
               
            } case 2: {
                seguro = false;
                valorLocacao = (valorLocacao * numeroDiasLocacao);
                System.out.println(valorLocacao);
                break;
            }
            default:
                System.out.println("Escolha algo valido.");
        }

        
        return valorLocacao;
    }


        //-----moto--------

    public double calcularLocacaoMoto(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a placa: ");
        String placa = scan.nextLine();
        System.out.println("Digite quantos dias será locado: ");
        int numeroDiasLocacao = scan.nextInt();
        System.out.println("Deseja seguro?\n1 - SIM\n2 - não ");
        int opcao = scan.nextInt();

        switch (opcao){
            case 1:{
                seguro = true;

                System.out.println("Digite o valor de locação: ");
                double valorLocacao = scan.nextDouble();
                double calcularSeguroMoto = (0.09f * valorLocacao);


                valorLocacao = (valorLocacao * numeroDiasLocacao) + (numeroDiasLocacao * calcularSeguroMoto);
                System.out.println(valorLocacao);
                break;

            } case 2: {
                seguro = false;

                System.out.println("Digite o valor de locação: ");
                double valorLocacao = scan.nextDouble();
                valorLocacao = (valorLocacao * numeroDiasLocacao);
                System.out.println(valorLocacao);
                break;
            }
            default:
                System.out.println("Escolha algo valido.");
        }
        return valorLocacao;
    }


    //-----get e set--------

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



}
