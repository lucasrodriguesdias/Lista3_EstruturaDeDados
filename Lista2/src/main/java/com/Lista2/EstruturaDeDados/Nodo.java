package com.Lista2.EstruturaDeDados;

public class Nodo {
    private int numeros;
    private Nodo proximo;

    public Nodo() {
    }


    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(int numeros) {
        this.numeros = numeros;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
}
