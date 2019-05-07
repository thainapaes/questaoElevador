package controllers;

import interfaces.IElevador;

public class ElevadorController implements IElevador {

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


}
