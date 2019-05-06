package entidades;

import javax.persistence.Entity;


public class PredioElevador {
    private int andares;
    private int inicio;

    public PredioElevador(int andares, int inicio) {
        this.setAndares(andares);
        this.setInicio(inicio);
    }

    public int getAndares() {
        return andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

}
