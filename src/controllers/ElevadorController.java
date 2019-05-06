package controllers;

import interfaces.IElevador;
import entidades.PredioElevador;

import java.util.ArrayList;

public class ElevadorController implements IElevador {

    private ArrayList<PredioElevador> predioList = new ArrayList<>();
    int mediaTempo = 20; //20 segundos para ir de um andar a outro

    @Override
    public int subir(int atual, int desejado) {
        int andaresSubidos = desejado - atual;
        return andaresSubidos;

    }

    @Override
    public int descer(int atual, int desejado) {
        int andaresDescidos = atual - desejado;
        return andaresDescidos;
    }

    @Override
    public void parada() {

    }



}
