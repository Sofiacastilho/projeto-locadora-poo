package Locadora2;

import java.io.*;
import java.util.Scanner;

public class Cliente implements Serializable {

    private String nome;
    private String cpf;
    private int idade;
    private int codigo;

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Cliente [nome=" + this.nome + ", cpf=" + this.cpf + ", idade=" + this.idade + "]");
        return buffer.toString();
    }

    public Cliente(){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }


    public void gravaPessoa(String filename) {
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream (new FileOutputStream(filename));

            Scanner scan = new Scanner(System.in);

            for (int i=0; i<3; i++){
                Cliente cliente = new Cliente();
                System.out.println("Digite o numero do cadastro: ");
                cliente.setCodigo(scan.nextInt());

                System.out.println("Nome: ");
                cliente.setNome(scan.next());
                System.out.println("Cpf: ");
                cliente.setCpf(scan.next());
                System.out.println("Idade: ");
                cliente.setIdade(scan.nextInt());

                outputStream.writeObject(cliente); //só escreve porque Person é seralizável
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


    public void lePessoa(String filename) {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream (new FileInputStream(filename));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Cliente) // read a generic object obj
                    System.out.println(((Cliente)obj).toString()); // cast to Cliente
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






    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;

    }
}
