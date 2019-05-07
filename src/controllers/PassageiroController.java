package controllers;

import excecoes.NumeroIncorretoException;
import interfaces.IPassageiro;

import java.util.ArrayList;

public class PassageiroController implements IPassageiro {

    ElevadorController elevadorController = new ElevadorController();
    int mediaTempo = 20;

    @Override
    public int selecionarAndar(int andares, int andarInicial, ArrayList<Integer> lista) {
        int resposta = 0;
        boolean flag = false;
        for (int elem : lista) {
            if (elem < andares && elem > 0) {
               flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            resposta = sobeOuDesce(andarInicial, lista);
        } else {
            throw new NumeroIncorretoException("Algum andar inserido é negativo ou maior que o limite.");
        }
        return resposta;
    }

    private int sobeOuDesce(int andarInicial, ArrayList<Integer> lista) {
        int tempoTotal = 0;
        int count = 0;
        int atualElevador = andarInicial;
        if (lista.size() > 0) {
            verificacao(atualElevador, lista);
            do {
                int destino = lista.get(count);
                if (destino > 0) {
                    if (atualElevador > destino) {
                        int qtdAndares = elevadorController.descer(atualElevador, destino);
                        atualElevador = destino;
                        tempoTotal = tempoTotal + qtdAndares;
                    } else if (atualElevador < destino) {
                        int qtdAndares = elevadorController.subir(atualElevador, destino);
                        atualElevador = destino;
                        tempoTotal = tempoTotal + qtdAndares;
                    }
                    verificacao(atualElevador, lista);
                }
                count++;
            } while (count < lista.size());
        }
        return (tempoTotal*mediaTempo);
    }

    private ArrayList<Integer> verificacao(int andarInicial, ArrayList<Integer> lista) {
        for(int i=0; i<lista.size();i++) {
            int var = lista.get(i);
            if (var == andarInicial) {
                var = var*(-1);
                lista.remove(i);
                lista.add(i, var);
            }
        }
        return lista;
    }

}
