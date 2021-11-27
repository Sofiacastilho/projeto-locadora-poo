package Locadora2;

import java.io.*;
import java.util.Scanner;

public class Veiculos implements Serializable{

    private String descricaoVeiculo;
    private String placaVeiculo;
    private int codigo;

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Veículo [placa=" + this.placaVeiculo + ", descrição=" + this.descricaoVeiculo + "]");
        return buffer.toString();
    }


    public void gravaVeiculo(String filename) {
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream (new FileOutputStream(filename));

            Scanner scan = new Scanner(System.in);

            for (int i=0; i<3; i++){
                Veiculos veiculos = new Veiculos();
                System.out.println("Digite o numero do cadastro: ");
                veiculos.setCodigo(scan.nextInt());

                System.out.println("Placa: ");
                veiculos.setPlacaVeiculo(scan.next());
                System.out.println("Descrição: ");
                veiculos.setDescricaoVeiculo(scan.next());

                outputStream.writeObject(veiculos); //só escreve porque Person é seralizável
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally { //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void leVeiculo(String filename) {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream (new FileInputStream(filename));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Veiculos) // read a generic object obj
                    System.out.println(((Veiculos)obj).toString()); // cast to Cliente
            }
        } catch (EOFException ex) { // when EOF is reached
            System.out.println("End of file reached.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally { //Close the ObjectInputStream
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public void setDescricaoVeiculo(String descricaoVeiculo) {
        this.descricaoVeiculo = descricaoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
