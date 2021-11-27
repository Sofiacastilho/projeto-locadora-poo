package Locadora2;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menu = 100;

        while (menu != 4) {
            try{
                System.out.println("---Menu---");

                System.out.println("1 - Menu clientes");
                System.out.println("2 - Menu veiculos");
                System.out.println("3 - Menu locações");
                System.out.println("4 - Sair");

                menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 1: {
                        menuClientes();
                        break;
                    }
                    case 2: {
                        menuVeiculos();

                        break;
                    }
                    case 3: {
                        menuLocacao();
                        break;
                    }
                    case 4: {
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Digite uma opção valida");

                }
            }catch (NullPointerException n) {
                System.out.println("Objeto vazio.");


            } catch (InputMismatchException n) {
                System.out.println("Digite caracteres validos.");

            }
            catch (NumberFormatException n) {
                System.out.println("Digite numeros.");

            }
        }

    }

    public static void menuClientes() {
        Scanner scan = new Scanner(System.in);
        try{
            int menu = 0;

            while(menu!= 3) {
                System.out.println("-- Menu Clientes---");

                System.out.println("1 - Cadastrar Cliente");
                System.out.println("2 - Listar Clientes");
                System.out.println("3 - Voltar");
                //System.out.println("----------------------------------");
                Cliente cliente = new Cliente();
                menu = scan.nextInt();

                switch(menu) {
                    case 1:{

                        cliente.gravaPessoa("listaClientes"+ cliente.getCodigo() +".txt");
                        //cliente.validaCliente();
                        break;
                    }
                    case 2:{

                        cliente.lePessoa("listaClientes"+ cliente.getCodigo() +".txt");
                        //locadora.listarClientes();
                        break;
                    }
                    case 3:{

                        break;
                    }
                    default:
                        System.out.println("Digite uma opção valida");
                }
                //System.out.println("");
            }
        }catch (NullPointerException n) {
            System.out.println("Objeto vazio.");
        } catch (InputMismatchException n) {
            System.out.println("Digite numeros.");
        }
    }


    public static void menuVeiculos() {
        Locadora locadora = new Locadora();
        Veiculos veiculos = new Veiculos();
        Scanner scan = new Scanner(System.in);
        int menu = 100;
        try{

            while(menu!= 3) {
                System.out.println("--- Menu veiculos ---");

                System.out.println("1 - Cadastrar veiculos");
                System.out.println("2 - Listar veiculos");
                System.out.println("3 - Voltar");

                menu = scan.nextInt();

                switch(menu) {
                    case 1:{
                        //locadora.cadastraVeiculo(veiculos);
                        veiculos.gravaVeiculo("listaVeiculos.txt");

                        break;
                    }
                    case 2:{
                        //locadora.listarVeiculos();
                        veiculos.leVeiculo("listaVeiculos.txt");

                        break;
                    }
                    case 3:{
                        //volta
                        break;
                    }
                    default:
                        System.out.println("Digite uma opção valida");
                }
            }
        }catch (NullPointerException n) {
            System.out.println("Objeto vazio.");
        } catch (InputMismatchException n) {
            System.out.println("Digite numeros.");
        }
    }


    public static void menuLocacao() {
        Locacao locacao = new Locacao();
        LocacaoVeiculos locacaoVeiculos = new LocacaoVeiculos();
        Scanner scan = new Scanner(System.in);
        try{
            int menu = 100;

            while(menu!= 4) {
                System.out.println("--- Menu Locações ---");

                System.out.println("1 - Locação de veiculos");
                System.out.println("2 - Listar locações");
                System.out.println("3 - Listar veículos locados");
                System.out.println("4 - Voltar");
                //System.out.println("----------------------------------");

                menu = scan.nextInt();

                switch(menu) {
                    case 1:{
                        locacao.locaVeiculo();

                        break;
                    }
                    case 2:{
                        //locadora.listarLocacoes();
                        break;
                    }
                    case 3:{

                        break;
                    }
                    case 4:{//volta

                    }
                    default:
                        System.out.println("Digite uma opção valida");
                }
            }
        }catch (NullPointerException n) {
            System.out.println("Objeto vazio.");
        } catch (InputMismatchException n) {
            System.out.println("Digite numeros.");
        }
    }
}
