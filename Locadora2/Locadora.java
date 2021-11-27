package Locadora2;

import java.util.ArrayList;

public class Locadora {

    private ArrayList<Cliente> listaCliente = new ArrayList<>();
    private ArrayList<Veiculos> listaVeiculos = new ArrayList<>();
    private ArrayList<LocacaoVeiculos> listaLocacaoVeiculos = new ArrayList<>();


    //-----get e set--------

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<Veiculos> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculos> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public ArrayList<LocacaoVeiculos> getLocacaoVeiculos() {
        return listaLocacaoVeiculos;
    }

    public void setLocacaoVeiculos(ArrayList<LocacaoVeiculos> locacaoVeiculos) {
        this.listaLocacaoVeiculos = locacaoVeiculos;
    }
}

